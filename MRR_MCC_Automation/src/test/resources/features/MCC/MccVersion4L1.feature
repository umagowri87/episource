Feature: Move Test Chart to 1-RAW
@mccs @all 
  Scenario: C-124 - Move the Test Chart to 1-RAW Status
    Given I am logged in at Salesforce Classic
    And user Navigate to Chart Mover Beta
    When user enters the Chart ID in the search field and clicks on search button
    When user select the chart and click on Update Status button
    And selects status as "1-RAW" and then Additional Parameters
    When Log in as "Coder Automation" in MCC
    And open MCC Chart Queue, select 'QA  Automation' project and Get 'A-FMR9k8' Test Chart
   @mccsu @all
  Scenario: C-201 - Get the Chart from Chart Allocation Page 
    Given I am logged in at Salesforce Classic
    When Log in as "Coder Automation" in MCC
    And open MCC Chart Queue, select 'epiCoder Demo' project and Get 'A-FMR9K8' Test Chart
@mcc @all @NoHomePageRedirectionMCC
	Scenario: C-223 - Verify for the chart details
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

@mccs @all  @NoHomePageRedirectionMCC
Scenario: C-224 - Verification of Custom Fields
  	#And check for 'Custom Fields' button and click on it
  	Then Verify for 'UMID' field is present
  	Then verify field 'Coder Name'
 		Then validate for 'Coder Credential'
  	Then verify for 'Provider Education Required?' field
  	Then verify for 'Education Description' is displayed 
#  	And click save buttton
#		Then verify for success message  
 @mccs @all @NoHomePageRedirectionMCC  
  Scenario: C-225 - Verification of Workflow tab
   When click on workflow tab
   Then check for 'Status','Processed By NLP','NLP Outcome','Total Pages' fields are present
   Then verify for Status drop down values '2 - L1 WIP','10 - Hold','11 - Duplicate'
@mccs @all @NoHomePageRedirectionMCC 
Scenario: C-202 - Verification of PDF View Access Fields
    Then verify and click on 'PDF View Access' button
    Then verify for 'PDF Access Reason' , 'Timestamp' and 'SUBMIT REASON' button
    Then verify for dropdown PDF Access Reason values 'NLP page mismatch','Image issue','Partial handwritten pages' and 'Not highlighted >= 150 pages'
#  	And click save buttton
#		Then verify for success message  
 # Then verify for No ICD error mesage "No ICDs" field should be TRUE, if there are no valid Dx Codes'
 @mcc @all @NoHomePageRedirectionMCC
Scenario: C-226 - Verification of Member & Provider Details Tab and Fields
  	And click on tab 'Member & Provider Details'
  	Then verify for 'Member Details','Member ID :','Member HICN :','Member MBI :','Chase ID :','Member Address :'
  	Then check for 'Provider Details','Provider First Name :','Provider Last Name :','Provider ID :','Provider NPI :'
  	Then validate for 'Provider TIN :','Provider Speciality :','Provider Credential :','Provider Address :'
@mcc @all @NoHomePageRedirectionMCC
Scenario: C-227 - verify the fields in Projects Tab
  And click on project tab
  Then verify for 'Project Name :', 'DOS Capture :', 'To :','Review Type :', 'DX Capture Type :' and 'Coding Type :'
	When user get the values of From date field
	When user get the values of  To date field
@mcc @all  @NoHomePageRedirectionMCC
Scenario: C-228 - verify the fields in Claims Data Tab
  And click on Claims Data tab
  Then validate 'DOS From', 'DOS To','Provider Name','Provider Id','Provider NPI','Dx Code' 'Claim Id' and 'Provider Address' fields
@mcc @all @NoHomePageRedirectionMCC
 Scenario: C-229 - verify "No ICD" field error message
  And click save button
  Then verify for No ICD error mesage "At least one Encounter with DX code is necessary in order to save or move the chart to the next stage"
