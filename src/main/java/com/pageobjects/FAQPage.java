package com.pageobjects;

import com.framework.libraries.FileReaderLibrary;
import com.framework.libraries.LogUtils;
import com.framework.libraries.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Rupak Mansingh this class helps the activities of FAQ page
 * every action on the page is done here
 */
public class FAQPage extends CommonPage {

    private static final LogUtils LOGGER = new LogUtils(FAQPage.class);

    public FAQPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//button[contains(text(),'OK')]")
    private WebElement selectRegionSubmitButton;

    @FindBy(how = How.ID, using = "askSupport")
    private WebElement askSupport;

    @FindBy(how = How.ID, using = "query")
    private WebElement searchField;

    @FindBy(how = How.NAME, using = "commit")
    private WebElement searchButton;

    @FindBy(how = How.XPATH, using = "//*[@class='search-results-heading']")
    private WebElement noResultMessage;


    public void clickAskSupport() {
        askSupport.click();
        LOGGER.info("Click on ask support button");
    }

    // navigate to offers page
    public void navigateToFAQPage() {
        driver.get(FileReaderLibrary.getInstance().getConfigReader().getApplicationUrl());
    }

    public FAQPage clickCategory(String category) {
        driver.findElement(By.xpath("//*[@class='main-menu']//*[contains(text(),'" + category + "')]")).click();
        LOGGER.info("Click on the category : "+ category);
        return this;
    }

    public String getCategoryName(String category) {
        return driver.findElement(By.xpath("//*[@class='category-list category-navigation']//*[contains(text(),'" + category + "')]")).getText();
    }

    public void enterSearchCategory(String searchInput){
        LOGGER.info("Enter the search category value : "+ searchInput);
        searchField.sendKeys(searchInput);
    }

    public FAQPage clickSearchButton(){
        LOGGER.info("Click on the search button");
        Utilities.waitForVisibilityofElement(driver,searchButton);
        searchButton.click();
        return this;
    }

    public String getCategoryName() {
        return noResultMessage.getText();
    }
}
