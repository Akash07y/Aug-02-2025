Feature: Verify amazon home page options
  Bacground: Login to application 
  Given User logged in to allpication
  And User click on Careers option
  
   @TC1234   @TC1235  @Sanity @Regression @amzeon
  Scenario: To verify open positions for students in carrear
    Given User logged in to allpication
    And User click on Careers option
    And User click on View open jobs under Opportunities for students
    When User select country of region as "China"
    And User select city as "Bigin"
    | Key | Value  |
    |     |        |
    Then Verify that all the results should have county code "CHI" and city name "Bigin"
  
   @TC4444 @Sanity @Regression @amzeon
  Scenario: To verify amezon services publications
    Given User logged in to allpication
    And User click on Amezon services option
    When User click on View all options under publication
    And User select Research area as 'Conversational AI'
    And User select Research area as 'Machine learning'
    Then User verify the total result displyed and total count '10'

  @TC8888 @Sanity  @amzeon
  Scenario: To verify amezon login successfull
    Given User logged in to allpication
    And User click on Amezon services option
    And User click on View all options under publication
    And User select Research area as 'Conversational AI'
    And User select Research area as 'Machine learning'
    Then User verify the total result displyed and total count '10'

 
  @TC8888 @Sanity @Regression @amzeon
  Scenario: To verify amezon status
    Given User logged in to allpication
    And Verify that service status
    And User select Research area as 'Conversational AI'
    And User select Research area as 'Machine learning'
    Then User verify the total result displyed and total count '10'
 