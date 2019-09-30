# Web Automation Test Suite

<br/>This automated web test suite covers all the test cases mentioned in code challenge file.

# Libraries Used

* Selenium:
    * To incorporate web tests.
* Cucumber:
    * To perform parallel execution of test.
    * To perform cross browser test.
* Log4J:
    * To perform logging across test application for all test cases on output stream and in a file.
    
# Features:

* Logging
    - Implemented using Log4J to log.
* Generation human readable report
    - HTML Reports are available in the "target\cucumber-html-reports\overview-features.html" directory having details of each test case execution.
* Taking screenshot on failed tests
    
* WebDriver factory
    - WebDriverFactory class is added as part of base package to enable WebDriver initialization for cross browser and platform test.
* Encapsulation layers like test data, logic of tests, actions on web pages and so on
    - PageFactory design pattern is used to have a clean separation of layers consisting of test data, logic
    and actions on web pages.
* Configurator:
  * run tests in parallel mode;  
  * ability to run tests for different browsers by configuring;
    - Test can run on chrome/firefox browsers 

# Steps to execute the project:

* Method 1: Command Line:
    * Execute via command line by entering following command:
      - Go to project workspace

    ```bash
    mvn clean install
    ```

* Method 2: Feature file:
    * Right click on the `Feature` file: click on Run as >> Cucumber feature file
