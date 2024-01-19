Feature: Copy Service dropdown

  @mrr
  Scenario: C-7 - Update Copy Service dropdown (Managed)
    Given I am logged in at Salesforce
    When Log in as "Enrique Quintanilla"
    When Open 'Medical Records Retrieval' app
    And Open New Epi Location form
    And Select Copy Service Type as 'Managed'
    Then Validate that values available in Copy Service field are correct
    And Log out as User

  @mrr
  Scenario: C-8 - Update Copy Service dropdown (Unmanaged)
    Given I am logged in at Salesforce
    When Log in as "Enrique Quintanilla"
    When Open 'Medical Records Retrieval' app
    And Open New Epi Location form
    And Select Copy Service Type as 'Unmanaged'
    Then Validate that values available in Copy Service field are correct
    And Log out as User
