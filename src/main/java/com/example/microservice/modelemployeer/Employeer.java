package com.example.microservice.modelemployeer;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="Employee")
public class Employeer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="bloodgroup")
    private String bloodgroup;

}
