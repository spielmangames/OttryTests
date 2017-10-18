package pageObjects.ottry.merchant;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.core.BasePage;
import utils.core.Config;


public class MerchantLoginPage extends BasePage {
    private String merchantLogin;
    private String merchantPassword;

    public MerchantLoginPage(WebDriver driver, Config config) {
        super(driver);
        merchantLogin = config.getMerchantLogin();
        merchantPassword = config.getMerchantPassword();
        try {
            getLoginField();
        } catch (TimeoutException e) {
            System.out.println("Seems that login page is not displayed. Trying to navigate...");
            driver.get(config.getMerchantURL());
        }
        try {
            getLoginField();
        } catch (TimeoutException e) {
            throw new IllegalStateException("Login field is not present after navigation attempt. It is not login page", e);
        }
    }

    By loginFieldLocator = By.cssSelector("[id='name']");
    By passwordFieldLocator = By.cssSelector("[id='password']");
    By okButtonLocator = By.cssSelector("[name='login']");

    private WebElement getLoginField() {
        return new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(loginFieldLocator));
    }

    private WebElement getPassField() {
        return driver.findElement(passwordFieldLocator);
    }

    private WebElement getOkBtn() {
        return driver.findElement(okButtonLocator);
    }

    public MerchantMainPage loginToMerchant(String login, String pass) {
        this.fillLoginField(login).
                fillPasswordField(pass).
                okBtnClick();
        return new MerchantMainPage(driver);
    }

    public MerchantMainPage loginToMerchant() {
        return loginToMerchant(merchantLogin, merchantPassword);
    }

    private void okBtnClick() {
        getOkBtn().click();
    }

    private MerchantLoginPage fillPasswordField(String pass) {
        getPassField().sendKeys(pass);
        return this;
    }

    private MerchantLoginPage fillLoginField(String login) {
        getLoginField().sendKeys(login);
        return this;
    }

}
