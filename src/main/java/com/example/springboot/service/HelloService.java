package com.example.springboot.service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.example.springboot.model.Product;

@Service
@Validated
public class HelloService {

	public Product getProduto(@Valid Product pProd) {
		if (pProd.getPrice() == 0) {
			throw new IllegalArgumentException("Preço nao pode ser nulo");
		}
        return pProd;
	}

	public Product getProduto(@Valid @Size(min =5) String name,  @NotNull @Valid Double price) {
        Product prod = new Product(1, name, price);

        return prod;
	}

}
