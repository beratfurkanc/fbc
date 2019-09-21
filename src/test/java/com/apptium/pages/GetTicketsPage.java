package com.apptium.pages;

import com.apptium.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GetTicketsPage {
    public GetTicketsPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//div[@class='hero-slide-buttons']//div//a")
    public WebElement getTicket;

    @FindBy(xpath = "//input[@placeholder='Search by City, Zip or Theatre']")
    public WebElement changeLocation;

    @FindBy(xpath = "//div[.='AMC Worldgate 9']")
    public WebElement selectWorldGate9;

    @FindBy(xpath = "//button[.='Save']")
    public WebElement saveButton;

}
