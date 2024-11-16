package org.example.AlphabetFrequencyReader;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * A utility class for reading the contents of a document.
 * Supports both plain text files and PDF files.
 */
public class DocumentReader {

    /**
     * Reads a text or PDF file and returns its content as a single string.
     *
     * @param filePath the path to the file to read
     * @return the file content as a single string
     * @throws IllegalArgumentException if the file type is unsupported
     * @throws IOException if there is an error reading the file
     */
    public String read(String filePath){
        if (filePath.endsWith(".pdf")){
            return readPDF(filePath);
        } else if (filePath.endsWith(".txt")){
            return readTextFile(filePath);
        } else {
            throw new IllegalArgumentException("Unsupported file type: " + filePath);
        }
    }

    /**
     * Reads the contents of a PDF file and returns it as a string.
     *
     * @param filePath the path to the PDF file
     * @return the contents of the PDF as a string
     * @throws IOException if an error occurs while reading the file
     */
    private String readPDF(String filePath){

        try (PDDocument document = PDDocument.load(new File(filePath))) {
            return new PDFTextStripper().getText(document);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Reads the contents of a plain text file and returns it as a string.
     *
     * @param filePath the path to the text file
     * @return the contents of the text file as a string
     * @throws IOException if an error occurs while reading the file
     */
    private String readTextFile(String filePath){

        try {
            return Files.readString(Paths.get(filePath));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
