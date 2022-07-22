package com.build.qa.build.selenium.tests;

import com.build.qa.build.selenium.pageobjects.homepage.CartPage;
import com.build.qa.build.selenium.pageobjects.homepage.CatagoryPage;
import com.build.qa.build.selenium.pageobjects.homepage.ProductPage;
import org.junit.Test;

import com.build.qa.build.selenium.framework.BaseFramework;
import com.build.qa.build.selenium.pageobjects.homepage.HomePage;
//
public class FergTest extends BaseFramework {

	/**
	 * Extremely basic test that outlines some basic
	 * functionality and page objects as well as assertJ
	 */
	@Test
	public void navigateToHomePage() {
		driver.get(getConfiguration("HOMEPAGE"));
		HomePage homePage = new HomePage(driver, wait);

		softly.assertThat(homePage.onHomePage())
			.as("The website should load up with the Ferguson.com desktop theme.")
			.isTrue();
	}

	/**
	 * Search for the Moen m6702bn from the search bar
	 * @assert that the product page shown/displayed is what is expected by checking the product brand and product id
	 * @difficulty Easy
	 */
	@Test
	public void searchForProductLandsOnCorrectProduct() throws InterruptedException {
		driver.get(getConfiguration("HOMEPAGE"));
		ProductPage productPage = new ProductPage(driver,wait);
		productPage.ProductSearch();
	}

	/**
	 * Go to the Bathroom Sinks category directly
	 * (https://www.ferguson.com/category/bathroom-plumbing/bathroom-faucets/bathroom-sink-faucets/_/N-zbq4i3)
	 * and add the second product on the search results (Category Drop) page to the cart.
	 * @assert that the expected product is added to the cart
	 * @difficulty Easy-Medium
	 */
	@Test
	public void addProductToCartFromCategoryDrop() throws InterruptedException {
		CatagoryPage CTPage = new CatagoryPage(driver,wait);
		CTPage.VerifyCatagoryItem();

	}

	/**
	 * Add two different finishes of a product (such as Moen m6702bn) to cart,
	 * change the quantity of each finish on the cart page
	 * @assert that the product and cart total update as expected when the quantity is changed
	 * @difficulty Medium-Hard
	 */
	@Test
	public void addMultipleCartItemsAndChangeQuantity() throws InterruptedException {
		driver.get(getConfiguration("HOMEPAGE"));
		ProductPage productPage = new ProductPage(driver,wait);
		productPage.ProductSearch();
		productPage.Addtocart();
		CartPage cartPage = new CartPage(driver,wait);
		cartPage.CartUpdate();

	}

	/**
	 * Go to a category drop page (such as Bathroom Faucets) and narrow by
	 * at least two filters (facets), e.g: Finish=Chromes and Brand=Brizo
	 * @assert that the correct filters are being narrowed, and the result count
	 * is correct, such that each facet selection is narrowing the product count.
	 * @difficulty Hard
	 */
	@Test
	public void facetNarrowBysResultInCorrectProductCounts() throws InterruptedException {
		CatagoryPage CTpage = new CatagoryPage(driver,wait);
		CTpage.FilterCheck();
	}
}
