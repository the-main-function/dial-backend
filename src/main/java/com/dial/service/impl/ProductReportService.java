package com.dial.service.impl;


import com.dial.entities.Product;
import com.dial.service.IProductService;
import jakarta.servlet.ServletOutputStream;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.List;

@Service
public class ProductReportService extends ReportAbstractService {

    private final IProductService productService;

    @Autowired
    public ProductReportService(IProductService productService) {
        this.productService = productService;
    }

    public void writeTableData() {
        // data
        List<Product> products = productService.fetchAllProducts();

        // font style content
        CellStyle style = getFontContentExcel();

        // starting write on row
        int startRow = 2;

        // write content
        for (Product product : products) {
            Row row = sheet.createRow(startRow++);
            int columnCount = 0;
            createCell(row, columnCount++, product.getProductId(), style);
            createCell(row, columnCount++, product.getName(), style);
            createCell(row, columnCount++, product.getStock(), style);
        }
    }


    public void exportProductsToExcel(HttpServletResponse response) throws IOException {
        newReportExcel();

        // response  writer to excel
        response = initResponseForExportExcel(response, "product-report");
        ServletOutputStream outputStream = response.getOutputStream();


        // write sheet, title & header
        String[] headers = new String[]{"Product ID", "Name", "Stock"};
        writeTableHeaderExcel("products", "DIAL : Product Stock Report", headers);

        // write content row
        writeTableData();

        workbook.write(outputStream);
        workbook.close();
    }
}
