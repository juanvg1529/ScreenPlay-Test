#author: Juan Diego Vera, Miriana Julio
# language: en


Feature: E-commerce Shopping Flow

  @successful
  Scenario Outline: User logs in, searches for a product, adds it to the cart, and completes the checkout process
    Given the <Actor> accesses the URL
    When "<Actor> logs in to the webpage with the following credentials:
      | Field     | Value                       |
      | Email     | juand.verag@autonoma.edu.co |
      | Password  | jdvg1529                    |
    Then <Actor> should be authenticated successfully
    When <Actor> searches for the <Product>
    And <Actor> clicks "Add to Cart"
    And the <Actor> provides the following product characteristics:
      | Characteristic | Value       |
      | Size           | Free size/L |
      | Color          | white       |
      | Quantity       | 1           |
    And <Actor> clicks "Add to Cart the product"
    When <Actor> proceeds to checkout
      | Field        | Value   |
      | Bank Deposit | true    |
      | UUID         | 7418596 |
    And <Actor> clicks "Pay Now"
    Then <Actor> should see the message "Congratulation! Payment is successful."
    Then <Actor> should see the product in the order history of the dashboard

    Examples:
      | Product                                      | Actor   |
      | Amazfit GTS 3 Smart Watch for Android iPhone | Miriana |
      | Men's Long Cuffed Jogger Yoga Sweat Pant     | Camilo  |


