package com.build.qa.build.selenium.pageobjects.pages;

import com.build.qa.build.selenium.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class SearchPage extends BasePage {

    private  By SearchPage;

    public SearchPage(WebDriver driver, Wait<WebDriver> wait) {
        super(driver, wait);
        SearchPage = By.cssSelector("#wrapper.plp");

    }

    public boolean onSearchPage() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(SearchPage)) != null;
    }

    @FindBy(xpath = "//*[text()='Brass Tones']")
    public WebElement BrassTonessCheckBox;

    @FindBy(xpath = "//*[text()='Brizo']//parent::div")
    public WebElement brizoBrand;

    @FindBy(xpath = "//*[text()='Chromes']//parent::div")
    public WebElement chromesCategory;

    @FindBy(xpath = "(//*[@class='sr-fg-content-name js-compare-search-item-name'])[1]")
    public WebElement firstItem;

    @FindBy (xpath = "(//a[@class='fz-13 link-black sr-fg-content-fastcode']/span)[1]")
    public WebElement firstItemPart;


    @FindBy(xpath = "(//*[@data-dname=\'brand\']//following::i)[1]")
    public WebElement brandShowMore;

    @FindBy(xpath = "//div[@class='word total-record']")
    public WebElement productCount;


    @FindBy(xpath = "//*[@class='sr-fg-content-name js-compare-search-item-name' and text()='KOHLER Devonshire® Two Handle Widespread Bathroom Sink Faucet with Metal Pop-Up Drain in Vibrant Polished Brass']")
    public WebElement fItem;



}
