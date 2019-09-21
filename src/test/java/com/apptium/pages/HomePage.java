package com.apptium.pages;

import com.apptium.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//button[contains(text(), 'No Thanks')]")
    public WebElement noThanks;

    @FindBy(xpath = "//a[contains(text(), 'See A Movie')]")
    public WebElement seeAMovie;

    public void selectMovie(String movie){
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(seeAMovie).perform();
        Driver.get().findElement(By.xpath("//a[contains(text(),'"+movie+"')]")).click();
    }



}
