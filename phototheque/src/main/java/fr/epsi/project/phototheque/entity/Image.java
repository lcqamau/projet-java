package fr.epsi.project.phototheque.entity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String category;
    private String description;
    private long size;
    private LocalDateTime creationDate;
    private LocalDateTime lastModifiedDate;
    private boolean presenceOfIndividual;
    // Getters and Setters
}
