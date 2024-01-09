package com.example.spirngapi.Contoller;

import com.example.spirngapi.DTO.ProductDTO;
import com.example.spirngapi.Entity.Product;
import com.example.spirngapi.Service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class Contoller {

    private final ProductService productService;

    public Contoller(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/product/{id}")
    public Product getProductByID(@PathVariable int id) {
        return productService.getProductByID(id);
    }

//    @GetMapping("/product/")
//    public Product getProductByName(@RequestParam String name, @RequestParam String desc, @RequestParam int price ) {
//        return productService.getProductByName("%"+name+"%");
//    }

    @GetMapping("/product/")
    public List<Product> getProductByFields(@RequestParam Map<String,String> requestParams) { //String name, @RequestParam String desc, @RequestParam int price
        String name=requestParams.get("name");
        String desc=requestParams.get("desc");
        String price=requestParams.get("price");
        return productService.getProductByFields(name, desc, price);
    }

    @DeleteMapping("/product/{id}")
    public boolean deleteProduct(@PathVariable int id) {
        return productService.deleteProduct(id);
    }

    @PostMapping("/product")
    public boolean createNewProduct(@RequestBody ProductDTO productDTO) {
        return productService.createProduct(productDTO);
    }
}
