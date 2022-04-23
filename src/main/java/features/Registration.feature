Feature: Registration flow feature

  Scenario: The Registration page can be accessed from Navigation bar
    Given "https://demo-opencart.com/" is accessed
    When User clicks on register button from navigation bar
    Then "index.php?route=account/register" is present within the current url


  Scenario: Open cart page is accessible
    When "https://demo-opencart.com/" is accessed
    Then "https://demo-opencart.com/" is present within the current url