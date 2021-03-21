package com.flipkart.pages;

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
	
	@FindBy(xpath="//div[@class='_12cXX4']")
	WebElement Pincode;
	
	public MyCartPage() {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	public void enterPincode(String pincode) {
		
		if(ClickOnDeliveryToDropdown.size()>0) {
			driver.findElement(By.xpath("//span[text()='Deliver to']//parent::div//following-sibling::div//img")).click();
		}
		InputPincode.clear();
		InputPincode.sendKeys(pincode);
		CheckButton.click();
		
		WebElement deliverypincode = (new WebDriverWait(driver, 15))
	              .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(),"+pincode+")]")));
		
		this.printDeliveryMsg();
		
	}
	public void printDeliveryMsg() {
		
		for(int i=0;i<DeliveryMsg.size();i++) {
		
			WebElement MoveToDeliveryMsg = driver.findElement(By.xpath("//div[@class='_1AtVbE col-12-12']["+(i+1)+"]//div[@class='_2pqhhf']"));
			commonMethod.moveToElement(MoveToDeliveryMsg);
	    
			WebElement msg=driver.findElement(By.xpath("//div[@class='_1AtVbE col-12-12']["+(i+1)+"]//div[@class='_2pqhhf']"));	
			
			WebElement PName=driver.findElement(By.xpath("//div[@class='_1AtVbE col-12-12']["+(i+1)+"]//div[@class='_3fSRat']//a"));
			String Name=PName.getText().toString();
	
			String pin=Pincode.getText().toString();
			
			System.out.println("product "+Name+" is available for "+pin+" pincode: "+msg.getText().toString());
		
		}
	}
	
}
