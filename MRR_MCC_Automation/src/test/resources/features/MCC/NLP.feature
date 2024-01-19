Feature: NLP feature file
 @nlp @all  @NoHomePageRedirectionMCC
  Scenario: C-124 - Move the Test Chart to 1-RAW Status
    Given I am logged in at Salesforce Classic
    And user Navigate to Chart Mover Beta
    When user enters the Chart ID in the search field and clicks on search button
    When user select the chart and click on Update Status button
    And selects status as "1-RAW" and then Additional Parameters
    When Log in as "Coder Automation" in MCC
    And open MCC Chart Queue, select 'C2C – QA Testing' project and Get 'C2C-A00001' Test Chart
    
@nlp  @all  @NoHomePageRedirectionMCC
 Scenario: verify NLP pdf Code Capture Functionality
  And user switch to pdf
 	Then Validate PDF viewer is opened
 #	When Go to page 3 and click at 'depression' highlighted in 'red'
 #	And Capture mandatory fields
 #		  | dxFlexText  | l1SecComment | encText  |
       #| D1 |   Add    | E1 |
 #	Then Validate data in Coding screen
#	 	  | dxFlexText  | l1SecComment | encText  |
 #		      | D1 |   Add   | E1 |
   #And Validate 'depression' is highlighted in 'green'
     #Then verify 'Delete','DOS Start','DOS End','Provider Name','Search','Provider ID'
     #Then validate for field 'Provider NPI'
     #Then check for '  Coder DXes','First Page','Add'
#	 	Then also verify 'Delete / Add','DX Code','HCC','Page  ','Dx Flex 1','Dx Flex 2' and 'L1 Secondary'
#	 Then also validate for 'Dx Flex 3','Dx Test Dropdown','Dx Test Date' and 'L1 Secondary'
    