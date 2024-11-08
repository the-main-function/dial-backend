package com.dial.service.impl;

import com.dial.entities.Arrival;
import com.dial.service.IArrivalService;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class ArrivalReportService extends ReportAbstractService {

    private final IArrivalService arrivalService;

    @Autowired
    public ArrivalReportService(IArrivalService arrivalService) {
        this.arrivalService = arrivalService;
    }

    public void writeTableData() {
        // data
        List<Arrival> arrivals = arrivalService.fetchAllArrivals();

        // font style content
        CellStyle style = getFontContentExcel();

        Format formatter = new SimpleDateFormat("yyyy-MM-dd");

        // starting write on row
        int startRow = 2;

        // write content
        for (Arrival arrival : arrivals) {
            Row row = sheet.createRow(startRow++);
            int columnCount = 0;
            createCell(row, columnCount++, arrival.getArrivalId(), style);
            createCell(row, columnCount++,  formatter.format(arrival.getArrivalDate()), style);
            createCell(row, columnCount++, arrival.getProduct().getName(), style);
            createCell(row, columnCount++, arrival.getArrivalStackQty(), style);
            createCell(row, columnCount++, arrival.getCurrentStackQty(), style);
        }
    }


    public void exportArrivalsToExcel(HttpServletResponse response) throws IOException {
        newReportExcel();

        // response  writer to excel
        response = initResponseForExportExcel(response, "arrival-report");
        ServletOutputStream outputStream = response.getOutputStream();


        // write sheet, title & header
        String[] headers = new String[]{"Arrival ID", "Arrival Date", "Product", "Arrival Qty", "Current Qty"};
        writeTableHeaderExcel("arrivals", "DIAL : Arrival Report", headers);

        // write content row
        writeTableData();

        workbook.write(outputStream);
        workbook.close();
    }
}
