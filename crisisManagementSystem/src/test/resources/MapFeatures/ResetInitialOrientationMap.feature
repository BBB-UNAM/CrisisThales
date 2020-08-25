
Feature: Crisis Map

Scenario: As a user we needs to rotate the map orientation

Given The user opens chrome and login in Crisis
When The crisis map is displayed
Then The user move orientation of crisis map
And The user reset the map orientation

