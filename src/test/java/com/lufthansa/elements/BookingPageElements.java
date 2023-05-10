package com.lufthansa.elements;

import com.lufthansa.utilities.BaseInformation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BookingPageElements {

    public BookingPageElements() {

        PageFactory.initElements(BaseInformation.getDriver(), this);
    }

    //BookingPage Elements

    @FindBy(css = "div[class='employeeProfileField required field four wide  required'] input")
    public List<WebElement> firstNameFields;

    @FindBy(css = "div[class='employeeProfileField required field five wide   required'] input")
    public List<WebElement> lastNameFields;

    @FindBy(css = "div[class='employeeProfileField field five wide  '] input")
    public List<WebElement> middleNameFields;

    @FindBy(css = "#email_0")
    public WebElement emailFieldPassenger;

    @FindBy(css = "#email_c_0")
    public WebElement confirmationEmailFieldPassenger;

    @FindBy(css = "#phone_0")
    public WebElement phoneNrFieldPassenger;

    @FindBy(css = "input[name^='gender_m']")
    public List<WebElement> maleCheckBoxes;

    @FindBy(css = "input[name^='gender_f']")
    public List<WebElement> femaleCheckBoxes;

    @FindBy(css = "select[id^='bdate_d']")
    public List<WebElement> dayDropdowns;

    @FindBy(css = "select[id^='bdate_m']")
    public List<WebElement> monthDropdowns;

    @FindBy(css = "select[id^='bdate_y']")
    public List<WebElement> yearDropdowns;

    @FindBy(xpath = "//h4[@class='ui dividing header' and contains(text(),'Passenger')]")
    public List<WebElement> passengerDropdown;

    @FindBy(css = "#seatSelectionBtn")
    public WebElement selectSeatButton;

    @FindBy(css = "span.seat--chargable")
    public List<WebElement> selectAvailableSeats;

    @FindBy(css = "button[class='ui blue button save-seats']")
    public WebElement saveButton;

    @FindBy(css = "div[class='grFormCard3 ui segment white']")
    public WebElement scroll;

    @FindBy(css = "input[name='rdbtnb2c'][value='2']")
    public WebElement cashRadioButton;

    @FindBy(css = "input[name='rdbtnb2c'][value='0']")
    public WebElement creditCardRadioButton;

    @FindBy(css = "#CUSTOM_FIELD_834-0")
    public WebElement customField;

    @FindBy(css = "#cbRules")
    public WebElement agreeCheckbox;

    @FindBy(css = "#btnCreateBooking")
    public WebElement confirmButton;

    @FindBy(css = "input[name^='cnN_']")
    public WebElement cardNumberField;

    @FindBy(css = "input[name^='cvv_']")
    public WebElement cvvField;

    @FindBy(css = "input[name^='cname_']")
    public WebElement nameOnCardField;

    @FindBy(css = "select[name^='exp_m_']")
    public WebElement expiresMonthDropdown;

    @FindBy(css = "select[name^='exp_y_']")
    public WebElement expiresYearDropdown;

    @FindBy(css = "select[name^='cntry_']")
    public WebElement countryDropdown;

    @FindBy(css = "input[name^='str_']")
    public WebElement billingAddressField;

    @FindBy(css = "input[name^='cty_']")
    public WebElement cityField;

    @FindBy(css = "input[name^='state_']")
    public WebElement stateField;

    @FindBy(css = "input[name^='zip_']")
    public WebElement postalCodeField;

    @FindBy(css = "div#addCarTravelTypeDiv > button")
    public WebElement addCarButton;

    @FindBy(css = "div#addHotelTravelTypeDiv > button")
    public WebElement addHotelButton;

}
