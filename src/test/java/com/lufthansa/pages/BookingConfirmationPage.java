package com.lufthansa.pages;

import com.lufthansa.elements.BookingConfirmationPageElements;
import com.lufthansa.utilities.BaseInformation;
import com.lufthansa.utilities.BasePageObject;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class BookingConfirmationPage {

    BasePageObject basePageObject = new BasePageObject(BaseInformation.getBaseInformation());
    BookingConfirmationPageElements bookingConfirmationPageElements = new BookingConfirmationPageElements();

    public void getUrl(String url) {
        BaseInformation.getDriver().get(url);
    }

      //******** Methods********//

    public String confirmBookingAndGetReferenceNumber() {

        basePageObject
                .getWaitUtils()
                .waitForElementVisible(bookingConfirmationPageElements.confirmationMessage);

        String bookingNumber = bookingConfirmationPageElements.bookingReferenceNumber.getText();
        String confirmationText = bookingConfirmationPageElements.confirmationMessage.getText();

        Assert.assertTrue(confirmationText.contains("Please, write down or remember this number"),
                "Booking confirmation message not found.");

        System.out.println("Booking confirmed. Reference number: " + bookingNumber);

        return bookingNumber;
    }

    public boolean verifyTravelerNamesOnBookingPage(DataTable dataTable) {

        List<Map<String, String>> passengerInfo = dataTable.asMaps(String.class, String.class);


        if (bookingConfirmationPageElements.travelerNameElements.size() != passengerInfo.size()) {
            System.out.println("Number of traveler name elements does not match the number of passengers.");
            return false;
        }

        for (int i = 0; i < bookingConfirmationPageElements.travelerNameElements.size(); i++) {
            WebElement travelerNameElement = bookingConfirmationPageElements.travelerNameElements.get(i);
            Map<String, String> passenger = passengerInfo.get(i);

            String expectedName = passenger.get("firstName") + " " + passenger.get("middleName") + " " + passenger.get("lastName");
            String actualName = travelerNameElement.getText();

            if (!expectedName.equals(actualName)) {
                System.out.println("Name mismatch for passenger: " + actualName + " expected " + expectedName);
                return false;
            }
        }
        System.out.println("All passenger names matched");
        return true;
    }
}
