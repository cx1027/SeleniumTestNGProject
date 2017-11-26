package com.tanmaysarkar.common;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.tanmaysarkar.common.Url;

public class SelTestCase {

	protected WebDriver driver;
	protected String appURL;

	// String url = Url.BASEURL.getURL() + Url.SAMPLE01.getURL();

	// @BeforeSuite
	// @Parameters("appURL")
	// public void setUrl(String appURL) {
	// this.appURL = appURL;
	// }

	@BeforeClass
	public void setUp() {
		driver = DriverUtils.getDriver();

	}
	//
	// @BeforeMethod()
	// @Parameters("browser")
	// public void launchBrowser(@Optional("Chrome") String browser) throws
	// MalformedURLException {
	// Reporter.log("beforemethord!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!#@#######################################");
	// if (browser.equalsIgnoreCase("Chrome")) {
	// System.setProperty("webdriver.chrome.driver",
	// "F:/selenium/libs/chromedriver.exe");
	// driver = new ChromeDriver();
	// } else if (browser.equalsIgnoreCase("FF")) {
	// //driver = new FirefoxDriver();
	// DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	// capabilities.setPlatform(Platform.LINUX);
	// driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),
	// capabilities);
	// } else {
	// driver = new InternetExplorerDriver();
	// }
	// }

	@AfterMethod
	public void closeBrowser(ITestResult result) throws IOException {
		if (!result.isSuccess()) {
			File imageFile = ((TakesScreenshot) new Augmenter().augment(driver)).getScreenshotAs(OutputType.FILE);
			String failureImageFileName = result.getMethod().getMethodName()
					+ new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime()) + ".png";
			File failureImageFile = new File(failureImageFileName);
			FileUtils.moveFile(imageFile, failureImageFile);
		}
		driver.close();
	}

	@AfterClass
	public void quitBrowser() throws IOException {
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println("Quit error:" + e.toString());
		}
	}
}