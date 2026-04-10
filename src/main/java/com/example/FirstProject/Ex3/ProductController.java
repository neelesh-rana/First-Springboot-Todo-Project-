package com.example.FirstProject.Ex3;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    public List<Product> products= new ArrayList<>();

    @GetMapping
    public List<Product> getproduct(){
        return  products;

    }


   @GetMapping("/{id}")
    public  Product getbyid(@PathVariable int id ){

        for(Product p : products){
            if(p.getId()==id){
                return  p ;
            }
        }
        return  null;

   }


   @PostMapping
    public Product createProduct(@RequestBody Product product){
        products.add(product);
        return  product;


   }



    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable int id) {

        boolean removed = products.removeIf(p -> p.getId() == id);

        if (removed) {
            return "Product Deleted";
        } else {
            return "Product Not Found";
        }
    }









}
