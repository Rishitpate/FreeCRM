package com.crm.qa.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath ="//td[contains(text(),'Contacts')]")
	WebElement contactslabel;
	
	@FindBy(id="first_name")
	WebElement firstname;
	
	@FindBy(id="surname")
	WebElement lastname;
	
	@FindBy(name="client_lookup")
	WebElement companyname;
	
	@FindBy(xpath="//input[@value='Save']")
	WebElement savebttn;
	
	//@FindBy(xpath ="//input[@value='52825009']")
	//WebElement checkbox;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel() {
		return contactslabel.isDisplayed();
	}
	
	public void SelectContacts(int value) {
		driver.findElement(By.xpath("//input[@value='"+value+"']")).click(); 
	}
	
	public void CreatenewContact(String title, String ftname, String ltname, String compname) {
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		firstname.sendKeys(ftname);
		lastname.sendKeys(ltname);
		companyname.sendKeys(compname);
		
		savebttn.click();
		
	}

}
