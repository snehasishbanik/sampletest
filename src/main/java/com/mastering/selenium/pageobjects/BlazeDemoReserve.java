package com.mastering.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static javax.xml.bind.DatatypeConverter.parseString;

public class BlazeDemoReserve {

    private WebDriver driver;
    public String priceField;

    public BlazeDemoReserve(WebDriver driver){
        this.driver=driver;
        System.out.println(driver.getTitle());
        if (!driver.getTitle().equals("BlazeDemo - reserve")){
            throw new WrongPageException("Incorrect page for BlazeDemo-Reserve page");
        }

    }

    public String actualResult(){
        priceField = driver.findElement(By.xpath("//th[contains(text(),'Price')]")).getText();
        return priceField;
    }

    public String expectedResult(){
        return "Price";
    }

}
