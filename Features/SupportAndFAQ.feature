#author: Rupak Mansingh

Feature: Support and FAQ feature

  @RegressionTest
  Scenario Outline: Search for particular keyword
    Given open FAQ page
    When click all category "<category>" of FAQ
    Then validate the FAQ category "<category>"

    Examples:
      | category           |
      | Getting Started    |
      | Team Management    |
      | Using Wire         |
      | Conferencing       |
      | Guests             |
      | Profile & Settings |
      | Privacy & Security |

  @RegressionTest
  Scenario Outline: Search for particular keyword
    Given open FAQ page
    When search with a particular keyword "<keyword>"
    Then validate list of result displayed as per search

    Examples:
      | keyword |
      | message |

  @RegressionTest
  Scenario Outline: Ask for support when search result is not found
    Given open FAQ page
    When search with a random keyword "<keyword>"
    Then validate no result found
    And open FAQ page
    When click on ask support option
    Then validate the ask support page is being displayed.

    Examples:
      | keyword       |
      | xyzhewwuyaxde |

