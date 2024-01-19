Feature: Schedule Retrieval
  
  @mrr
  Scenario: C-78 - Once an appointment is created workflow status changes to Appointment set
    Given I am logged in at Salesforce
    When Open 'Retrieval Console' app
    And Search for 'L-02847795'
    Then Validate LID 'L-02847795' is displayed
    When Scheduling a Field appointment
    Then Validate Workflow Status is 'Appointment Set'
   