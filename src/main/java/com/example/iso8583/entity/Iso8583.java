package com.example.iso8583.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "iso8583")
public class Iso8583 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "json")
    private String json;

}
