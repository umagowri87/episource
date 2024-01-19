Feature: Move Test Chart to 1-RAW
@mccm
  Scenario: C-124 - Move the Test Chart to 1-RAW Status
    Given I am logged in at Salesforce Classic
    When Login as Admin User & Verify the Developer Console menu is Displayed
    And Click on Developer Console Menu in Profile Dropdown
    And Open Apex Code Window & Run the script
    Then Switch to Home Page
@mccm
  Scenario: C-201 - Get the Chart from Chart Allocation Page 
    Given I am logged in at Salesforce Classic
    When Log in as "Coder Automation" in MCC
    And open MCC Chart Queue, select 'epiCoder Demo' project and Get 'A-FMR9K8' Test Chart
@mccf @NoHomePageRedirectionMCC
	Scenario: Verify for the chart details
	Then verify for "Patient Name :Villa , David   DOB :10/11/1949   Gender :M   Chart ID :A-FMR9K8   Total Pages :19" text is displayed 
#	Then verify for Chart Id field value "A-FMR9K8"
#	Then verify for "patient name" field is diplayed
#	Then verify for the patient name field  contains value
#	Then verify for "DOB" field is getting displayed 
#	Then verify for DOB field contains value
#	Then verify for "Gender" field is displayed  properly
#	Then verify for Gender field contains value
#	Then validate that "Total Pages" field is displayed 
#	Then verify for Total Pages field contains value

 @mccm  @NoHomePageRedirectionMCC
Scenario: Verification of Custom Fields 
  	#And check for 'Custom Fields' button and click on it
  	Then Verify for 'UMID' field is present
  	Then verify field 'Coder Name'
 		Then validate for 'Coder Credential'
  	Then verify for 'Provider Education Required?' field
  	Then verify for 'Education Description' is displayed 
#  	And click save buttton
#		Then verify for success message  
  @mccm @NoHomePageRedirectionMCC  
  Scenario: Verification of Workflow tab 
   When click on workflow tab
   Then check for 'Status','Processed By NLP','NLP Outcome','Total Pages' fields are present
   Then verify for Status drop down values '2 - L1 WIP','10 - Hold','11 - Duplicate'
@mcc @NoHomePageRedirectionMCC 
Scenario: C-202 - Verification of PDF View Access Fields
    Then verify and click on 'PDF View Access' button
    Then verify for 'PDF Access Reason' , 'Timestamp' and 'SUBMIT REASON' button
    Then verify for dropdown PDF Access Reason values 'NLP page mismatch','Image issue','Partial handwritten pages' and 'Not highlighted >= 150 pages'

#  	And click save buttton
#		Then verify for success message  
  
 # Then verify for No ICD error mesage "No ICDs" field should be TRUE, if there are no valid Dx Codes'
 @mcc @NoHomePageRedirectionMCC
Scenario: Verification of Member & Provider Details Tab and Fields
  	And click on tab 'Member & Provider Details'
  	Then verify for 'Member Details','Member ID :','Member HICN :','Member MBI :','Chase ID :','Member Address :'
  	Then check for 'Provider Details','Provider First Name :','Provider Last Name :','Provider ID :','Provider NPI :'
  	Then validate for 'Provider TIN :','Provider Speciality :','Provider Credential :','Provider Address :'
@mcc @NoHomePageRedirectionMCC
Scenario: verify the fields in Projects Tab
  And click on project tab
  Then verify for 'Project Name :', 'DOS Capture :', 'To :','Review Type :', 'DX Capture Type :' and 'Coding Type :'
	When user get the values of From date field
	When user get the values of  To date field
@mcc  @NoHomePageRedirectionMCC
Scenario: verify the fields in Claims Data Tab
  And click on Claims Data tab
  Then validate 'DOS From', 'DOS To','Provider Name','Provider Id','Provider NPI','Dx Code' 'Claim Id' and 'Provider Address' fields
@mcc @NoHomePageRedirectionMCC
 Scenario: verify "No ICD" field error message
  And click save button
  Then verify for No ICD error mesage "At least one Encounter with DX code is necessary in order to save or move the chart to the next stage"
@mcc @NoHomePageRedirectionMCC
Scenario: Dx field validation for invalid DX code
		#When user clicks on workflow tab
		When user refreshs the page 
		When user click on Add New Encounter
		When user enters valid date and provider name
		When user click on open all encounter
		#When user enters valid date, provider name and visit type
    And user enters invalid numeric DX code
    And enters page no, slects 'Add' as L1 primary comment
    #And clicks on save button    
    Then verifys for valid error message 'Invalid DX Code'
    When user Delete the encounter
    #And clicks on save button
 
 @mcc @NoHomePageRedirectionMCC 
