package com.ideafactory.valida.services;

import com.ideafactory.valida.dto.ValidationReceiptResponse;
import com.ideafactory.valida.utils.FileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDateTime;

@Service
public class MulticaixaExpressRecieptService {

    @Autowired
    private FileManager fileManager;
    public ValidationReceiptResponse validateReceipt(File file) {
        if (
                file == null || !file.isFile()
        ){
            return new ValidationReceiptResponse(
                    "Document is not correct",
                    false,
                    false,
                    LocalDateTime.now()
            );
        }
        boolean isAssigned = fileManager.isPdfSigned(file);
        if (!isAssigned) {
            return new ValidationReceiptResponse(
                    "Document is not assigned",
                    false,
                    false,
                    LocalDateTime.now()
            );
        }

        return new ValidationReceiptResponse(
                fileManager.getPdfProperties(file).toString(),
                true,
                false,
                LocalDateTime.now()
        );

    }
}
