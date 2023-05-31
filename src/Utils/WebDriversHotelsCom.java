package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WebDriversHotelsCom {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void startingOperation() {
        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

        System.setProperty("web-driver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();

        driver.manage().deleteAllCookies();

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));//sadece ana sayfa yüklenirken en başta
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));// bütün sonradan görünen webElement için geçerli

        driver.get("https://tr.hotels.com/");

        loginTest();

    }

    @AfterClass
    public static void waitClose() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    //@AfterClass
    //public static void Wait(int second) {
    //    try {
    //        Thread.sleep(second * 1000);
    //    } catch (InterruptedException e) {
    //        throw new RuntimeException(e);
    //    }
//
//    }

    @AfterClass
    public static void close() {

        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (Exception ignored) {

        }
    }

    void loginTest() {
        WebElement inputEntrance = driver.findElement(By.id("gc-custom-header-nav-bar-acct-menu"));
        inputEntrance.click();
        WebElement entRance = driver.findElement(By.cssSelector("a[class='uitk-button uitk-button-medium uitk-button-fullWidth uitk-button-has-text uitk-button-as-link uitk-button-primary']"));
        entRance.click();
        WebElement inputMail = driver.findElement(By.id("loginFormEmailInput"));
        inputMail.sendKeys("hsyn_hsyn77@hotmail.com");
        WebElement loginButton = driver.findElement(By.id("loginFormSubmitButton"));
        loginButton.click();
        WebElement passwordButton = driver.findElement(By.id("passwordButton"));
        passwordButton.click();
        WebElement password = driver.findElement(By.id("enterPasswordFormPasswordInput"));
        password.sendKeys("Se_238523");
        Tools.wait(1);
        WebElement enterPasswordFormSubmitButton = driver.findElement(By.xpath("//button[@id='enterPasswordFormSubmitButton']"));
        enterPasswordFormSubmitButton.click();


    }

    public static void HotelRezervazyonPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Set<String> windowAllWindows = driver.getWindowHandles();

        for (String window : windowAllWindows) {
            driver.switchTo().window(window);
        }

        js.executeScript("window.scrollBy(0,200)");
        WebElement element = driver.findElement(By.xpath("//button[@type='submit']"));
        element.click();


    }

    public static void RezervasyonForm() {

        WebElement formName = driver.findElement(By.xpath("//input[@id='room-details-room-0-first-name']"));
        formName.sendKeys("Hüseyin");
        Tools.wait(1);

        WebElement formLastname = driver.findElement(By.xpath("//input[@id='room-details-room-0-last-name']"));
        formLastname.sendKeys("hüseyin");
        Tools.wait(1);

        WebElement mail = driver.findElement(By.xpath("//input[@id='contact-details-email']"));
        mail.sendKeys("huseyin1234@gmail.com");
        Tools.wait(1);
        WebElement phone = driver.findElement(By.xpath("//input[@id='contact-details-phone']"));
        phone.sendKeys("05055455454");
        Tools.wait(1);
        WebElement paymentName = driver.findElement(By.xpath("//input[@id='payment-details-first-name']"));
        paymentName.sendKeys("Hüseyin");
        Tools.wait(1);
        WebElement paymentLastname = driver.findElement(By.xpath("//input[@id='payment-details-last-name']"));
        paymentLastname.sendKeys("hüseyin");
        Tools.wait(1);
        WebElement carNo = driver.findElement(By.xpath("//input[@id='payment-details-card-number']"));
        carNo.sendKeys("5112579743352517");
        Tools.wait(1);
        WebElement cardMonth = driver.findElement(By.xpath("//input[@id='expiry-month']"));
        cardMonth.sendKeys("04");
        Tools.wait(1);
        WebElement cardyear = driver.findElement(By.xpath("//input[@id='expiry-year']"));
        cardyear.sendKeys("24");
        Tools.wait(1);
        WebElement carCvv = driver.findElement(By.xpath("//input[@id='payment-details-cvv']"));
        carCvv.sendKeys("106");
        Tools.wait(1);
        WebElement receptionapproval = driver.findElement(By.xpath("//[@id='book-button']"));
        receptionapproval.click();


    }



}
