package fr.epsi.project.phototheque.service;
import fr.epsi.project.phototheque.entity.Image;
import fr.epsi.project.phototheque.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class ImageService {

    private final ImageRepository imageRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public List<Image> getLastTenImages() {
        // Implémentez votre logique ici
        return new ArrayList<>();
    }
}