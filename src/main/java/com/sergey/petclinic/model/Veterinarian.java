package com.sergey.petclinic.model;

import javax.persistence.*;

/**
 * @author Sergey Borodkin
 */
@Entity
@Table(name = "veterinarian")
public class Veterinarian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "specialty")
    private String specialty;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Veterinarian(String name, String specialty) {
        this.name = name;
        this.specialty = specialty;
    }

    public Veterinarian() {
    }
}
