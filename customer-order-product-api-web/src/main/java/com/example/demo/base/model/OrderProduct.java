package com.example.demo.base.model;

import java.util.Objects;
import com.example.demo.base.model.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * OrderProduct
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-01-10T15:38:16.832+05:30[Asia/Calcutta]")
public class OrderProduct  implements Serializable  {
  private static final long serialVersionUID = 1L;

  @JsonProperty("orderProductId")
  private Integer orderProductId = null;

  @JsonProperty("productId")
  private Product productId = null;

  @JsonProperty("quantity")
  private Integer quantity = null;

  @JsonProperty("date")
  private LocalDate date = null;

  public OrderProduct orderProductId(Integer orderProductId) {
    this.orderProductId = orderProductId;
    return this;
  }

  /**
   * Get orderProductId
   * @return orderProductId
  **/
  @ApiModelProperty(required = true, value = "")
      @NotNull

    public Integer getOrderProductId() {
    return orderProductId;
  }

  public void setOrderProductId(Integer orderProductId) {
    this.orderProductId = orderProductId;
  }

  public OrderProduct productId(Product productId) {
    this.productId = productId;
    return this;
  }

  /**
   * Get productId
   * @return productId
  **/
  @ApiModelProperty(value = "")
  
    @Valid
    public Product getProductId() {
    return productId;
  }

  public void setProductId(Product productId) {
    this.productId = productId;
  }

  public OrderProduct quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Get quantity
   * @return quantity
  **/
  @ApiModelProperty(value = "")
  
    public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public OrderProduct date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * Start date
   * @return date
  **/
  @ApiModelProperty(example = "Sun Jan 01 05:30:00 IST 2017", value = "Start date")
  
    @Valid
    public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderProduct orderProduct = (OrderProduct) o;
    return Objects.equals(this.orderProductId, orderProduct.orderProductId) &&
        Objects.equals(this.productId, orderProduct.productId) &&
        Objects.equals(this.quantity, orderProduct.quantity) &&
        Objects.equals(this.date, orderProduct.date);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderProductId, productId, quantity, date);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderProduct {\n");
    
    sb.append("    orderProductId: ").append(toIndentedString(orderProductId)).append("\n");
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
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
