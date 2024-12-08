package com.example.Inventory_Microservices_Java;

import com.example.Inventory_Microservices_Java.Model.Inventory;
import com.example.Inventory_Microservices_Java.Repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryMicroservicesJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryMicroservicesJavaApplication.class, args);
	}


	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository)
	{
		return args -> {
			Inventory inventory= new Inventory();
			inventory.setSkuCode("Iphone_15");
			inventory.setQuantity(100);

			Inventory inventory1= new Inventory();
			inventory1.setSkuCode("Iphone_13");
			inventory1.setQuantity(300);

			Inventory inventory2= new Inventory();
			inventory2.setSkuCode("Samsung_S24");
			inventory2.setQuantity(100);

			Inventory inventory3= new Inventory();
			inventory3.setSkuCode("Samsung_S23");
			inventory3.setQuantity(10);

			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory1);
			inventoryRepository.save(inventory2);
			inventoryRepository.save(inventory3);

		};

	}
}
