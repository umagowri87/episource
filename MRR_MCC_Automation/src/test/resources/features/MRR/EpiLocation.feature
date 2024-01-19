Feature: EpiLocation
  
  @mrr
  Scenario: C-13 - Contact section must not be display at Epi Location page
    Given I am logged in at Salesforce
    When Open 'Medical Records Retrieval' app
    And Search for 'L-02854125'
    Then Validate LID 'L-02854125' is displayed
    And Validate Contact section is not displayed
    
  @mrr
  Scenario: C-22 - LID with Do Not Call activated
    Given I am logged in at Salesforce
    When Open 'Medical Records Retrieval' app
    And Search for 'L-02854125'
    Then Validate LID 'L-02854125' is displayed
    When Do No Call checkbox is checked
    Then Validate Do Not Call label is displayed
			
  @mrr
  Scenario: C-23 - LID with Do Not Call not activated
    Given I am logged in at Salesforce
    When Open 'Medical Records Retrieval' app
    And Search for 'L-02854125'
    Then Validate LID 'L-02854125' is displayed
    When Do No Call checkbox is unchecked
    Then Validate Do Not Call label is not displayed

  @mrr
  Scenario: C-86 - User can review Location bar in Epi Location
    Given I am logged in at Salesforce
    When Open 'Retrieval Console' app
    And Search for 'L-02847795'
    Then Validate LID 'L-02847795' is displayed
    And Validate Location bar is displayed
    
