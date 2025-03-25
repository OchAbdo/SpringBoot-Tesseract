package com.example.tesseracttest.controllors;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.tesseracttest.services.tesseractService;

import net.sourceforge.tess4j.TesseractException;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/conv")
@CrossOrigin(origins = "*")
public class tesseractControllor {

    @Autowired
    private tesseractService tesseractservice;

    @PostMapping("/fr")
    public ResponseEntity<String> converterImgageToTextFr(@RequestParam("file") MultipartFile file) {
        
         try {
            String extractedText = tesseractservice.extractText(file);
            return new ResponseEntity<>(extractedText , HttpStatus.OK);
        } catch (IOException | TesseractException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de l'extraction du texte");
        }
    }

    
    

    

}
