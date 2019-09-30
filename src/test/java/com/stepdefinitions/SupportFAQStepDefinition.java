package com.stepdefinitions;

import com.framework.libraries.FileReaderLibrary;
import com.pageobjects.FAQPage;

import com.cucumber.context.TestContext;
import com.framework.libraries.LogUtils;
import com.pageobjects.SupportPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.AfterClass;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Rupak Mansingh this is execution class for the offers page, valid
 * cucumber glue codes for the feature file
 */
public class SupportFAQStepDefinition {

    FAQPage faqPage;
    TestContext testContext;
    SupportPage supportPage;
    private static final LogUtils LOGGER = new LogUtils(SupportFAQStepDefinition.class);

    public SupportFAQStepDefinition(TestContext context) {

        testContext = context;
        faqPage = testContext.getPageObjectLibrary().getFAQPage();
        supportPage = testContext.getPageObjectLibrary().getSupportPage();
    }

    @Given("^open FAQ page$")
    public void open_FAQ_page() {
        LOGGER.info("********** Support and FAQ feature execution started ***********\n");
        faqPage.navigateToFAQPage();
    }

    @When("^click all category \"([^\"]*)\" of FAQ$")
    public void click_all_category_of_FAQ(String category) {
        faqPage.clickCategory(category);
    }

    @Then("^validate the FAQ category \"([^\"]*)\"$")
    public void validate_the_FAQ_category(String category) {
        assertThat("Street name didn't update", faqPage.getCategoryName(category), is(category));
    }

    @When("^search with a particular keyword \"([^\"]*)\"$")
    public void search_with_a_particular_keyword(String searchInput) {
        faqPage.enterSearchCategory(searchInput);
        faqPage.clickSearchButton();
    }

    @Then("^validate list of result displayed as per search$")
    public void validate_list_of_result_displayed_as_per_search() {
        assertThat("Search didn't work", faqPage.getCategoryName(), is(containsString("results for")));
    }

    @When("^search with a random keyword \"([^\"]*)\"$")
    public void search_with_a_random_keyword(String randomInput) {
        faqPage.enterSearchCategory(randomInput);
        faqPage.clickSearchButton();
    }

    @Then("^validate no result found$")
    public void validate_no_result_found() {
        assertThat("Search didn't work", faqPage.getCategoryName(), is(containsString("No results for")));
    }

    @When("^click on ask support option$")
    public void click_on_ask_support_option() {
        faqPage.clickAskSupport();
    }

    @Then("^validate the ask support page is being displayed\\.$")
    public void validate_the_ask_support_page_is_being_displayed() {
        assertThat("Home page url didn't displayed",supportPage.getPageTitle(),
                is(FileReaderLibrary.getInstance().getConfigReader().getApplicationUrl() + "/requests/new"));
        testContext.getWebDriverLibrary().getDriver().quit();
    }
}
