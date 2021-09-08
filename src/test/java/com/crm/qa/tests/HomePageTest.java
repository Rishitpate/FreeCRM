package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest() {
		super();
	}
	
	//testcases should be seperated -- independent with each other
	//before each test cases -- launch the browser and login
	//@test -- execute test cases
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage= new LoginPage();
		testUtil = new TestUtil();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomepageTitleTest() {
		String HomePageTitle = homepage.verifyHomepageTitle();
		Assert.assertEquals(HomePageTitle, "CRMPRO", "HomePageTitle not matched");
	}
	
	@Test (priority=2)
	public void verifyUsernameTest() {
		testUtil.switchToFrame();
		Assert.assertTrue(homepage.verifycorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest() {
		testUtil.switchToFrame();
		contactsPage = homepage.clickonContactsLink();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
