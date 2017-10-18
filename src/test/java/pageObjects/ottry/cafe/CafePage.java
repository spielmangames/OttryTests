package pageObjects.ottry.cafe;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.ottry.BaseServicePage;
import utils.core.BasePage;
import utils.core.Config;

public class CafePage extends BaseServicePage {

    public CafePage(WebDriver driver, Config config) {
        super(driver);
        try {
            getObBtn();
        } catch (TimeoutException e) {
            System.out.println("Seems that cafe page is not displayed. Trying to navigate...");
            driver.get(config.getCafeURL());
        }
        try {
            getObBtn();
        } catch (TimeoutException e) {
            throw new IllegalStateException("OB button is not present after navigation attempt. Cafe page is not loaded", e);
        }
        try {
            obBtnClick();
        } catch (TimeoutException e) {
            throw new IllegalStateException("Service is not loaded.", e);
        }
    }

    By obBtnLocator = By.xpath("//button[@class='bo-sbv-b btn waves-effect waves-light']");

    private WebElement getObBtn() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(obBtnLocator));
    }

    private WebElement obBtnClick() {
        getObBtn().click();
        return getGoBtn();
    }


}
