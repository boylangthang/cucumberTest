#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Login actions

  @tag1
  Scenario: Successful login with valid credentials
    Given User is on Login page    
    When User enters username and password    	
    And User clicks submit button    
    Then User is redirected to the Landing page   

	Scenario: Unsuccessful login with empty username
    Given User is on Login page    
    When User does not enter username
    But User enters password
    And User clicks submit button    
    Then An error message ask user to enter username    
    
  Scenario: Unsuccessful login with empty password
    Given User is on Login page    
    When User enters username
    But User does not enter password
    And User clicks submit button    
    Then An error message ask user to enter password
    
#
  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
