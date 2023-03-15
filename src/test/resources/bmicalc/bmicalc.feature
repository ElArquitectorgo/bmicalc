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
Feature: IMC computation
  As a user I want to compute the IMC of a given height and weigth so that I can know the result

  @tag1
  Scenario: Computing the IMC of 70 cm and 1.70 kg
    Given I have an IMC calculator
    When I compute the IMC of 70 and 1.70
    Then The system returns 24.22