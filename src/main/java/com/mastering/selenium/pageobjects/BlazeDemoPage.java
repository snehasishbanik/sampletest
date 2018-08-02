package com.mastering.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


/*Created by Snehasish on 01-Aug-18*/

public class BlazeDemoPage {

    private WebDriver driver;
    WebDriverWait wait=new WebDriverWait(driver,10);

    private static String baseURL;

    private WebElement departureCity;
    private WebElement destinationCity;
    private WebElement findFlights;

    public BlazeDemoPage(WebDriver driver){
        this.driver=driver;
        baseURL="http://blazedemo.com/";
        driver.get(baseURL);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'Welcome to the Simple Travel Agency!')]")));

        System.out.println(driver.getTitle());
        if (!driver.getTitle().equals("BlazeDemo")) {
            throw new WrongPageException("Incorrect page for Blaze Demo");
        }
    }

    public BlazeDemoReserve goToBlazeDemoReserve(){
        departureCity=driver.findElement(By.name("fromPort"));
        departureCity.click();

        destinationCity=driver.findElement(By.name("toPort"));
        destinationCity.click();

        findFlights=driver.findElement(By.xpath("//input[@value='Find Flights']"));
        findFlights.click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[contains(text(),'Flights from')]")));

        return new BlazeDemoReserve(driver);
    }

}
