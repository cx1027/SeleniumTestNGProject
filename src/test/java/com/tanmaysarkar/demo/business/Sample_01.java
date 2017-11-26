package com.tanmaysarkar.demo.business;

import org.openqa.selenium.WebDriver;

import com.tanmaysarkar.common.Url;
import com.tanmaysarkar.demo.data.RegistrationData;
import com.tanmaysarkar.demo.page.Sample_01_;

public class Sample_01 extends Sample_01_{

	public Sample_01(WebDriver driver) {
		super(driver);		
	}
	
	//fill form
	public void formFillUp(String fname,String lname,String address){
		Sample_01_ sample01 = new Sample_01_(driver);
		sample01.enterFirstName(fname);
		sample01.enterLastName(lname);
		sample01.enterAddress(address);
//		getFName().clear();
//		getFName().sendKeys(fname);
//		getLName().clear();
//		getLName().sendKeys(lname);
//		getAddress().clear();
//		getAddress().sendKeys(address);		
	}
	
	
	public void formFillUp(RegistrationData registrationData){
		Sample_01_ sample01 = new Sample_01_(driver);
		sample01.enterFirstName(registrationData.getFirstName());
		sample01.enterLastName(registrationData.getLastName());
		sample01.enterAddress(registrationData.getAddress());
//		getFName().clear();
//		getFName().sendKeys(fname);
//		getLName().clear();
//		getLName().sendKeys(lname);
//		getAddress().clear();
//		getAddress().sendKeys(address);		
	}
	
	
	
    public void navigateToSample01() {
        String url = Url.BASEURL.getURL() + Url.SAMPLE01.getURL();
        System.out.println("Navigating to sample_01: " + url);
        navigateToURL(url);
    }

    
    public void submitData(){
    	Sample_01_ sample01 = new Sample_01_(driver);
		sample01.clickSubmit();
    }
    

}
