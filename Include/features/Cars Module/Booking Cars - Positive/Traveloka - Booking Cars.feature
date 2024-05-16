#Author: aldirhmn@gmail.com
@BookingCarFunctionality
Feature: Booking Cars Functionality E2E
  This feature is using for doing booking a cars until payment

  @SearchCarProduuct
  Scenario: Searching Cars for Booking
    Given User already login and navigate to Cars Menu
    When User choose "Without Driver"
    And User input the Pick Up Location "Jakarta" , PickUp Date "2" Days After , Dropoff Date "5" Days After
    And User tap btn Search
    Then User successfully Get List Cars Provider

  @ChoosingCar
  Scenario: Choose Cars from Provider
    Given User already in List Cars Provider and Choose Cars to Book
    When User choose Cars Provider
    Then User success choosing Cars

  @PickingLocationCar
  Scenario: Picking Pick-Up Location and Drop-Off Location
    Given User already choose cars and pick "Rental Office" to Pick-up Location
    When User choose detail Pick-up Location
    And User input Drop-Off Location "Other Location"
    And User input notes in Pick-up and Drop-off Location
    Then User successfully Picking Location Car

  @BookingDetails
  Scenario: Fill All Booking Details
    Given User already booking car and in Detail Booking Page
    When User fill Contact Details and Driver Details
    And User fill Special Request and Check All Rental Requirement
    And User select payment method and process payment
    Then User successfully Booking a Car
