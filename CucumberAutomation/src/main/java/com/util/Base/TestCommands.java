package com.util.Base;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.google.common.base.Function;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestCommands extends TestBase{



	/**
	 * Finds element based on specified By locator
	 * 
	 * @param locator
	 *            By selector to locate element on webpage
	 * @return WebElement WebElement which is identified via provided xpath
	 * @throws TestScriptException
	 */
	protected WebElement findElement(By locator){
		try {
			waitForElementToBeAvailable(locator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver.findElement(locator);
	}

	/**
	 * Finds all elements based on By selector
	 * 
	 * @param locator
	 *            By selector to locate element on webpage
	 * @return List of WebElements List of WebElements which are identified via
	 *         provided xpath
	 * @throws TestScriptException
	 */
	protected List<WebElement> findElements(By locator) {
		List<WebElement> elements = null;
		try {
			elements = driver.findElements(locator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return elements;
	}

	
	public boolean verifyLowToHigh(List<Float> listFloat){
		
		List<Float> beforeSortList=new ArrayList<>();
		beforeSortList.addAll(listFloat);
		Collections.sort(listFloat);
		for(int i=0;i<listFloat.size();i++){
			if(listFloat.get(i).equals(beforeSortList.get(i))){
				continue;
			}else{
				return false;
			}
		}
		
		return true;
		
	}
		
	/**
	 * Returns By object based on name using local object repository. Searches
	 * the local repo for the name and create By object on the basis on
	 * information found(type and locator) Returns null if the name is not found
	 * in object repo
	 * 
	 * @param name
	 *            Name of the element in the local object repository
	 * @return By selector Returns the By selector using the Local repository
	 * @throws TestScriptException
	 */
	protected By getLocator(String name,String type) {
		name = name.trim();
		By byLocator = null;
		try {
				String locatorType = type;
			String locator = name;
			if (locatorType.equalsIgnoreCase("id"))
				byLocator = By.id(locator);
			else if (locatorType.equalsIgnoreCase("name"))
				byLocator = By.name(locator);
			else if (locatorType.equalsIgnoreCase("xpath"))
				byLocator = By.xpath(locator);
			else if (locatorType.equalsIgnoreCase("linktext"))
				byLocator = By.linkText(locator);
			else if (locatorType.equalsIgnoreCase("partiallinktext"))
				byLocator = By.partialLinkText(locator);
			else if (locatorType.equalsIgnoreCase("tagname"))
				byLocator = By.tagName(locator);
			else if (locatorType.equalsIgnoreCase("cssselector"))
				byLocator = By.cssSelector(locator);
			else if (locatorType.equalsIgnoreCase("classname"))
				byLocator = By.className(locator);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return byLocator;
	}
	
	/**
	 * Opens the URL in the browser
	 * 
	 * @param url
	 *            URL to be opened
	 * @return String[] Returns the result of the execution
	 */
	public void openUrl(String url) {
		
			driver.get(url);
	}

	/**
	 * Click the element specified
	 * 
	 * @param name
	 *            Name of the element (should be present in the local
	 *            repository)
	 * @param type
	 *            Type of the element like button, link and so on
	 * @return String[] Returns the result of the execution
	 * @throws TestScriptException
	 */
	public boolean clickElement(String name, String type){
		try {
				By webEle = getLocator(name,type);
				WebElement webElement = findElement(webEle);
				webElement.click();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}	

	/**
	 * This method clicks the specified element via JavaScript
	 * 
	 * @param name
	 *            - Name of the element (should be present in the local
	 *            repository)
	 * @return String[] Returns the result of the execution
	 * @throws TestScriptException
	 */
	public boolean clickElementjs(WebElement element) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			mouseHover(element);
			executor.executeScript("arguments[0].click();", element);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Enters the value provided in the specified element
	 * 
	 * @param name
	 *            Name of the element (details present in local object
	 *            repository)
	 * @param type
	 *            Type of the element like text, checkbox, lookup etc
	 * @param value
	 *            Value to be entered
	 * @return String[] Returns the result of the execution
	 * @throws TestScriptException
	 */
	public void inputData(String name, String type, String value){
		try {
			if (type.equalsIgnoreCase("text") || type.equalsIgnoreCase("integer") || type.equalsIgnoreCase("double"))
				inputText(name, value,type);
			else if (type.equalsIgnoreCase("picklist"))
				selectPicklistValue(name, value,type);
			else if (type.equalsIgnoreCase("checkbox"))
				selectCheckbox(name, value,type);
			else if (type.equalsIgnoreCase("multipicklist"))
				selectMultiplicklistValue(name, value,type);
			else if (type.equalsIgnoreCase("radio"))
				selectRadioButton(name, value,type);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void inputDataType(WebElement ele, String type, String value){
		try {
			if (type.equalsIgnoreCase("text") || type.equalsIgnoreCase("integer") || type.equalsIgnoreCase("double"))
				inputText(ele, value);
			else if (type.equalsIgnoreCase("picklist"))
				selectPicklistValue(ele, value);
			else if (type.equalsIgnoreCase("checkbox"))
				selectCheckbox(ele, value);
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Input value to the alert and click ok.
	 * 
	 * @param Value
	 *            Value to be entered in the alert
	 * @return Object Returns the result of the execution
	 * @throws TestScriptException
	 */
	public void inputToAlert(String value) {
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, 1);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			if (value != "N") {
				alert.sendKeys(value);
			}
			alert.accept();
		} catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * Selects values in the multi-picklist
	 * 
	 * @param name
	 *            Name of the multi-picklist
	 * @param value
	 *            Values to be selected separated by comma
	 * @throws TestScriptException
	 */
	protected void selectMultiplicklistValue(String name, String value,String type) {
		try {
			WebElement unselected = findElement(getLocator(name,type));
			WebElement add = findElement(getLocator(name + "Add",type));
			String[] values = value.split(",");
			for (String val : values) {
				List<WebElement> options = unselected.findElements(By.tagName("option"));
				for (WebElement option : options) {
					String text = option.getText();
					if (text.equalsIgnoreCase(val)) {
						option.click();
						add.click();
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	/**
	 * Types the value in the text box specified
	 * 
	 * @param name
	 *            Name of the element
	 * @param value
	 *            Value to be entered
	 * @throws TestScriptException
	 */
	protected void inputText(String name,String type, String value){
		try {
			waitForElementToBeAvailable(getLocator(name,type));
			By webEle = getLocator(name,type);
			WebElement webElement = findElement(webEle);

			webElement.sendKeys(Keys.CONTROL + "a");
			webElement.sendKeys(Keys.DELETE);

			webElement.clear();
			webElement.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void inputText(WebElement webElement, String value){
		try {
			mouseHover(webElement);
			webElement.sendKeys(Keys.CONTROL + "a");
			webElement.sendKeys(Keys.DELETE);

			webElement.clear();
			webElement.sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Selects or de-selects the checkbox
	 * 
	 * @param name
	 *            Name of the checkbox
	 * @param value
	 *            Value to be entered; should be 'check' or 'uncheck'savd
	 * @throws TestScriptException
	 */
	protected void selectCheckbox(String name, String value,String type){
		try {
			By webEle = getLocator(name,type);
			WebElement webElement = findElement(webEle);
			if ((value.equalsIgnoreCase("uncheck") && webElement.isSelected())
					|| (value.equalsIgnoreCase("check") && !webElement.isSelected()))
				webElement.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void selectCheckbox(WebElement webElement, String value){
		try {
			mouseHover(webElement);
			if ((value.equalsIgnoreCase("uncheck") && webElement.isSelected())
					|| (value.equalsIgnoreCase("check") && !webElement.isSelected()))
				webElement.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Selects value in the picklist
	 * 
	 * @param name
	 *            Name of the picklist
	 * @param value
	 *            Values to be selected
	 * @throws TestScriptException
	 */
	protected void selectPicklistValue(String name, String value,String type){
		try {
			By webEle = getLocator(name,type);
			WebElement webElement = findElement(webEle);
			Select picklist = new Select(webElement);
			picklist.selectByVisibleText(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void selectPicklistValue(WebElement webElement, String value){
		try {
			mouseHover(webElement);
			Select picklist = new Select(webElement);
			picklist.selectByVisibleText(value);
		} catch (Exception e) {
			mouseHover(webElement);
			Select picklist = new Select(webElement);
			picklist.selectByValue(value);
		}
	}

	/**
	 * Verify the text for the particular element
	 * 
	 * @param name
	 *            Name of the element
	 * @param text
	 *            Text that is to be verified
	 * @return String[] Returns the result of the execution
	 * @throws TestScriptException
	 */
	public boolean verifyText(String name, String text,String type){
		
		try {
			String screenText;
			By webEle = getLocator(name,type);
			WebElement webElement = findElement(webEle);
			mouseHover(name,type);
			screenText = webElement.getText().trim();
			if(screenText.equalsIgnoreCase(text)){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Verifies the presence of element specified
	 * 
	 * @param name
	 *            Name of the element
	 * @return String[] Returns the result of the execution
	 * @throws TestScriptException
	 */
	public void verifyPresence(String name,String type)  {
		
		try {
			By webEle = getLocator(name,type);
			WebElement webElement = findElement(webEle);
			webElement.isDisplayed();
			mouseHover(name,type);
			
		 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Select value in the radio button
	 * 
	 * @param name
	 *            Name of the element
	 * @param value
	 *            Value to be selected
	 * @throws TestScriptException
	 */
	protected void selectRadioButton(String name, String value,String type){
		try {
			By webEle = getLocator(name,type);
			List<WebElement> RadioButtons = findElements(webEle);
			for (WebElement RadioButton : RadioButtons) {
				String onScreenValue = RadioButton.getAttribute("value");
				if (onScreenValue.equals(value)) {
					RadioButton.click();
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	/**
	 * Clear the existing text of field
	 * 
	 * @param name
	 *            - The field that needs to be cleared
	 * @return Object Returns the result of the execution
	 * @throws TestScriptException
	 */
	public void clearText(String name,String type) {

		try {
			By webEle = getLocator(name,type);
			WebElement webElement = findElement(webEle);
			webElement.clear();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used for scrolling down..
	 * 
	 * @return Object Returns the result of the execution
	 * 
	 */
	public void scrollDown(){

		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript(
					"window.scrollTo(0,Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight));");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method is used for scrolling up..
	 * 
	 * @return Object Returns the result of the execution
	 * 
	 */
	public void scrollUp() {

		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript(
					"window.scrollTo(Math.max(document.documentElement.scrollHeight,document.body.scrollHeight,document.documentElement.clientHeight),0);");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Verify that the mentioned web element is absent on the screen.
	 * 
	 * @param name
	 *            - Element whose absence we need to verify.
	 * @return String[] Returns the result of the execution
	 * @throws TestScriptException
	 */
	public boolean verifyAbsence(String name,String type){
		try {
			By webEle = getLocator(name,type);
			WebElement webElement = driver.findElement(webEle);

			if (webElement != null) {
				return false;
			}
			return true;
		
		} catch (Exception e) {
			return true;
			}

	}
	
	/**

	 * Hover Mouse on element
	 * 
	 * @param name
	 *            Element to be hovered on
	 * @return Object Returns the result of the execution
	 * @throws TestScriptException
	 */
	public void mouseHover(String name,String type){

		try {
			Actions action = new Actions(driver);
			By webEle = getLocator(name,type);
			WebElement element = driver.findElement(webEle);
			action.moveToElement(element).build().perform();
			/*
			 * JavascriptExecutor jse = (JavascriptExecutor) driver;
			 * jse.executeScript("window.scrollTo(" +
			 * element.getLocation().getX() + "," +
			 * (element.getLocation().getY() - 575) + ");");
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	public boolean mouseHover(WebElement element){

		try {
			
			Actions action = new Actions(driver);
			action.moveToElement(element).build().perform();
			Thread.sleep(5000);
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			return false;
		}
	}
	
	
	public boolean mouseHoverJScript(WebElement HoverElement) {
		try {
			if (isElementPresent(HoverElement)) {
				
				RemoteWebElement homePage = (RemoteWebElement) HoverElement;
			            ((HasInputDevices)driver).getMouse().mouseMove(homePage.getCoordinates());
			            Thread.sleep(2000);
			            return true;
			}else{
				return false;
			}
		}
		
			  catch (StaleElementReferenceException e) {
			System.out.println("Element with " + HoverElement
					+ "is not attached to the page document"
					+ e.getStackTrace());
		} catch (NoSuchElementException e) {
			System.out.println("Element " + HoverElement + " was not found in DOM"
					+ e.getStackTrace());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error occurred while hovering"
					+ e.getStackTrace());
		}
		return false;
	}
	
	public static boolean isElementPresent(WebElement element) {
		boolean flag = false;
		try {
			if (element.isDisplayed()|| element.isEnabled())
				flag = true;
		} catch (NoSuchElementException e) {
			flag = false;
		} catch (StaleElementReferenceException e) {
			flag = false;
		}
		return flag;
	}
	
	/**
	 * Fluent wait for element to be visibles
	 * 
	 * @throws TestScriptException
	 */
	protected void waitForElementToBeAvailable(By by){
		// Wait first to list appear..
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
					.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getUniqueValue(){
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		return timestamp.getTime()+"";
	}

	/**
	 * Fluent wait for element to be visible
	 * 
	 * @return String[] Returns the result of the execution
	 * @throws TestScriptException
	 */
	public WebElement waitForElementToBeVisible(Integer timeoutInSec, String name,String type) {

		try {
			Pattern pattern = Pattern.compile("screenshot\\((.+?)\\)",Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(name);
            if(matcher.find()){
            	name = matcher.group(1);
            }
        	final By element = getLocator(name,type);
			
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(timeoutInSec, TimeUnit.SECONDS)
					.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

			WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {

					return driver.findElement(element);
				}
			});
			if(foo!=null){
				return foo;
			}else{
				return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<WebElement> waitForElementsToBeVisible(Integer timeoutInSec, String name,String type) {

		try {
			
        	final By element = getLocator(name,type);
			
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(timeoutInSec, TimeUnit.SECONDS)
					.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

			List<WebElement> foo = (List<WebElement>) wait.until(new Function<WebDriver, List<WebElement>>() {
				public List<WebElement> apply(WebDriver driver) {

					return driver.findElements(element);
				}
			});
			if(foo!=null){
				return foo;
			}else{
				return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**

	 * Waits for the element to be Invisible
	 * 
	 * @param name
	 *            Element for which we need to wait for invisibility
	 * @return Object Returns the result of the execution
	 * @throws TestScriptException
	 */
	public void waitForElementInVisible(String name,String type) {
		// Wait first to list appear..
		final By element = getLocator(name,type);

		
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(100, TimeUnit.SECONDS)
					.pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

			wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}



}