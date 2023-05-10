package com.lufthansa.utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitUtils {
    private BaseInformation baseInformation;
    private Duration defaultDuration;

    private WebDriver driver = BaseInformation.getDriver();
    WebDriverWait waitDriver = new WebDriverWait(driver,30);

    public WaitUtils(BaseInformation baseInformation, Duration defaultDuration) {
        this.baseInformation = baseInformation;
        this.defaultDuration = defaultDuration;
    }


    public static void waitFor(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e1) {
            System.out.println("ERROR in waitForMethod");
        }
    }

    public WebElement waitForElementVisible(WebElement element) {
        return waitDriver.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementClickable(WebElement element) {
        return waitDriver.until(ExpectedConditions.elementToBeClickable(element));
    }


    public WebElement waitForElementVisibleOfElementLocated(By locator) {
        return waitDriver.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public List<WebElement> waitForNumberOfElementsToBeLessThan(By locator, int numberOfElements) {
        return waitDriver.until(ExpectedConditions.numberOfElementsToBeLessThan(locator, numberOfElements));
    }

    public List<WebElement> waitForAllElementsToBePresent(By locator) {
        return waitDriver.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public List<WebElement> waitForAllElementsToBeVisible(List<WebElement> elements) {
        return waitDriver.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void waitForURLToContainKeyWord(String keyword) {
        waitDriver.until(ExpectedConditions.urlContains(keyword));
    }


    public void waitForElementToBeInvisible(WebElement element) {
        waitDriver.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForALlElementToBeInvisible(List<WebElement> element) {
        waitDriver.until(ExpectedConditions.invisibilityOfAllElements(element));
    }


    public void waitForTitleToContain(String expectedText) {
        waitDriver.until(ExpectedConditions.titleContains(expectedText));
    }

}
