package fr.epsi.project.phototheque.v1.dto;

public class UserDto {
    private String firstname;
    private String lastname;

    private Long id;

    public UserDto() {

    }

    public UserDto(String firstname, String lastname) {
        this(null, firstname, lastname);
    }

    public UserDto(Long id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
