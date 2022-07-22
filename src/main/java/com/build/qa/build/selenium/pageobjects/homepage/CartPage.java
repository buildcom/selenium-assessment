package com.build.qa.build.selenium.pageobjects.homepage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

import com.build.qa.build.selenium.pageobjects.BasePage;

public class CartPage extends BasePage {

    private By UpdateQuantityItem1;
    private By IncreaseQuantity1;
    private By UpdateQuantityItem2;
    private By IncreaseQuantity2;
    private By CartCount;

    public CartPage(WebDriver driver, Wait<WebDriver> wait) {
        super(driver, wait);
        UpdateQuantityItem1 = By.xpath("//*[@id=\"item-datas\"]/li[1]/div[3]/div[3]/div[2]/div[1]/div[1]/div/input");
        IncreaseQuantity1 = By.xpath("//*[@id=\"item-datas\"]/li[1]/div[3]/div[3]/div[2]/div[1]/div[1]/div/div[2]"); //Normally I would find a better locator but this is just a purpose of the assignment
        UpdateQuantityItem2 = By.xpath("//*[@id=\"item-datas\"]/li[2]/div[3]/div[3]/div[2]/div[1]/div[1]/div/input");
        IncreaseQuantity2 = By.xpath("//*[@id=\"item-datas\"]/li[2]/div[3]/div[3]/div[2]/div[1]/div[1]/div/div[2]");
        CartCount = By.xpath("//*[@class='shoppingCartAmount']");
    }

    public void CartUpdate () throws InterruptedException {

        driver.findElement(UpdateQuantityItem1).click();
        driver.findElement(IncreaseQuantity1).click();
        Thread.sleep(2000);
        driver.findElement(UpdateQuantityItem2).click();
        driver.findElement(IncreaseQuantity2).click();
        String Carttotal = driver.findElement(CartCount).getText();
        System.out.println(Carttotal);
        Assert.assertEquals("4",Carttotal);  // BUG : It will fail because the cart total doesn't update when you increase Quantity
    }
}
