package com.ideafactory.valida.services;

import com.ideafactory.valida.dto.ValidationReceiptResponse;
import com.ideafactory.valida.utils.FileManager;
import com.ideafactory.valida.utils.MulticaixaExpressReceiptKey;
import org.apache.logging.log4j.util.StringBuilders;
import org.apache.pdfbox.cos.COSName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDateTime;

@Service
public class MulticaixaExpressRecieptService {

    private static final Logger log = LoggerFactory.getLogger(MulticaixaExpressRecieptService.class);
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

        var pdfInfo = fileManager.getPdfProperties(file);

        final String creator = String.format("%s", pdfInfo.getCOSObject().getNameAsString("Creator"));
        final String author = String.format("%s", pdfInfo.getAuthor());


        return new ValidationReceiptResponse(
                fileManager.extractTextFromPdf(file),
                isAssigned,
                (
                        author.equals(MulticaixaExpressReceiptKey.getInstance().author) &&
                    pdfInfo.getProducer().equals(MulticaixaExpressReceiptKey.getInstance().producer) &&
                    creator.equals(MulticaixaExpressReceiptKey.getInstance().creator)
                ),
                LocalDateTime.now()
        );

    }
}
