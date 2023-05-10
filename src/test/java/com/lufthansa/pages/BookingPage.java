package com.lufthansa.pages;

import com.lufthansa.elements.BookingPageElements;
import com.lufthansa.globals.Globals;
import com.lufthansa.utilities.BaseInformation;
import com.lufthansa.utilities.BasePageObject;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;


public class BookingPage {

    BasePageObject basePageObject = new BasePageObject(BaseInformation.getBaseInformation());
    BookingPageElements bookingPageElements = new BookingPageElements();

    public void getUrl(String url) {
        BaseInformation.getDriver().get(url);
    }

    //******** Methods********//


    public void setPassengerInfo(DataTable dataTable) {

//        try {
//            basePageObject
//                    .getWaitUtils()
//                    .waitForAllElementsToBeVisible(bookingPageElements.firstNameFields);
//        } catch (TimeoutException e) {
//
//        }

        basePageObject
                .getWaitUtils()
                .waitForAllElementsToBeVisible(bookingPageElements.firstNameFields);

        List<Map<String, String>> passengerData = dataTable.asMaps(String.class, String.class);
        int index = 0;
        for (Map<String, String> row : passengerData
        ) {
            String[] birthdate = row.get("dateOfBirth").split("/");
            bookingPageElements.firstNameFields.get(index).sendKeys(row.get("firstName"));
            bookingPageElements.middleNameFields.get(index).sendKeys(row.get("middleName"));
            bookingPageElements.lastNameFields.get(index).sendKeys(row.get("lastName"));
            bookingPageElements.dayDropdowns.get(index).sendKeys(birthdate[0]);
            bookingPageElements.monthDropdowns.get(index).sendKeys(birthdate[1]);
            bookingPageElements.yearDropdowns.get(index).sendKeys(birthdate[2]);
            if (row.get("gender").equalsIgnoreCase("female")) {
                bookingPageElements.femaleCheckBoxes.get(index).click();
            } else {
                bookingPageElements.maleCheckBoxes.get(index).click();
            }
            if (index == 0) {
                basePageObject
                        .getWebElementUtils()
                        .sendKeysToElement(bookingPageElements.emailFieldPassenger, row.get("email"));
                basePageObject
                        .getWebElementUtils()
                        .sendKeysToElement(bookingPageElements.confirmationEmailFieldPassenger, row.get("confirmationEmail"));
                basePageObject
                        .getWebElementUtils()
                        .sendKeysToElement(bookingPageElements.phoneNrFieldPassenger, row.get("phoneNumber"));
            }
            if (index < passengerData.size() - 1) {
                bookingPageElements.passengerDropdown.get(index + 1).click();
            }
            index++;
        }
        System.out.println("Filled in all passenger info");
    }

    public void clickSelectSeatButton() {

        basePageObject
                .getWebElementUtils()
                .clickWebElement(bookingPageElements.selectSeatButton);

        System.out.println("Clicked Select Seat button");
    }

    public void selectSeat(String seat) {

        Boolean flag;
        flag = selectDesiredSeat(seat);

        if (flag) {
            System.out.println("Selected seat " + seat);
        } else {
            for (WebElement e : bookingPageElements.selectAvailableSeats
            ) {
                String seatCode = e.getAttribute("data-code");
                if (seatCode == null) {
                    continue;
                }
                if (seatCode.contains("A") || seatCode.contains("F")) {
                    e.click();
                    System.out.println("Selected seat " + seatCode + " since desired seat was unavailable");
                    return;
                }
            }
        }
    }

    public Boolean selectDesiredSeat(String seat) {

        basePageObject
                .getWaitUtils()
                .waitForAllElementsToBeVisible(bookingPageElements.selectAvailableSeats);

        for (WebElement seatElement : bookingPageElements.selectAvailableSeats) {
            String seatCode = seatElement.getAttribute("data-code");
            if (seatCode == null) {
                continue;
            }
            if (seatCode.equals(seat)) {
                seatElement.click();
                return true;
            }
        }
        return false;
    }

    public void clickSaveButton() {

        basePageObject
                .getWebElementUtils()
                .clickWebElement(bookingPageElements.saveButton);

        basePageObject
                .getWaitUtils()
                .waitForElementToBeInvisible(bookingPageElements.saveButton);

        System.out.println("Clicked save button.");
    }

    public void selectPaymentOption(String paymentOption) {

        basePageObject
                .getWebElementUtils()
                .scrollToElement(bookingPageElements.scroll);

        switch (paymentOption) {

            case "Cash":
                bookingPageElements.cashRadioButton.click();

                break;

            case "Credit Card/Debit Card":
                bookingPageElements.creditCardRadioButton.click();
                break;

            default:
                throw new IllegalArgumentException("Invalid payment option: " + paymentOption);
        }

        System.out.println("Selected payment option: " + paymentOption);
    }

    public void clickAddCarButton() {

        basePageObject
                .getWebElementUtils()
                .clickWebElement(bookingPageElements.addCarButton);
    }

    public void clickAddHotelButton() {

        basePageObject
                .getWebElementUtils()
                .clickWebElement(bookingPageElements.addHotelButton);
    }

    public void setCustomField() {

        basePageObject
                .getWebElementUtils()
                .sendKeysToElement(bookingPageElements.customField, Globals.cardVerificationValue);

        System.out.println("Set custom field to: " + Globals.cardVerificationValue);
    }

    public void clickAgreeCheckbox() {

        bookingPageElements.agreeCheckbox.click();

        System.out.println("Clicked agree checkbox.");
    }

    public void clickConfirmButton() {

        basePageObject
                .getWebElementUtils()
                .clickWebElement(bookingPageElements.confirmButton);

        System.out.println("Clicked confirm button.");
    }


    public void setCreditCardInfo(DataTable dataTable) {
        List<Map<String, String>> cardInfoList = dataTable.asMaps(String.class, String.class);
        Map<String, String> cardInfo = cardInfoList.get(0);

        bookingPageElements.cardNumberField.sendKeys(cardInfo.get("cardNumber"));
        bookingPageElements.cvvField.sendKeys(cardInfo.get("cvv"));
        bookingPageElements.nameOnCardField.sendKeys(cardInfo.get("nameOnCard"));

        Select monthDropdown = new Select(bookingPageElements.expiresMonthDropdown);
        monthDropdown.selectByValue(cardInfo.get("expireMonth"));

        Select yearDropdown = new Select(bookingPageElements.expiresYearDropdown);
        yearDropdown.selectByValue(cardInfo.get("expireYear"));

        Select countryDropdown = new Select(bookingPageElements.countryDropdown);
        countryDropdown.selectByVisibleText(cardInfo.get("country"));

        bookingPageElements.billingAddressField.sendKeys(cardInfo.get("billingAddress"));
        bookingPageElements.cityField.sendKeys(cardInfo.get("city"));
        bookingPageElements.stateField.sendKeys(cardInfo.get("state"));
        bookingPageElements.postalCodeField.sendKeys(cardInfo.get("postalCode"));

        System.out.println("Filled in all card info");

    }
}



