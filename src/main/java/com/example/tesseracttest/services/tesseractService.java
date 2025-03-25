package com.example.tesseracttest.services;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

@Service
public class tesseractService {
    
    public String extractText(MultipartFile file) throws IOException, TesseractException {
        //Convertir MultipartFile en File
        File convFile = convertMultipartFileToFile(file);

        try {
            // Initialiser Tesseract
            ITesseract tesseract = new Tesseract();
            tesseract.setDatapath("/usr/share/tesseract-ocr/5/tessdata"); // Adapter selon ton installation
            tesseract.setLanguage("ara"); // Définir la langue

            // Extraire le texte
            return tesseract.doOCR(convFile);
        } finally {
            // Supprimer le fichier temporaire après traitement
            convFile.delete();
        }
    }

    // Convertir MultipartFile en File 
    private File convertMultipartFileToFile(MultipartFile file) throws IOException {
        String extension = getFileExtension(file.getOriginalFilename());
        File convFile = File.createTempFile("temp", extension);
        file.transferTo(convFile);
        return convFile;
    }

    // obtenir l'extension d'un image
    private String getFileExtension(String fileName) {
        int lastIndex = fileName.lastIndexOf(".");
        return (lastIndex == -1) ? ".png" : fileName.substring(lastIndex);
    }
}
