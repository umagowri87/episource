Feature:  Melissa API

#Background: Open Chrome browser. 
#		Given Open Chrome browser.

  @mrr
  Scenario: C-1 - User is able to click Cancel button.
    Given I am logged in at Salesforce
    When Open 'Your Account' app
    And Search for 'Test Site 2/17'
    Then Test Site is displayed
    When Click on New button for Provider Address section
    Then New provider address form is displayed
    When Click to Cancel button
    Then Recently viewed provider addresses page is displayed.
    
  @mrr
  Scenario: C-2 - User is able to submit a New Provider Address.
    Given I am logged in at Salesforce
    When Open 'Your Account' app
    And Search for 'Test Site 2/17'
    Then Test Site is displayed
    When Click on New button for Provider Address section
    Then New provider address form is displayed
    When Filling provider address form
      | facilityName  | addressType | verified  | activeFromDate | activeToDate | searchAddress |
      | test1 |  Shipping    | true |  15/08/2023 | 20/08/2023 | 200 Main St, Auburn, , AL, 36830 |
    And Click to Save button
    Then Validate Provider Address
      | facilityName  | addressType | verified  | activeFromDate | activeToDate | searchAddress |
      | test1 |  Shipping    | true |  8/15/2023 | 8/20/2023 | 200 Main St, Auburn, , AL, 36830 |
      
  @mrr
  Scenario: C-3 - User is able to edit an existing Provider Address.
    Given I am logged in at Salesforce
    When Open 'Your Account' app
    And Search for 'Test Site 2/17'
    Then Test Site is displayed
    When Click on New button for Provider Address section
    Then New provider address form is displayed
    When Filling provider address form
      | facilityName  | addressType | verified  | activeFromDate | activeToDate | searchAddress |
      | test1 |  Shipping    | true |  15/08/2023 | 20/08/2023 | 200 Main St, Auburn, , AL, 36830 |
    And Click to Save button
    Then Validate Provider Address
      | facilityName  | addressType | verified  | activeFromDate | activeToDate | searchAddress |
      | test1 |  Shipping    | true |  8/15/2023 | 8/20/2023 | 200 Main St, Auburn, , AL, 36830 |
    When Click to Edit button
    Then New provider address form is displayed
    When Filling provider address form
      | facilityName  | addressType | verified  | activeFromDate | activeToDate | searchAddress |
      | test1 |  Record Custodian    | true |  15/08/2023 | 20/08/2023 | 3431 John F Kennedy Blvd, Jersey City, , NJ, 07307 |
    And Click to Save button
    Then Validate Provider Address
      | facilityName  | addressType | verified  | activeFromDate | activeToDate | searchAddress |
      | test1 |  Record Custodian    | true |  8/15/2023 | 8/20/2023 | 3431 John F Kennedy Blvd, Jersey City, , NJ, 07307 |
   
  @mrr
  Scenario: C-4 - User is unable to submit an Address outside US.
    Given I am logged in at Salesforce
    When Open 'Your Account' app
    And Search for 'Test Site 2/17'
    Then Test Site is displayed
    When Click on New button for Provider Address section
    Then New provider address form is displayed
    Then Validate that an address outside US cannot be entered.
      | facilityName  | addressType | verified  | activeFromDate | activeToDate | searchAddress |
      | test1 |  Shipping    | true |  15/08/2023 | 20/08/2023 | 4600 Cambie St, Vancouver, BC, Canada |

  @mrr
  Scenario: C-5 - User is unable edit and submit an Address outside US.
    Given I am logged in at Salesforce
    When Open 'Your Account' app
    And Search for 'Test Site 2/17'
    Then Test Site is displayed
    When Click on New button for Provider Address section
    Then New provider address form is displayed
    When Filling provider address form
      | facilityName  | addressType | verified  | activeFromDate | activeToDate | searchAddress |
      | test1 |  Shipping    | true |  15/08/2023 | 20/08/2023 | 200 Main St, Auburn, , AL, 36830 |
    And Click to Save button
    Then Validate Provider Address
      | facilityName  | addressType | verified  | activeFromDate | activeToDate | searchAddress |
      | test1 |  Shipping    | true |  8/15/2023 | 8/20/2023 | 200 Main St, Auburn, , AL, 36830 |
    When Click to Edit button
    Then New provider address form is displayed
    Then Validate that an address outside US cannot be entered.
      | facilityName  | addressType | verified  | activeFromDate | activeToDate | searchAddress |
      | test1 |  Shipping    | true |  15/08/2023 | 20/08/2023 | 4600 Cambie St, Vancouver, BC, Canada |
    
  @mrr
  Scenario: C-6 - User is unable save new provider address with empty mandatory fields.
    Given I am logged in at Salesforce
    When Open 'Your Account' app
    And Search for 'Test Site 2/17'
    Then Test Site is displayed
    When Click on New button for Provider Address section
    Then New provider address form is displayed
    When Click to Save button
    Then Validate mandatory field error is displayed
