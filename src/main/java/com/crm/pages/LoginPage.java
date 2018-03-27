package com.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.interactions.Action;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.testbase.TestBase;

public class LoginPage extends TestBase{

	//Page Factory ===OR
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@type ='submit']")
	WebElement LgnButton;
	
	@FindBy(xpath ="//button[contains(text(),'Sign Up')]")
	WebElement SignupBtn;
	
	@FindBy(xpath="//div[contains(@class,'intercom-chat-card-author')]")
	WebElement mousehover;
	
	@FindBy(xpath="//div[contains(@class,'intercom-borderless-dismiss-button')]//span")
	WebElement closepopup;
	//Initialization of Webelements to the driver using PageFactory
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
				
	}
	//Actions://
	public HomePage LoginCrm(String uname,String pwd) throws InterruptedException {
		
		username.sendKeys(uname);
		password.sendKeys(pwd);
		
		Thread.sleep(10000);
		driver.switchTo().frame("intercom-borderless-frame");
		
		Actions action = new Actions(driver);
		/*action.moveToElement(driver.findElement(By.xpath("//div[contains(@class,'intercom-chat-card-author')]"))).build().perform();
		
		driver.findElement(By.xpath("//div[contains(@class,'intercom-borderless-dismiss-button')]//span")).click();*/
		
		
		action.moveToElement(mousehover).build().perform();
		closepopup.click();

		LgnButton.click();
		
		return new HomePage();
		
	}
	
}
