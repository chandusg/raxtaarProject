@login-feature
Feature: Dashboard Verification 

#Background:
#
#Given I am logged in to the application 

Scenario:
Dashboard should be seen by default 
	Given I am logged in to the application 
	Then I see the overview page by default 
	And I see the count of "hoists" 
	And I see the count of "users" 
	And I see the count of "controllers" 
	And I see the count of "companies" 
	And I see the count of "locations" 
@inDev	
Scenario:
On Clicking of Edit button, the hoist edit pop up should appear 
	Given I am logged in to the application 
	Then I see the overview page by default 
	When I click on hoists menu 
	Then I see the hoist overview screen 
	And I see the records sorted with Number column 
	And for first record I click on "Edit" button 
	Then I see the Edit Hoist popup screen open 
	And Fill the below details and click on Submit Button
	|Number|1|
	|Type|RX2050F|
	|Company|ANC|
	|Location|22 Bishops Gate|
	|Description|TNT Equipment|
	|Controller|8931088116112100943|
	|Note|Not Mandatory dummy Notes|
	Then the pop up should be diaplyed with Sucessfully Submitted message
	When the close button is clicked in the pop up
@chandru	
Scenario: It should be possible to delete the hositdetails when clicked on Ok button in the pop up
	Given I am logged in to the application 
	When I click on hoists menu 
	Then I see the hoist overview screen 
	And I see the records sorted with Number column 
	And for first record I click on "Delete" button 
	Then I see the Delete Hoist popup screen open 
	When I click on the "OK" button the pop up
	Then the hositDetails will be deleted
	
	Scenario: It should not be possible to delete the hosit details when clicked on Cancel button in the pop up
	Given I am logged in to the application 
	When I click on hoists menu 
	Then I see the hoist overview screen 
	And I see the records sorted with Number column 
	And for first record I click on "Delete" button 
	Then I see the Delete Hoist popup screen open 
	When I click on the "Cancel" button the pop up
	Then the hositDetails should not be deleted
	