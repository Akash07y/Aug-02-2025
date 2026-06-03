Feature: Test demo scenarios
  
  Bacground: Login to application 
  Given User logged in to test application

  Scenario: Verify demo test of amezon
    Given User click on edit profile button
    And User enter the name as "Test" and email as "test@gmail.com"
    When User click on save button
    And User click on view profile button
    Then Verify all the details in the profile
    | Key 			|   Value  			|
    | First Name    |   Test    		|
    | Last Name    	|   Demo     		|
    | Mobile No    	|   1234568526     	|
    | Email Id    	|   test#gmail.com  |
    | Address    	|   Katraj, Pune    |
    
  @RetsingWithMultipleTestData
   Scenario Outline: Verify demo test of amezon
    Given User click on edit profile button
    And User enter the "<Target>" as "<Name>" and email as "<Email>"
    When User click on save button
    And User click on view profile button
    Then Verify all the details in the profile
    | Key 			|   Value  			|
    | First Name    |   <Name>    		|
    | Last Name    	|   <LastName>     		|
    | Mobile No    	|   <Mobile>     	|
    | Email Id    	|   test#gmail.com  |
    | Address    	|   Katraj, Pune    |
    
    Example : Test data for profile update
    |Target			| Name    	|   Email  			| LastName     	| Mobile    |
    |First name		| Test1   	| test1@gmail.com 	| Demo 			| 1254 		|
    |Last name		| Akash  	|	test2@gmail.com | Smith 		| 654 		|
    |Last name		| Alex  	|	test4@gmail.com | Hello 		| 984851 	|
    |First name		| Jim   	|	test5@gmail.com | Test 			| 65489 	|    
    
    
    
    
    
    
    
    
    
    
    