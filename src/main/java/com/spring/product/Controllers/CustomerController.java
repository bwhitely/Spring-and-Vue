package com.spring.product.Controllers;

import com.spring.product.DAO.CustomerRepository;
import com.spring.product.Entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/customers/")
@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(value = "/")
    public ResponseEntity<Object> getCustomers(){
        try {
            Iterable<Customer> customers = customerRepository.findAll();
            return new ResponseEntity<>(customers, HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getCustomerById(@PathVariable("id") Long id){
        try {
            Customer customer = customerRepository.findById(id).get();
            if (customer != null){
                return new ResponseEntity<>(customer, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Object> createCustomer(@RequestBody Customer customer){
        try {
            Customer savedCustomer = customerRepository.save(customer);
            return new ResponseEntity<>(savedCustomer, HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCustomer(@PathVariable("id") Long id, @RequestBody Customer customer){
        try {
            customer.setId(id);
            Customer savedCustomer = customerRepository.save(customer);
            return new ResponseEntity<>(savedCustomer, HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") Long id){
        try {
            customerRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
