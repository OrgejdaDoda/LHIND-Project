Feature: Booking Multi Leg Flight

  Background:
    Given I am on the flight booking page

  Scenario: Book multi leg flight from Tirana to Vienne, from Vienne to Bangkok and from Bangkok to Vienne
            for 3 adults and 2 children in economy class with Austrian Airlines reserving a hotel and choosing credit card payment


    When I select "MultiDestination" flight
    And I enter "Tirana" as the "departure" at "TIA" airport for the "1" flight
    And I enter "Vienna" as the "destination" at "VIE" airport for the "1" flight
    And I select a date after "2" "month" for the "1" flight
    And I click add a leg button for the "1" flight
    And I enter "Vienna" as the "departure" at "VIE" airport for the "2" flight
    And I enter "Bangkok" as the "destination" at "BKK" airport for the "2" flight
    And I select a date after "0" "days" for the "2" flight
    And I click add a leg button for the "2" flight
    And I enter "Bangkok" as the "departure" at "BKK" airport for the "3" flight
    And I enter "Vienna" as the "destination" at "VIE" airport for the "3" flight
    And I select a date after "7" "days" for the "3" flight

    And I select "3" "adult"
    And I select "2" "children"
    And I select "Economy" "cabin"
    And I click the advanced option button
    Then I select the Non-stop flight option
    And I click search button
    And I select "Austrian Airlines" as the preferred airline and click book now
    And I set the following passenger information

      | firstName | middleName | lastName | gender | dateOfBirth | email             | confirmationEmail | phoneNumber |
      | Orgejda   | Ori        | Doda     | female | 16/Jun/2000 | orgejda@gmail.com | orgejda@gmail.com | 0676060606  |
      | Deivid    | Dev        | Luka     | male   | 5/Mar/2000  |                   |                   |             |
      | Daniel    | Dan        | Luka     | male   | 5/Mar/2007  |                   |                   |             |
      | Lukas     | Luc        | Luka     | male   | 5/Feb/2012  |                   |                   |             |
      | Hana      | Luc        | Luka     | female | 5/Feb/2012  |                   |                   |             |

    And I choose "Credit Card/Debit Card" for payment type
    And I enter the following card information

      | cardNumber       | cvv | expireMonth | expireYear | nameOnCard   | country | billingAddress | city   | state      | postalCode |
      | 5555341244441115 | 737 | 7           | 2023       | Orgejda Doda | Albania | Don Bosko      | Tirane | California | 1001       |

    And I click addHotel button
    And I enter "Bangkok" at "BKK" on the check in location
    And I select "Check In" date
    And I select "Check Out" date
    And I choose "2" rooms
    When I am on the "1" room I enter "2" adults and children

      | numberOfChild |
      | 0             |

    When I am on the "2" room I enter "1" adults and children
      | numberOfChild | 1 | 2 |
      | 2             | 8 | 8 |

    Then I click on the search button
    And I select a hotel cheaper then "3500" per night and cheaper then "25000" total
    And I set custom field
    And I click the agree checkbox
    And I click the confirm button
    Then I should see the booking confirmation page,get the booking reference number and verify these passenger names

      | firstName | middleName | lastName |
      | Orgejda   | Ori        | Doda     |
      | Deivid    | Dev        | Luka     |
      | Daniel    | Dan        | Luka     |
      | Lukas     | Luc        | Luka     |
      | Hana      | Luc        | Luka     |
