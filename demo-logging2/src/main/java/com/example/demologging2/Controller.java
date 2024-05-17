package com.example.demologging2;

import jakarta.annotation.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
@RestController
public class Controller {

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {

        // Implement file storage logic here (e.g., save to disk, database)
        String fileName = file.getOriginalFilename(); // Get original file name
        // ... (Store the file)

        return ResponseEntity.ok("File uploaded successfully: " + fileName);
    }

    @GetMapping("/download")
    public ResponseEntity<File> downloadFile() throws IOException {

        String pathFileName= "C:\\Users\\Labib\\OneDrive\\Immagini\\Saved Pictures\\fukayamamo-cHP9WBFKm9o-unsplash.jpg";
        File file = new File(pathFileName);

        // Implement file retrieval logic here (e.g., read from disk, database)
        String fileName = "fukayamamo-cHP9WBFKm9o-unsplash.jpg"; // Replace with stored file name

        if (file == null || !file.exists()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(MediaType.APPLICATION_OCTET_STREAM_VALUE))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileName + "\"")
                .body(file);
    }
}
