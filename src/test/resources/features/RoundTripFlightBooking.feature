Feature: Booking Round Trip Flight

  Background:
    Given I am on the flight booking page

  Scenario: Book round trip flight from Frankfurt to Budapest for 2 adults and 1 infant in Business class
  with Bussines option, reserving a car and choosing credit card payment


    When I select "RoundTrip" flight
    And I enter "Frankfurt" as the departure at "FRA" airport
    And I enter "Budapest" as the destination at "BUD" airport
    Then I verify the route has these airports "FRA" "BUD"
    And I select the first date of the "present" "month" as the departure date
    And I select after "1" "month" the return date
    And I select "2" "adult"
    And I select "1" "infant"
    And I select "Business" "cabin"
    And I click search button
    And I select "Lufthansa" as the preferred airline
    And I select "BUSINESS" option

    And I set the following passenger information
      | firstName | middleName | lastName | gender | dateOfBirth | email             | confirmationEmail | phoneNumber |
      | Orgejda   | Ori        | Doda     | female | 16/Jun/2000 | orgejda@gmail.com | orgejda@gmail.com | 0679898989  |
      | Deivid    | Dev        | Luka     | male   | 5/Mar/2000  |                   |                   |             |
      | Lukas     | Luc        | Luka     | male   | 5/Feb/2023  |                   |                   |             |
      |           |            |          |        |             |                   |                   |             |
    And I choose "Credit Card/Debit Card" for payment type

    And I enter the following card information
      | cardNumber       | cvv | expireMonth | expireYear | nameOnCard   | country | billingAddress | city   | state      | postalCode |
      | 5555341244441115 | 737 | 7           | 2023       | Orgejda Doda | Albania | Don Bosko      | Tirane | California | 1001       |


    And I click addCar button
    And I select "12:30 pm" "12:30 pm" hours
    And I click search button
    And I click bookNow button

    And I set custom field
    And I click the agree checkbox
    And I click the confirm button
    Then I should see the booking confirmation page,get the booking reference number and verify these passenger names
      | firstName | middleName | lastName |
      | Orgejda   | Ori        | Doda     |
      | Deivid    | Dev        | Luka     |
      | Lukas     | Luc        | Luka     |
