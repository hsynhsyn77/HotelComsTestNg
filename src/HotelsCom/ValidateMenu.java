package HotelsCom;

import Utils.Tools;
import Utils.WebDriversHotelsCom;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class ValidateMenu extends WebDriversHotelsCom {
    ValidateMenuPOM elements = new ValidateMenuPOM();

    JavascriptExecutor js = (JavascriptExecutor) driver;

    @Test(priority = 1)
    void validateMenuTest() {
        List<String> menuExpectedList = new ArrayList<>();
        menuExpectedList.add("Konaklama yerinizi kaydedin");
        menuExpectedList.add("Destek");
        menuExpectedList.add("Seyahatler");
        menuExpectedList.add("Hesap");
        By menuFinder = By.cssSelector("nav[class='navigation-bar']>div>div");
        List<WebElement> menuList = driver.findElements(menuFinder);
        Tools.compareToList(menuExpectedList, menuList);
        WebElement loginValidation = driver.findElement(By.id("gc-custom-header-nav-bar-acct-menu"));
        Assert.assertTrue(loginValidation.getText().contains("Hesap"));
    }

    @Test(priority = 2)
    void toWhere() {
        elements.button1.click();
        elements.destinationFind.click();
        elements.destinationFind2.sendKeys("karadağ");
        elements.destinationClick.click();
        elements.click.click();
        elements.dateSearchTic.click();
        elements.chooseDateStart.click();
        Tools.wait(1);
        elements.chooseDateFinish.click();
        elements.dateOk.click();
        elements.visit.click();
        Tools.wait(1);
        elements.childs.click();
        Tools.wait(1);
        Select select = new Select
                (driver.findElement(By.xpath("//select[@id='age-traveler_selector_children_age_selector-0-0']")));
        int age = driver.findElements(By.xpath("//select[@id='age-traveler_selector_children_age_selector-0-0']")).size();
        select.selectByIndex(age);
        int randomAge = Tools.generateRandomNumber(age);
        driver.findElement(By.xpath("(//select[@id='age-traveler_selector_children_age_selector-0-0'])[" + randomAge + "]"));
        select.selectByIndex(age);
        Tools.wait(1);
        elements.visitOk.click();
        elements.searchButton.click();
    }

    @Test(priority = 3)
    void chooseHotel() {
        List<WebElement> hotelsList = driver.findElements(By.xpath("//div[@data-stid='lodging-card-responsive']"));
        System.out.println(hotelsList.size());
        int hotels = driver.findElements(By.xpath("//div[@data-stid='lodging-card-responsive']")).size();
        int randomHotel = Tools.generateRandomNumber(hotels);
        System.out.println(randomHotel);
        driver.findElement(By.xpath("(//div[@data-stid='lodging-card-responsive'])[" + randomHotel + "]")).click();
        System.out.println(driver.findElement(By.xpath("(//div[@data-stid='lodging-card-responsive'])[" + randomHotel + "]")).getText());
        HotelRezervazyonPage();
        Tools.wait(1);
        RezervasyonForm();


    }

}