@mcc @all @NoHomePageRedirectionMCC
Scenario: C-230 - Dx field validation for invalid DX code
		#When user clicks on workflow tab
		When user refreshs the page 
		When user click on Add New Encounter
		When user enters valid date and provider name
		When user click on open all encounter
		#When user enters valid date, provider name and visit type
    And user enters invalid numeric DX code
    #And enters page no, slects 'Add' as L1 primary comment
    #And clicks on save button    
    Then verifys for valid error message 'Invalid DX Code'
    When user Delete the encounter
    #And clicks on save button
@mcc @all @NoHomePageRedirectionMCC 
Scenario: C-231 - verify the save button functionality
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
 @mcc @all @NoHomePageRedirectionMCC 
 Scenario: C-232 - verify the mandatory error messages for chart flexi fields
  When user clicks on chart details tab
  When user clear the values in coder name field
	And click save button
	Then verify for valid error message 'Required Chart Flex Field(s) missing'
	#When user Delete the encounter
	#When user refreshs the page 


@mcc @all @NoHomePageRedirectionMCC
Scenario: verify NLP pdf Code Capture Functionality
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
Then validate for field 'Provider NPI'
Then check for '# Coder DXes','First Page','Add'
	Then also verify 'Delete / Add','DX Code','HCC','Page #','Dx Flex 1','Dx Flex 2' and 'L1 Secondary'
Then also validate for 'Dx Flex 3','Dx Test Dropdown','Dx Test Date' and 'L1 Secondary'

@mcc @all @NoHomePageRedirectionMCC
Scenario: C-233 - DX field validation for same DX code
    When user click on Add New Encounter
		When user enters valid date and provider name
		When user enters valid DX Code 'i10'
		And clicks on Add row
		When user enters another DX code as 'i10'
		Then verifys for valid error message 'Duplicate DX Code for Encounter DOS Start'
@mcc @all  @NoHomePageRedirectionMCC
Scenario: C-234 - DX field validation for error message 000 and i10
		#And clicks on save button
		#When user click on Add New Encounter
		When user enters valid date and provider name
		#When user enters valid date, provider name and visit type
		When user enters valid DX Code 'i10'
		And enters page no, slects 'Add' as L1 primary comment
		And clicks on Add row
		When user enters another DX code as '000'
		Then verifys for valid error message '"000" and a valid DX Code cannot exist together'
@mcc @all   @NoHomePageRedirectionMCC
Scenario: C-235 - DX field validation for 000 with valid date 
		When user enters valid date and provider name
		When user enters valid DX Code '000' 
		And enters page no, slects 'Add' as L1 primary comment
		And clicks on save button
		Then verify for valid error message 'DX Code "000" cannot have following L1 Primary Comments, "Add"'
		When user Delete the encounter
@mcc @all @NoHomePageRedirectionMCC
Scenario: C-236 - Encounter field mandatory validation
		When user Add New encounter
		And clicks on save button
    Then verifys for valid error message 'One or more Encounters have empty DOS Start and/or DOS End'
		#When user Delete the encounter
@mcc @all  @NoHomePageRedirectionMCC
Scenario: C-237 - Encounter-custom mandatory field validation
 		When user refresh the page
 		When user Add New encounter
 		When user gives DOS Start and DOS End date
 		And clicks on save button
    Then verifys for valid error message 'Required Provider Number(s) missing' and 'One or more Encounters have empty DOS Start and/or DOS End'
 		When user Delete the encounter
@mcc @all  @NoHomePageRedirectionMCC
Scenario: C-238 - custom field validation
 		When user refresh the page
 		#And check for 'Custom Fields' button and click on it
 		When user enters valid provider name
 		And clicks on save button
 		Then verify for valid error message 'Required Encounter Flex Field(s) miss @NoHomePageRedirectionMCC'
