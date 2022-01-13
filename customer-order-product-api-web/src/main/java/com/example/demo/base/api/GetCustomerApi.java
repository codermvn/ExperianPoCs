/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.15).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.example.demo.base.api;

import com.example.demo.base.model.Customer;
import com.example.demo.base.model.ExceptionResponse;
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
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-01-11T23:42:49.995+05:30[Asia/Calcutta]")
@Api(value = "getCustomer", description = "the getCustomer API")
public interface GetCustomerApi {

    Logger log = LoggerFactory.getLogger(GetCustomerApi.class);

    default Optional<ObjectMapper> getObjectMapper(){
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest(){
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @ApiOperation(value = "get customer By customerId", nickname = "getCustomerCustomerIdGet", notes = "you can get customer by customerId ", response = Customer.class, tags={ "customers", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "search results matching criteria", response = Customer.class),
        @ApiResponse(code = 404, message = "search customer not found", response = ExceptionResponse.class) })
    @RequestMapping(value = "/getCustomer/{customerId}",
        produces = { "application/json", "application/xml" }, 
        method = RequestMethod.GET)
    default ResponseEntity<Customer> getCustomerCustomerIdGet(@ApiParam(value = "",required=true) @PathVariable("customerId") Integer customerId
) throws Exception{
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
            log.warn("ObjectMapper or HttpServletRequest not configured in default GetCustomerApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
