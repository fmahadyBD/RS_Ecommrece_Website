package com.rs.rs.models;



import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="admins")
public class Admins {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String name;
    private String role;

    @OneToMany(mappedBy = "admins", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Messages> messages;

    // No-argument constructor
    public Admins() {
    }

    // Constructor with parameters
    public Admins(String name, String role, List<Messages> messages) {
        this.name = name;
        this.role = role;
        this.messages = messages;
    }
 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Messages> getMessages() {
        return messages;
    }

    public void setMessages(List<Messages> messages) {
        this.messages = messages;
    }


    
}
