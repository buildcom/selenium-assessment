package com.build.qa.build.selenium.pageobjects.pages;

import com.build.qa.build.selenium.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class ProductPage extends BasePage {

    private By productWrapper ;
    public ProductPage(WebDriver driver, Wait<WebDriver> wait) {
        super(driver, wait);
        productWrapper=By.cssSelector("#wrapper.productdetail-new");
    }

    public boolean onProductDetailPage(){
        return wait.until(ExpectedConditions.presenceOfElementLocated(productWrapper)) != null;
    }

    @FindBy(xpath = "//h2[@class='product__brand']")
    public WebElement productBrand;

    @FindBy(xpath = "//span[@itemprop='productID']")
    public WebElement productId;

    @FindBy(xpath ="//i[@class='fg-icon-plus']//parent::button")
    public WebElement quantityBtnPlus;

    @FindBy(xpath = "//i[@class='fg-icon-minus']//parent::button")
    public WebElement quantityBtnMinus;

    @FindBy(xpath = "//input[@value='Add to Cart']")
    public WebElement addToCart;

    @FindBy(xpath = "(//*[@class='js-cartitem-count cartitem-count'])[1]")
    public WebElement viewCard;


    @FindBy(xpath = "//*[@class='price__main price-value']")
    public WebElement priceOfItem;


    @FindBy(xpath = "(//div[@class='total-price']/span)[1]")
    public WebElement totalPrice$;


    @FindBy(xpath = "//h1[@class='product__name']")
    public WebElement itemName;









}
