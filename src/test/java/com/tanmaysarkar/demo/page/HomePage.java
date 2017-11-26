package com.tanmaysarkar.demo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.tanmaysarkar.demo.data.RegistrationData;

public class HomePage {
	
	private WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	@CacheLookup
	@FindBy(linkText = "Home")
	WebElement HomeLink;
	
	public HomePage clickHome() {
		HomeLink.click();
		return PageFactory.initElements(driver, HomePage.class);
	}
	
	@CacheLookup
	@FindBy(name = "userName")
	WebElement userName;
	
	@CacheLookup
	@FindBy(name = "password")
	WebElement password;
	
	@CacheLookup
	@FindBy(name = "login")
	WebElement login;
	
	public HomePage enterLoginname(String loginname) {
		userName.sendKeys(loginname);
		return this;
	}
	
	public HomePage enterLoginpsw(String psw) {
		password.sendKeys(psw);
		return this;
	}
	
	public AfterLogin clickLogin() {
		login.click();
		
		AfterLogin gg = new AfterLogin(driver);
		PageFactory.initElements(driver, gg);
		
		return PageFactory.initElements(driver, AfterLogin.class);
	}
	
	
	public AfterLogin login(RegistrationData logindata) {
		
		Reporter.log("email: " +logindata.getEmail()+"<br>");
		Reporter.log("password: " +logindata.getPassword()+"<br>");
		
		return enterLoginname(logindata.getEmail())
				.enterLoginpsw(logindata.getPassword())
				.clickLogin();
	}
}