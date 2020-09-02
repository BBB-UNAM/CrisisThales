Feature: Crisis Map
Scenario: Display geography layers in the map

Given The user go to open chrome we explorer
When The crisis map is visible to the user 
And Each geography layer is enabled
And Each geography layer is disabled
Then The chrome web browser is closed
