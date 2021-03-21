package com.flipkart.testcases;

import java.awt.AWTException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.flipkart.base.TestBase;
import com.flipkart.pages.AddToCartPage;
import com.flipkart.pages.FlipkartHomePage;

public class FlipkartTest extends TestBase{

	FlipkartHomePage flipkartHomepage;
	AddToCartPage addToCartPage;
	
	public FlipkartTest() {
		// TODO Auto-generated constructor stub
		super();
		
	}
	
	@Test(priority=6)
	public void CloseLoginPopup() throws AWTException {
		flipkartHomepage=new FlipkartHomePage();
		flipkartHomepage.closeLoginPopup();
	}
	
	@Test(priority=7)
	public void goToWindowsAc() {
		flipkartHomepage.clickOnWindowsAc();
		
	}
	
	@Test(priority=8)
	public void CompareSelectedItem() {
		addToCartPage=flipkartHomepage.addToCompare();
	}
	
	
}
