package com.qa.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.util.Base.TestCommands;

public class TestHomePage extends TestCommands {

	
	@FindBy(id="index")
	WebElement homepageele;
	
	
	String signin="//*[@class='login' and @title='Log in to your customer account']";
	String dress="//*[@id='block_top_menu']/descendant::ul[contains(@class,'menu-content')]/child::li/child::a[text()='Dresses']/..";
	String summ="//*[@id='block_top_menu']/descendant::ul[contains(@class,'menu-content')]/child::li/child::a[text()='Dresses']/..//a[text()='Summer Dresses']";
	
	@FindBy(xpath="//*[@id='block_top_menu']/descendant::ul[contains(@class,'menu-content')]/child::li/child::a[text()='Dresses']/..")
	WebElement DressesMenu;
	
	@FindBy(xpath="//*[@id='block_top_menu']/descendant::ul[contains(@class,'menu-content')]/child::li/child::a[text()='Dresses']/..//a[text()='Summer Dresses']")
	WebElement SummerDresses;
	
	

	public TestHomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateOnHomePage(){
		return driver.getTitle();
	}
	
	public boolean validateSignInButton(){
		WebElement ele=waitForElementToBeVisible(60, signin, "xpath");
		if(ele!=null){
			return true;
		}else{
			return false;
		}
		
	}
	
	public TestRegisterLoginPage clickSignInButton(){
		if(clickElement(signin, "xpath")){
			return new TestRegisterLoginPage();
		}else{
			return null;
		}
	}
	
	public boolean hoverMenu(){
		WebElement ele=waitForElementToBeVisible(60, dress, "xpath");
		if(ele!=null){
		
		if(mouseHoverJScript(ele)){
			return true;
		}else{
			return false;
		}
		}else{
			return false;
		}
	}
	
	public boolean hoverSubmenu(){
		WebElement ele=waitForElementToBeVisible(60, summ, "xpath");
		if(ele!=null){
		
		if(mouseHoverJScript(ele)){
			return true;
		}else{
			return false;
		}
		}else{
			return false;
		}
	}
	
	public TestProductPage clickSubmenu(){
		WebElement ele=waitForElementToBeVisible(60, summ, "xpath");
		if(ele!=null){
		
		if(mouseHoverJScript(ele)){
			ele.click();
			return new TestProductPage();
		}else{
			return null;
		}
		}else{
			return null;
		}
	}
}
