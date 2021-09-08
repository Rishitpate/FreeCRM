package com.crm.qa.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase{
	
	TestUtil testutil;
	
	@FindBy(xpath="//td[contains(text(),'User: Rishit Patel')]")
	@CacheLookup //to improve script speed
	WebElement userNamelabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement ContactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement DealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement TasksLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement NewContactLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this); 
	}
	
	public String verifyHomepageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifycorrectUserName() {
		return userNamelabel.isDisplayed();
	}
	
	public ContactsPage clickonContactsLink() {
		
		WebElement ContactsLink = driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"));
		ContactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickonDealsLink() {
		DealsLink.click(); 
		return new DealsPage();
	}
	
	public TasksPage clickonTasksLink() {
		TasksLink.click(); 
		return new TasksPage();
	}
	
	public void ClickonNewContactLink() throws InterruptedException{
		
		Actions builder = new Actions(driver);
		builder.moveToElement(DealsLink).build().perform();
		builder.moveToElement(ContactsLink).build().perform();
		NewContactLink.click();	
	}

}
