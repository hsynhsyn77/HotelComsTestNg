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
    By validation = By.id("gc-custom-header-nav-bar-acct-menu");
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

        WebElement loginValidation = driver.findElement(validation);
        Assert.assertTrue(loginValidation.getText().contains("Hesap"));


    }

    @Test(priority = 2)
    void toWhere() {

        WebElement button1 = driver.findElement(By.xpath("//div/div/div/button[3]"));
        button1.click();

        WebElement destinationFind = driver.findElement(By.xpath("//button[@class='uitk-fake-input uitk-form-field-trigger']"));
        destinationFind.click();
        WebElement destinationFind2=driver.findElement(By.xpath("//input[@id='destination_form_field']"));
        destinationFind2.sendKeys("karadağ");

        WebElement destinationClick = driver.findElement(By.xpath("/html//div[@id='destination_form_field-menu']/section//ul/li[1]/div[@class='uitk-action-list-item-content']/button[@type='button']"));
        destinationClick.click();
        WebElement click = driver.findElement(By.xpath("//*[@class='uitk-heading uitk-heading-3 uitk-spacing uitk-spacing-padding-block-three']"));
        click.click();
        WebElement dateSearchTic = driver.findElement(By.xpath("//*[@class='uitk-faux-input uitk-form-field-trigger']"));
        dateSearchTic.click();
        WebElement chooseDateStart = driver.findElement(By.xpath("//*[@data-day='15'][1]"));
        chooseDateStart.click();

        Tools.wait(1);

        WebElement chooseDateFinish = driver.findElement(By.xpath(" //*[@data-day='22']"));
        chooseDateFinish.click();
        WebElement dateOk = driver.findElement(By.xpath(" //*[@data-stid='apply-date-picker']"));
        dateOk.click();
        WebElement visit = driver.findElement(By.xpath("//*[@data-stid='open-room-picker']"));
        visit.click();

        Tools.wait(1);

        WebElement childs = driver.findElement(By.xpath("//*[@aria-label='Oda 1 için çocuk sayısını artırın']"));
        childs.click();

        Tools.wait(1);

        Select select = new Select  //                 //select[@id='age-traveler_selector_children_age_selector-0-0']
                (driver.findElement(By.xpath("//select[@id='age-traveler_selector_children_age_selector-0-0']")));

        int age = driver.findElements(By.xpath("//select[@id='age-traveler_selector_children_age_selector-0-0']")).size();
        select.selectByIndex(age);
        int randomAge = Tools.generateRandomNumber(age);

        driver.findElement(By.xpath("(//select[@id='age-traveler_selector_children_age_selector-0-0'])[" + randomAge + "]"));
        select.selectByIndex(age);


        Tools.wait(1);

        WebElement visitOk = driver.findElement(By.id("traveler_selector_done_button"));
        visitOk.click();
        WebElement searchButton = driver.findElement(By.id("search_button"));
        searchButton.click();

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
