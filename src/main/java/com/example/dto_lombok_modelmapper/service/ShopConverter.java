package com.example.dto_lombok_modelmapper.service;

import com.example.dto_lombok_modelmapper.entity.Shop;
import com.example.dto_lombok_modelmapper.entity.ShopDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopConverter {
    public ShopDTO convertToDTO(Shop shop) {
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setId(shop.getId());
        shopDTO.setAddress(shop.getAddress());
        shopDTO.setName(shop.getName());
        shopDTO.setSiteExists(shop.isSiteExists());
        return shopDTO;
    }

    public Shop convertToEntity(ShopDTO shopDTO) {
        Shop shop = new Shop();
        shop.setId(shopDTO.getId());
        shop.setName(shopDTO.getName());
        shop.setAddress(shopDTO.getAddress());
        shop.setSiteExists(shopDTO.isSiteExists());
        return shop;
    }

    public List<ShopDTO> convertToListDTO(List<Shop> shops) {
        return shops.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
}
