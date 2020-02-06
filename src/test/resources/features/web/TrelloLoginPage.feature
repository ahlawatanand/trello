Feature: Login into Trello
  In order to access Trello homepage
  As a valid user
  I want to login into Trello loginpage

#  Scenario: Launch Login page and login with Valid details
#    When the user goes to Trello Login page
#    And enters the valid details and click on LoginButton
#      | username | password |
#      | test123user    | password@123      |
#    Then user can see the trello boards


  Scenario: Launch Login page and enter invalid details
    When the user goes to Trello Login page
    And enters the invalid details and click on LoginButton
      | username    | password       |
      | test123user | password@123aa |
    Then user can see 'Invalid psassword' message