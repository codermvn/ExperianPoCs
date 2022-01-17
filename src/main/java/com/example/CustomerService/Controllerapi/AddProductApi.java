/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.15).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.example.CustomerService.Controllerapi;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.CustomerService.model.InputProduct;
import com.example.demo.base.model.ExceptionResponse;
import com.example.demo.base.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-01-14T15:25:09.990+05:30[Asia/Calcutta]")
@Api(value = "addProduct", description = "the addProduct API")
public interface AddProductApi {

    Logger log = LoggerFactory.getLogger(AddProductApi.class);

    default Optional<ObjectMapper> getObjectMapper(){
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest(){
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @ApiOperation(value = "add product", nickname = "addProductPost", notes = "add product ", response = Product.class, tags={ "products", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = Product.class),
        @ApiResponse(code = 400, message = "invalid input, object invalid", response = ExceptionResponse.class),
        @ApiResponse(code = 409, message = "Product already exists", response = ExceptionResponse.class) })
    @RequestMapping(value = "/addProduct",
        produces = { "application/json", "application/xml" }, 
        consumes = { "application/json", "application/xml" },
        method = RequestMethod.POST)
    default ResponseEntity<Product> addProductPost(@ApiParam(value = "product to add"  )  @Valid @RequestBody InputProduct body
) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{\r\n  \"productId\" : 5,\r\n  \"company\" : \"company\",\r\n  \"inventory\" : 2,\r\n  \"productName\" : \"Shirt\",\r\n  \"productPrice\" : 5.637376656633329\r\n}", Product.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default AddProductApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
