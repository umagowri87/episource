Feature: Provider Packet
  
  @mrr @test
  Scenario: C-105 - User is able to send Provider Packet via Fax
    Given I am logged in at Salesforce
    When Open 'Retrieval Console' app
    And Search for 'L-02847795'
    Then Validate LID 'L-02847795' is displayed
    And User is able to send Provider Packet via Fax
    
  @mrr @test
  Scenario: C-106 - User is able to send Provider Packet via Email
    Given I am logged in at Salesforce
    When Open 'Retrieval Console' app
    And Search for 'L-02847795'
    Then Validate LID 'L-02847795' is displayed
    And User is able to send Provider Packet via Email
    

   