package com.flipkart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.base.TestBase;
import com.flipkart.util.CommonMethods;

public class MyCartPage extends TestBase{
	
	CommonMethods commonMethod=new CommonMethods();
	
	@FindBy(xpath="//input[@placeholder='Enter delivery pincode']")
	WebElement InputPincode;
	
	@FindBy(xpath="//span[text()='Check']")
	WebElement CheckButton;
	
	@FindBy(xpath="//span[text()='Deliver to']//parent::div//following-sibling::div//img")
	List<WebElement> ClickOnDeliveryToDropdown;
	
	@FindBy(xpath="//div[@class='_1AtVbE col-12-12']//div[@class='_2pqhhf']")
	List<WebElement> DeliveryMsg;
	
	@FindBy(xpath="//div[@class='_1AtVbE col-12-12']//div[@class='_1tBBEs']")
	List<WebElement> StockNotAvailable;
	
	@FindBy(xpath="//div[@class='_2pqhhf']")
	List<WebElement> productcodelist;
	
	@FindBy(xpath="//div[@class='_2pqhhf']//ancestor::div//div[@class='_2-uG6-']//a")
	List<WebElement> ProductName;
	
	public MyCartPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	public void enterPincode(String pincode) throws InterruptedException {
		
		if(ClickOnDeliveryToDropdown.size()>0) {
			driver.findElement(By.xpath("//span[text()='Deliver to']//parent::div//following-sibling::div//img")).click();
		}
		InputPincode.clear();
		InputPincode.sendKeys(pincode);
		CheckButton.click();
		
		WebElement deliverypincode = (new WebDriverWait(driver, 60))
	              .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),"+pincode+")]")));
		
		this.printDeliveryMsg();
		
	}
	public void printDeliveryMsg() {
		
		
		List<String> productcode = new ArrayList<>();
		List<String> productname= new ArrayList<>();
		
		
		for (WebElement match : productcodelist) {
			productcode.add(match.getText());
	    }
		for(WebElement pname: ProductName) {
			productname.add(pname.getText());
		}
		
		WebElement EnteredPincode=driver.findElement(By.xpath("//div[@class='_12cXX4']//span"));
		String pin=EnteredPincode.getText().toString();
		
		System.out.println("Printing delivery msg for pincode: "+pin);
		System.out.println("======================Start==================");
		
		for(int i=0;i<productcode.size();i++) {
			
			System.out.println(productcode.get(i)+" for product name: "+productname.get(i));
		}
		if(StockNotAvailable.size()>0) {
		for(int i=0;i<StockNotAvailable.size();i++) {
			System.out.println(driver.findElement(By.xpath("//div[@class='_1AtVbE col-12-12']//div[@class='_1tBBEs']")).getText());
			
		}}
		System.out.println("====================end=======================");
		
		
		
	}
	
}
