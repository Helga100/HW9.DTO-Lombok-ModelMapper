package com.example.dto_lombok_modelmapper.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "DTOShop")
@Data
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;
    private int employeeQuantity;
    private boolean siteExists;

}
