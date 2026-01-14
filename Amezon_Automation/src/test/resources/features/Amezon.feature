Feature: Verify amazon home page options
  
  Scenario: To verify open positions for students in carrear
    Given User logged in to allpication
    And User click on Careers option
    And User click on View open jobs under Opportunities for students
    When User select country of region as "China"
    Then Verify that all the results should have county code "CHI" and city name "Bigin"
  
  Scenario: To verify amezon services publications
    Given User logged in to allpication
    And User click on Amezon services option
    When User click on View all options under publication
    And User select Research area as 'Conversational AI'
    And User select Research area as 'Machine learning'
    Then User verify the total result displyed and total count

  Scenario: To verify amezon login successfull
    Given User logged in to allpication
    And User click on Amezon services option
    And User click on View all options under publication
    When User select Research area as Conversational AI
    And User select Research area as Machine learning
    Then User verify the total result displyed and total coun

 