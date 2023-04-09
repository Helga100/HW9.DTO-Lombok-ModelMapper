package com.example.dto_lombok_modelmapper.repository;

import com.example.dto_lombok_modelmapper.entity.Shop;
import org.springframework.data.repository.CrudRepository;

public interface ShopRepository extends CrudRepository<Shop, Long> {
}
