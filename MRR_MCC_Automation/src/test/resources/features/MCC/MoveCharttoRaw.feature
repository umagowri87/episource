Feature: Move Test Chart to 1-RAW
 
  Scenario:  C-124 - Move the Test Chart to 1-RAW Status
    Given I am logged in at Salesforce Classic
    When Login as Admin User & Verify the Developer Console menu is Displayed
    And Click on Developer Console Menu in Profile Dropdown
    And Open Apex Code Window & Run the script
    Then Switch to Home Page

  Scenario:  Get the Chart from Chart Allocation Page and Verify Header is hided
    Given I am logged in at Salesforce Classic
    When Log in as "Coder Automation" in MCC
    And open MCC Chart Queue, select 'epiCoder Demo' project and Get 'A-FMR9K8' Test Chart
    Then verify collapsible header is hided
	#       To verify the navigation of different tabs.
  Then verify for 'Custom Fields' tab
  Then validate 'Demographics' tab
  Then check for 'Chart URL' tab
  Then view for 'Workflow' tab
  Then look for 'Project' tab
  Then validate for 'Supplemental' tab
  Then view 'Dx Codes from Other Charts' tab
  #         Validate the fields in "Custom field" tab
  Then navigate to custom fields tab
  Then Verify for 'UMID' field is present
  Then verify field 'Coder Name'
  Then validate for 'Coder Credential'
  Then verify for 'Provider Education Required?' field
  Then verify for 'Education Description' is displayed
 #				 Verify the fields in Demographic tab
  And click on Demographic tab
  Then verify for 'First Name' , 'Last Name','Member Id' and 'DOB' fields
  Then check for 'Gender','Chase Id','# Chart Pages' and 'Processed By NLP' fields
  Then validate for 'Status','Hold Reason','Hold Comments' and 'No ICDs' fields
  Then verify for Status drop down values '2 - L1 WIP','10 - Hold','11 - Duplicate'
#					Verify the fields in chart url tab
  And clickon ChartUrl tab
  Then verify for 'Allow Adobe', 'Timestamp' and 'Requested By' fields are present
#					 verify the fields in Workflow Tab
  And click on Workflow tab
  Then check for 'L1 Username','L1 Start Time','L1 Finish Time' fields are present
#							verify the fields in Projects Tab
  And click on project tab
  Then verify for 'Project Name', 'DOS Capture From', 'DOS Capture To','Review Type', 'DX Capture Type' and 'Coding Type'
#						 	verify the fields in Supplemental Tab
  And click on supplemental tab
  Then validate 'DOS From', 'DOS To','Provider Number', and 'DXCode 1'
  Then verify 'DXCode 2','DXCode 3','DXCode 4','DXCode 5','DXCode 6','DXCode 7','DXCode 8'
  Then verify 'Provider Name' and 'Provider Address'
#						  	verify DX Code from other charts Tab
  And click on DX Codes from other charts tab
  Then validate for 'DOS From' and 'DOS To' fields
  Then navigate to custom fields tab
  And clear all the values in custom fields tab
  #							verify the mandatory error messages
  And click save button
  Then verify for mandatory validation error message
#               verify the save button functionality
  And enter text in 'D1' UMID field
  And enter values in 'Coder Name' and 'Coder Credential' field
  And select the 'Provider Education Required?' field
  And click save button
  Then verify for success message
# 								verify NLP pdf Code Capture Functionality
  And user switch to pdf
  Then Validate PDF viewer is opened
		When Go to page 3 and click at 'depression' highlighted in 'red'
		And Capture mandatory fields
		  | dxFlexText  | l1SecComment | encText  |
      | D1 |   Add    | E1 |
		Then Validate data in Coding screen
		  | dxFlexText  | l1SecComment | encText  |
		      | D1 |   Add   | E1 |
    And Validate 'depression' is highlighted in 'green'
    Then verify 'Delete','DOS Start','DOS End','Provider Name','Search','Provider ID'
 #   Then validate for 'Provider NPI','EncPageRange'
    Then check for '# Coder DXes','First Page','Add'
		Then also verify 'Delete / Add','DX Code','HCC','Page #','Dx Flex 1','Dx Flex 2' and 'L1 Secondary'
		#Then also validate for 'Dx Flex 3','Dx Test Dropdown','Dx Test Date' and 'L1 Secondary'