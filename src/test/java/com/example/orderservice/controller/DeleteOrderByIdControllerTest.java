/*
 * package com.example.orderservice.controller;
 * 
 * import org.junit.jupiter.api.Test; import org.mockito.Mockito; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest; import
 * org.springframework.boot.test.mock.mockito.MockBean; import
 * org.springframework.test.web.servlet.MockMvc; import
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders; import
 * static
 * org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
 * 
 * import com.example.orderservice.model.Order; import
 * com.example.orderservice.service.OrderService;
 * 
 * @WebMvcTest(value = DeleteOrderByIdController.class) public class
 * DeleteOrderByIdControllerTest {
 * 
 * @Autowired private MockMvc mockMvc;
 * 
 * @MockBean private OrderService orderService;
 * 
 * @Test public void testDeleteOrderOrderIdDelete() throws Exception {
 * 
 * Order order = new Order();
 * 
 * Mockito.when(orderService.deleteOrderById(1)).thenReturn(order);
 * mockMvc.perform(MockMvcRequestBuilders.delete("/deleteOrder/{orderId}",
 * 1)).andExpect(status().isOk()); } }
 */