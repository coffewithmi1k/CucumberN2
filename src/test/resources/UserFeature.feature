Feature: UserController
  @runnn
  Scenario: Log In
    Given LogIn Parameters
    When sends post logIn request
    Then verifies user is logged In