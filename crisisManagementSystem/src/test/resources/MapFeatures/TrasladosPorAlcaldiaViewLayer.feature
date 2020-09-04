Feature: Crisis Map

Scenario: The user enable the TRASLADOS POR ALCALDIA layer

Given the user opens a chrome browser and login with valid credentials
When the crisis map is displayed in the web browser 
And the user opens layer menu and clicks in TRASLADOS POR ALCALDIA layer
Then the user close crisis map 

