package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Date;

public class Login {

    @Test(priority = 1)
    public void verifyLoginWithValidCredentials() {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4000));
        driver.findElement(By.xpath("//span[text()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("anitha.emmidi@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("An1pricha7477");
        driver.findElement(By.xpath("//input[@value='Login']")).click();


        Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed
                (), "Edit your account information is not displated");
        driver.quit();

    }

    @Test(priority = 2)
    public void verifyLoginWithInValidCredentials() {

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//span[text()='My Account']")).click();

        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("anith.emmidii" + generateTimeStamp() + "@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("An1");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible")).getText();
        String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password";
        Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected warning message is not displayed");
        driver.quit();

    }
    public void verifyLoginWithInvalidEmailAndValidPassword(){

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//span[text()='My Account']")).click();

        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("anitha.emmidi" + generateTimeStamp() + "@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("An1pricha7477");
        driver.findElement(By.xpath("//input[@value='Login']")).click();

        String actualWarningMessage = driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible")).getText();
        String expectedWarningMessage = "Warning: No match for E-Mail Address and/or Password";
        Assert.assertTrue(actualWarningMessage.contains(expectedWarningMessage), "Expected warning message is not displayed");
        driver.quit();


    }


    public String generateTimeStamp() {
        Date date = new Date();
        return date.toString().replace(" ", "_").replace(":", "_");
    }
}


