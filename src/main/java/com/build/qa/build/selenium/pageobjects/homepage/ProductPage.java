package com.build.qa.build.selenium.pageobjects.homepage;

import com.build.qa.build.selenium.pageobjects.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class ProductPage extends BasePage {

    private By SearchBox;
    private By SearchButton;
    private By ProductBrand;
    private By ProductID;
    private By AddToCart;
    private By MatteFinish;
    private By Cart;

    public ProductPage(WebDriver driver, Wait<WebDriver> wait) {
        super(driver, wait);

        SearchBox = By.name("search");
        SearchButton = By.xpath("//*[contains(@class,'icon-search')]");
        ProductBrand = By.xpath("//*[contains(@class,'product__brand')]");
        ProductID = By.xpath("//*[@itemprop='productID']");
        AddToCart = By.xpath("//*[@value='Add to Cart']");
        MatteFinish = By.xpath("//*[@title='Matte Black']");
        Cart = By.xpath("//*[contains(@class,'cart i-cart')]");

    }
    public void ProductSearch () throws InterruptedException {
        driver.findElement(SearchBox).sendKeys("M6702BN");
        driver.findElement(SearchButton).click();
        Thread.sleep(3000);
        String ProductName = driver.findElement(ProductBrand).getText();
        System.out.println(ProductName);
        String ProductNumber = driver.findElement(ProductID).getText();
        System.out.println(ProductNumber);
        Assert.assertEquals("Moen", ProductName);
        Assert.assertEquals("Part #M6702BN", ProductNumber);
    }
    public void Addtocart () throws InterruptedException {
      driver.findElement(AddToCart).click();
      Thread.sleep(3000);
      driver.findElement(MatteFinish).click();
      Thread.sleep(3000);
      driver.findElement(AddToCart).click();
      Thread.sleep(3000);
      driver.findElement(Cart).click();

    }

    }
