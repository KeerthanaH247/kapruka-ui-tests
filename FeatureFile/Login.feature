Feature: User Account Regestration and Login

Scenario: User clicks on Profile icon

Given User is on the Homepage
When User clicks on Profile icon
Then User should be able to directed to Login page

Scenario Outline: Create Account

Given User is on Login page
When User clicks on Create Account button user will be navigated to Account creation Page 
And User enters "<First name>" , "<Last name>", "<Email address>", "<Password>" and "<confirm Passowrd>" 
Then Clicks on Create account buuton
 
 Examples: 
 | First name | Last name | Email address | Password | confirm Passowrd |
 | 					  |						|								|					 |									|
 | User1		  | demo1		  | user1demo1@example.com 	| Welcome@1 | Welcome |
 | User2 | demo2 | user2demo2@example.com | Welcome@1 | Welcome@1 |

Scenario Outline: Login Account

Given User is on Login page
When User enters "<Login Email>" ,"<Login password>" 
Then User will be redirected to homepage 

Examples: 
| Login Email | Login password |
| user2demo2@example.com  | Welcome@1 |
