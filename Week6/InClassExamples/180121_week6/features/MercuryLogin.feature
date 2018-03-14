#Feature is the first keyword of a feature file that simply designates it as such.
Feature: Mercury Tours Login
	I wish to login to Mercury using proper credentials.

	#Scenario: keyword designates a single test
	#Scenario Outline: is used for a parameterized test. It MUST be used with an 
	##Examples: table
	Scenario: Logging into mercury tours
		Given a user is at the login screen for mercury tours.
		When a user shall input a username and a password and click submit 
		#This is called a datatable. 
		#Datatables are used in situations where you would have a lot of input fields that require
		#numerous data or identity
			|field			|value			|type|
			|userName		|bobbert		|text|
			|password		|bobbert		|text|
			|login			|						|click|
			|fromPort		|Frankfurt	|weblist|
			|toMonth		|11					|weblist|
			#|findFlights|						|click|
		Then a user shall be redirected to the find flights page
		
		
		#Examples table must be formatted like below. Whitespace doesnt matter.
#		Examples: 
#		|username		|password		|
#		|bobbert		|bobbert		|
#		|tropicana	|tropicana	|
#		|goodbye		|hello			|
