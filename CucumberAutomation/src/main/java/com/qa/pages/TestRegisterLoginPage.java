package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.util.Base.TestCommands;

public class TestRegisterLoginPage extends TestCommands{

	@FindBy(how=How.XPATH,using="//h3[text()='Create an account']")
	WebElement reglogingheading;
	
	@FindBy(id="email_create")
	WebElement regloginEmailInput;
	
	@FindBy(id="SubmitCreate")
	WebElement regloginSubmit;
	
	@FindBy(xpath="//*[@id='create_account_error']//li[text()='Invalid email address.']")
	WebElement regInvalidEmailError;
	
	 
	 public TestRegisterLoginPage(){
			PageFactory.initElements(driver, this);
		}
		
	 
	public String validateRegisterLoginPage(){
		return driver.getTitle();
	}
	
	public boolean registerSectionAvail(){
		return mouseHover(reglogingheading);
	}
	
	public void inputUniqueEmail(){
		regloginEmailInput.sendKeys("test"+getUniqueValue()+"@example.com");
	}
	
	public void inputEmail(String InValidEmail){
		regloginEmailInput.sendKeys(InValidEmail);
	}
	
	public TestRegisterPage clickCreateAccount(){
		clickElementjs(regloginSubmit);
			return new TestRegisterPage();
	
	}
	
	public boolean validateErrorMessge(){
		return mouseHover(regInvalidEmailError);
		
	}
}
