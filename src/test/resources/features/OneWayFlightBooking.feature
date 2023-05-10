Feature: Booking a One Way Flight

  Background:
    Given I am on the flight booking page

  Scenario: Book one way flight from Frankfurt to Munich for 2 adults in Economy class with Light economy option,
  selecting desired seat and choosing cash payment

    When I select "OneWay" flight
    And I enter "Frankfurt" as the departure at "FRA" airport
    And I enter "Munich" as the destination at "MUC" airport
    And I select a date on the upcoming month
    And I select "2" "adult"
    And I select "Economy" "cabin"
    And I click search button
    And I select "Lufthansa" as the preferred airline
    And I select "LIGHT" option
    And I set the following passenger information
      | firstName | middleName | lastName | gender | dateOfBirth | email             | confirmationEmail | phoneNumber |
      | Orgejda   | Ori        | Doda     | female | 16/Jun/2000 | orgejda@gmail.com | orgejda@gmail.com | 0676060606  |
      | Deivid    | Dev        | Luka     | male   | 5/Mar/2000  |                   |                   |             |
    And I click the seat button
    And I select "22A" as the preferred seat
    And I click the save button
    #And I choose "Cash" for payment type
    And I choose "Credit Card/Debit Card" for payment type

    And I enter the following card information
      | cardNumber       | cvv | expireMonth | expireYear | nameOnCard   | country | billingAddress | city   | state      | postalCode |
      | 5555341244441115 | 737 | 7           | 2023       | Orgejda Doda | Albania | Don Bosko      | Tirane | California | 1001       |

    And I set custom field
    And I click the agree checkbox
    And I click the confirm button
    Then I should see the booking confirmation page,get the booking reference number and verify these passenger names
      | firstName | middleName | lastName |
      | Orgejda   | Ori        | Doda     |
      | Deivid    | Dev        | Luka     |
