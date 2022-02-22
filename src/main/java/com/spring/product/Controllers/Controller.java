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

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/") //important benny mate...
public class Controller {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("")
    public String home(){
        return "Home";
    }
}
