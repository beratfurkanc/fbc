package com.apptium.utilities;

import com.apptium.pages.GetTicketsPage;
import com.apptium.pages.HomePage;
import com.apptium.pages.MovieTimesPage;

public class Pages {
    private GetTicketsPage getTicketsPage;
    private HomePage homePage;
    private MovieTimesPage movieTimesPage;

    public HomePage homePage(){
        if(homePage == null){
            homePage = new HomePage();
        }
        return homePage;
    }

    public GetTicketsPage getTicketsPage() {
        if (getTicketsPage == null) {
            getTicketsPage = new GetTicketsPage();
        }
        return getTicketsPage;
    }

    public MovieTimesPage movieTimesPage(){
        if(movieTimesPage == null){
            movieTimesPage = new MovieTimesPage();
        }
        return movieTimesPage;
    }

}
