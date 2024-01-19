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
    And open MCC Chart Queue and Get 'A-FMR9K8' Test Chart
    Then verify collapsible header is hided
      # And Log out as L1 User
  #  Then Log in as Admin User
 
  Scenario: Verify in header all tabs are displayed
  
  Given Coder is in MCC Chart Queue and Get 'A-FMR9K8' Test Chart
  Then verify for 'Custom Fields' tab
  Then validate 'Demographics' tab
  Then check for 'Chart URL' tab
  Then view for 'Workflow' tab
  Then look for 'Project' tab
  Then validate for 'Supplemental' tab
  Then view 'Dx Codes from Other Charts' tab
  
@mcc(enabled=false)
Scenario:  verify all fields in Custom Fields tab
  
  Given the user is in home page
  When click on MCC Chart Queue
  And click on 'My pending charts' tab
  And user clicks on 'A-FMR9K8' chart
  Then verify for the 'A-FMR9K8' chart
  Then Verify for 'Chart Flex 1' field is present
  Then verify field 'Chart Test Text'
  Then validate for 'Test ReadOnly Field'
  Then verify for 'Chart Test CheckBox' field
  Then verify for 'Chart Flex 5' is displayed
  
 @mcc(enabled=false)
  Scenario:  verify all fields in Demographic tab
  
  Given the user is in home page
  When click on MCC Chart Queue
  And click on 'My pending charts' tab
  And user clicks on 'C2C-A00009' chart
  Then verify for the 'C2C-A00009' chart
  And click on Demographic tab
  Then verify for 'First Name' , 'Last Name','Member Id' and 'DOB' fields
  Then check for 'Gender','Chase Id','# Chart Pages' and 'Processed By NLP' fields
  Then validate for 'Status','Hold Reason','Hold Comments' and 'No ICDs' fields
  Then verify for Status drop down values '2 - L1 WIP','10 - Hold','11 - Duplicate'
  
  @mcc(enabled=false)
  
  Scenario:  verify all fields in Chart URL tab
  
  Given the user is in home page
  When click on MCC Chart Queue
  And click on 'My pending charts' tab
  And user clicks on 'C2C-A00009' chart
  Then verify for the 'C2C-A00009' chart
  And clickon ChartUrl tab
  Then verify for 'Allow Adobe', 'Timestamp' and 'Requested By' fields are present
  
  @mcc(enabled=false)
  Scenario:  verify all fields in Workflow tab
  
  Given the user is in home page
  When click on MCC Chart Queue
  And click on 'My pending charts' tab
  And user clicks on 'C2C-A00009' chart
  Then verify for the 'C2C-A00009' chart
  And click on Workflow tab
  Then check for 'L1 Username','L1 Start Time','L1 Finish Time' fields are present
  
  @mcc(enabled=false)
  Scenario:  verify all fields in project tab
  
  Given the user is in home page
  When click on MCC Chart Queue
  And click on 'My pending charts' tab
  And user clicks on 'C2C-A00009' chart
  Then verify for the 'C2C-A00009' chart
  And click on project tab
  Then verify for 'Project Name', 'DOS Capture From', 'DOS Capture To','Review Type', 'DX Capture Type' and 'Coding Type'
  
  @mcc(enabled=false)
  Scenario: verify all fields in Supplemental tab
  
  Given the user is in home page
  When click on MCC Chart Queue
  And click on 'My pending charts' tab
  And user clicks on 'C2C-A00009' chart
  Then verify for the 'C2C-A00009' chart
  And click on supplemental tab
  Then validate 'DOS From', 'DOS To','Provider Number', and 'DXCode 1'
  Then verify 'DXCode 2','DXCode 3','DXCode 4','DXCode 5','DXCode 6','DXCode 7','DXCode 8'
  Then verify 'Provider Name' and 'Provider Address'
  
  @mcc(enabled=false)
   Scenario: verify all fields in DX codes from other charts tab
  
  Given the user is in home page
  When click on MCC Chart Queue
  And click on 'My pending charts' tab
  And user clicks on 'C2C-A00009' chart
  Then verify for the 'C2C-A00009' chart
  And click on DX Codes from other charts tab
  Then validate for 'DOS From' and 'DOS To' fields
  
@mcc(enabled=false)
Scenario:  verify for madatory error message in chart

  Given the user is in home page
  When click on MCC Chart Queue
  And click on 'My pending charts' tab
  And user clicks on 'C2C-A00009' chart
  Then verify for the 'C2C-A00009' chart
 # And enter text in 'Chart Flex 1' field
  And clear the values in 'Chart Test Text' field
  And click save button
  Then verify for mandatory validation error message
  
 @mcc(enabled=false)
Scenario:  verify for Save all button in chart

  Given the user is in home page
  When click on MCC Chart Queue
  And click on 'My pending charts' tab
  And user clicks on 'C2C-A00009' chart
  Then verify for the 'C2C-A00009' chart
 # And enter text in 'Chart Flex 1' field
  And select the 'Chart Test CheckBox' field
#  And enter values in 'Chart Test Text' field
  And click save button
  Then verify for success message
 
 @mcc(enabled=false)
Scenario:  verify NLP PDF Viewer

  Given the user is in home page
  When click on MCC Chart Queue
  And click on 'My pending charts' tab
  And user clicks on 'C2C-A00009' chart
  #And user switch to pdf
  Then Validate PDF viewer is opened
		When Go to page 7 and click at 'pmr' highlighted in 'red'
		And Capture mandatory fields
		  | dxFlexText  | l1SecComment | encText  |
      | D1 |   ASR 5-Partial/Incomplete Patient Name     | E1 |
		Then Validate data in Coding screen
		  | dxFlexText  | l1SecComment | encText  |
      | D1 |   ASR 5-Partial/Incomplete Patient Name     | E1 |
    And Validate 'PMR' is highlighted in 'green'
    Then verify 'DOS Delete','DOS Start','DOS End','Provider Name','Search','Provider ID'
   