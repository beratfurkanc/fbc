package com.apptium.pages;

import com.apptium.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MovieTimesPage {

    public MovieTimesPage(){
        PageFactory.initElements(Driver.get(),this);
    }


    @FindBy(xpath = "(//select[@class='Showtimes-Action-Dropdown'])[2]")
    public WebElement selectDate;

    @FindBy(xpath = "(//section[@tabindex='0'])[1]")
    public WebElement timesRow1;

    @FindBy(xpath = "(//section[@tabindex='0'])[1]//div[@class='Showtime']")
    public List<WebElement> avaliableHoursRow1;

}
