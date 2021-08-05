Feature: Add job title

  @addJobTitle
  Scenario: Adding new job titles
    And user is logged in with valid admin credentials
    Then user clicks on job button and adds new job title
    Then new job title is added "LazyBoy" succesfully
