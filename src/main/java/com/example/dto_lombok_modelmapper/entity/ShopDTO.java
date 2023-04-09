package com.example.dto_lombok_modelmapper.entity;

import lombok.Data;

@Data
public class ShopDTO {
    private Long id;
    private String name;
    private String address;
    private boolean siteExists;
}
