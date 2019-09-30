package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Rupak Mansingh this class is for support page features
 */
public class SupportPage extends CommonPage {

    public SupportPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle(){
        return driver.getCurrentUrl();
    }
}
