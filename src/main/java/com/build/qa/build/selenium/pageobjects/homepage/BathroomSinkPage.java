package com.build.qa.build.selenium.pageobjects.homepage;

import com.build.qa.build.selenium.pageobjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

public class BathroomSinkPage extends BasePage {



    private By UpdateQuantityItem1;
    private By IncreaseQuantity1;
    private By UpdateQuantityItem2;
    private By IncreaseQuantity2;
    private By CartCount;

    public BathroomSinkPage (WebDriver driver, Wait<WebDriver> wait) {
        super(driver, wait);
        UpdateQuantityItem1 = By.xpath("//*[@id=\"item-datas\"]/li[1]/div[3]/div[3]/div[2]/div[1]/div[1]/div/input");
        IncreaseQuantity1 = By.xpath("//*[@id=\"item-datas\"]/li[1]/div[3]/div[3]/div[2]/div[1]/div[1]/div/div[2]"); //Normally I would find a better locator
        UpdateQuantityItem2 = By.xpath("//*[@id=\"item-datas\"]/li[2]/div[3]/div[3]/div[2]/div[1]/div[1]/div/input");
        IncreaseQuantity2 = By.xpath("//*[@id=\"item-datas\"]/li[2]/div[3]/div[3]/div[2]/div[1]/div[1]/div/div[2]");
        CartCount = By.xpath("//*[@class='shoppingCartAmount']");
    }
}
