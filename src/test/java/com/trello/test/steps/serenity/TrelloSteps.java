package com.trello.test.steps.serenity;


import com.trello.test.pages.TrelloLoginPage;
import com.trello.test.pages.TrelloHomePage;
import net.thucydides.core.annotations.Step;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TrelloSteps {

    private TrelloLoginPage loginTrello;
    private TrelloHomePage homeTrello;

    @Step
    public void isAtTrelloLoginPage() throws InterruptedException {

        loginTrello.open();
        loginTrello.findLoginButton();

    }


    @Step
    public void enterUsernamePasswordAndLogin(Map<String, String> loginDetails) throws InterruptedException{
        loginTrello.enterUsernamePasswordAndLogin(
                loginDetails.get("username"),
                loginDetails.get("password"));
    }

    @Step
    public void canSeeTrelloBoards() throws InterruptedException{
        homeTrello.trelloBoardsAreDisplayed();

    }

    public void userCanSeeThisMessage(String message) {
        String messageFromPage = loginTrello.userCanSeeThisMessage();
        assertEquals("Login Failed:", message, messageFromPage);
    }

}