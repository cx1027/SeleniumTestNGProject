package com.tanmaysarkar.demo.regression;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.openqa.selenium.By;

//comment the above line and uncomment below line to use Chrome
//import org.openqa.selenium.chrome.ChromeDriver;
public class FFtest {

	public static void main(String[] args) {
		// declaration and instantiation of objects/variables
		System.setProperty("webdriver.firefox.marionette", "C:\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();


		String baseUrl = "https://www.bnz.co.nz/registration/ib/app/flow/registerCreditCard?execution=e2s1";

		driver.get(baseUrl);

		
		//check title
		String actualTitle = driver.getTitle();

		Assert.assertTrue(driver.getTitle().contains("Internet Banking registration"));

		
		//Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Sample by - Tanmay Sarkar"));
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"login-header\"]/div/div/div[1]/h1")).getText().contains("Internet Banking registration"));
		Assert.assertTrue(driver.findElement(By.id("login")).getText().contains("Internet Banking registration"));
		Assert.assertTrue(driver.findElement(By.cssSelector("#login-header > div > div > div.inline-block.width-33pc > h1")).getText().contains("Internet Banking registration"));
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id='login-header']/div/div/div[1]/h1")).getText().contains("Internet Banking registration"));
		
		//get attributes: innerHTML
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id='login-header']/div/div/div[1]/h1")).getAttribute("innerHTML").contains("Internet Banking registration"));

        System.out.println("Test execution completed");

		// close Fire fox
		driver.close();

	}

}