package com.apptium.step_def;

import com.apptium.pages.MovieTimesPage;
import com.apptium.utilities.Driver;
import com.apptium.utilities.Pages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Amc_Step_Def {
    Pages pages = new Pages();
    HashMap<String, List<String>> avaliableTimes = new HashMap<>();
    JavascriptExecutor jse = (JavascriptExecutor)(Driver.get());

    @Given("User is on home page")
    public void user_is_on_home_page() {
        pages.homePage().noThanks.click();
    }

    @When("User select a {string}")
    public void user_select_a(String movie) {
        pages.homePage().selectMovie(movie);
    }

    @Then("User click get tickets for the movie")
    public void user_click_get_tickets_for_the_movie() throws InterruptedException {
        pages.getTicketsPage().getTicket.click();
        Thread.sleep(2000);
    }

    @Then("User change the location with {string}")
    public void user_change_the_location_with(String zipCode) {
        if(Driver.get().getTitle().equals("Movie Times at AMC Theatres")){
            return;
        }else{
            pages.getTicketsPage().changeLocation.sendKeys(""+zipCode+ Keys.ENTER);
            pages.getTicketsPage().selectWorldGate9.click();
            pages.getTicketsPage().saveButton.click();
        }
    }

    @Then("User search for available {string}")
    public void user_search_for_available(String days) {
        for(int i=0; i<Integer.parseInt(days); i++){
            MovieTimesPage movieTimesPage = new MovieTimesPage();
            Select select = new Select(movieTimesPage.selectDate);
            select.getOptions().get(i).click();
            List<String> availableHours = new ArrayList<>();
            jse.executeScript("arguments[0].scrollIntoView();", movieTimesPage.timesRow1);
            for(WebElement element : movieTimesPage.avaliableHoursRow1){
                availableHours.add(element.getText());
            }
            avaliableTimes.put(select.getOptions().get(i).getText(),availableHours);
        }
        for(String str : avaliableTimes.keySet()){
            System.out.println(str+"--->"+avaliableTimes.get(str));
        }
        }
    }

