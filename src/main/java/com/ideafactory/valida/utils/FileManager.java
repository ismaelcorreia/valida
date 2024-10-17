package com.ideafactory.valida.utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.apache.pdfbox.text.PDFTextStripper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Objects;


@Component
public class FileManager {

    private static final Logger log = LoggerFactory.getLogger(FileManager.class);

    public boolean isPdfSigned(String filePath) {
        return isPdfSigned(new File(filePath));
    }
    public boolean isPdfSigned(File file) {

        try (PDDocument document = PDDocument.load(file)) {
            List<PDSignature> signatures = document.getSignatureDictionaries();
            return signatures != null && !signatures.isEmpty();
        } catch (IOException e) {
            log.error(e.getMessage());
            return false;
        }
    }

    public void printSignatureDetails(String filePath) {
        try (PDDocument document = PDDocument.load(new File(filePath))) {
            List<PDSignature> signatures = document.getSignatureDictionaries();

            if (signatures != null && !signatures.isEmpty()) {
                for (PDSignature sig : signatures) {
                    System.out.println("Nome: " + sig.getName());
                    System.out.println("Contato: " + sig.getContactInfo());
                    System.out.println("Local: " + sig.getLocation());
                    System.out.println("Razão: " + sig.getReason());
                    System.out.println("Data da assinatura: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(sig.getSignDate().getTime()));
                    System.out.println("-------------------------------");
                }
            } else {
                System.out.println("O PDF não possui assinaturas.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static File fromMultipartFileToFile(MultipartFile multipartFile) throws IOException {
        File file = new File(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(multipartFile.getBytes());
        }
        return file;
    }


    public PDDocumentInformation getPdfProperties(File file) {
        try (PDDocument document = PDDocument.load(file)) {
            return document.getDocumentInformation();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return null;
    }


    public String extractTextFromPdf(String filePath) {
        try (PDDocument document = PDDocument.load(new File(filePath))) {
            PDFTextStripper pdfStripper = new PDFTextStripper();
            return pdfStripper.getText(document);
        } catch (IOException e) {
            e.printStackTrace();
            return "Ocorreu um erro ao extrair o texto do PDF.";
        }
    }
}