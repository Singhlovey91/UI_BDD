
@tag
Feature: Prepayment Charge Calculator

  @tag1
  Scenario: Error Validation Test
    Given User open the browser and launch the application
    When User enters following details 
    |outstanding Balance|remainingTermYears|remainingTermMonths|paymentFrequency|paymentAmount|currentInterestRate|
    |450000							|10 					  	 |5									 |Bi-Weekly			  |6500				  |									  |
    And User click on calculate button
    Then Validate the error and error text
    

 
