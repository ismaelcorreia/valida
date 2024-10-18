package com.ideafactory.valida;

import com.ideafactory.valida.utils.FileManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class ReadingTest {

    static final String testDocument = "teste.pdf";
    static final String testFakerDocument = "teste-faker.pdf";
    static final String testProof= "teste-proof.pdf";

    static FileManager fileManager;
    @BeforeAll
    static void setup() {
        fileManager = new FileManager();
    }

    @Test
    void checkFile(){
        Assertions.assertTrue(new File(testDocument).exists());
    }

    @Test
    public void testIsPdfSigned() {
        assertTrue(fileManager.isPdfSigned(testFakerDocument));
    }

    @Test
    public void testPrintSignatureDetails() {
        fileManager.printSignatureDetails(testFakerDocument);
    }

}
