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
	
	@Test(priority=11)
	public void VerifyPincode() throws InterruptedException {
		
		myCartPage=new MyCartPage();
		myCartPage.enterPincode("380055");
		myCartPage.enterPincode("380051");
		
	}
	
	@AfterSuite
	public void tearDown(){
		driver.quit();
	}
}
