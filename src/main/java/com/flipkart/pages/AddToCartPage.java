package com.flipkart.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.base.TestBase;
import com.flipkart.util.CommonMethods;

public class AddToCartPage extends TestBase{

	CommonMethods commonMethod=new CommonMethods();
	
	@FindBy(xpath="//div[@id='fk-compare-page']//div[@class='row']//div[contains(@class,'col')]//button")
	List<WebElement> AddToCartXPath;
	
	@FindBy(xpath="//div[text()='Unable to add to Cart. Please try in a few minutes.']")
	List<WebElement> UnableToAddCart;
	
	@FindBy(xpath="//div[text()='My Cart (3)']")
	List<WebElement> MyCart;
	
	@FindBy(xpath="//div[contains(@class,'_1Z-FPJ')]//a[contains(@class,'_3L_M2k')]")
	List<WebElement> ProductName;
	
	@FindBy(xpath="//div[contains(@class,'_1Z-FPJ')]//div[@class='_30jeq3']")
	List<WebElement> ProductPrice;
	
	public AddToCartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void PrintProductNameAndPrice() {
		for(int i=0;i<ProductName.size();i++) {
			
			System.out.println("Product Name: "+driver.findElement(By.xpath("//div[contains(@class,'_1Z-FPJ')]["+(i+1)+"]//a[contains(@class,'_3L_M2k')]")).getText());
			System.out.println("Product Price: "+driver.findElement(By.xpath("//div[contains(@class,'_1Z-FPJ')]["+(i+1)+"]//div[@class='_30jeq3']")).getText());
		}
	}
	
	public MyCartPage clickOnAddToCart() {
		
		for(int j=0;j<AddToCartXPath.size();j++) {
	    	
			
    		String AddCartXPath="//div[@id='fk-compare-page']//div[@class='row']//div[contains(@class,'col')]["+(j+2)+"]//button[text()='ADD TO CART']";
    		
    		WebElement AddToCart = driver.findElement(By.xpath(AddCartXPath));
    		commonMethod.moveToElement(AddToCart);
    	    driver.findElement(By.xpath(AddCartXPath)).click();
    	    
    	    if(UnableToAddCart.size()!=0) {
    	    	System.out.println("System is not able to perform ADD TO CART operation due to some issue");
    	    	driver.quit();
    	    }
    	    
    	    WebElement placeorder = (new WebDriverWait(driver, 10))
  	             .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Place Order']")));
    	    
    	    	if(MyCart.size()>0) {
    	    		System.out.println("All selected 3 items are added successfully into CART");
    	    		break;
    	    	
    	    }
    	    driver.navigate().back();
    	    
    	    
    	}
		return new MyCartPage();
	}
}
