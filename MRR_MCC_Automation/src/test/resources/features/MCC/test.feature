Feature: Move Test Chart to 1-RAW

  Scenario: Move the Test Chart to 1-RAW Status
    Given I am logged in at Salesforce Classic
    When Login as Admin User & Verify the Developer Console menu is Displayed
    And Click on Developer Console Menu in Profile Dropdown
    And Open Apex Code Window & Run the script
    Then Switch to Home Page

  Scenario: Get the Chart from Chart Allocation Page and Verify Header is hided
    Given I am logged in at Salesforce Classic
    When Log in as "Coder Automation" in MCC
    And open MCC Chart Queue, select 'epiCoder Demo' project and Get 'A-FMR9K8' Test Chart
    Then check for 'Status','Processed By NLP','NLP Outcome','Total Pages' fields are present
    
