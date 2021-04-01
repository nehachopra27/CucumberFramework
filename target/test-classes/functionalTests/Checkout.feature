Feature: Golden path for user checkout
Description: This feature tests the complete product checkout flow on the e-commerce website.

Scenario: User is able to place an order for any item in catalog

Given User is on Home Page
When he navigates to the Women Category
And adds to cart the first available product on page
And moves to the checkout page
And login as a existing user
|username|test23@test.com|
|password|test123|
And select existing address
And agrees to terms and conditions
And selects BankWire and complete checkout
Then Product should be ordered
