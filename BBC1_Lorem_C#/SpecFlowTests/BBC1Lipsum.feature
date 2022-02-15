Feature: BBC1 with Lorem ipsum
As a user
I want to test all main site functionality
So that I can be sure that site works correctly

@mytag
Scenario: Checking that text contains word
    Given User opens 'Lipsum' page
    When User chooses Russian language
    Then User checks that text first paragraph contains word 'рыба'


@mytag
 Scenario: Checking that the created Lorem starts with text
    Given User opens 'Lipsum' page
    When User generates a new lorem
    Then User checks that the created Lorem starts with text 'Lorem ipsum dolor sit amet, consectetur adipiscing elit'


@mytag
 Scenario Outline: Checking created word lorem is the actual result
    Given User opens '<homePage>' page
    When User input an element '<element>' and count <count>
    Then User Checking created '<element>' lorem is the <expected_result>

    Examples:
      | homePage | count | element | expected_result|
      | Lipsum   |   10  |  words  | 10             |
      | Lipsum   |    0  |  words  | 5              |
      | Lipsum   |   -1  |  words  | 5              |
      | Lipsum   |   20  |  words  | 20             |
      | Lipsum   |    5  |  words  | 5              |
      | Lipsum   |   10  |  bytes  | 10             |
      | Lipsum   |  -10  |  bytes  | 5              |
      | Lipsum   |    0  |  bytes  | 5              |

@mytag
Scenario Outline: Checking created lorem not start with text
    Given User opens 'Lipsum' page
    When User disables checkbox begin with lorem
    And User generates a new lorem
    Then User checking created lorem not start with 'Lorem ipsum dolor sit amet, consectetur adipiscing elit'


@mytag
Scenario: Checking probability contains word "lorem"
    Given User opens 'Lipsum' page
    When User generates 10 text with lorem 
    Then Compares that the average number is greater than 2


@mytag
Scenario: Checks the name of the headline article
	Given User opens 'BBC' page
	When User click to the News
	Then User checks the title of the main article with 'Charles leads Jubilee tributes to 'remarkable' Queen'

@mytag
Scenario: Checks secondary article titles
	Given User opens 'BBC' page
	When User click to the News
	Then User checks actual list secondary article titles with expected list

	| articles  | titles                                             |
	| article 1 | Beloved Indian singer Lata Mangeshkar dies at 92   |
	| article 2 | Tragic end for boy trapped in Moroccan well        |
	| article 3 | Russia 70% ready to invade Ukraine, US sources say |
	| article 4 | The fast fashion graveyard in a desert             |     
    | article 5 | The fast fashion graveyard in a desert             |
	
 @mytag
 Scenario:  Checks the name of the first article by search category 
	Given User opens 'BBC' page
	When User click to the News
	Then User checks the name of the first article with 'UK' 

@mytag
Scenario Outline: Checks message the form without field
	Given User opens 'Lipsum' page
	And User generates the text of the question
	And User opens 'BBC' page
	When User click to the News
	And User chooses Coronavirus news
	And User choses Coronavirus stories
	And User choses ask questions
	Then Filled out the form witout '<field>' and corrected the error '<message>'

	Examples:
      | url | field    | message                      |
      | BBC | question | can't be blank               |
      | BBC | accept   | must be accepted             |
      | BBC | email    | Email address can't be blank |
      | BBC | name     | Name can't be blank          |                                   
                                                                                                                                     
