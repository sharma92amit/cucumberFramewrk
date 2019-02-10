Feature: Add Product into Cart

@RegistrationTest
Scenario: Validate User is able to Register with valid email address

	Given User Open Browser
	Then User Open The URL
	Then User is on Home Page
	When Sign In Button is Available
	Then Click on Sign Button
	When Create an Account Section on Authentication Page is Load
	Then Enter a Valid Email Address
	Then Click on Create an Account Button
	When Your Personal Information Page is Load
	Then Enter The Required Values
	|Mr|test|user|test1234|5|7|2014|test company|test add1|test add2|Jaipur|Indiana|00000|United States|5453452235|test123|
	Then Click on Register Button
	And Name of User is displaying in Header "test user"
	Then Close Browser
	


@RegistrationTest
Scenario: Validate User should get an error message if registering with an incorrect email address

	Given User Open Browser
	Then User Open The URL
	Then User is on Home Page
	When Sign In Button is Available
	Then Click on Sign Button
	When Create an Account Section on Authentication Page is Load
	Then Enter an InValid Email Address "test.com"
	Then Click on Create an Account Button
	And User should get an error message
	Then Close Browser


@MenuTest	
Scenario: Validate The MegaMenu Works
	Given User Open Browser
	Then User Open The URL
	Then User is on Home Page
	Then Hover on the MegaMenu Dresses
	When Summer Dresses SubMenu is Displaying
	Then Click on Summer Dresses Menu
	And Summer Dresses Page is Load
	Then Close Browser

@ProductTest
Scenario: Validate Product Sorting is working properly

	Given User Open Browser
	Then User Open The URL
	Then User is on Home Page
	Then Hover on the MegaMenu Dresses
	When Summer Dresses SubMenu is Displaying
	Then Click on Summer Dresses Menu
	When Summer Dresses Page is Load
	Then Click on View "Grid"
	And Products Should Display in "Grid"
	Then Select Sort Product by "Price: Lowest first"
	And Products Should Display Sorted by "Price: Lowest first"
	Then Close Browser

@ProductTest
Scenario: Validate Product View is Working Properly
	
	Given User Open Browser
	Then User Open The URL
	Then User is on Home Page
	Then Hover on the MegaMenu Dresses
	When Summer Dresses SubMenu is Displaying
	Then Click on Summer Dresses Menu
	When Summer Dresses Page is Load
	Then Click on View "List"
	And Products Should Display in "List"
	Then Click on View "Grid"
	And Products Should Display in "Grid"
	Then Close Browser


@CartTest
Scenario Outline: Validate Cart Summary Page is Displaying The Same Product Name,Color and Quantity 
	
	Given User Open Browser
	Then User Open The URL
	Then User is on Home Page
	Then Hover on the MegaMenu Dresses
	When Summer Dresses SubMenu is Displaying
	Then Click on Summer Dresses Menu
	When Summer Dresses Page is Load
	Then Click on View "<VIEW>"
	And Products Should Display in "<VIEW>"
	Then Click on The Product which has Blue Color Option
	When Product View Page is Load
	Then Enter Quantity "<QTY>" and Size "<SIZE>" and Color "<COLOR>"
	Then Click on Add to Card button
	When Product Successfully Added Pop up Appear
	Then Click on Proceed to Checkout button
	When Shopping Cart Summary Paged Load
	Then Product Color as "<COLOR>" Quantity as "<QTY>" Size as "<SIZE>" should be Selected
	Then Close Browser

Examples:
	|QTY|SIZE|COLOR|VIEW|
	|2|M|Blue|List|

