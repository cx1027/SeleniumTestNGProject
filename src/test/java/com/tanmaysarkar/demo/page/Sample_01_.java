package com.tanmaysarkar.demo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tanmaysarkar.common.BasePage;

public class Sample_01_ extends BasePage {
	//Define driver
	public WebDriver driver;

	//locate webelement
//	public By fname = By.id("ts_first_name");
//
//	public By lname = By.id("ts_last_name");
//
//	public By address = By.id("ts_address");
	
	
	@CacheLookup
	@FindBy(how=How.ID,using="userName")
	WebElement USER_NAME;
	
	@CacheLookup
	@FindBy(id = "ts_first_name")
	WebElement ts_first_name;
	
	@CacheLookup
	@FindBy(id = "ts_last_name")
	WebElement ts_last_name;
	
	@CacheLookup
	@FindBy(id = "ts_address")
	WebElement ts_address;
	
	@CacheLookup
	@FindBy(name = "Submit1")
	WebElement button_submit;

	
	

	//initiate driver
	public Sample_01_(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); //add this
	}

	
	//action to webelement
//	public WebElement getFName() {
//		return driver.findElement(fname);
//	}
//
//	public WebElement getLName() {
//		return driver.findElement(lname);
//	}
//
//	public WebElement getAddress() {
//		return driver.findElement(address);
//	}
	
	
	public Sample_01_ enterFirstName(String strFirstName) {
//		ts_first_name.sendKeys(strFirstName);
		sendKeys(ts_first_name, strFirstName);
		return this;
	}
	
	public Sample_01_ enterLastName(String strLastName) {
		sendKeys(ts_last_name, strLastName);
		return this;
	}
	
	public Sample_01_ enterAddress(String strAdress) {
		sendKeys(ts_address, strAdress);
		return this;
	}
	
	public Sample_01_ clickSubmit() {
		click(button_submit);
		return this;
	}
}
