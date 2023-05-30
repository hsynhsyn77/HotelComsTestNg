package HotelsCom;

import Utils.WebDriversHotelsCom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LoginTest extends WebDriversHotelsCom {
    @Test
    void loginTest() {
        WebElement inputEntrance = driver.findElement(By.id("gc-custom-header-nav-bar-acct-menu"));
        inputEntrance.click();
        WebElement entRance = driver.findElement(By.xpath("//a[@data-stid='link-header-account-signin']"));
        entRance.click();
        WebElement inputMail = driver.findElement(By.id("loginFormEmailInput"));
        inputMail.sendKeys("hsyn_hsyn77@hotmail.com");
        WebElement loginButton = driver.findElement(By.id("loginFormSubmitButton"));
        loginButton.click();
    }
}
