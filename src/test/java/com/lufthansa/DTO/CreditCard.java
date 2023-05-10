package com.lufthansa.DTO;

public class CreditCard {

    private String cardNumber;
    private String cvv;
    private String expiresMonth;
    private String expiresYear;
    private String nameOnCard;
    private String country;
    private String billingAddress;
    private String city;
    private String state;
    private String postalCode;

    public CreditCard(String cardNumber, String cvv, String expiresMonth, String expiresYear, String nameOnCard,
                      String country, String billingAddress, String city, String state, String postalCode) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiresMonth = expiresMonth;
        this.expiresYear = expiresYear;
        this.nameOnCard = nameOnCard;
        this.country = country;
        this.billingAddress = billingAddress;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }


    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getExpiresMonth() {
        return expiresMonth;
    }

    public void setExpiresMonth(String expiresMonth) {
        this.expiresMonth = expiresMonth;
    }

    public String getExpiresYear() {
        return expiresYear;
    }

    public void setExpiresYear(String expiresYear) {
        this.expiresYear = expiresYear;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
