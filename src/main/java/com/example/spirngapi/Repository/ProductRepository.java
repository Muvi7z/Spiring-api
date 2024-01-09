package com.example.spirngapi.Repository;

import com.example.spirngapi.DTO.ProductDTO;
import com.example.spirngapi.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query(value = "select p from Product p where p.id = :id")
    Product findProductById(int id);
    @Query(value = "select p from Product p where p.name like :name") //"%fsad%"
    Product findProductByName(String name);

    @Query(value = "select p from Product p where p.name like :name and p.description like :desc and p.price = :price")
    List<Product>  findProductByFields(String name, String desc, int price);

    @Query(value = "select p from Product p where p.name like :name and p.description like :desc")
    List<Product>  findProductByDescriptionAndPrice(String name, String desc);

    @Query(value = "select p from Product p where p.id = :id")
    Product deleteProduct(int id);

    @Query(value = "select p from Product p")
    List<Product> getAllProduct();
}
