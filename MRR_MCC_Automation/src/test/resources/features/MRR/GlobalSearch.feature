Feature: Global search
  
  @mrr
  Scenario: C-42 - User is able to search Groups by unique id
    Given I am logged in at Salesforce
    When Open 'Provider Group Database' app
    And Search for Account 'G-0048924'
    Then Validate Account 'G-0048924' is displayed
  
  @mrr
  Scenario: C-45 - User is able to search Sites by unique id
    Given I am logged in at Salesforce
    When Open 'Provider Group Database' app
    And Search for Account 'S-0048925'
    Then Validate Account 'S-0048925' is displayed
    
  @mrr
  Scenario: C-43 - User is able to search Groups by name
    Given I am logged in at Salesforce
    When Open 'Provider Group Database' app
    And Search for Account 'testGroup'
    Then Validate Account 'testGroup' is displayed
  
  @mrr
  Scenario: C-46 - User is able to search Sites by name
    Given I am logged in at Salesforce
    When Open 'Provider Group Database' app
    And Search for Account 'testSite'
    Then Validate Account 'testSite' is displayed
