package com.example.GameStore.model;

import com.example.GameStore.service.DeveloperServiceImpl;
import com.sun.istack.NotNull;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "developers")
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String country;

    @Column
    private String postcode;

    public Developer(){}

    public Developer(String name, String country, String postcode) {
        this.name = name;
        this.country = country;
        this.postcode = postcode;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { 
        this.name = name;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", postcode='" + postcode + '\'' +
                '}';
    }
}
