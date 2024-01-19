Feature: Bug Reports
  
  @mrr
  Scenario: C-9 - User with no access to Bug Report cannot raise a bug
    Given I am logged in at Salesforce
    When Log in as "Karen Brown"
    Then User is unable to open 'Bug Reporting' app
	  And Log out as User
      
  @mrr
  Scenario: C-10 - User is able to create a Bug Report
    Given I am logged in at Salesforce
    When Log in as "Enrique Quintanilla"
    And Open 'Bug Reporting' app
    And Create a Bug Report
      | whichSystem  | ifOther | numberOfAffected  | summary | describeTheIssueInDetail | whatIsImpact |  whatAreMembersData  |  whatIsClass  |  whatIsRisk  |
      | Salesforce |  | 4 | Test | Test | 4 | 3 | 2 | 0 |
    Then Validate values in Bug Report
      | whichSystem  | ifOther | numberOfAffected  | summary | describeTheIssueInDetail | whatIsImpact |  whatAreMembersData  |  whatIsClass  |  whatIsRisk  | bugPriority |
      | Salesforce |  | 4 | Test | Test | 4 | 3 | 2 | 0 | 2.75 |
    And Log out as User
    
  @mrr
  Scenario: C-11 - If selecting "Which system is affected?" as Other. If Other, name of system field gets mandatory.
    Given I am logged in at Salesforce
    When Log in as "Enrique Quintanilla"
    And Open 'Bug Reporting' app
    And Create a Bug Report
      | whichSystem  | ifOther | numberOfAffected  | summary | describeTheIssueInDetail | whatIsImpact |  whatAreMembersData  |  whatIsClass  |  whatIsRisk  |
      | Other |  | 4 | Test | Test | 4 | 3 | 2 | 0 |
    Then Validate If Other, system name field is required
    And Log out as User