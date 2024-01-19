Feature: Page Load Time Test
  
  @pageloadtimetest
  Scenario: Page Load time Test
    Given I am logged in at Salesforce
    When Open 'Retrieval Console' app
    And Open 'Medical Records Retrieval' app
    And Search for 'L-02854125'
		And Open 'Your Account' app
    And Search for 'testSiteEnrique'
    And Log in as "Enrique Quintanilla"
    And Open 'Bug Reporting' app
    Then Log out as User