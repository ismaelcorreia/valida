package com.ideafactory.valida;

import com.ideafactory.valida.utils.PdfVerifier;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ValidaApplicationTests {


    @Autowired
    private PdfVerifier pdfVerifier;

    static final String testDocument = "teste.pdf";

    static final String testFakerDocument = "teste-faker.pdf";


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
        pdfVerifier.printPdfProperties(testFakerDocument);
    }

}
