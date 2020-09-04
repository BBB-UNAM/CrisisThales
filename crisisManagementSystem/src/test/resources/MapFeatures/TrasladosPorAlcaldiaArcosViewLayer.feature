Feature: Crisis map
Scenario: Visualisation of BOWS layer in the map 

Given The user go to open Crisis login page and login
When The crisis map is displayed in thge chrome browser
And The user clicks on bows layer and it is displayed
Then The user closes crisis portal
