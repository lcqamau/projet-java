package fr.epsi.project.phototheque.entity;

import jakarta.persistence.*;

/**
 * Entité prenant en charge les utilisateurs.
 *
 * <p>
 *     L'annotation <i>@Entity</i> indique que cette classe est une classe de mapping
 *     entre le mode objet de l'application et la base de données.
 *     Hibernate realisera automatiquement un mapping entre les colonnes de la table <i>users</i>
 *     et les propriétés des instances de la classe <i>User</i>
 * </p>
 * <p>
 *      L'annotation <i>@Table</i> permet de spécifier le nom de la table à mapper.
 *      Cette annotation n'est pas obligatoire. Par defaut, le nom de la classe est identique
 *      au nom de la table.
 * </p>
 */
@Entity
@Table( name = "users")
public class User {

    /**
     * la propriété <i>id</i>  sera associée à la clé primaire de la table <i>users</i>.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
