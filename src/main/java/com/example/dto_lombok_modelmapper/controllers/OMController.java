package com.example.dto_lombok_modelmapper.controllers;

import com.example.dto_lombok_modelmapper.entity.Shop;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/mapper/shops")
public class OMController {
    private Map<Long, Shop> shops = new HashMap<>();
    ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    @PostMapping()
    public void postShop(HttpServletRequest request) {
        BufferedReader reader = request.getReader();
        String shopJson = reader.lines().collect(Collectors.joining());
        System.out.println(shopJson);
        Shop shop = objectMapper.readValue(shopJson, Shop.class);
        shops.put(shop.getId(), shop);
    }

    @SneakyThrows
    @GetMapping
    public void getShops(HttpServletResponse response) {
        final Collection<Shop> values = shops.values();
        String shopsResponse = objectMapper.writeValueAsString(values);
        response.getWriter().write(shopsResponse);
    }
}
