package HotelsCom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ValidateMenuPOM {
    @FindBy(xpath = "//div/div/div/button[3]")
    public WebElement button1;

    @FindBy(xpath = "//button[@class='uitk-fake-input uitk-form-field-trigger']")
    public WebElement destinationFind;

    @FindBy(xpath = "//input[@id='destination_form_field']")
    public WebElement destinationFind2;

    @FindBy(xpath = "/html//div[@id='destination_form_field-menu']/section//ul/li[1]/div[@class='uitk-action-list-item-content']/button[@type='button']")
    public WebElement destinationClick;

    @FindBy(xpath = "//*[@class='uitk-heading uitk-heading-3 uitk-spacing uitk-spacing-padding-block-three']")
    public WebElement click;

    @FindBy(xpath = "//*[@class='uitk-faux-input uitk-form-field-trigger']")
    public WebElement dateSearchTic;

    @FindBy(xpath = "//*[@data-day='15'][1]")
    public WebElement chooseDateStart;

    @FindBy(xpath = "//*[@data-day='22']")
    public WebElement chooseDateFinish;

    @FindBy(xpath = "//*[@data-stid='apply-date-picker']")
    public WebElement dateOk;

    @FindBy(xpath = "//*[@data-stid='open-room-picker']")
    public WebElement visit;

    @FindBy(xpath = "//*[@aria-label='Oda 1 için çocuk sayısını artırın']")
    public WebElement childs;

    @FindBy(id = "traveler_selector_done_button")
    public WebElement visitOk;

    @FindBy(id = "search_button")
    public WebElement searchButton;


}
