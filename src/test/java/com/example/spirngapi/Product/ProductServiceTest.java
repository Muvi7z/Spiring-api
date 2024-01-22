package com.example.spirngapi.Product;

import com.example.spirngapi.DTO.ProductDTO;
import com.example.spirngapi.Entity.Product;
import com.example.spirngapi.Repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductRepository productRepository;

    @Test
    void getProduct() {
        Product product = new Product("name", 1000, 2, "Desc");
        Mockito.when(productRepository.findProductById(1)).thenReturn(product);

        Product product1 = productService.getProductByID(1);

        Assertions.assertEquals(product.getName(),product1.getName() );
    }

    @Test
    void getByFields() {
        Product product = new Product("name card", 1000, 2, "Desc names");

        Mockito.when(productRepository.findProductByDescriptionAndPrice("%name%", "%names%")).thenReturn(List.of(product));

        List<Product> products = productService.getProductByFields("name", "names", null);

        Assertions.assertEquals(product.getId(),products.get(0).getId() );
        Assertions.assertEquals(product.getPrice(),products.get(0).getPrice() );
        Assertions.assertEquals(product.getQuantity(),products.get(0).getQuantity() );
        Assertions.assertEquals(product.getDescription(),products.get(0).getDescription() );
        Assertions.assertEquals(product.getName(),products.get(0).getName() );
    }
}
