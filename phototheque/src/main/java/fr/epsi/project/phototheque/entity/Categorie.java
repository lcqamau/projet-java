package fr.epsi.project.phototheque.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "Categorie")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Categorie")
    private Long id;

    @Column(name = "Nom")
    private String name;

    @Column(name = "Nombre_img")
    private int numberOfImages;

    // Getters and Setters
    // Constructors
    // Equals and HashCode
}