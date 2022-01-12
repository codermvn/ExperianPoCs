package com.example.demo.base.model;

import java.util.Objects;
import com.example.demo.base.model.Customer;
import com.example.demo.base.model.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Order
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-01-11T23:42:49.995+05:30[Asia/Calcutta]")
public class Order  implements Serializable  {
  private static final long serialVersionUID = 1L;

  @JsonProperty("orderId")
  private Integer orderId = null;

  @JsonProperty("customerId")
  private Customer customerId = null;

  @JsonProperty("orderProductId")
  @Valid
  private List<Product> orderProductId = null;

  @JsonProperty("orderValue")
  private BigDecimal orderValue = null;

  @JsonProperty("orderStatus")
  private String orderStatus = null;

  public Order orderId(Integer orderId) {
    this.orderId = orderId;
    return this;
  }

  /**
   * Get orderId
   * @return orderId
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }

  public Order customerId(Customer customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * Get customerId
   * @return customerId
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Customer getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Customer customerId) {
    this.customerId = customerId;
  }

  public Order orderProductId(List<Product> orderProductId) {
    this.orderProductId = orderProductId;
    return this;
  }

  public Order addOrderProductIdItem(Product orderProductIdItem) {
    if (this.orderProductId == null) {
      this.orderProductId = new ArrayList<>();
    }
    this.orderProductId.add(orderProductIdItem);
    return this;
  }

  /**
   * Get orderProductId
   * @return orderProductId
  **/
  @ApiModelProperty(value = "")
      @Valid
    public List<Product> getOrderProductId() {
    return orderProductId;
  }

  public void setOrderProductId(List<Product> orderProductId) {
    this.orderProductId = orderProductId;
  }

  public Order orderValue(BigDecimal orderValue) {
    this.orderValue = orderValue;
    return this;
  }

  /**
   * Get orderValue
   * @return orderValue
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public BigDecimal getOrderValue() {
    return orderValue;
  }

  public void setOrderValue(BigDecimal orderValue) {
    this.orderValue = orderValue;
  }

  public Order orderStatus(String orderStatus) {
    this.orderStatus = orderStatus;
    return this;
  }

  /**
   * Get orderStatus
   * @return orderStatus
  **/
  @ApiModelProperty(value = "")
  
    public String getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(String orderStatus) {
    this.orderStatus = orderStatus;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Order order = (Order) o;
    return Objects.equals(this.orderId, order.orderId) &&
        Objects.equals(this.customerId, order.customerId) &&
        Objects.equals(this.orderProductId, order.orderProductId) &&
        Objects.equals(this.orderValue, order.orderValue) &&
        Objects.equals(this.orderStatus, order.orderStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, customerId, orderProductId, orderValue, orderStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Order {\n");
    
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    orderProductId: ").append(toIndentedString(orderProductId)).append("\n");
    sb.append("    orderValue: ").append(toIndentedString(orderValue)).append("\n");
    sb.append("    orderStatus: ").append(toIndentedString(orderStatus)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
