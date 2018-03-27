package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.testbase.TestBase;

public class LoginPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	public LoginPageTest() {
		super();
	}
	
	
	@BeforeTest
	public void Setup() {
		intialization();
		loginpage = new LoginPage();
		
	}
	
	
	@Test
	public void LoginCrmTest() throws InterruptedException {
		homepage = loginpage.LoginCrm(prop.getProperty("username"),prop.getProperty("password") );
		System.out.println(homepage.toString());
		Assert.assertEquals(homepage.toString(),new HomePage().toString());
		System.out.println(new HomePage().toString());
	
	}
	
	@AfterMethod
	public void CloseBrowser() {
	driver.quit();
	}
}
