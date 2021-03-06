package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.qameta.allure.Step;

public class BookingPage extends BaseServicePage {

    public BookingPage(WebDriver driver) {
        super(driver);
        try {
            getBookBtn();
        } catch (TimeoutException e) {
            throw new IllegalStateException("Book button is not present. Considering that this is not a booking page", e);
        }
    }

    By bookBtnLocator = By.cssSelector("[class ='bo-ev-sb btn waves-effect waves-light']");

    @Step("Click on book button")
    public BookingPage bookBtnClick() {
        getBookBtn().click();
        return this;
    }

    private WebElement getBookBtn() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(bookBtnLocator));
    }

}
