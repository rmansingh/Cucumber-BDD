package com.framework.libraries;

import com.pageobjects.SupportPage;
import org.openqa.selenium.WebDriver;

import com.pageobjects.FAQPage;
;

/**
 * @author Rupak Mansingh This class helps to create every page object. If
 * applications have multiple step definitions file then with the help
 * of this class we can avoid object creation again and again in step
 * definition files
 */
public class PageObjectLibrary {

    private WebDriver driver;
    private FAQPage faqPage;
    private SupportPage supportPage;

    public PageObjectLibrary(WebDriver driver) {

        this.driver = driver;
    }

    // initialize FAQPage object, if already present then return the current instance.
    public com.pageobjects.FAQPage getFAQPage() {
        return (faqPage == null) ? faqPage = new FAQPage(driver) : faqPage;
    }

    // initialize SupportPage object, if already present then return the current instance.
    public SupportPage getSupportPage() {
        return (supportPage == null) ? supportPage = new SupportPage(driver) : supportPage;
    }
}
