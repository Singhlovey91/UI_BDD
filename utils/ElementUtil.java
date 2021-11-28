package com.qa.prePaymentCal.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil{
	
	WebDriver driver;
	JavaScriptUtil jsUtil; //Calling JavaScriptUtil
	
	//Constructor for ElementUtil
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		jsUtil = new JavaScriptUtil(this.driver); //Calling JavaScriptUtil
	}
	
	
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			System.out.println("Locator is : " + locator);
			element = driver.findElement(locator);
			//jsUtil.flash(element); //Calling JavaScriptUtil
		//	jsUtil.drawBorder(element); //Calling JavaScriptUtil
			System.out.println("Webelement is created successfully : " + locator);
		}catch(Exception e) {
			System.out.println("Some exception got occured with this locator : " + locator);
		}
		return element;
	}
	
	//To enter the values in any input field
	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value); 
	}
	
	//To click on any element (Button, Link, Checkbox, Image, Radiobutton)
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	
	public String doGetText(By locator) {
		return getElement(locator).getText();
	}
	
	public void selectByvisibleText(By locator, String text ) {
		WebElement element = driver.findElement(locator);
	Select select = new Select(element);
	select.selectByVisibleText(text);
	
	}
	public void selectByIndex(By locator, int index ) {
		WebElement element = driver.findElement(locator);
	Select select = new Select(element);
	select.selectByIndex(index);
	
	}
	
	
	
	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
	// Explicit Wait to wait untill title is present
	public String waitForTitleToBePresent(String title, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}
	
	
}
