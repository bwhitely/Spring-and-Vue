package com.spring.product.DAO;

import com.spring.product.Entities.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
