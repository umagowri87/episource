Feature: Call Log
  
  @mrr
  Scenario: C-79 - User is able to select Unable to verify at Verification Category
    Given I am logged in at Salesforce
    When Open 'Medical Records Retrieval' app
    And Search for 'L-02854125'
    Then Validate LID 'L-02854125' is displayed
    When Fill out the Call Log form
    |  callType  |  callCategory  |  callOutcome  |  followUpDate  |  followUpNote  |  comments  |
    |  Internal  |  Verification  |  Unable to Verify  |  |  |  |
    Then Validate Call Outcome value is 'Unable to Verify'
    
  @mrr
  Scenario: C-80 - User is able to select Partial Verification at Verification Category
    Given I am logged in at Salesforce
    When Open 'Medical Records Retrieval' app
    And Search for 'L-02854125'
    Then Validate LID 'L-02854125' is displayed
    When Fill out the Call Log form
    |  callType  |  callCategory  |  callOutcome  |  followUpDate  |  followUpNote  |  comments  |
    |  Internal  |  Verification  |  Partial Verification  |  |  |  |
    Then Validate Call Outcome value is 'Partial Verification'
			
  @mrr
  Scenario: C-81 - User is able to select True CNA at Verification Category
    Given I am logged in at Salesforce
    When Open 'Medical Records Retrieval' app
    And Search for 'L-02854125'
    Then Validate LID 'L-02854125' is displayed
    When Fill out the Call Log form
    |  callType  |  callCategory  |  callOutcome  |  followUpDate  |  followUpNote  |  comments  |
    |  Internal  |  Verification  |  True CNA  |  |  |  |
    Then Validate Call Outcome value is 'True CNA'

  @mrr
  Scenario: C-82 - User is able to select Deactivate Research required Outcome at Verification Category
    Given I am logged in at Salesforce
    When Open 'Medical Records Retrieval' app
    And Search for 'L-02854125'
    Then Validate LID 'L-02854125' is displayed
    When Fill out the Call Log form
    |  callType  |  callCategory  |  callOutcome  |  followUpDate  |  followUpNote  |  comments  |
    |  Internal  |  Verification  |  Research Required  |  |  |  |
    Then Validate Call Outcome value is '--None--'