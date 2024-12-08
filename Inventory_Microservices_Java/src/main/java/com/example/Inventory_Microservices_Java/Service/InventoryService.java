package com.example.Inventory_Microservices_Java.Service;


import com.example.Inventory_Microservices_Java.Repository.InventoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Transactional(readOnly = true)
    public boolean isInStock(String skucode)
    {
return inventoryRepository.findBySkuCode(skucode).isPresent();
    }
}
