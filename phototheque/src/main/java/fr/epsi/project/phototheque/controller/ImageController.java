package fr.epsi.project.phototheque.controller;

import fr.epsi.project.phototheque.entity.Image;
import fr.epsi.project.phototheque.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/lastTen")
    public ResponseEntity<List<Image>> getLastTenImages() {
        return ResponseEntity.ok(imageService.getLastTenImages());
    }
}
