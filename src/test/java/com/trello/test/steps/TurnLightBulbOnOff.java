package com.trello.test.steps;

import com.trello.test.steps.serenity.LightBulbSteps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.given;

public class TurnLightBulbOnOff {

    @Steps
    private LightBulbSteps lightBulb;

    @Given("^The lightbulb is (OFF|ON)$")
    public void theLightbulbIsOFF(String action) throws Throwable {
        if (action.equals("OFF"))
            lightBulb.turnOff();
        else if (action.equals("ON"))
            lightBulb.turnOn(null);
    }

    @When("^I want to turn it (ON|OFF)(?: with power (\\d+))?$")
    public void iWantToTurnItONWithPower(String action, Integer power) {
        if (action.equals("OFF"))
            lightBulb.turnOff();
        else if (action.equals("ON"))
            lightBulb.turnOn(power);
    }


    @Then("^I should be able to set the switch successfully$")
    public void iShouldBeAbleToSetTheSwitchSuccessfully() throws Throwable {
        lightBulb.switchShouldBeSetSuccessfully();
    }

}
