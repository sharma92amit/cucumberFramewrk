package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.util.Base.TestCommands;

public class TestProductDetailPage extends TestCommands{

	@FindBy(how=How.XPATH,using="//*[@id='center_column']/descendant::h1[@itemprop='name']")
	WebElement prodName;

		String addedToCart="//*[@id='layer_cart']/descendant::h2[contains(.,'Product successfully added to your shopping cart')]";
		@FindBy(how=How.ID,using="quantity_wanted")
		WebElement prodQty;

		@FindBy(how=How.XPATH,using="//*[@id='attributes']/descendant::label[contains(text(),'Size')]/following-sibling::div/descendant::select")
		WebElement prodSize;
		
		String prodColor="//*[@id='attributes']/descendant::label[contains(text(),'Color')]/following-sibling::div/descendant::a[@name='colornameplaceholder']";    

		@FindBy(how=How.XPATH,using="//p[@id='add_to_cart']/button[@type='submit']")
		WebElement prodAddToCart;

		@FindBy(how=How.XPATH,using="//*[@id='layer_cart']/descendant::*[@class='button-container']//a[@title='Proceed to checkout']")
		WebElement prodCheckout;
		
		@FindBy(how=How.ID,using="product")
		WebElement prodPage;
		
		public TestProductDetailPage(){
			PageFactory.initElements(driver, this);
		}
	
		public boolean validateProdDetailPage(){
				if(isElementPresent(prodPage)){
					return true;
				}else{return false;}
		}
		
		public void inputProdQty(String value){
				inputDataType(prodQty, "text", value);
		}
		
		public void inputProdSize(String value){
				inputDataType(prodSize, "picklist", value);
		}
		public boolean inputProdColor(String value){
				prodColor=prodColor.replace("colornameplaceholder", value);
					WebElement ele=waitForElementToBeVisible(60, prodColor, "xpath");
				return clickElementjs(ele);
		}
		
		public boolean addToCart(){
				return clickElementjs(prodAddToCart);
		}
		
		public boolean validatedProdAddToCard(){
			WebElement ele=waitForElementToBeVisible(60, addedToCart, "xpath");
			return isElementPresent(ele);
		}
		public TestCartSummaryPage proceedToCheckout(){
				if(clickElementjs(prodCheckout)){
					return new TestCartSummaryPage();
				}else{
					return null;
				}
		}
	
}

