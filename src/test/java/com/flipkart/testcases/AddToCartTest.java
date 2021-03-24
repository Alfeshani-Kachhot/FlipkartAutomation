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
	public void verifyProductNameandPrice() {
		addToCartPage=new AddToCartPage();
		addToCartPage.PrintProductNameAndPrice();
	}
	@Test(priority=10)
	public void VerifyAddToCart() {
		
		myCartPage=addToCartPage.clickOnAddToCart();
	}
	
}
