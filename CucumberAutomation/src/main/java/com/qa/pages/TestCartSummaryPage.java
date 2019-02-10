package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.util.Base.TestCommands;

public class TestCartSummaryPage extends TestCommands{
	@FindBy(how=How.XPATH,using="//h1[@id='cart_title' and contains(.,'Shopping-cart summary')]")
	WebElement cartHeading;
	
	@FindBy(how=How.XPATH,using="//*[@id='cart_summary']/descendant::td[@class='cart_description']/child::*[@class='product-name']//a")
	WebElement cartProdName;

	@FindBy(how=How.XPATH,using="//*[@id='cart_summary']/descendant::td[@class='cart_description']/small//a")
	WebElement cartProdSizeColor;

	@FindBy(how=How.XPATH,using="//*[@id='cart_summary']/descendant::td[contains(@class,'cart_quantity')]/input[@type='text']")
	WebElement cartProdQty;
	
	public TestCartSummaryPage(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateCartSummaryPage(){
		return isElementPresent(cartHeading);
	}
	
	public String getCartProdName(){
		return cartProdName.getText().trim();
	}
	
	public String getCartProdQty(){
		String qty =cartProdQty.getAttribute("value");
		return qty;
	}
	
	public String getCartProdSize(){
		String size=cartProdSizeColor.getText().trim().replace(" ", "");
		size=size.substring(size.lastIndexOf(":")+1).trim();
		System.out.println(size);
		return size;
		
	}
	
	public String getCartProdColor(){
		String color=cartProdSizeColor.getText().trim().replace(" ", "");
		color=color.substring(color.indexOf(":")+1,color.indexOf(",")).trim();
		System.out.println(color);
		return color;
	}
	
	
	
}
