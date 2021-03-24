package com.flipkart.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.flipkart.base.TestBase;

public class CommonMethods extends TestBase {

	
	Actions actions = new Actions(driver);
	
	public void moveToElement(WebElement webElement) {
		
		actions.moveToElement(webElement).perform();;
		
	}
	
	public void printProductNameAndPrice(List<WebElement> productName,List<WebElement> productPrice) {
		
		for(int i=0;i<productName.size();i++) {
			System.out.println("Product Name:");
		}
	}
	
	public int getIndex(List<WebElement> DeliveryMsg,String productcode) {
		int index=0;
		for (int i=0;i<DeliveryMsg.size();i++) {
			if(driver.findElement(By.xpath("//div[@class='_1AtVbE col-12-12']//div[@class='_2pqhhf']//ancestor::div//div[@class='_20RCA6']")).getText()==productcode) {
				index=i+1;
				break;
			}
		}
		return index;
	}
}
