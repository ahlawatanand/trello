Feature: Switch Light bulb On and Off
  In order to be make sure my light bulb is working
  As an user
  I want to turn my light bulb On and Off

  Scenario: Turn the bulb ON
    Given The lightbulb is OFF
    When I want to turn it ON with power 20
    Then I should be able to set the switch successfully


  Scenario: Turn the bulb OFF
    Given The lightbulb is ON
    When I want to turn it OFF
    Then I should be able to set the switch successfully

