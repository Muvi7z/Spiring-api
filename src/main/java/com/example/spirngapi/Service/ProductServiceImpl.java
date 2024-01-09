package com.example.spirngapi.Service;

import com.example.spirngapi.DTO.ProductDTO;
import com.example.spirngapi.Entity.Product;
import com.example.spirngapi.Repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public boolean createProduct(ProductDTO product) {
        Product productDAO = new Product(product.getName(), product.getPrice(), product.getQuantity(), product.getDescription());
        try {
            productRepository.save(productDAO);
            return true;
        }
        catch (Exception e) {
            //error log
            return false;
        }
    }

    @Override
    public Product getProductByID(int id) {
        return productRepository.findProductById(id);
    }
    @Override
    public Product getProductByName(String name) {
        return productRepository.findProductByName(name);
    }
    @Override
    public List<Product>  getProductByFields(String name, String desc, String price) {
        List<Product>  product = null;

        if (desc == null) desc = "";
        if (name == null) name = "";

        if(price != null) {
            try {
                int parsedPrice = Integer.parseInt(price);
                product = productRepository.findProductByFields("%"+name+"%", "%"+desc+"%", parsedPrice);

            }
            catch (Exception e) {
                // return error invalid params
            }
        }
        else {

            product = productRepository.findProductByDescriptionAndPrice("%"+name+"%", "%"+desc+"%");

        }
        return product;
    }


    @Override
    public Product updateProduct(ProductDTO product) {
        Product productDAO = new Product(product.getId(), product.getName(), product.getPrice(), product.getQuantity(), product.getDescription());
        return productRepository.save(productDAO);
    }

    @Override
    public boolean deleteProduct(int id) {
        try {
            productRepository.deleteById(id);
            return true;
        }
        catch (Exception e) {
            //error log
            return false;
        }
    }
}
