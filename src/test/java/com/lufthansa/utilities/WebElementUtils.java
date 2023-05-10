package com.lufthansa.utilities;

import org.openqa.selenium.*;

import java.time.Duration;
import java.util.List;

public class WebElementUtils {
    WebDriver driver = BaseInformation.getDriver();

    private final BaseInformation baseInformation;
    private final WaitUtils waitUtils;


    public WebElementUtils(BaseInformation baseInformation, Duration defaultDuration) {
        this.baseInformation = baseInformation;
        this.waitUtils = new WaitUtils(baseInformation, defaultDuration);
    }

    public void clickWebElement(WebElement webElement) {
        waitUtils.waitForElementVisible(webElement)
                .click();

    }


    public void sendKeysToElement(WebElement element, String value) {

        element.sendKeys(value);

    }

    public void submitWebElement(WebElement webElement) {
        waitUtils.waitForElementVisible(webElement)
                .submit();
    }

    public void scrollToElement(WebElement element) {
        waitUtils.waitForElementVisible(element);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollToElements(List<WebElement> elements) {
        for (WebElement element : elements) {
            waitUtils.waitForElementVisible(element);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        }

    }
}