Scenario: verify the save button functionality
# 	And check for 'Custom Fields' button and click on it
  And enter text in 'C1' UMID field
  And enter values in 'Coder' and 'Coder Credential' field
  And select the 'Provider Education Required?' field
  #When user enters valid date and provider name
   When user click on Add New Encounter	
   When user enters valid date and provider name
   #When user enters valid date, provider name and visit type
   #When user enters valid date and provider name
  	When user enters valid DX Code 'i10'
	And enters page no, slects 'Add' as L1 primary comment
	And click save button
	Then verify for success message
#	And clicks on save and continue button 
#	When performs click action on save button
 @mcc @NoHomePageRedirectionMCC 
 Scenario: verify the mandatory error messages for chart flexi fields
  When user clicks on chart details tab
  When user clear the values in coder name field
	And click save button
	Then verify for valid error message 'Required Chart Flex Field(s) missing'
	#When user Delete the encounter
	#When user refreshs the page 


#@mcc      @NoHomePageRedirectionMCC
#Scenario: verify NLP pdf Code Capture Functionality
#	 	And user switch to pdf
#	Then Validate PDF viewer is opened
#		When Go to page 3 and click at 'depression' highlighted in 'red'
#		And Capture mandatory fields
#		  | dxFlexText  | l1SecComment | encText  |
      #| D1 |   Add    | E1 |
#		Then Validate data in Coding screen
	#	  | dxFlexText  | l1SecComment | encText  |
#		      | D1 |   Add   | E1 |
#   And Validate 'depression' is highlighted in 'green'
    #Then verify 'Delete','DOS Start','DOS End','Provider Name','Search','Provider ID'
    #Then validate for field 'Provider NPI'
    #Then check for '# Coder DXes','First Page','Add'
	#	Then also verify 'Delete / Add','DX Code','HCC','Page #','Dx Flex 1','Dx Flex 2' and 'L1 Secondary'
	#Then also validate for 'Dx Flex 3','Dx Test Dropdown','Dx Test Date' and 'L1 Secondary'

@mcc @NoHomePageRedirectionMCC
Scenario:  DX field validation for same DX code
    When user click on Add New Encounter
		When user enters valid date and provider name
		When user enters valid DX Code 'i10'
		And clicks on Add row
		When user enters another DX code as 'i10'
		Then verifys for valid error message 'Duplicate DX Code for Encounter DOS Start'
@mcc  @NoHomePageRedirectionMCC
Scenario: DX field validation for error message 000 and i10
		#And clicks on save button
		#When user click on Add New Encounter
		When user enters valid date and provider name
		#When user enters valid date, provider name and visit type
		When user enters valid DX Code 'i10'
		And enters page no, slects 'Add' as L1 primary comment
		And clicks on Add row
		When user enters another DX code as '000'
		Then verifys for valid error message '"000" and a valid DX Code cannot exist together'
@mcc   @NoHomePageRedirectionMCC
Scenario: DX field validation for 000 with valid date 
		When user enters valid date and provider name
		When user enters valid DX Code '000' 
		And enters page no, slects 'Add' as L1 primary comment  
		Then verify for valid error message 'Invalid DX Code'
		When user Delete the encounter
@mcc  @NoHomePageRedirectionMCC
Scenario: Encounter field mandatory validation
		When user Add New encounter
		And clicks on save button
    Then verifys for valid error message 'One or more Encounters have empty DOS Start and/or DOS End' and 'Required Provider Number(s) missing'
		#When user Delete the encounter
@mcc  @NoHomePageRedirectionMCC
Scenario: Encounter-custom mandatory field validation
 		When user refresh the page
 		When user Add New encounter
 		When user gives DOS Start and DOS End date
 		And clicks on save button
 		Then verify for valid error message 'Required Provider Number(s) missing'
 		When user Delete the encounter
@mcc  @NoHomePageRedirectionMCC
Scenario: custom field validation
 		When user refresh the page
 		#And check for 'Custom Fields' button and click on it
 		When user enters valid provider name
 		And clicks on save button
 		Then verify for valid error message 'Required Encounter Flex Field(s) missing'
