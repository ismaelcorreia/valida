package com.ideafactory.valida.utils;

import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;


@Component
public class PdfVerifier {

    public boolean isPdfSigned(String filePath) {

        try (PDDocument document = PDDocument.load(new File(filePath))) {
            List<PDSignature> signatures = document.getSignatureDictionaries();
            return signatures != null && !signatures.isEmpty();
        } catch (IOException e) {
            e.printStackTrace();
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


    public PDDocumentInformation printPdfProperties(String filePath) {
        try (PDDocument document = PDDocument.load(new File(filePath))) {
            return document.getDocumentInformation();
//            PDDocumentInformation info = document.getDocumentInformation();
//            System.out.println("Título: " + info.getTitle());
//            System.out.println("Autor: " + info.getAuthor());
//            System.out.println("Assunto: " + info.getSubject());
//            System.out.println("Palavras-chave: " + info.getKeywords());
//
//            System.out.println("Data de Criação: " +  formatter.format(info.getCreationDate().getTime()));
//            if( info.getModificationDate() != null){
//                System.out.println("Data de Modificação: " +formatter.format(info.getModificationDate().getTime()));
//            }
//            System.out.println("Criador: " + info.getCreator());
//            System.out.println("Produtor: " + info.getProducer());
//            System.out.println("Número de Páginas: " + document.getNumberOfPages());
        } catch (IOException e) {
            e.printStackTrace();
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