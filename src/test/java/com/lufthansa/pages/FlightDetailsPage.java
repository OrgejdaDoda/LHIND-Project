package com.lufthansa.pages;

import com.lufthansa.elements.FlightDetailsPageElements;
import com.lufthansa.utilities.BaseInformation;
import com.lufthansa.utilities.BasePageObject;
import com.lufthansa.utilities.ComponentsUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FlightDetailsPage {

    BasePageObject basePageObject = new BasePageObject(BaseInformation.getBaseInformation());
    FlightDetailsPageElements flightDetailsPageElements = new FlightDetailsPageElements();
    ComponentsUtils componentsUtils = new ComponentsUtils();

    public void getUrl(String url) {
        BaseInformation.getDriver().get(url);
    }

    //******** Methods********//

   public void selectPreferredAirline(String airline) {

        componentsUtils.selectPreferredAirline(airline);
   }

    public void selectPreferredAirlineAndBookNow(String airline) {

        componentsUtils.selectPreferredAirlineAndBookNow(airline);
    }


    public void clickBookNowButton(String optionValue) {

        WebElement bookNowButton = BaseInformation.getDriver()
                .findElement(By.xpath(flightDetailsPageElements.bookNowButtonXpath.replace("optionValue", optionValue)));

        basePageObject
                .getWebElementUtils()
                .scrollToElement(bookNowButton);
        basePageObject
                .getWebElementUtils()
                .clickWebElement(bookNowButton);

        System.out.println("Clicked Book Now button with option value: " + optionValue);
    }

}
