package com.example.GameStore.model;

import com.example.GameStore.repo.DeveloperRepo;
import com.example.GameStore.service.DeveloperService;
import com.example.GameStore.service.DeveloperServiceImpl;
import org.hibernate.dialect.DB297Dialect;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;


@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String isbn;

    @Column
    private Integer quantity;

    @Column
    private Double price;

    @ManyToOne
    @JoinColumn(name = "developer_id")
    private Developer developer;

    @Column
    private String genre;

    @Column
    private Integer releaseYear;

    public Game(){}

    public Game(String name, String isbn, Integer quantity, Double price, String genre, Integer releaseYear, Developer developer) {
            this.name = name;
            this.isbn = isbn;
            this.quantity = quantity;
            this.price = price;
            this.genre = genre;
            this.releaseYear = releaseYear;
            this.developer = developer;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice(){
        return price;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }


    @Override
    public String toString() {
        return "VideoGame{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isbn='" + isbn + '\'' +
                ", quantity='" + quantity + '\'' +
                ", price='" + price + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseYear=" + releaseYear +
                ", developer=" + developer +
                '}';
    }
}
