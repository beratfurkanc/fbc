package com.apptium.testng_data_provider;

import com.apptium.pages.MovieTimesPage;
import com.apptium.utilities.Driver;
import com.apptium.utilities.ExelUtil;
import com.apptium.utilities.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestNG_DataProvider extends TestBase {

    @Test(dataProvider = "getData")
    public void amcTest(String movie, String zipCode, String days) throws InterruptedException {
        HashMap<String, List<String>> avaliableTimes = new HashMap<>();
        JavascriptExecutor jse = (JavascriptExecutor)(Driver.get());

        pages.homePage().noThanks.click();
        pages.homePage().selectMovie(movie.trim());
        pages.getTicketsPage().getTicket.click();

        boolean location = false;
        WebDriverWait wait = new WebDriverWait(driver,2);
        try {
            wait.until(ExpectedConditions.titleIs("Movie Times at AMC Theatres"));
        }catch (Exception e){
            location = true;
        }
        if (location){
            pages.getTicketsPage().changeLocation.sendKeys(zipCode.substring(0,zipCode.indexOf('.'))+ Keys.ENTER);
            pages.getTicketsPage().selectWorldGate9.click();
            pages.getTicketsPage().saveButton.click();
        }

        for(int i=0; i<Integer.parseInt(days.substring(0,days.indexOf('.'))); i++){
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
        writeToFile("movie.txt",avaliableTimes.toString());
//        for(String str : avaliableTimes.keySet()){
//            System.out.println(movie+"-->"+str+"--->"+avaliableTimes.get(str));
//
//        }
    }


    @DataProvider
    public Object[][] getData(){
        ExelUtil exelUtil = new ExelUtil("src/main/resources/Movies.xlsx","movies");
        return ((Object[][]) exelUtil.getDataArray());
    }

    public static void writeToFile(String file, String line){
        try {
            PrintWriter writer = new PrintWriter(file);
            writer.println(line);
            writer.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
