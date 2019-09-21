package com.apptium.testng_data_provider;

import com.apptium.pages.MovieTimesPage;
import com.apptium.utilities.Driver;
import com.apptium.utilities.ExelUtil;
import com.apptium.utilities.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestNG_DataProvider extends TestBase {


    @Test(dataProvider = "getData")
    public void amcTest(String movie, String zipCode, String days) throws InterruptedException {
        HashMap<String, List<String>> avaliableTimes = new HashMap<>();
        JavascriptExecutor jse = (JavascriptExecutor)(Driver.get());
        System.out.println("movie "+movie+" days "+days+ " zipcode "+zipCode);
        pages.homePage().noThanks.click();
        pages.homePage().selectMovie(movie.trim());
        pages.getTicketsPage().getTicket.click();
        Thread.sleep(2000);
        if(Driver.get().getTitle().equals("Movie Times at AMC Theatres")){
            //return;
        }else{
            pages.getTicketsPage().changeLocation.sendKeys(""+zipCode.substring(0,5)+ Keys.ENTER);
            pages.getTicketsPage().selectWorldGate9.click();
            pages.getTicketsPage().saveButton.click();
        }
        System.out.println("bu ne lan-->"+Integer.parseInt(days.substring(0,1)));
        for(int i=0; i<Integer.parseInt(days.substring(0,1)); i++){
            MovieTimesPage movieTimesPage = new MovieTimesPage();
            Select select = new Select(movieTimesPage.selectDate);
            select.getOptions().get(i).click();
            List<String> availableHours = new ArrayList<>();
            jse.executeScript("arguments[0].scrollIntoView();", pages.movieTimesPage().timesRow1);
            for(WebElement element : movieTimesPage.avaliableHoursRow1){
                availableHours.add(element.getText());
            }
            avaliableTimes.put(select.getOptions().get(i).getText(),availableHours);
        }
        for(String str : avaliableTimes.keySet()){
            System.out.println(str+"--->"+avaliableTimes.get(str));
        }
    }


    @DataProvider
    public Object[][] getData(){
        ExelUtil exelUtil = new ExelUtil("C:/Users/ibrah/Desktop/projects/amc/src/test/resources/Movies.xlsx","movies");
        return ((Object[][]) exelUtil.getDataArray());
    }
}
