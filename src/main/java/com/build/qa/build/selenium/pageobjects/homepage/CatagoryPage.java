package com.build.qa.build.selenium.pageobjects.homepage;

import com.build.qa.build.selenium.pageobjects.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class CatagoryPage extends BasePage {

    private By Seconditem;
    private By AddingToCart;
    private By Cart;
    private By ProductTitle;
    private By ProductTitleCart;
    private By Brand;
    private By BrandType;
    private By ResultNumber;
    private By Finish;
    private By FinishType;

    public CatagoryPage(WebDriver driver, Wait<WebDriver> wait) {
        super(driver, wait);
        Seconditem = By.xpath("//*[contains(@data-url,'7289400')]");
        AddingToCart = By.xpath("//*[contains(@data-form,'addToCart')]");
        Cart = By.xpath("//*[contains(@class,'cart i-cart')]");
        ProductTitle = By.xpath("//*[@id='sku7289400']/div[4]/a/p");
        ProductTitleCart = By.xpath("//*[@id='item-datas']/li/div[3]/div[2]/div/a/p");
        Brand = By.xpath("//*[contains(@class,'brand_rfbox')]/ul/li[1]");
        BrandType = By.xpath("//*[@id='wrapper']/main/div/div/div[2]/div/div[3]/div[2]/div[2]/p[2]");
        ResultNumber = By.id("totalNumRecs");
        Finish = By.xpath("//*[contains(@class,'Color_Finish_Category_rfbox')]/ul/li[1]");
        FinishType = By.xpath("//*[@id='wrapper']/main/div/div/div[2]/div/div[2]/div[2]/div[3]/p[2]");

    }

    public void VerifyCatagoryItem() throws InterruptedException {

        driver.get("https://www.ferguson.com/category/bathroom-plumbing/bathroom-faucets/bathroom-sink-faucets/_/N-zbq4i3");
        String ProducttitleCTPage = driver.findElement(ProductTitle).getText();
        driver.findElement(Seconditem).click();
        Thread.sleep(3000);
        driver.findElement(AddingToCart).click();
        Thread.sleep(3000);
        driver.findElement(Cart).click();
        Thread.sleep(3000);
        String ProductTitleCartPage = driver.findElement(ProductTitleCart).getText();
        Assert.assertEquals(ProducttitleCTPage, ProductTitleCartPage);


    }

    public void FilterCheck() throws InterruptedException {
        driver.get("https://www.ferguson.com/category/bathroom-plumbing/bathroom-faucets/bathroom-sink-faucets/_/N-zbq4i3");
        driver.findElement(Brand).click();
        Thread.sleep(6000);
        String BrandTypeName = driver.findElement(BrandType).getText();
        Assert.assertEquals("PROFLO®", BrandTypeName);
        String Filter1result = driver.findElement(ResultNumber).getAttribute("value");
        System.out.println(Filter1result);
        Assert.assertEquals("94", Filter1result);
        driver.findElement(Finish).click();
        Thread.sleep(6000);
        String FinishTypeName = driver.findElement(FinishType).getText();
        Assert.assertEquals("Chromes",FinishTypeName);
        String Filter2result = driver.findElement(ResultNumber).getAttribute("value");
        System.out.println(Filter2result);
        Assert.assertEquals("71",Filter2result);


    }
}