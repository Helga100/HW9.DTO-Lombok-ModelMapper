package com.example.dto_lombok_modelmapper.controllers;

import com.example.dto_lombok_modelmapper.entity.Shop;
import com.example.dto_lombok_modelmapper.entity.ShopDTO;
import com.example.dto_lombok_modelmapper.service.ShopConverter;
import com.example.dto_lombok_modelmapper.service.ShopServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/shops")
public class ShopController {

    @Autowired
    private ShopServiceImpl shopServiceImpl;

    @Autowired
    private ShopConverter shopConverter;

    @PostMapping
    public ResponseEntity<ShopDTO> createShop(@RequestBody ShopDTO shopDTO) {
        if (shopDTO == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Shop shop = shopConverter.convertToEntity(shopDTO);
        Shop createdShop = shopServiceImpl.createShop(shop);
        return new ResponseEntity<>(shopConverter.convertToDTO(createdShop), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<ShopDTO>> getShops() {
        List<Shop> shops = shopServiceImpl.findShops();
        return new ResponseEntity<>(shopConverter.convertToListDTO(shops), HttpStatus.OK);
    }
}
