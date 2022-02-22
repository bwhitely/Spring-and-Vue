package com.spring.product.Controllers;

import com.spring.product.DAO.ProductRepository;
import com.spring.product.Entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products/")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/")
    public ResponseEntity<Object> getProducts(){
        try {
            Iterable<Product> products = productRepository.findAll();
            return new ResponseEntity<>(products, HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable("id") Long id){
        try {
            Product product = productRepository.findById(id).get();
            if (product != null){
                return new ResponseEntity<>(product, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Object> createProduct(@RequestBody Product product){
        try {
            Product savedProduct = productRepository.save(product);
            return new ResponseEntity<>(savedProduct, HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable("id") Long id, @RequestBody Product product){
        try {
            product.setId(id);
            Product savedProduct = productRepository.save(product);
            return new ResponseEntity<>(savedProduct, HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") Long id){
        try {
            productRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
