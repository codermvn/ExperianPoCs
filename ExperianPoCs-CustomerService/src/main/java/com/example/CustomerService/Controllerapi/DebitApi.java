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

import com.example.CustomerService.model.Customer;
import com.example.CustomerService.model.CustomerAmount;
import com.example.CustomerService.model.ExceptionResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-01-14T00:13:12.191+05:30[Asia/Calcutta]")
@Api(value = "debit", description = "the debit API")
public interface DebitApi {

    Logger log = LoggerFactory.getLogger(DebitApi.class);

    default Optional<ObjectMapper> getObjectMapper(){
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest(){
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @ApiOperation(value = "debit amount", nickname = "debitPost", notes = "debit amount ", response = Customer.class, tags={ "customers", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "amount debited", response = Customer.class),
        @ApiResponse(code = 500, message = "internal server error", response = ExceptionResponse.class),
        @ApiResponse(code = 404, message = "Customer could not be found", response = ExceptionResponse.class),
        @ApiResponse(code = 408, message = "available debit is less than debit requested", response = ExceptionResponse.class) })
    @RequestMapping(value = "/debit",
        produces = { "application/json", "application/xml" }, 
        consumes = { "application/json", "application/xml" },
        method = RequestMethod.POST)
    default ResponseEntity<Customer> debitPost(@ApiParam(value = "amount to be debited"  )  @Valid @RequestBody CustomerAmount body
)  {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{\r\n  \"debitAvailable\" : 1.4658129805029452,\r\n  \"customerAddress\" : \"customerAddress\",\r\n  \"modeOfPayment\" : \"modeOfPayment\",\r\n  \"customerId\" : 6,\r\n  \"customerName\" : \"customerName\",\r\n  \"status\" : \"active\"\r\n}", Customer.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default DebitApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
