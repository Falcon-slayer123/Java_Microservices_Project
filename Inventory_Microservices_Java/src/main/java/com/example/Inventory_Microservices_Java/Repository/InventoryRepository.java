package com.example.Inventory_Microservices_Java.Repository;

import com.example.Inventory_Microservices_Java.Model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    Optional<Inventory> findBySkuCode(String skucode);
}
