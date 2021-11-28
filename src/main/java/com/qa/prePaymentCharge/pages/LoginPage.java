package com.qa.prePaymentCharge.pages;
//1. Page Objects
//2. Create Constructor
//3. Create Page Methods
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.prePaymentCharge.base.BasePage;
import com.qa.prePaymentCharge.utils.Constants;
import com.qa.prePaymentCharge.utils.ElementUtil;

public class LoginPage extends BasePage {
	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	//Creating Page Objects
	By homeBtn = By.xpath("//span[@id='lblHomeLink']");
	By pageTitle = By.xpath("//span[@id='lblPageTitle']");
	By loginbutton = By.xpath("//button[@type='submit']");
	By signupLink = By.xpath("//a[contains(text(),'Sign Up')]");
	
	//Constructor for login
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver); //Calling ElementUtil
	}
	
	public String getLoginPageTitle() {
		//return driver.getTitle(); 
		return elementUtil.waitForTitleToBePresent(Constants.HOME_PAGE_TITLE, 10); //Calling ElementUtil
	}
	

	public boolean verifySignUpLink() { 
		//return driver.findElement(signupLink).isDisplayed();
		return elementUtil.doIsDisplayed(signupLink); //Calling ElementUtil
	}
	

	public HomePage doLogin(String username, String password) {
		//elementUtil.waitForElementToBeVisible(this.username, 10); //Calling ElementUtil
		
		/*driver.findElement(this.username).sendKeys(username);
		driver.findElement(this.password).sendKeys(password);
		driver.findElement(this.loginbutton).click();*/ 
		
		//elementUtil.doSendKeys(this.username, username); //Calling ElementUtil
		//elementUtil.doSendKeys(this.password, password); //Calling ElementUtil
		elementUtil.doClick(this.loginbutton); //Calling ElementUtil
		
		return new HomePage(driver); //Page Chaining (As we can access HomePage through Login Page)
	}
	
}
