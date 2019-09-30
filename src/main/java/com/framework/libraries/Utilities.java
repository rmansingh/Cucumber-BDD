package com.framework.libraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Rupak Mansingh Utilities class to help in different activities
 */
public class Utilities {

    // wait till element visibility
    public static void waitForVisibilityofElement(WebDriver driver, WebElement ele) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(ele));
    }
}
