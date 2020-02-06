package com.trello.test.pages;

/**
 * enum to define element name string
 */
public enum ElementName {

    LOGIN("login"),
    USERNAME("user"),
    PASSWORD("password"),
    BOARDS("Boards");


    public final String locator;

    ElementName(String locator) {
        this.locator = locator;
    }



}
