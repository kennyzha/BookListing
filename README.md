
## Instructions ##
1. Go to server directory and run BookList.java in demo package.
2. Open index.html in client directory.

![alt text](https://i.imgur.com/CCTkoVU.png)

---

# Book Listing Exercise #

The purpose of this exercise is to test your familiarity with Java full-stack development.  You'll be building a small book listing app using frameworks of your choice and the Goodreads' public API.

## Functional Requirements ##

* The user will be presented with a simple search page with an input field and a search button
* Clicking the search button triggers a search to the Goodreads' API and displays the results on the screen
* The results must contain the author, title, and image of the book
* The results should be sortable by title and author, with title as the default

## System Requirements ##

* The application must be written in Java, though the sorting must be handled client-side and written in Javascript
* You may use any Java frameworks / libraries that you see fit
* Errors that occur during processing should be logged and the user should be presented with a message asking them to retry.

## Non-Requirements ##

* Security measures, including user authentication / authorization as well as general web application security (eg xss, sql injection, etc)
* Unit testing
* UX, as long as the application is usable.  As this is just an exercise the GUI may be bare bones
* Logging, with the exception of errors

## Misc Notes ##

* https://www.goodreads.com/api/index#search.books (Key: RDfV4oPehM6jNhxfNQzzQ, Secret: fu8fQ5oGQEDlwiICw45dGSuxiu13STyIrxY0Rb6ibI).
* The Goodreads search API returns XML. Transform the XML into JSON and only send what your app will need
* Be sure to document your code, _especially cases where you might have made a different choice in a 'real' application_
* Upon completion, be sure that your code is accessible through a git repo, and provide the link to that repo to Dotdash

## Bonus Points ##

* Include pagination in the UI.
