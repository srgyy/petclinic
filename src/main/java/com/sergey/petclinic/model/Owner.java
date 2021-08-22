package com.sergey.petclinic.model;

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * @author Sergey Borodkin
 */
@Entity
@Table(name = "owner")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "First Name should not be empty")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Last Name should not be empty")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "Address should not be empty")
    @Column(name = "address")
    private String address;

    @NotBlank(message = "City should not be empty")
    @Column(name = "city")
    private String city;

    @NotBlank(message = "Telephone should not be empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Telephone should be 10 digits")
    @Column(name = "telephone")
    private String telephone;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Owner(String firstName, String lastName, String address, String city, String telephone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.telephone = telephone;
    }

    public Owner() {
    }
}
