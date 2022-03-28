Feature: Books Page Feature

Background: 
Given User has already logged into the application
| username | password |
| qaautomation@yopmail.com | !Buddy6jar |

Scenario: Sort books by various opitions
Given Clicked on books menu 
When Books page is opened with title 'Demo Web Shop. Books'
And Clicked on Sort by dropdown and selected the option A to Z
Then Books are sorted Alphabeticall by A to Z
And Clicked on Sort by dropdown and selected the option Z to A
Then Books are sorted Alphabeticall by Z to A