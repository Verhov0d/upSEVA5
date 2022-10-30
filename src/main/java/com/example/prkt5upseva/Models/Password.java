package com.example.prkt5upseva.Models;
import javax.persistence.*;

@Entity
@Table(name = "passwords")
public class Password {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String passwordName;
    @OneToOne(optional = true, mappedBy = "password")
    private Person owner;

    public Long getId() {
        return id;
    }

    public String getPasswordName() {
        return passwordName;
    }

    public Person getOwner() {
        return owner;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPasswordName(String passwordName) {
        this.passwordName = passwordName;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }
}