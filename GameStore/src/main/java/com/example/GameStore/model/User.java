package com.example.GameStore.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String username;

    @Column
    private char[] password;

    @Column
    private String email;

    @Column
    private String role;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="user")
    private Collection<Order> orders = new HashSet<>();


    public User(){}

    public User(String username, String password, String email, String role) {
        this.username = username;
        this.password = password.toCharArray();
        this.email = email;
        this.role = role.toLowerCase();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return Arrays.toString(password);
    }

    public void setPassword(String password) {
        this.password = password.toCharArray();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
       this.role = role.toLowerCase();
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password=" + Arrays.toString(password) +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
