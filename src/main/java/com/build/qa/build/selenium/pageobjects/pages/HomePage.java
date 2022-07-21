package com.build.qa.build.selenium.pageobjects.pages;

import com.build.qa.build.selenium.CommonMethods.CommonMethods;
import com.build.qa.build.selenium.framework.BaseFramework;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import com.build.qa.build.selenium.pageobjects.BasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends BasePage {

	private static final Logger LOG = LoggerFactory.getLogger(HomePage.class);
	
	private By homePageWrapper;

	
	public HomePage(WebDriver driver, Wait<WebDriver> wait) {
		super(driver, wait);
		homePageWrapper = By.cssSelector("#wrapper.homepage");

	}
	
	public boolean onHomePage() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(homePageWrapper)) != null;
	}

	@FindBy(name = "search")
	public WebElement search_field;

	@FindBy(xpath = "//a[@class=\"fg-icon-search\" and @href=\"javascript:;\"]")
	public WebElement searchButton;



	public static void searchAnItem(String itemName){

		HomePage homePage=new HomePage(driver,wait);

		CommonMethods.sendKey(homePage.search_field, itemName);
		LOG.info(itemName +" is being sent ");

		homePage.searchButton.click();

	}
}
