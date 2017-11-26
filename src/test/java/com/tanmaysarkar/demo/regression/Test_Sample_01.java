package com.tanmaysarkar.demo.regression;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


import com.tanmaysarkar.common.BasePage;
import com.tanmaysarkar.common.SelTestCase;
import com.tanmaysarkar.demo.business.Sample_01;
import com.tanmaysarkar.demo.data.RegistrationData;
import com.tanmaysarkar.common.CustomVerification;

public class Test_Sample_01 extends SelTestCase {

	/**
	 * Test method execution disrupts when any assertion fails
	 */

	@Test(dataProvider = "regData", dataProviderClass = RegistrationData.class)
	public void newRegistration(RegistrationData registrationData) {
//		BasePage b = new BasePage();
//		WebDriver driver = b.getDriver();
		
		Sample_01 sample01 = PageFactory.initElements(driver, Sample_01.class);
		sample01.navigateToSample01();
		sample01.formFillUp(registrationData);
		sample01.submitData();
		//assert driver.findElement(By.tagName("body")).getText().contains("Sample by - Tanmay Sarkar");
        String actual_error =driver.findElement(By.tagName("body")).getText();
		//String actual_error =driver.findElement(By.tagName("body")).getAttribute(ïnnerHTML");
        
        
        
        
        Assert.assertTrue("not contain", actual_error.contains("Sample by - Tanmay Sarkar"));
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("Sample by - Tanmay Sarkar"));
		
		// driver.manage().window().maximize();
		// sample1.formFillUp("tanmay", "sarkar", "home");
		// driver.close();
	}

//	@Test(dataProvider = "regData", dataProviderClass = RegistrationData.class)
//	public void newRegistration1(RegistrationData registrationData) {
//		CustomVerification.begin();
//		NewRegistrationPage registration = PageFactory.initElements(driver, NewRegistrationPage.class);
//		AccountCreationPage createPage = registration.registerNewUser(registrationData);
//		assert driver.findElement(By.tagName("body")).getText().contains("Thank you for registering.");
//		HomePage returnhome = createPage.clickHome();// return home
//		// login
//		AfterLogin loginfromhome = returnhome.login(registrationData);
//		CustomVerification.end();
//	}
}
