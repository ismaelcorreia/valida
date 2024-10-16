package com.ideafactory.valida;

import com.ideafactory.valida.utils.PdfVerifier;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class ReadingTest {

    static final String testDocument = "teste.pdf";
    static final String testFakerDocument = "teste-faker.pdf";
    static final String testProof= "teste-proof.pdf";

    static PdfVerifier pdfVerifier;
    @BeforeAll
    static void setup() {
        pdfVerifier = new PdfVerifier();
    }

    @Test
    void checkFile(){
        Assertions.assertTrue(new File(testDocument).exists());
    }

    @Test
    public void testIsPdfSigned() {
        assertTrue(pdfVerifier.isPdfSigned(testFakerDocument));
    }

    @Test
    public void testPrintSignatureDetails() {
        pdfVerifier.printSignatureDetails(testFakerDocument);
    }

    @Test
    public void testPrintDetails() {
//        pdfVerifier.printPdfProperties(testProof);
//        Produtor: iText® 7.0.5 ©2000-2017 iText Group NV (AGPL-version);
//        modified using iText® 5.5.13.3 ©2000-2022 iText Group NV (AGPL-version)

        pdfVerifier.printPdfProperties(testDocument);
    }

    @Test
    public void testPrintDetails() {
//        pdfVerifier.printPdfProperties(testProof);
//        Produtor: iText® 7.0.5 ©2000-2017 iText Group NV (AGPL-version);
//        modified using iText® 5.5.13.3 ©2000-2022 iText Group NV (AGPL-version)

        pdfVerifier.printPdfProperties(testDocument);
    }
}