@mcc @NoHomePageRedirectionMCC
Scenario: DX field validation 		
 		When user enters valid date and provider name
		When user enters valid DX Code '000'
 		And enters page no, slects 'No HCC Codes' as L1 primary comment  
		Then verify for valid error message 'Invalid DX Code'
		When user Delete the encounter
@mcc   @NoHomePageRedirectionMCC
Scenario: Project Details Tab - Date validation
		 When user get the values of From date field
		 When user get the values of  To date field
		 
@mccm @NoHomePageRedirectionMCC
Scenario: Verify for success message
		When user click on Add New Encounter
		When user enters valid date and provider name
		When user enters valid DX Code 'e119'
		And enters page no, slects 'Add' as L1 primary comment 
		And clicks on save button
		Then verify for success message 
		And clicks on save and continue button
		Then verify for success message 
@mcc  @NoHomePageRedirectionMCC
Scenario: Add DX code i10		
		When user click on Add New Encounter
		When user enters valid date and provider name in row2
		When user enters visit type in row2
		When user enters valid DX Code 'i10' in row2
		And enters page no, slects 'Patient name or identifiers lacking' as L1 primary comment in row2 
		And clicks on save button
		Then verify for success message 
@mcc  @NoHomePageRedirectionMCC
Scenario: Add DX code E118		
		When user click on Add New Encounter
		When user enters valid date and provider name in row3
		When user enters visit type in row3
		When user enters valid DX Code 'e118' in row3
		And enters page no, slects 'Add' as L1 primary comment in row3
		And clicks on save button
		Then verify for success message 
@mcc @NoHomePageRedirectionMCC
Scenario: Add DX code J449		
		When user click on Add New Encounter
		When user enters valid date and provider name in row4
		When user enters visit type in row4
		When user enters valid DX Code 'J449' in row4
		And enters page no, slects 'Add' as L1 primary comment in row4 
		And clicks on save button
		Then verify for success message 
		
@mcc  @NoHomePageRedirectionMCC
Scenario: Add DX code F323		
		When user click on Add New Encounter
		When user enters valid date and provider name in row5
		When user enters visit type in row5
		When user enters valid DX Code 'F323' in row5
		And enters page no, slects 'Code Not Supported' as L1 primary comment in row5 
		And clicks on save button
		Then verify for success message 
		And clicks on save and continue button
		Then verify for success message 
#		And enters page no, slects 'Add' as L1 primary comment
#		And clicks on Add row
#		When user enters another DX code as '000'
#		When click on open new encounter
@mccm @NoHomePageRedirectionMCC
	Scenario: Logout from coder Auditor
	When user clicks on down arrow
	And selects Logout option
	Then verifies for Login page
@mccm @NoHomePageRedirectionMCC
  Scenario: Login as admin,update the chart status as L2 and fetch the chart.
  When login as Admin
  Given I am logged in at Salesforce Classic
	When Log in as "Test Automation" in MCC	and click on Single chart mover
	Then user get the chart and verify status of chart is "8 - Ready to Deliver"
	And update the chart status as "4 - L2 Backlog"
	When Log in as "Auditor Automation" in MCC
	And open MCC Chart Queue, select 'epiCoder Demo' project and Get 'A-FMR9K8' Test Chart
@mcc @NoHomePageRedirectionMCC
	Scenario: Verify for the chart details
	Then verify for "Patient Name :Villa , David   DOB :10/11/1949   Gender :M   Chart ID :A-FMR9K8   Total Pages :19" text is displayed 
#	Then verify for "Chart Id" field is displayed 
#	Then verify for Chart Id field value "A-FMR9K8"
#	Then verify for "patient name" field is diplayed
#	Then verify for the patient name field  contains value
#	Then verify for "DOB" field is getting displayed 
#	Then verify for DOB field contains value
#	Then verify for "Gender" field is displayed  properly
#	Then verify for Gender field contains value
#	Then validate that "Total Pages" field is displayed 
#	Then verify for Total Pages field contains value
 @mcc(enabled=false)  @NoHomePageRedirectionMCC
Scenario: Verification of Custom Fields 
  	#And check for 'Custom Fields' button and click on it
  	Then Verify for 'UMID' field is present
  	Then verify field 'Coder Name'
 		Then validate for 'Coder Credential'
  	Then verify for 'Provider Education Required?' field
  	Then verify for 'Education Description' is displayed 