@mcc @all @NoHomePageRedirectionMCC
Scenario: C-239 - DX field validation		
 		When user enters valid date and provider name
		When user enters valid DX Code '000'
 		And enters page no, slects 'No HCC Codes' as L1 primary comment  
		Then verify for valid error message 'Invalid DX Code'
		When user Delete the encounter
	@mccs @all @NoHomePageRedirectionMCC
Scenario: C-240 - Verify for success message.
		When user click on Add New Encounter
		When user enters valid date and provider name
		When user enters valid DX Code 'e119'
		And enters page no, slects 'Add' as L1 primary comment 
		And clicks on save button
		Then verify for success message
	@mccs @all  @NoHomePageRedirectionMCC
Scenario: C-241 - Add DX code i10	
		When user click on Add New Encounter
		When user enters valid date and provider name in row2
		When user enters visit type in row2
		When user enters valid DX Code 'i10' in row2
		And enters page no, slects 'Patient name or identifiers lacking' as L1 primary comment in row2 
		And clicks on save button
		Then verify for success message 
@mccs @all  @NoHomePageRedirectionMCC
Scenario: C-242 - Add DX code E118		
		When user click on Add New Encounter
		When user enters valid date and provider name in row3
		When user enters visit type in row3
		When user enters valid DX Code 'e118' in row3
		And enters page no, slects 'Add' as L1 primary comment in row3
		And clicks on save button
		Then verify for success message 
@mccs @all @NoHomePageRedirectionMCC
Scenario: Add DX code J449		
		When user click on Add New Encounter
		When user enters valid date and provider name in row4
		When user enters visit type in row4
		When user enters valid DX Code 'J449' in row4
		And enters page no, slects 'Add' as L1 primary comment in row4 
		And clicks on save button
		Then verify for success message 
		@mccs @all  @NoHomePageRedirectionMCC
Scenario: Add DX code F323		
		When user click on Add New Encounter
		When user enters valid date and provider name in row5
		When user enters visit type in row5
		When user enters valid DX Code 'F323' in row5
		And enters page no, slects 'Code Not Supported' as L1 primary comment in row5 
		And clicks on save button
		Then verify for success message 
#		And clicks on save and continue button
#		Then verify for success message 
#		And enters page no, slects 'Add' as L1 primary comment
#		And clicks on Add row
#		When user enters another DX code as '000'
#		When click on open new encounter
		@mccs @all  @NoHomePageRedirectionMCC
Scenario: Add DX code M3502		
		When user click on Add New Encounter
		When user enters valid date and provider name 'TESTMA6' in row6
		When user enters visit type in row6
		When user enters valid DX Code 'M3502' in row6
		And enters page no, slects 'Add' as L1 primary comment in row6 
		When user enters another DX code 'S48119A', page no,flexi fields and select 'Add' as L1 primary comment in row6 
		When user enters another DX code 'Z992', page no,flexi fields and select 'Add' as L1 primary comment in row6 
		And clicks on save button
		#Then verify for success message 
		When user clicks on openall encounters button
		Then user verify for HCC code populated
		When user click on closeall encounters button
		And clicks on save and continue button
		@mccs @all @NoHomePageRedirectionMCC
