package com.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.util.Base.TestCommands;

public class TestProductPage extends TestCommands{

	
	@FindBy(how=How.ID,using="selectProductSort")
	WebElement sortingPicklist;
	
	@FindBy(how=How.ID,using="grid")
	WebElement gridViewButton;
	
	@FindBy(how=How.ID,using="list")
	WebElement listViewButton;
	
	@FindBy(how=How.XPATH,using="//ul[@class='product_list row grid']")
	WebElement productGridView;
	
	@FindBy(how=How.XPATH,using="//ul[@class='product_list row list']")
	WebElement productListView;
	
	String prodWithBlueColor="(//*[contains(@class,'product_list')]/descendant::a[@class='color_pick' and contains(@href,'blue')])[1]";
	String prodPrice= "//*[contains(@class,'product_list')]/descendant::*[contains(@class,'left-block')]/descendant::*[@itemprop='price']";

	public TestProductPage(){
		PageFactory.initElements(driver, this);
	}

	public String validateProductPage(){
		return driver.getTitle();  //Summer Dresses - My Store
	}

	public boolean selectProductView(String view){
		if(view.equalsIgnoreCase("Grid")){
			if(clickElementjs(gridViewButton)){
			return true;
			}else{return false;}
		}else if(view.equalsIgnoreCase("list")){
			if(clickElementjs(listViewButton)){
				return true;
				}else{return false;}
			}else{
				return false;
			}
	}
	
	
	public void selectSorting(String sortby){
		inputDataType(sortingPicklist, "picklist", sortby);
	}
	public boolean validateProductView(String view){
		if(view.equalsIgnoreCase("Grid")){
		if(clickElementjs(gridViewButton)){
		if(isElementPresent(productGridView)){
			return true;
		}else{
			return false;
		}
		}else{
		return false;
		}
		}else if(view.equalsIgnoreCase("list")){
			if(clickElementjs(listViewButton)){
				if(isElementPresent(productListView)){
					return true;
				}else{
					return false;
				}
				}else{
				return false;
				}
		}
		return false;
	}
	
	
	public boolean validateProductLowToHighSorting() throws InterruptedException{
		Thread.sleep(10000);
		List<WebElement> eleList=waitForElementsToBeVisible(60, prodPrice, "xpath");
		List<Float> priceList=new ArrayList<>();
		if(eleList!=null){
			for(WebElement ele: eleList){
				String elePrice=ele.getAttribute("innerHTML").trim().substring(1);
				System.out.println(elePrice);
				priceList.add(Float.parseFloat(elePrice));
			}
			return verifyLowToHigh(priceList);
		}
		return false;
	}
	public TestProductDetailPage selectProductWithBlue(){
		WebElement ele=waitForElementToBeVisible(60, prodWithBlueColor, "xpath");
		if(clickElementjs(ele)){
			return new TestProductDetailPage();
		}else{
			return null;
		}
	}
	
	
	
	



}
