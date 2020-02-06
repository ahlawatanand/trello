package com.trello.test.steps.serenity;

import com.trello.test.utils.ReusableSpecification;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

import static org.hamcrest.Matchers.containsString;

import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.then;

public class LightBulbSteps {

    private EnvironmentVariables environmentVariable = SystemEnvironmentVariables.createEnvironmentVariables();
    private Map<String, Integer> powerCapacity = new HashMap<String, Integer>();

    @Step("Turning the Light bulb Off")
    public void turnOff() {
        SerenityRest
                .rest()
                .spec(ReusableSpecification.getGenericRequestSpec())
                .log()
                .all()
                .get(getLightBulbEndPoint() + "off").then().statusCode(200);
    }

    @Step("Turning the Light bulb On ")
    public void turnOn(Integer power) {

        powerCapacity.put("power", power);

        SerenityRest
                .rest()
                .spec(ReusableSpecification.getGenericPOSTRequestSpec())
                .body(powerCapacity)
                .log()
                .all()
                .post(getLightBulbEndPoint() + "on").then().statusCode(200);
    }


    @Step
    public void switchShouldBeSetSuccessfully() {
        if (powerCapacity.get("power") != null)
            then()
                    .spec(ReusableSpecification.getGenericResponseSpec())
                    .log()
                    .all()
                    .assertThat()
                    .body("Result", containsString("Switch & custom power set successfully"));
        else
            then()
                    .spec(ReusableSpecification.getGenericResponseSpec())
                    .log()
                    .all()
                    .assertThat()
                    .body("Result", containsString("Switch set successfully"));

    }

    private String getLightBulbEndPoint() {

        return environmentVariable.getProperty("lightbulb.APIEndPoint");
    }
}
