package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Rupak Mansingh common scenario handle for feature files
 */
public class CommonPage {

    WebDriver driver;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
