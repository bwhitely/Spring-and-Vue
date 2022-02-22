package com.spring.product.Controllers;

import com.spring.product.DAO.CustomerRepository;
import com.spring.product.DAO.ProductRepository;
import com.spring.product.Entities.Customer;
import com.spring.product.Entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.stream.Stream;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/") //important benny mate...
public class Controller {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("")
    public ResponseEntity<Object> home(){
        try {
            Iterable<Customer> customers = customerRepository.findAll();
            Iterable<Product> products = productRepository.findAll();
            ArrayList<Object> customersAndProducts = new ArrayList<>();

            for (Customer c : customers){
                customersAndProducts.add(c);
            }
            for (Product p : products)
                customersAndProducts.add(p);
            return new ResponseEntity<>(customersAndProducts, HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
