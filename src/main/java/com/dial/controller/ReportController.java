package com.dial.controller;

import com.dial.service.impl.ArrivalReportService;
import com.dial.service.impl.ProductReportService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ReportController {

    private ProductReportService productReportService;
    private ArrivalReportService arrivalReportService;

    @Autowired
    public ReportController(ProductReportService productReportService, ArrivalReportService arrivalReportService) {
        this.productReportService = productReportService;
        this.arrivalReportService = arrivalReportService;
    }

    @GetMapping("/excel/product-report")
    public void exportProductListToExcel(HttpServletResponse httpServletResponse) throws IOException{
        productReportService.exportProductsToExcel(httpServletResponse);
    }

    @GetMapping("/excel/arrival-report")
    public void exportArrivalsToExcel(HttpServletResponse httpServletResponse) throws IOException{
        arrivalReportService.exportArrivalsToExcel(httpServletResponse);
    }
}
