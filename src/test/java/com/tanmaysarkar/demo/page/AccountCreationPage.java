package com.tanmaysarkar.demo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountCreationPage {
	
	private WebDriver driver;
	
	public AccountCreationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@CacheLookup
	@FindBy(linkText = "Home")
	WebElement HomeLink;
	
	public HomePage clickHome() {
		HomeLink.click();
		return PageFactory.initElements(driver, HomePage.class);}
}
