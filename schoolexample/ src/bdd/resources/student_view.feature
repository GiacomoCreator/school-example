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

Feature: Student Application Frame
         Specifications of the behavior of the Student Application Frame

Scenario: The initial state of the view
Given The database contains the students with the following values
 | 1 | first student |
 | 2 | second student |
When The Student View is shown
Then The list contains elements with the following values
 | 1 | first student |
 | 2 | second student |
 
Scenario: Add a new student
Given The Student View is shown
When The user enters the following values in the text fields
 | id | name |
 | 1 | a new student |
And The user clicks the "Add" button
Then The list contains elements with the following values
 | 1 | a new student |