#  	And click save buttton
#		Then verify for success message  
  @mcc(enabled=false) @NoHomePageRedirectionMCC  
  Scenario: Verification of Workflow tab 
   When click on workflow tab
   Then check for 'Status','Processed By NLP','NLP Outcome','Total Pages' fields are present
   Then verify for Status drop down values '2 - L1 WIP','10 - Hold','11 - Duplicate'
@mcc(enabled=false) @NoHomePageRedirectionMCC 
Scenario: C-202 - Verification of PDF View Access Fields
    Then verify and click on 'PDF View Access' button
    Then verify for 'PDF Access Reason' , 'Timestamp' and 'SUBMIT REASON' button
    Then verify for dropdown PDF Access Reason values 'NLP page mismatch','Image issue','Partial handwritten pages' and 'Not highlighted >= 150 pages'

#  	And click save buttton
#		Then verify for success message  
  
 # Then verify for No ICD error mesage "No ICDs" field should be TRUE, if there are no valid Dx Codes'
 @mcc(enabled=false)  @NoHomePageRedirectionMCC
Scenario: Verification of Member & Provider Details Tab and Fields
  	And click on tab 'Member & Provider Details'
  	Then verify for 'Member Details','Member ID :','Member HICN :','Member MBI :','Chase ID :','Member Address :'
  	Then check for 'Provider Details','Provider First Name :','Provider Last Name :','Provider ID :','Provider NPI :'
  	Then validate for 'Provider TIN :','Provider Speciality :','Provider Credential :','Provider Address :'
  	@mcc(enabled=false) @NoHomePageRedirectionMCC
Scenario: verify the fields in Projects Tab
  And click on project tab
  Then verify for 'Project Name :', 'DOS Capture :', 'To :','Review Type :', 'DX Capture Type :' and 'Coding Type :'
	When user get the values of From date field
	When user get the values of  To date field
@mcc(enabled=false)  @NoHomePageRedirectionMCC
Scenario: verify the fields in Claims Data Tab
  And click on Claims Data tab
  Then validate 'DOS From', 'DOS To','Provider Name','Provider Id','Provider NPI','Dx Code' 'Claim Id' and 'Provider Address' fields
@mccn @NoHomePageRedirectionMCC
Scenario: verify the primary comment for correct option
  Then validate 'Delete','DOS Start', 'DOS End','Provider Name','Search','Provider ID','Provider NPI','Visit Type','Enc Flex 2','# Coder DXes','First Page' and 'Add' fields
	Then verify for 'Delete / Add','DX Code','HCC','Page #','Dx Flex 1','Dx Flex 2','L1 Secondary','L2/MA Primary','L2/MA Manual Comments','L2/MA QA Comments'
	#And click save buttton
	Then verify L2MA Primary Comment "Correct"
@mccn @NoHomePageRedirectionMCC
Scenario: verify the primary comment for incorrect option
	When Auditor edit the dx code fields and verify for "incorrect" option
@mccn(enabled=false) @NoHomePageRedirectionMCC
Scenario: Logout from Auditor Automation
When user clicks on down arrow
And selects Logout option
Then verifies for Login page
@mccn(enabled=false)  @NoHomePageRedirectionMCC
  Scenario: Login as admin,update the chart status as MA and fetch the chart.
  When login as Admin
  Given I am logged in at Salesforce Classic
	When Log in as "Test Automation" in MCC	and click on Single chart mover
	Then user get the chart and verify status of chart is "8 - Ready to Deliver"
	And update the chart status as "7 - Master Audit"
	When Log in as "Master Auditor Automation" in MCC
	And open MCC Chart Queue, select 'epiCoder Demo' project and Get 'A-FMR9K8' Test Chart
	@mccn(enabled=false) @NoHomePageRedirectionMCC
Scenario: verify the MA primary comment for incorrect option
#	When Master Auditor edit the dx code fields and verify for "incorrect" option


@mccn(enabled=false)  @NoHomePageRedirectionMCC
Scenario Outline: Verify for success message for 5 DX codes
		When user click on Add New Encounter
		When user enters valid date, <row> , "<provider name>" and "<visit type>"
		When user enters valid "<DX Code>"
		And enters "<page no>" and "<L1 primary comment>"
		And clicks on save button
		Then verify for success message 
Examples:
| row | provider name | visit type | DX Code | page no | L1 primary comment |
|  1  | Test1					|   inline	 | e119		 |	3			 |    disease					|
|  2  | Test2					|   out			 | i10     |  6      |    disease2				|
	


	
	
 		