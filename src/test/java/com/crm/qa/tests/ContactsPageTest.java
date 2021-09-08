package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import com.crm.qa.util.Xls_Reader;

public class ContactsPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage= new LoginPage();
		testUtil = new TestUtil();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		contactsPage = homepage.clickonContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabelTest() {
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page.");
	}
	
	@Test(priority=2)
	public void selectSingleContactsTest() {
		contactsPage.SelectContacts(52825660);
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest() {
		contactsPage.SelectContacts(52825660);
		contactsPage.SelectContacts(52825661);
	}
	
	@DataProvider
	public Object[][] getTestData(){
		Object[][] data = new Object[3][4];
		Xls_Reader d = new Xls_Reader(TestUtil.testdatapath);
		
		for(int i =2;i<=d.getRowCount("Contacts");i++) {
			for(int j=0;j<=(d.getColumnCount("Contacts")-1);j++) {
				data[i-2][j]=d.getCellData("Contacts", j, i);
			}
		}
		return data;
	}
	
	@Test(priority = 4, dataProvider = "getTestData" )
	public void validateCreateNewContactTest(String title, String firstname, String lastname, String company) throws InterruptedException {
		homepage.ClickonNewContactLink();
		contactsPage.CreatenewContact(title, firstname, lastname, company);
		}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}