Scenario: C-243 - Logout from coder
When user clicks on down arrow
And selects Logout option
#	When user clicks on down arrow
#	And selects Logout option
Then verifies for Login page
@mccs @all @NoHomePageRedirectionMCC
Scenario: C-244 - Login as admin,verify status of chart is "8 - Ready to Deliver"
When user get the title of page and log in as salesforce as classic
#When login as Admin
Given I am logged in at Salesforce Classic
When Log in as "Test Automation" in MCC	and click on Single chart mover
Then user get the chart and verify status of chart is "8 - Ready to Deliver"
@mccs @all @NoHomePageRedirectionMCC
Scenario:  update the chart status as L2 and fetch the chart.
And update the chart status as "4 - L2 Backlog"
When Log in as "Auditor Automation_mcc" in MCC
And open MCC Chart Queue, select 'QA Automation' project and Get 'A-FMR9K8' Test Chart
@mccs @all @NoHomePageRedirectionMCC
Scenario: verify Encounter fields
When user clicks on openall encounters button
Then validate 'Delete','DOS Start', 'DOS End','Provider Name','Search','Provider ID','Provider NPI','Visit Type','Enc Flex 2','# Coder DXes','First Page' and 'Add' fields
Then verify for 'Delete / Add','DX Code','HCC','Page #','Dx Flex 1','Dx Flex 2','L1 Secondary','L2/MA Primary','L2/MA Manual Comments','L2/MA QA Comments'
Then user verify for the given DX Code "E119","I10","E118","J449","F323","M3502","S48119A","Z992"
And clicks on save button
Then verify for success message
When user click on closeall encounters button
When user clicks on openall encounters button
#Then auditor clicks save and continue button
#When user clicks on downarrow of row1
#Then verify L2MA Primary Comment "Incorrect"
#And clicks on save and continue button
#Then verify for success message
@mccs @all @NoHomePageRedirectionMCC
Scenario: Auditor save the existing details and verify for correct comment
And click save buttton
Then verify for success message
#When user clicks on downarrow of row1
Then verify L2MA Primary Comment "Correct"
@mccs @all @NoHomePageRedirectionMCC
Scenario: verify for the given DX codes in Auditor Login
#Then verify L2MA Primary Comment "Correct"
When user click on closeall encounters button
When user clicks on openall encounters button
Then user verify for the given DX Code "E119","I10","E118","J449","F323","M3502","S48119A","Z992"
@mccs @all @NoHomePageRedirectionMCC
Scenario: verify the incorrect primary comment after editing few fields
#When Auditor edit the dx code fields and verify for "incorrect" option
When Auditor edit the existing date in row1
When Auditor edit Provider name field in row2
When Auditor edit visit type in row3
When user edit the dx code in row4
When user edit page number in row5
When user edit flex field in row6
#When user click on closeall encounters button
#When user clicks on openall encounters button
When user edit flex field in row7
When user edit L1 secondary comment in row8 as "Missing Provider Signature/Credential"
And clicks on save button
Then verify for success message 
	When user click on closeall encounters button
	When user clicks on openall encounters button
	#Then auditor clicks save and continue button
	#When user clicks on downarrow of row1
	#Then verify L2MA Primary Comment "Incorrect"
	#And clicks on save and continue button
	#Then verify for success message 
	@mccs @all @NoHomePageRedirectionMCC
Scenario: verify delete funtionality in Auditor Login
	When user click on delete icon of row5
	When user give confirmation to delete
	Then verify the respective Dx code is deleted
			@mccs @all  @NoHomePageRedirectionMCC
Scenario: Again Add DX code F323 to verify missed comment in Auditor Login
		When user click on Add New Encounter
		When user enters valid date and provider name in row5
		When user enters visit type in row5
		When user enters valid DX Code 'F323' in row5
		And enters page no, slects 'Code Not Supported' as L1 primary comment in row5
		And clicks on save button
		Then verify for success message 
		When user click on closeall encounters button
	  When user clicks on openall encounters button
		Then verify for missed comment
		Then verify L2MA Primary Comment "Incorrect"
		#When user edit L1 secondary comment in row5
		#Then auditor clicks save and continue button
		And clicks on save and continue button
		And again open the chart and save the given values
	  #Then verify for success message 
	@mccs @all @NoHomePageRedirectionMCC
Scenario: Logout from Auditor Automation
	When user clicks on down arrow
	And selects Logout option
	Then verifies for Login page
	@mccs @all @NoHomePageRedirectionMCC
Scenario: C-244 - Login as MA,verify status of chart is "8 - Ready to Deliver"
	When user get the title of page and log in as salesforce as classic
	#When login as Admin
	Given I am logged in at Salesforce Classic
	When Log in as "Test Automation" in MCC	and click on Single chart mover
	Then user get the chart and verify status of chart is "8 - Ready to Deliver"
	@mccs @all @NoHomePageRedirectionMCC
