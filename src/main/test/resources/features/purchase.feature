#author: Juan Diego Vera, Miriana Julio, Andres Camilo Fajardo
# language: en


Feature: E-commerce Shopping Flow

  @successful
  Scenario: User logs in, searches for a product, adds it to the cart, and completes the checkout process
    Given the "Miriana" accesses the URL
    When "Miriana" logs in to the webpage with the following credentials:
      | Field     | Value                       |
      | Email     | juand.verag@autonoma.edu.co |
      | Password  | jdvg1529                    |
    Then "Miriana" should be authenticated successfully
    When "Miriana" searches for the "Amazfit GTS 3 Smart Watch for Android iPhone"
    And "Miriana" clicks "Add to Cart"
    And the "Miriana" provides the following product characteristics:
      | Characteristic | Value     |
      | Size           | Free Size |
      | Color          | White     |
      | Quantity       | 2         |
    And "Miriana" clicks "Cart"
    When "Miriana" completes the payment
      | Field          | Value        |
      | Payment Method | Bank Deposit |
    Then "Miriana" should see the message "Congratulation! Payment is successful."
    Then "Miriana" should see the product in the order history of the dashboard


