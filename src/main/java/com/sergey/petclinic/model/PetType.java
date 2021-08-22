package com.sergey.petclinic.model;

import javax.persistence.*;

/**
 * @author Sergey Borodkin
 */
@Entity
@Table(name = "pet_type")
public class PetType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type", unique = true)
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public PetType(String type) {
        this.type = type;
    }

    public PetType() {
    }
}
