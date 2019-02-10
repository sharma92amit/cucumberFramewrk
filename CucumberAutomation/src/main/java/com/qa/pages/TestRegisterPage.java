package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.util.Base.TestCommands;

import cucumber.api.DataTable;

public class TestRegisterPage extends TestCommands{

	@FindBy(xpath="//h3[text()='Your personal information']")
	WebElement registerPageHeading;
	
	@FindBy(how=How.ID,using="id_gender1")
	WebElement radioMr;
	
	@FindBy(how=How.ID,using="id_gender2")
	WebElement radioMrs;
	
	@FindBy(how=How.ID,using="customer_firstname")
	WebElement input_cust_FistName;
	
	@FindBy(how=How.ID,using="customer_lastname")
	WebElement input_cust_LastName;
	
	@FindBy(how=How.ID,using="email")
	WebElement input_webemail;
	
	@FindBy(how=How.ID,using="passwd")
	WebElement input_passwd;
	
	@FindBy(how=How.ID,using="days")
	WebElement dd_days;
	
	@FindBy(how=How.ID,using="months")
	WebElement dd_months;
	
	@FindBy(how=How.ID,using="years")
	WebElement dd_years;
	
	@FindBy(how=How.ID,using="firstname")
	WebElement web_firstname;
	
	@FindBy(how=How.ID,using="lastname")
	WebElement web_lastname;
	
	@FindBy(how=How.ID,using="company")
	WebElement web_company;
	
	@FindBy(how=How.ID,using="address1")
	WebElement web_address1;
	
	@FindBy(how=How.ID,using="address2")
	WebElement web_address2;
	
	@FindBy(how=How.ID,using="city")
	WebElement web_city;
	
	@FindBy(how=How.ID,using="id_state")
	WebElement dd_id_state;
	
	@FindBy(how=How.ID,using="postcode")
	WebElement web_postcode;
	
	@FindBy(how=How.ID,using="id_country")
	WebElement dd_id_country;
	
	@FindBy(how=How.ID,using="other")
	WebElement textarea_other;
	
	@FindBy(how=How.ID,using="phone_mobile")
	WebElement web_phone_mobile;
	
	@FindBy(how=How.ID,using="alias")
	WebElement web_alias;
	
	@FindBy(how=How.ID,using="submitAccount")
	WebElement btn_submitAccount;
	
	@FindBy(how=How.XPATH,using="//div[@class='header_user_info']//span")
	WebElement signin_username;
	
	
	public TestRegisterPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean validateRegisterDetailPage(){
		return mouseHover(registerPageHeading);
	}
	
	public boolean enterRequiredValue(DataTable arg){
		try{
		List<List<String>> dataRow=arg.raw();
		if(dataRow.get(0).get(0).equalsIgnoreCase("Mr")){
			radioMr.click();
		}else if(dataRow.get(0).get(0).equalsIgnoreCase("Mrs")){
			radioMrs.click();
		}
		inputDataType(input_cust_FistName, "text", dataRow.get(0).get(1));
		inputDataType(input_cust_LastName, "text", dataRow.get(0).get(2));
		inputDataType(input_passwd, "text", dataRow.get(0).get(3));
		inputDataType(dd_days, "picklist", dataRow.get(0).get(4));
		inputDataType(dd_months, "picklist", dataRow.get(0).get(5));
		inputDataType(dd_years, "picklist", dataRow.get(0).get(6));
		inputDataType(web_firstname, "text", dataRow.get(0).get(1));
		inputDataType(web_lastname, "text", dataRow.get(0).get(2));
		inputDataType(web_company, "text", dataRow.get(0).get(7));
		inputDataType(web_address1, "text", dataRow.get(0).get(8));
		inputDataType(web_address2, "text", dataRow.get(0).get(9));
		inputDataType(web_city, "text", dataRow.get(0).get(10));
		inputDataType(dd_id_state, "picklist", dataRow.get(0).get(11));
		inputDataType(web_postcode, "text", dataRow.get(0).get(12));
		inputDataType(dd_id_country, "picklist", dataRow.get(0).get(13));
		inputDataType(web_phone_mobile, "text", dataRow.get(0).get(14));
		inputDataType(web_alias, "text", dataRow.get(0).get(15));
		return true;
		}catch(Exception e){
			e.getMessage();
			return false;
		}
	}
	
	public void register(){
		clickElementjs(btn_submitAccount);
	}
	
	public String validateUserRegistered(){
		String username=signin_username.getText();
		return username;
	}
	
	
}
