package com.example.ProductService.Service;


import com.example.ProductService.DTO.ProductRequest;
import com.example.ProductService.DTO.ProductResponse;
import com.example.ProductService.Model.Product;
import com.example.ProductService.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {


    private final ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(ProductRequest productRequest)
    {
        Product product= new Product(productRequest.getName(),productRequest.getDescription(),productRequest.getPrice());

        productRepository.save(product);

    }

    public List<ProductResponse> getAllProducts() {

        List<Product> products=productRepository.findAll();

       return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {

      ProductResponse productResponse= new ProductResponse();
      productResponse.setName(product.getName());
      productResponse.setId(product.getId());
      productResponse.setPrice(product.getPrice());
    productResponse.setDescription(product.getDescription());

      return productResponse;
    }
}
