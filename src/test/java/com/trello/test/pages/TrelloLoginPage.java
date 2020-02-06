package com.trello.test.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

@DefaultUrl("https://trello.com/login")
public class TrelloLoginPage extends PageObject {

    private ElementName element;


    public TrelloLoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * This is method is to get the element which can be located by their name and to separate name constants from PageObject class
     * @param name is constant containing element name
     * @return reference of WebElementFacade interface
     * The WebElementFacade class convenient dealing with web elements, providing some commonly-used extra features that are not provided out-of-the-box by the WebDriver API
     */
    private WebElementFacade getElementByName(ElementName name) {
        this.element = name;
        return find(By.name(element.locator));
    }
    private WebElementFacade getElementByID(ElementName id) {
        this.element = id;
        return find(By.id(element.locator));
    }
    private WebElementFacade getElementByCSS(String css) {
        return find(By.cssSelector(css));
    }

    public void findLoginButton() throws InterruptedException {
        String loginClass = getElementByID(ElementName.LOGIN).getAttribute("value");

    }


    public void enterUsernamePasswordAndLogin(String username, String password) throws InterruptedException{
        TimeUnit.SECONDS.sleep(3);
        getElementByID(ElementName.USERNAME).type(username);
        getElementByID(ElementName.PASSWORD).type(password);
        getElementByID(ElementName.LOGIN).click();
        TimeUnit.SECONDS.sleep(5);
    }

    public String userCanSeeThisMessage() {
        String messageFromPage = getElementByCSS("#error > p").getText();
        return messageFromPage;
    }
}