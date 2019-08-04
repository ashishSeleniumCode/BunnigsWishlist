Feature: Bunnings landing page

Scenario: Verify the search text field button functionality

Given User is on the Bunnings Landing page
When User enters the text in search box
Then user is navigated to the search result page  


Scenario: Verify the item is added to Wishlist

Given User is on the search page
Then Add it to the Wishist
And Product should be added in the wishlist  