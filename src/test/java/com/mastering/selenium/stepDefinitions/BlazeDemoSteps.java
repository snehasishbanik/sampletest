package com.mastering.selenium.stepDefinitions;

import com.mastering.selenium.pageobjects.BlazeDemoPage;
import com.mastering.selenium.pageobjects.BlazeDemoReserve;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;



/*Created by Snehasish on 02-Aug-18*/

public class BlazeDemoSteps {

    private WebDriver driver;
    public BlazeDemoPage blazeDemoPage;
    public BlazeDemoReserve blazeDemoReserve;

    @Given("^I open BlazeDemo UI$")
    public void i_open_BlazeDemo_UI() throws Throwable{
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        blazeDemoPage = new BlazeDemoPage(driver);
    }

    @When("^I choose from Philadelphia to Rome$")
    public void i_choose_Philadelphia_to_Rome(){
        blazeDemoReserve = blazeDemoPage.goToBlazeDemoReserve();
    }

    @Then("^It should take me to the flight price page$")
    public void it_should_show_flight_price(){
        assertEquals(blazeDemoReserve.actualResult(),(blazeDemoReserve.expectedResult()));
    }
}
