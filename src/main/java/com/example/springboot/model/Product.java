package com.example.springboot.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "Entidade de produtos", value="Nosso Produto")
@Validated
@Valid
public class Product {
    private int id;
    @NotNull
    @Size(min=5)
    private String name;
    
    @NotNull
    private double price;

    public Product(int id, @Valid @NotNull @Size(min=5, max=10) String name, @Valid @NotNull double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Product() {
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
