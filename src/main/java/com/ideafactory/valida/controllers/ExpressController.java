package com.ideafactory.valida.controllers;

import com.ideafactory.valida.dto.ValidationReceiptResponse;
import com.ideafactory.valida.services.MulticaixaExpressRecieptService;
import com.ideafactory.valida.utils.FileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/express")
public class ExpressController {
    @Autowired
    private MulticaixaExpressRecieptService service;
    @Autowired
    private FileManager manager;
    @GetMapping
    public String express() {
        return "Hello from Express!";
    }



    @PostMapping("/validate")
    public ResponseEntity<ValidationReceiptResponse> validatePDF(@RequestPart("receipt") MultipartFile receipt) throws IOException {
            return ResponseEntity.ok(service.validateReceipt(FileManager.fromMultipartFileToFile(receipt)));
    }

}
