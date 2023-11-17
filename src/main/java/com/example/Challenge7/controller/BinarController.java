package com.example.Challenge7.controller;

import com.example.Challenge7.model.BinarDetail;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/api/invoice")
@Configuration
public class BinarController {
    @GetMapping(value = "/generate-invoice", produces = MediaType.APPLICATION_PDF_VALUE)
    @Secured(value = "ROLE_USER")
    public ResponseEntity generateInvoice() throws JRException, FileNotFoundException {
        List<BinarDetail> binarDetail = Arrays.asList(
                BinarDetail.builder().productName("Nasi Pecel").quantity("6").price("90000").build(),
                BinarDetail.builder().productName("Mendoan").quantity("2").price("20000").build(),
                BinarDetail.builder().productName("Es Jeruk").quantity("6").price("30000").build()
        );
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("userName","Ervie");
        dataMap.put("totalPrice","Rp 140.000");
        JasperPrint invoice = JasperFillManager.fillReport(
                JasperCompileManager.compileReport(ResourceUtils.getFile("classpath:Binar.jrxml").getAbsolutePath()),
                dataMap,
                new JRBeanCollectionDataSource(binarDetail)
        );
                return ResponseEntity.ok()
                        .body(JasperExportManager.exportReportToPdf(invoice));

    }
}
