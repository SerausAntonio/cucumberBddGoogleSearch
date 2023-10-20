#https://www.youtube.com/watch?v=rapOSYGwLuA
# mvn exec:java -Dexec.classpathScope=test -Dexec.mainClass=io.cucumber.core.cli.Main
Feature: Google search

  Background:
    Given I am on the Google page

  Scenario: Find some cheese
    When I search for "cheese"
    Then the page title should start with "cheese"

  Scenario: Find some cucumber
    When I search for "cucumber"
    Then the page title should start with "cucumber"

  Scenario Outline: Find Search item on Google
    When I search for "<keyword>"
    Then the page title should start with "<keyword>"
 Examples:
   | keyword  |
   | selenium |
   | postman  |