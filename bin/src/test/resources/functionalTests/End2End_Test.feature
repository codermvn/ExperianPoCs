#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Order Search

Scenario: Client wants to deduct inventory
When Client calls /deductInventory/5 with productId as 185
Then the client receives answer as 1990

Scenario: Client wants to get a productName from product inventory
When Client calls /getProduct/185
Then the client receives answer as T-shirt

Scenario: Client wants to add a new product in inventory
When Client calls /addProduct with  productName "Laptop", productPrice 50000.000,company "HP", inventory as 10
Then new product is added into inventory

Scenario: Client wants to delete an order in inventory
When Client calls /deleteOrder/526
Then the client receives an order with order status failed

Scenario: Client wants to get an order
When Client calls /getOrder/526
Then the client receives an Order
