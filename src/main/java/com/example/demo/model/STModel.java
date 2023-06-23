package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Smart_tracz_db")
@Data
public class STModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String materialId;
    private String materialName;
}
