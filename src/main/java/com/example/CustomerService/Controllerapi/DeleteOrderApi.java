/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.15).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.example.CustomerService.Controllerapi;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.CustomerService.model.ExceptionResponse;
import com.example.CustomerService.model.Order;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-01-14T00:13:12.191+05:30[Asia/Calcutta]")
@Api(value = "deleteOrder", description = "the deleteOrder API")
public interface DeleteOrderApi {

    Logger log = LoggerFactory.getLogger(DeleteOrderApi.class);

    default Optional<ObjectMapper> getObjectMapper(){
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest(){
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @ApiOperation(value = "delete Order By orderId", nickname = "deleteOrderOrderIdDelete", notes = "you can delete order by orderId ", response = Order.class, tags={ "orders", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "search results matching criteria", response = Order.class),
        @ApiResponse(code = 404, message = "search order not found", response = ExceptionResponse.class) })
    @RequestMapping(value = "/deleteOrder/{orderId}",
        produces = { "application/json", "application/xml" }, 
        method = RequestMethod.DELETE)
    default ResponseEntity<Order> deleteOrderOrderIdDelete(@ApiParam(value = "",required=true) @PathVariable("orderId") Integer orderId
) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{\r\n  \"ordStatus\" : \"success\",\r\n  \"orderId\" : 0,\r\n  \"orderProducts\" : [ {\r\n    \"date\" : \"2017-01-01T00:00:00.000+0000\",\r\n    \"product\" : {\r\n      \"productId\" : 5,\r\n      \"company\" : \"company\",\r\n      \"inventory\" : 2,\r\n      \"productName\" : \"Widget Adapter\",\r\n      \"productPrice\" : 5.637376656633329\r\n    },\r\n    \"quantity\" : 7\r\n  }, {\r\n    \"date\" : \"2017-01-01T00:00:00.000+0000\",\r\n    \"product\" : {\r\n      \"productId\" : 5,\r\n      \"company\" : \"company\",\r\n      \"inventory\" : 2,\r\n      \"productName\" : \"Widget Adapter\",\r\n      \"productPrice\" : 5.637376656633329\r\n    },\r\n    \"quantity\" : 7\r\n  } ],\r\n  \"orderValue\" : 9.301444243932576,\r\n  \"customer\" : {\r\n    \"debitAvailable\" : 1.4658129805029452,\r\n    \"customerAddress\" : \"customerAddress\",\r\n    \"modeOfPayment\" : \"modeOfPayment\",\r\n    \"customerId\" : 6,\r\n    \"customerName\" : \"customerName\",\r\n    \"status\" : \"active\"\r\n  }\r\n}", Order.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default DeleteOrderApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
