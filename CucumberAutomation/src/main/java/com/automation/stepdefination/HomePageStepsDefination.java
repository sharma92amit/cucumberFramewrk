package com.automation.stepdefination;

import org.testng.Assert;

import com.qa.pages.TestCartSummaryPage;
import com.qa.pages.TestHomePage;
import com.qa.pages.TestProductDetailPage;
import com.qa.pages.TestProductPage;
import com.qa.pages.TestRegisterLoginPage;
import com.qa.pages.TestRegisterPage;
import com.util.Base.TestBase;
import com.util.Base.TestCommands;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageStepsDefination extends TestCommands{

	TestHomePage homePage=new TestHomePage();
	TestRegisterLoginPage registerLoginPage;
	TestRegisterPage registerPage;
	TestProductPage productPage;
	TestProductDetailPage prodDetailPage;
	TestCartSummaryPage prodCartSummaryPage;
	
	
	@Given("^User Open Browser$")
	public void user_Open_Browser(){
		TestBase.initialisation();
	}
	
	@Then("^User Open The URL$")
	public void user_Open_URL(){
		openUrl(prop.getProperty("URL"));
	}
	
	@Then("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
	    String title=homePage.validateOnHomePage();
	    Assert.assertEquals("My Store", title);
	    Thread.sleep(5000);
	}

	@When("^Sign In Button is Available$")
	public void sign_In_Button_is_Available() throws Throwable {
	   Assert.assertEquals(true,homePage.validateSignInButton());
	    
	}

	@Then("^Click on Sign Button$")
	public void click_on_Sign_Button() throws Throwable {
	    registerLoginPage=homePage.clickSignInButton();
	    
	}

	@When("^Create an Account Section on Authentication Page is Load$")
	public void create_an_Account_Section_on_Authentication_Page_is_Load() throws Throwable {
	   String title= registerLoginPage.validateRegisterLoginPage();
	   Assert.assertEquals("Login - My Store", title);
	   Thread.sleep(5000);
	   Assert.assertEquals(true, registerLoginPage.registerSectionAvail());
	}
	

@Then("^Enter an InValid Email Address \"([^\"]*)\"$")
public void enter_a_InValid_Email_Address(String InValidEmail) throws Throwable {
    	registerLoginPage.inputEmail(InValidEmail);
    
}

@Then("^Click on Create an Account Button$")
public void click_on_Create_an_Account_Button() throws Throwable {
     	registerPage=registerLoginPage.clickCreateAccount();
     	Thread.sleep(5000);
}

@Then("^Enter a Valid Email Address")
public void enter_a_Valid_Email_Address() throws Throwable {
		registerLoginPage.inputUniqueEmail();
}

@Then("^User should get an error message$")
public void user_should_get_an_error_message() throws Throwable {
    registerLoginPage.validateErrorMessge();
}

@When("^Your Personal Information Page is Load$")
public void your_Personal_Information_Page_is_Load() throws Throwable {
      Assert.assertEquals(true, registerPage.validateRegisterDetailPage());
}

@Then("^Enter The Required Values$")
public void enter_The_Required_Values(DataTable arg1) throws Throwable {
	Assert.assertEquals(true, registerPage.enterRequiredValue(arg1));
}

@Then("^Click on Register Button$")
public void click_on_Register_Button() throws Throwable {
	registerPage.register();
		
    
}

@Then("^Name of User is displaying in Header \"([^\"]*)\"$")
public void name_of_User_is_displaying_in_Header(String username) throws Throwable {
	Assert.assertEquals(username, registerPage.validateUserRegistered());
    
}

@Then("^Close Browser$")
public void close_Browser() throws Throwable {
    driver.quit();
    
}

@Then("^Hover on the MegaMenu Dresses$")
public void hover_on_the_MegaMenu_Dresses() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    Assert.assertEquals(true, homePage.hoverMenu());
}

@When("^Summer Dresses SubMenu is Displaying$")
public void summer_Dresses_SubMenu_is_Displaying() throws Throwable {
	Assert.assertEquals(true, homePage.hoverSubmenu());
}

@Then("^Click on Summer Dresses Menu$")
public void click_on_Summer_Dresses_Menu() throws Throwable {
    	productPage= homePage.clickSubmenu();
}

@Then("^Summer Dresses Page is Load$")
public void summer_Dresses_Page_is_Load() throws Throwable {
    	Assert.assertEquals("Summer Dresses - My Store", productPage.validateProductPage());
    
}

@Then("^Click on View \"([^\"]*)\"$")
public void click_on_View_Grid(String view) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
		productPage.selectProductView(view);
}

@Then("^Products Should Display in \"([^\"]*)\"$")
public void products_Should_Display_in_Grid(String view) throws Throwable {
    	productPage.validateProductView(view);
 
}

@Then("^Select Sort Product by \"([^\"]*)\"$")
public void select_Sort_Product_by_Price_Lowest_First(String sortby) throws Throwable {
    	productPage.selectSorting(sortby);
 
}

@Then("^Products Should Display Sorted by \"([^\"]*)\"$")
public void products_Should_Display_Sorted_by(String sortby) throws Throwable {
		Assert.assertEquals(true, productPage.validateProductLowToHighSorting());
 
}

@Then("^Click on The Product which has Blue Color Option$")
public void click_on_The_Product_which_has_Blue_Color_Option() throws Throwable {
   
    prodDetailPage=productPage.selectProductWithBlue();
}

@When("^Product View Page is Load$")
public void product_View_Page_is_Load() throws Throwable {
    Assert.assertEquals(true, prodDetailPage.validateProdDetailPage());
    
}

@Then("^Enter Quantity \"([^\"]*)\" and Size \"([^\"]*)\" and Color \"([^\"]*)\"$")
public void enter_Quantity_and_Size_and_Color(String qty,String size,String color) throws Throwable {
    	prodDetailPage.inputProdQty(qty);
    	prodDetailPage.inputProdSize(size);
    	prodDetailPage.inputProdColor(color);
}

@Then("^Click on Add to Card button$")
public void click_on_Add_to_Card_button() throws Throwable {
    	Assert.assertEquals(true, prodDetailPage.addToCart());
    
}

@When("^Product Successfully Added Pop up Appear$")
public void product_Successfully_Added_Pop_up_Appear() throws Throwable {
    	Assert.assertEquals(true, prodDetailPage.validatedProdAddToCard());
    
}

@Then("^Click on Proceed to Checkout button$")
public void click_on_Proceed_to_Checkout_button() throws Throwable {
         prodCartSummaryPage=prodDetailPage.proceedToCheckout();
    
}

@When("^Shopping Cart Summary Paged Load$")
public void shopping_Cart_Summary_Paged_Load() throws Throwable {
    	Assert.assertEquals(true, prodCartSummaryPage.validateCartSummaryPage());
    
}

@Then("^Product Color as \"([^\"]*)\" Quantity as \"([^\"]*)\" Size as \"([^\"]*)\" should be Selected$")
public void product_Color_Quantity_Size_should_be_same_as_Selected(String prodColor,String prodQty,String prodSize) throws Throwable {
    	String color=prodCartSummaryPage.getCartProdColor();
    	String size=prodCartSummaryPage.getCartProdSize();
    	String qty=prodCartSummaryPage.getCartProdQty();
    	Assert.assertEquals(prodColor, color);
    	Assert.assertEquals(prodSize, size);
    	Assert.assertEquals(prodQty, qty);
	
}


}
