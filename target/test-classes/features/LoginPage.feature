Feature: Login Page Feature

Scenario: Login page opened
Given Login page is opened 
When Login page title is available
Then Login page title is "Demo Web Shop. Login"

Scenario: Forgot password link available
Given Login page is opened 
Then Forgot password link is available

Scenario: Login with appropriate credentials
Given Login page is opened 
When Entered user name
And Entered password
And Clicked on Login button
Then Successfully logged-in and home page title is displayed as "Demo Web Shop"