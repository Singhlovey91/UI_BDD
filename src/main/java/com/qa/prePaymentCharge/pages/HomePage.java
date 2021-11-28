package com.qa.prePaymentCharge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.prePaymentCharge.base.BasePage;
import com.qa.prePaymentCharge.utils.Constants;
import com.qa.prePaymentCharge.utils.ElementUtil;

public class HomePage extends BasePage {

	private WebDriver driver;
	private ElementUtil elementUtil;
	
	
	By outstandingBalance = By.xpath("//input[@id='txtOutstandingBal']");
	By remainingTermYear = By.xpath("//select[@id='ddlRemainingTermYear']");
	By remainingTermMonth = By.xpath("//select[@id='ddlRemainingTermMonth']");
	By paymentFrequency = By.xpath("//select[@id='ddlPayFrequency']");
	By paymentAmount	= By.xpath("//input[@id='txtPayAmount']");
	By currentInterestRate= By.xpath("//input[@id='txtCurIntRate']");
	By calculateBtn = By.xpath("//input[@id='btnCalculate']");
	By errorMessage= By.xpath("//span[@id='rfvCurIntRate']");
	
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		//elementUtil = new ElementUtil(this.driver);
	}
	
	public void sendMortgageAmount(String outstandingBalance,String remainingTermYear, String remainingTermMonth,String paymentFrequency,
			 String paymentAmount, String currentInterestRate) {
		elementUtil.doSendKeys(this.outstandingBalance, outstandingBalance);
		elementUtil.selectByvisibleText(this.remainingTermYear, remainingTermMonth);
		elementUtil.selectByvisibleText(this.remainingTermMonth, remainingTermMonth);
		elementUtil.selectByvisibleText(this.paymentFrequency, paymentFrequency);
		
		elementUtil.selectByvisibleText(this.paymentAmount, paymentAmount);
		elementUtil.doSendKeys(this.currentInterestRate, currentInterestRate);
		
		
	}
	
	public void clickOnCalculateLink() {
		elementUtil.doClick(calculateBtn);
	}
	public String validateErrorMessage() {
		return elementUtil.doGetText(errorMessage);
	
	}
}
