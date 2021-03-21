package com.flipkart.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.flipkart.base.TestBase;
import com.flipkart.pages.FlipkartHomePage;
import com.flipkart.pages.GoogleHomePage;

public class GoogleSearchTest extends TestBase {
	
	GoogleHomePage googleHome;
	FlipkartHomePage flipkartHomepage;
	
	public GoogleSearchTest() {
		super();
	}
	
	@BeforeSuite
	public void setup() {
		initialization();
		googleHome=new GoogleHomePage();
	}
	
	@Test(priority=1)
	public void VerifyGoogleSearch() {
		boolean flag=googleHome.ValidateGoogleSearch();
		Assert.assertTrue(flag,"Google URL Not opened");
	}
	
	@Test(priority=2)
	public void searchFlipkart() {
		
		googleHome.searchFlipkart("flipkart");
	}
	
	@Test(priority=3)
	public void PrintSearchOptionsAndSubmitSearch() {
		googleHome.printAutoSuggestionList();
	}
	@Test(priority=4)
	public void verifyTitleAfterFlipkartSearch() {
		String title=googleHome.validateFlipkartSearchTitle();
		Assert.assertEquals(title, "flipkart - Google Search","flipkart google search not performed");
	}
	
	@Test(priority=5)
	public void clickOnFlipkartLink() {
		flipkartHomepage= googleHome.clickOnFlipkartLink();
		
	}
	
}
