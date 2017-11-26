package com.tanmaysarkar.demo.regression;


import base.LoadProperties;
import enums.Products;
import org.openqa.selenium.WebDriver;
import actions.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ShoppingCartReviewPage;
import pojo.Book;
import utils.DriverUtils;

public class LoginPageTest {

    private HtmlUnitDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException, UnknownHostException{
        driver = new HtmlUnitDriver(true);
        driver.get(System.getProperty("login.url"));
    }

    @Test
    public void testAuthenticationFailureWhenProvidingBadCredentials(){
    	System.out.println("Login Successfully");
        driver.findElement(By.id("username")).sendKeys("fakeuser");
        driver.findElement(By.id("password")).sendKeys("fakepassword");
        driver.findElement(By.id("login")).click();

        assertTrue(driver.getCurrentUrl().endsWith("failed"));
    }

    @Test
    public void testAuthenticationSuccessWhenProvidingCorrectCredentials(){
        driver.findElement(By.id("username")).sendKeys("validuser");
        driver.findElement(By.id("password")).sendKeys("validpassword");
        driver.findElement(By.id("login")).click();

        assertTrue(driver.getCurrentUrl().endsWith("/<name_of_webapp>/"));
    }

}
