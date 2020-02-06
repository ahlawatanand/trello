package com.trello.test.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.By.className;

//@DefaultUrl("https://trello.com/test123user/boards")
@At(urls={"#HOST/*/boards"})
public class TrelloHomePage extends PageObject {

    private ElementName element;

    @FindBy(xpath = "//span[@class='_3qwe2tMMFonNvf'][text()='Boards']")
    WebElementFacade boardElement;


    public TrelloHomePage(WebDriver driver) {
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
    private WebElementFacade getElementByClass(ElementName classtofind) {
        this.element = classtofind;
        return find(className(element.locator));
    }

    public void trelloBoardsAreDisplayed() throws InterruptedException {
//        page.currentPageAt();
//        String loginClass = getElementByClass(BOARDS).getAttribute("class");
//        boardElement.isCurrentlyVisible();
        System.out.println("----------Boards found--------------"+boardElement.isCurrentlyVisible());

    }
}