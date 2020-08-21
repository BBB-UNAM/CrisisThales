Feature: Crisis Map

Scenario: Visualization of LUGARES DE INTERES layer group 

Given The user opens Crisis login webpage and insert a valid credentials to login
When The crisis main page with the map is displayed
And The user clicks on map Layers button
Then The user can disable and enable LUGARES DE INTERES layer
