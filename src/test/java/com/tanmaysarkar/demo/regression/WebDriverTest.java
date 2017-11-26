package com.tanmaysarkar.demo.regression;

import java.io.IOException;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.tanmaysarkar.common.CustomVerification;
import com.tanmaysarkar.common.SelTestCase;
import com.tanmaysarkar.common.Url;
import com.tanmaysarkar.demo.data.RegistrationData;
import com.tanmaysarkar.demo.page.AccountCreationPage;
import com.tanmaysarkar.demo.page.AfterLogin;
import com.tanmaysarkar.demo.page.HomePage;
import com.tanmaysarkar.demo.page.NewRegistrationPage;

public class WebDriverTest extends SelTestCase {

	/**
	 * Test method execution disrupts when any assertion fails
	 */
	@Test
	public void hardAssertion() {
		driver.get(appURL);
		Assert.assertTrue("first name field is missing", driver.findElements(By.name("firstName")).size() == 1);

		// Deliberate test failure
		Assert.assertTrue("last name field is missing", driver.findElements(By.name("wrongLastName")).size() == 0);
		Assert.assertTrue("Phone number field is missing",
				driver.findElements(By.name("wrongPhoneNumber")).size() == 0);

		Assert.assertTrue("user Name field is missing", driver.findElements(By.name("userName")).size() == 1);
	}

	/**
	 * Test method execution continues even if any assertion fails
	 */
	@Test
	public void softAssertion() {
		driver.get(appURL);
		CustomVerification customVerification = new CustomVerification();
		customVerification.verifyTrue("first name field is missing",
				driver.findElements(By.name("firstName")).size() == 1);

		// Deliberate test failure but yet test execution continues
		customVerification.verifyTrue("last name field is missing",
				driver.findElements(By.name("wrongLastName")).size() == 1);
		customVerification.verifyTrue("Phone number field is missing",
				driver.findElements(By.name("wrongPhoneNumber")).size() == 1);

		customVerification.verifyTrue("email address field is missing",
				driver.findElements(By.name("userName")).size() == 1);
		// customVerification.checkForVerificationErrors();
	}

	@Test(dataProvider = "regData", dataProviderClass = RegistrationData.class)
	public void newRegistration(RegistrationData registrationData) {
		driver.get(appURL);
		NewRegistrationPage registration = PageFactory.initElements(driver, NewRegistrationPage.class);
		AccountCreationPage createPage = registration.registerNewUser(registrationData);
		
		
		
		assert driver.findElement(By.tagName("body")).getText().contains("Thank you for registering.");
		Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
		
		
		HomePage returnhome = createPage.clickHome();// return home
		// login
		AfterLogin loginfromhome = returnhome.login(registrationData);
	}

	@Test(dataProvider = "loginData2", dataProviderClass = RegistrationData.class)
	public void testlogin(RegistrationData registrationData) {
		String url = Url.BASEURL.getURL() + Url.SAMPLE01.getURL();
		this.setUrl("http://newtours.demoaut.com/mercurywelcome.php");
		driver.get(appURL);
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		AfterLogin loginfromhome = home.login(registrationData);
	}

	@Test(dataProvider = "loginData2", dataProviderClass = RegistrationData.class)
	public void testlogin2(RegistrationData registrationData) {
		this.setUrl("http://newtours.demoaut.com/mercurywelcome.php");
		driver.get(appURL);
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		AfterLogin afterLoginPage = home.login(registrationData);
	}

	@Test(dataProvider = "loginData", dataProviderClass = RegistrationData.class)
	public void testlogin(String userName, String password) {
		this.setUrl("http://newtours.demoaut.com/mercurywelcome.php");
		driver.get(appURL);
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		try {
			RegistrationData regData = new RegistrationData();
			regData.setUserName(userName);
			regData.setEmail(userName);
			regData.setPassword(password);
			AfterLogin afterLoginPage = homePage.login(regData);
		} catch (Exception ex) {
		}
	}

	//
	/**
	 * Data driven testing using csv file
	 * 
	 * @param registrationData
	 */
	@Test(dataProvider = "regCSVData", dataProviderClass = RegistrationData.class)
	public void newRegistrationUsingCSVFile(RegistrationData registrationData) {
		driver.get(appURL);
		NewRegistrationPage registration = PageFactory.initElements(driver, NewRegistrationPage.class);
		registration.registerNewUser(registrationData); 
		assert driver.findElement(By.tagName("body")).getText().contains("Thank you for registering. ");
	}
}
