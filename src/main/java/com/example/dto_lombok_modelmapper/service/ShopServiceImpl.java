package com.example.dto_lombok_modelmapper.service;

import com.example.dto_lombok_modelmapper.entity.Shop;
import com.example.dto_lombok_modelmapper.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Override
    public Shop createShop(Shop shop) {
        return shopRepository.save(shop);
    }

    @Override
    public List<Shop> findShops() {
        return (List<Shop>) shopRepository.findAll();
    }
}
