Feature: User is able to place order successfully.


  Scenario Outline: validate user is able to login successfully
    Given Browser launched successfully
    And User is on the application login page
    When User enters valid <userid> and <password>
    And User clicks on login button
    Then User lands on application home page successfully

    Examples: 
      | userid        | password     |
      | standard_user | secret_sauce |
      

  Scenario: User add items in the cart
    When User selects products
    Then the products is added into the cart
    Then User click on cart icon
    And User verifies products in the cart
    And user clicks on checkout button


   Scenario Outline: User checkout the products successfully
    When User enters Customer <Firtname>, <LastName> and <ZipCode>
    And User clicks on finish button
    Then order is placed successfully
    And Close the browser

    Examples: 
      | Firtname |LastName |ZipCode|
      | Test     | User    |09999  |
      
   