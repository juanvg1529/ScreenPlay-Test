#author: Juan Diego Vera, Miriana Julio
# language: en


Feature: E-commerce Shopping Flow

  @successful
  Scenario Outline: User logs in, searches for a product, adds it to the cart, and completes the checkout process
    Given the "Miriana" accesses the URL
    When the Miriana logs in to the webpage with the following credentials:
      | Field     | Value                       |
      | Email     | juand.verag@autonoma.edu.co |
      | Password  | jdvg1529                    |
    Then "Miriana" should be authenticated successfully
    When "Miriana" searches for the  <Product>
    And "Miriana" selects the <Product>
    And "Miriana" clicks "Add to Cart"
    And the user provides the following product characteristics:
      | Characteristic | Value      |
      | Size           | <size>    |
      | Color          | <color>   |
      | Quantity       | <quantity> |
    And  clicks "Add to Cart"
    When Miriana proceeds to checkout
      | Field        | Value   |
      | Bank Deposit | true    |
      | UUID         | 7418596 |
    And the user clicks "Pay Now"
    Then Miriana should see the message "Congratulation! Payment is successful."
    Then Miriana should see the product in the order history of the dashboard

    Examples:
      | Product |
      | 1       |
      | 2       |


