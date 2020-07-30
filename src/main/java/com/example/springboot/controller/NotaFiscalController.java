package com.example.springboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.model.Product;
import com.example.springboot.service.HelloService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jcifs.smb.SmbFile;

@Api("Operações com documentos fiscais da mensageria. ")
@RestController
@Validated
public class NotaFiscalController {
	@Autowired
	private HelloService helloService; 
	
    @RequestMapping(path = "/hello")
    @ApiOperation(value = "Operações de Nota Fiscal.", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Não existe") })
    public String index(@RequestParam(required=false, value="Product") Product pProd) {
        return "{'value' : 'Greetings from GET Nota Fiscal Controller!'}";
    }

    @RequestMapping(path = "/hello", method=RequestMethod.POST)
    @ApiOperation(value = "Operações de Nota Fiscal.", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Não existe") })
    public String setIndex(@RequestParam(required=false, value="Product") Product pProd) {
        return "{'value' : 'Greetings from  POST Nota Fiscal Controller!!'}";
    }
    
    @ApiOperation(value = "Consulta de produto")
    @GetMapping(value = "/produto", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getProduto(@RequestParam(required=false) Product pProd) {
    	return helloService.getProduto(pProd);
    }
    
    @ApiOperation(value = "Consulta de produto 2")
    @GetMapping(value = "/produto_b", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getProduto(@RequestParam(required=false) String name, @RequestParam(required=false) @Valid Double price) {
    	System.out.println("Starting method getProduto");
    	 Product prod = new Product(1, name, price);
    	return helloService.getProduto(name, price);
    }

}
