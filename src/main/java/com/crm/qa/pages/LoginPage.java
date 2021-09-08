package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//Page Factory - OR:
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn;
	
	@FindBy(linkText="Sign Up")
	WebElement signUp;
	
	@FindBy(xpath="//a[@class='navbar-brand']")
	WebElement CRMLogo;
	
	//Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
		
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMLogo() {
		return CRMLogo.isDisplayed();
	}
	
	public HomePage login(String us, String pwd) {
		username.sendKeys(us);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	}
	
	
	
	
