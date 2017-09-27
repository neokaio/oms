General thoughts:
 - requirements are quite vague
 - time constraint quite strict
 - no details about the orders or products

Design:
 - build a web app, accessible through browser
 - use spring security to handle auth
 - make it as simple as possible to complete as much as possible within the time window

Implementation:
 - login does not take company into account; this probably requires a custom authenticator, but I ran out of time to implement it
 - registration shows pages and submits data, but the login service is not updated; use "user"/"password" to access the app
 - product service provides a hardcoded list; typically this data would come from external API or a database
 - order service does nothing but store the orders for individual users; in real world this would interact with an external API to send the order out
 - created a single test as a POC; the app should have many more
 - no client as ran out of time, but the client is the web browser really
