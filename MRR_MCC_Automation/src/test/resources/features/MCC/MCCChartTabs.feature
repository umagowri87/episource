Feature: Move Test Chart to 1-RAW
@mccut
  Scenario: C-124 - Move the Test Chart to 1-RAW Status
    Given I am logged in at Salesforce Classic
    When Login as Admin User & Verify the Developer Console menu is Displayed
   # Given I am logged in at Salesforce Classic
@mccut
  Scenario: C-201 - Get the Chart from Chart Allocation Page 
    Given I am logged in at Salesforce Classic
    When Log in as "Coder Automation" in MCC
    And open MCC Chart Queue, select 'epiCoder Demo' project and Get 'A-FMR9K8' Test Chart
@mccut
 Scenario: C-243 - Logout from coder
	When user clicks on down arrow
	And selects Logout option
#	When user clicks on down arrow
#	And selects Logout option
#	Then verifies for Login page
@mccut @NoHomePageRedirectionMCC
  Scenario: C-244 - Login as admin,verify status of chart is "8 - Ready to Deliver"
  #When login as Admin
  #Given I am logged in at Salesforce Classic
	When Log in as "Test Automation" in MCC	and click on Single chart mover
	Then user get the chart and verify status of chart is "8 - Ready to Deliver"	
@mccut @NoHomePageRedirectionMCC
  Scenario:  update the chart status as L2 and fetch the chart.
	And update the chart status as "4 - L2 Backlog"
	When Log in as "Auditor Automation_mcc" in MCC
	And open MCC Chart Queue, select 'QA Automation' project and Get 'A-FMR9K8' Test Chart
@mccut @NoHomePageRedirectionMCC
Scenario: verify the primary comment for incorrect option
	When Auditor edit the dx code fields and verify for "incorrect" option
	When Auditor edit the existing date
	And clicks on save button
	Then verify for success message
	When user click on closeall encounters button
	When user clicks on openall encounters button
	#When user clicks on downarrow of row1
	Then verify L2MA Primary Comment "Incorrect"