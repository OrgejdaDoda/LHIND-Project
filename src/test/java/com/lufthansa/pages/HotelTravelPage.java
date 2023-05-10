package com.lufthansa.pages;

import com.lufthansa.elements.HotelTravelPageElements;
import com.lufthansa.utilities.BaseInformation;
import com.lufthansa.utilities.BasePageObject;
import com.lufthansa.utilities.ComponentsUtils;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class HotelTravelPage {

    BasePageObject basePageObject = new BasePageObject(BaseInformation.getBaseInformation());
    HotelTravelPageElements hotelTravelPageElements = new HotelTravelPageElements();
    ComponentsUtils componentsUtils = new ComponentsUtils();

    public void getUrl(String url) {
        BaseInformation.getDriver().get(url);
    }


    public void searchCheckInLocation(String inputDeparture, String completedDeparture) {

        componentsUtils.searchAutoComplete("Check In", inputDeparture, completedDeparture);
    }

    public void chooseCheckInOutDate(String intent) {

        componentsUtils.selectCheckInCheckOutDate(intent);
    }

    public void chooseRoomNo(String roomNo) {

        componentsUtils.selectOption(hotelTravelPageElements.noRoomsDropdown, roomNo);
    }


    public void fillInGuestInformation(String roomNo, String adultNo, DataTable dataTable) {

        List<Map<String, String>> childrenNoList = dataTable.asMaps(String.class, String.class);
        Map<String, String> childrenNo = childrenNoList.get(0);


        componentsUtils.selectOption(hotelTravelPageElements.adultsDropdown.get(Integer.parseInt(roomNo) - 1), adultNo);

        if (childrenNo.get("numberOfChild").equals("0")) {

            componentsUtils.selectOption(hotelTravelPageElements.childDropdown.get(Integer.parseInt(roomNo) - 1), childrenNo.get("numberOfChild"));

        } else {
            componentsUtils.selectOption(hotelTravelPageElements.childDropdown.get(Integer.parseInt(roomNo) - 1), childrenNo.get("numberOfChild"));
            for (int i = 0; i < Integer.parseInt(childrenNo.get("numberOfChild")); i++) {
                componentsUtils.selectOption(hotelTravelPageElements.childAgeDropdown.get(i), childrenNo.get(String.valueOf(i + 1)));
            }
        }


        componentsUtils.selectOption(hotelTravelPageElements.noRoomsDropdown, roomNo);
    }


    public void clickSearchButton() {

        basePageObject
                .getWebElementUtils()
                .clickWebElement(hotelTravelPageElements.searchButton);

    }

    public void selectHotel(String pricePerNight, String totalPrice) {

        basePageObject
                .getWaitUtils()
                .waitForAllElementsToBeVisible(hotelTravelPageElements.hotelPrices);

        for (WebElement priceElement : hotelTravelPageElements.hotelPrices) {
            String priceText = priceElement.getText();

            double price = Double.parseDouble(priceText.replaceAll("[^0-9.]", ""));

            if (price < Integer.parseInt(pricePerNight) && price * 7 < Integer.parseInt(totalPrice)) {
                WebElement hotelElement = priceElement.findElement(By.xpath(".."));
                WebElement selectButton = hotelElement.findElement(By.className("select-button"));
                selectButton.click();
                break;
            }
        }
    }
}
