Feature: Crisis Map
Scenario: View elements in the map without any data

Given The user opens Crisis Map portal and login in 
When The user test that CAMAS GENERALES hospitals with any data is not vissible 
And The user test that CAMAS UCI hospitals with any data is not vissible 
Then The user closes Crisis SDP portal and this test is finished
