package com.flipkart.testcases;

import org.testng.annotations.Test;

import com.flipkart.base.TestBase;
import com.flipkart.pages.AddToCartPage;
import com.flipkart.pages.MyCartPage;

public class AddToCartTest extends TestBase{

	AddToCartPage addToCartPage;
	MyCartPage myCartPage;
	
	public AddToCartTest() {
		super();
		
	}
	
	@Test(priority=9)
	public void VerifyAddToCart() {
		addToCartPage=new AddToCartPage();
		myCartPage=addToCartPage.clickOnAddToCart();
	}
	
}
