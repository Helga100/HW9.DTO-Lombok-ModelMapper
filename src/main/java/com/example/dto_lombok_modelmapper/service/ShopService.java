package com.example.dto_lombok_modelmapper.service;

import com.example.dto_lombok_modelmapper.entity.Shop;

import java.util.List;

public interface ShopService {

    Shop createShop(Shop shop);

    List<Shop> findShops();
}
