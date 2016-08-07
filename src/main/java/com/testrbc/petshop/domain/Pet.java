package com.testrbc.petshop.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "PET")
public class Pet {

    private static final long serialVersionUID = -7616924841970580811L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, unique = true)
    @ApiModelProperty(notes = "The Id of the pet", required = true)
    private String id;

    @Basic
    @NotNull
    @Column(name = "NAME")
    private String name;

    @Basic
    @NotNull
    @Column(name = "OWNER")
    private String owner;

    @Basic
    @Column(name = "BREED")
    private String breed;

    @Basic
    @Column(name = "GENDER")
    private String gender;

    @Basic
    @Column(name = "BIRTH_DATE")
    private String birthDate;

    @Basic
    @Column(name = "ADDRESS")
    private String address;

    @Basic
    @Column(name = "STATUS")
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTags() {
        List<String> tags = new ArrayList<>();
        tags.add(getName());
        tags.add(getAddress());
        tags.add(getBreed());
        tags.add(getGender());
        tags.add(getOwner());
        tags.add(getStatus());
        tags.add(getBirthDate());
        return tags.toString();
    }
}

