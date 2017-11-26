/*
https://www.youtube.com/watch?v=p5LtbF9KCqg
  
Test Scripts Improvement:
ProperComment
1. Author information
2. Proper Comments for funcitons 
3. Naming convention for class and function

Tests/Keyword/Data  should be independent on the application to resistant to changes in the UI
1. Page Factory Model
2. Test Flow
3. Data Object
4. Tool Class

Robust:
1. Regular expression
2. Exception control
   统一异常类 UtilCom in Amazon
   多重try catch
3. Screenshot if failed
   http://www.cnblogs.com/zhangfei/p/4271923.html
4. Report log
5. assertion class
6. listener


efficiency:
1. Run parallel
2. emun class：URL？

 */

package com.tanmaysarkar.demo.regression;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.tanmaysarkar.common.BasePage;
import com.tanmaysarkar.demo.business.Sample_01;

public class MyTest {

	@Test
	public void test01() {
		BasePage b = new BasePage();
		WebDriver driver = b.getDriver();
		Sample_01 sample1 = PageFactory.initElements(driver, Sample_01.class);
		String url = "http://demo.tanmaysarkar.com/sample_01.html";
		driver.get(url);
		driver.manage().window().maximize();
		sample1.formFillUp("tanmay", "sarkar", "home");
		driver.close();

	}
}
