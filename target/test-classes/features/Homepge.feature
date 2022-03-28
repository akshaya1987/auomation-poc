Feature: Home Page Feature

Background: 
Given User has already logged into the application
| username | password |
| qaautomation@yopmail.com | !Buddy6jar |


Scenario: Featured Products section is present
Given User is in Home page
Then Featured Products section is available

Scenario: Products count in the Featured Products section is proper
Given User is in Home page
When Featured Products section is available
Then Count of products listed in Featured Products is 6