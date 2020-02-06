package com.trello.test.steps;

import com.trello.test.steps.serenity.TrelloSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

import java.util.List;
import java.util.Map;

public class TrelloLoginSteps {

    @Steps
    private TrelloSteps user;

    @Given("^the user goes to Trello Login page$")
    public void TrelloLoginSteps() throws InterruptedException {
        user.isAtTrelloLoginPage();
//        TimeUnit.SECONDS.sleep(15);
        System.out.println("hello \n");


    }

    @And("^enters the valid details and click on LoginButton$")
    public void entersTheValidDetailsAndLogin(List<Map<String, String>> loginDetails) throws Throwable {
        user.enterUsernamePasswordAndLogin(loginDetails.get(0));
        //throw new PendingException();
    }

    @Then("^user can see the trello boards$")
    public void userCanSeeTheTrelloBoard() throws Throwable {
        user.canSeeTrelloBoards();
        //throw new PendingException();
    }

    @And("^enters the invalid details and click on LoginButton$")
    public void entersTheInvalidDetailsAndClickOnLoginButton(List<Map<String, String>> loginDetails) throws Throwable {
        user.enterUsernamePasswordAndLogin(loginDetails.get(0));
//        throw new PendingException();
    }

    @Then("^user can see '(.*)' message$")
    public void userCanSeeMessage(String message) {


           user.userCanSeeThisMessage(message);


//        throw new PendingException();
    }
}
