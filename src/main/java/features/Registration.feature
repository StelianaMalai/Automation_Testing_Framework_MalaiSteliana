@TC3
Feature: Registration flow feature

  Background:
    Given "HomePage" is opened

  @TC1
  Scenario: The Registration page can be accessed from Navigation bar
    When User clicks on register button from navigation bar
    Then "index.php?route=account/register" is present within the current url

  @TC2
  Scenario: Open cart page is accessible
      Then "https://demo-opencart.com/" is present within the current url

  @TC3
  Scenario Outline: Error message is displayed when providing invalid data for registration form
    And "RegisterPage" is opened
    When the register fields are populated with the following data:
      | firstName       | <first name>       |
      | lastName        | <last name>        |
      | email           | <email>            |
      | phone           | <phone>            |
      | password        | <password>         |
      | confirmPassword | <confirm password> |
    And privacy checkbox is clicked
    And continue button is clicked
    Then the following key words are present within the error message
      | <error message> |
    Examples:
      | affectedField    | first name | last name | email            | phone       | password   | confirm password | error message                                   |
      | First Name       |            | Customer  | tested@email.com | 05785548454 | Testedpass | Testedpass       | First Name must be between 1 and 32 characters! |
      | Last Name        | Tested     |           | tested@email.com |             | Testedpass | Testedpass       | Last Name must be between 1 and 32 characters!  |
      | E-mail           | Tested     | Customer  |                  | 05785548454 | Testedpass | Testedpass       | appear to be valid!                             |
      | Telephone        | Tested     | Customer  | tested@email.com |             | Testedpass | Testedpass       | Telephone must be between 3 and 32 characters!  |
      | Password         | Tested     | Customer  | tested@email.com | 05785548454 |            | Testedpass       | Password must be between 4 and 20 characters!   |
      | Password         | Tested     | Customer  | tested@email.com | 05785548454 | abc        | abc              | Password must be between 4 and 20 characters!   |
      | Password Confirm | Tested     | Customer  | tested@email.com | 05785548454 | Testedpass |                  | Password confirmation does not match password!  |


