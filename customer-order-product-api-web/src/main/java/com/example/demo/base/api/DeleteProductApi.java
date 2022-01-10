/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.15).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.example.demo.base.api;

import com.example.demo.base.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-01-10T11:54:52.310+05:30[Asia/Calcutta]")
@Api(value = "deleteProduct", description = "the deleteProduct API")
public interface DeleteProductApi {

    Logger log = LoggerFactory.getLogger(DeleteProductApi.class);

    default Optional<ObjectMapper> getObjectMapper(){
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest(){
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @ApiOperation(value = "delete Product By ProductId", nickname = "deleteProductProductIdDelete", notes = "you can delete Product by ProductId ", response = Product.class, responseContainer = "List", tags={ "products", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "product deleted successfully", response = Product.class, responseContainer = "List"),
        @ApiResponse(code = 400, message = "bad input parameter") })
    @RequestMapping(value = "/deleteProduct/{productId}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    default ResponseEntity<List<Product>> deleteProductProductIdDelete(@ApiParam(value = "",required=true) @PathVariable("productId") Integer productId
) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("[ {\r\n  \"productId\" : 0,\r\n  \"company\" : \"company\",\r\n  \"inventory\" : 1,\r\n  \"productName\" : \"Widget Adapter\",\r\n  \"productPrice\" : 6.027456183070403\r\n}, {\r\n  \"productId\" : 0,\r\n  \"company\" : \"company\",\r\n  \"inventory\" : 1,\r\n  \"productName\" : \"Widget Adapter\",\r\n  \"productPrice\" : 6.027456183070403\r\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default DeleteProductApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
