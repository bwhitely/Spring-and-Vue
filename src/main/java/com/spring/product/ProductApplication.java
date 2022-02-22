package com.spring.product;

import com.spring.product.DAO.CustomerRepository;
import com.spring.product.DAO.ProductRepository;
import com.spring.product.Entities.Customer;
import com.spring.product.Entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class ProductApplication {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(false);
        config.addAllowedOriginPattern("*"); // this allows all origin
        config.addAllowedHeader("*"); // this allows all headers
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
    @Bean
    CommandLineRunner runner() {
        return args -> {
            Customer c1 = new Customer("Ben", "Whitely", "bwhitely@live.com", "0403357524");
            Customer c2 = new Customer("Toula", "Kenyon", "tkenyon@gmail.com", "0411234123");

            Product p1 = new Product("iPhone 13", "Good phone", 1199.00f);
            Product p2 = new Product("Dell Laptop", "Fast", 2399.99f);

            customerRepository.save(c1);
            customerRepository.save(c2);
            productRepository.save(p1);
            productRepository.save(p2);
        };
    }
}
