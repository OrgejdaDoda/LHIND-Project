package com.lufthansa.pages;

import com.lufthansa.elements.CarTravelPageElements;
import com.lufthansa.utilities.BaseInformation;
import com.lufthansa.utilities.BasePageObject;

public class CarTravelPage {

    BasePageObject basePageObject = new BasePageObject(BaseInformation.getBaseInformation());
    CarTravelPageElements carTravelPageElements = new CarTravelPageElements();

    public void getUrl(String url) {
        BaseInformation.getDriver().get(url);
    }

    //******** Methods********//

    public void clickSearchButton() {

        basePageObject
                .getWebElementUtils()
                .clickWebElement(carTravelPageElements.searchButton);

        System.out.println("Search button clicked");
    }

    public void clickBookNowButton() {

        basePageObject
                .getWebElementUtils()
                .clickWebElement(carTravelPageElements.bookNowButton);
    }

}
