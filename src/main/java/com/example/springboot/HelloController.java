package com.example.springboot;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.model.Product;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api("Operações com documentos fiscais da mensageria. ")
@RestController
public class HelloController {
    @RequestMapping(path = "/hello")
    @ApiOperation(value = "Operações de Nota Fiscal.", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Não existe") })
    public String index(@RequestParam(required=false, value="Product") Product pProd) {
        return "{'value' : 'Greetings from Spring Boot!'}";
    }

    @RequestMapping(path = "/hello", method=RequestMethod.POST)
    @ApiOperation(value = "Operações de Nota Fiscal.", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Não existe") })
    public String setIndex(@RequestParam(required=false, value="Product") Product pProd) {
        return "{'value' : 'Greetings from Spring Boot!'}";
    }
    
    @ApiOperation(value = "Consulta de produto")
    @GetMapping(value = "/produto", produces = MediaType.APPLICATION_JSON_VALUE)
    public Product getProduto(@RequestParam(required=false) Product pProd) {
        Product prod = new Product();
        prod.setId(1);
        prod.setName("Serviço de cloud");
        prod.setPrice(201.88);

        return prod;
    }
}
