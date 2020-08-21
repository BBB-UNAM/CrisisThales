Feature: Crisis Map

Scenario: LUGARES DE INTEREZ visualization one by one each layer 

Given The user opens Crisis login webpage and login in
When The crisis main page map is displayed
And The user clicks on map Layers button menu
And The user clicks in each layer institution to disable it
Then The user clicks in each layer institution to enable it
