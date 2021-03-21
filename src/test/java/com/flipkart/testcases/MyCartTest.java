package com.flipkart.testcases;

import java.util.ArrayList;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.flipkart.base.TestBase;
import com.flipkart.pages.MyCartPage;

public class MyCartTest extends TestBase{

	MyCartPage myCartPage;
		
	public MyCartTest() {
		super();
	}
	
	@Test(priority=10)
	@Parameters({"pincode1","pincode2"})
	public void VerifyPincode() {
		
		myCartPage=new MyCartPage();
		myCartPage.enterPincode("pincode1");
		myCartPage.enterPincode("pincode2");
		
	}
	
	@AfterSuite
	public void tearDown(){
		driver.quit();
	}
}