Scenario:  update the chart status as L3 and fetch the chart.
	And update the chart status as "7 - Master Audit"
	When Log in as "Master Auditor Automation_mcc" in MCC
	And open MCC Chart Queue, select 'QA Automation' project and Get 'A-FMR9K8' Test Chart
	#And open MCC Chart Queue, select 'QA Automation' project and Get 'A-FMR9K8' Test Chart
	And Accept alert
@mccs @all @NoHomePageRedirectionMCC
	Scenario: Master Auditor verify Encounter fields
	When user clicks on openall encounters button
	Then validate 'Delete','DOS Start', 'DOS End','Provider Name','Search','Provider ID','Provider NPI','Visit Type','Enc Flex 2','# Coder DXes','First Page' and 'Add' fields
	Then verify for 'Delete / Add','DX Code','HCC','Page #','Dx Flex 1','Dx Flex 2','L1 Secondary','L2/MA Primary' in Master Auditor
	#Then verify for 'L2/MA Manual Comments','L2/MA QA Comments' in Master Auditor
	Then user verify for the given DX Code "E119","I10","E118","A0103","M3502","S48119A","Z992","F323"
	@mccs @all @NoHomePageRedirectionMCC 
	Scenario:  Master Auditor save the existing details and verify for the correct comment
	And click save buttton
	Then verify for success message
	Then verify for the MA comment "Correct"
	@mccs @all @NoHomePageRedirectionMCC
Scenario: verify the incorrect primary comment after editing the fields
	#When Auditor edit the dx code fields and verify for "incorrect" option
	When Master Auditor edit the existing date in row1
	When Master Auditor edit Provider name field in row2
	When Master Auditor edit visit type in row3
	When Master Auditor edit the dx code in row4
	When Master Auditor edit page number in row5
	When Master Auditor  edit flex field in row6
	When Master Auditor  edit flex field in row7
	When Master Auditor  edit L1 secondary comment in row8 as "Missing Provider Signature/Credential"
	And clicks on save button
	Then verify for success message
	When user click on closeall encounters button
	When user clicks on openall encounters button
	#Then auditor clicks save and continue button
	#When user clicks on downarrow of row1
	#Then verify L2MA Primary Comment "Incorrect"
	#And clicks on save and continue button
	#Then verify for success message 
@mccs @all @NoHomePageRedirectionMCC
Scenario: verify delete funtionality in MA Login
	When Master Auditor click on delete icon of Dxcode F323
	When user give confirmation to delete
	Then verify the respective Dx code is deleted
		@mccs @all  @NoHomePageRedirectionMCC
Scenario: Again Add DX code F323 and verify for 'Missed' comment in MA	
		When user click on Add New Encounter
		When user enters valid date and provider name in row5
		When user enters visit type in row5
		When user enters valid DX Code 'F323' in row5
		And enters page no, slects 'Code Not Supported' as L1 primary comment in row5 
		And clicks on save button
		Then verify for success message 
		When user click on closeall encounters button
	  When user clicks on openall encounters button
		Then verify for missed comment
		Then verify MA Primary Comment "Incorrect"
		And save the given values and click on submit button
		And clicks on save and continue button
		@mccs @all @NoHomePageRedirectionMCC
Scenario: Logout from Auditor Automation
	When user clicks on down arrow
	And selects Logout option	
	Then verifies for Login page
	@mccs @all @NoHomePageRedirectionMCC
Scenario: C-244 - Login as MA,verify status of chart is "8 - Ready to Deliver"
	When user get the title of page and log in as salesforce as classic
	#When login as Admin
	Given I am logged in at Salesforce Classic
	When Log in as "Test Automation" in MCC	and click on Single chart mover
	Then user get the chart and verify status of chart is "8 - Ready to Deliver"


		
