Feature: Address Finder
  
  @mrr
  Scenario: C-20 - User search for an Address, all fields but Address Line 2 must get locked.
    Given I am logged in at Salesforce
    When Open 'Retrieval Console' app
    And Search for 'L-02854125'
    Then Validate LID 'L-02854125' is displayed
    When Click Address Finder
    And Search for Address '200 Main St, Auburn, , AL, 36830'
    Then Validate all fields are locked but Address line 2
    
  
  @mrr
  Scenario: C-21 - User is unable to search for an invalid address (outside US)
    Given I am logged in at Salesforce
    When Open 'Retrieval Console' app
    And Search for 'L-02854125'
    Then Validate LID 'L-02854125' is displayed
    When Click Address Finder
    Then Validate Address '4600 Cambie St, Vancouver, BC, Canada' outside of US cannot be entered