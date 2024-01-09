package com.example.spirngapi.Service;

import com.example.spirngapi.DTO.ProductDTO;
import com.example.spirngapi.Entity.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProducts();

    public boolean createProduct(ProductDTO product);

    public Product getProductByID(int id);
    public Product updateProduct(ProductDTO product);
    public boolean deleteProduct(int id);
    public Product getProductByName(String name);
    public List<Product>  getProductByFields(String name, String desc, String price);

}
