package com.build.qa.build.selenium.tests;

import com.build.qa.build.selenium.CommonMethods.CommonMethods;
import com.build.qa.build.selenium.pageobjects.pages.ProductPage;
import com.build.qa.build.selenium.pageobjects.pages.SearchPage;
import org.junit.Test;

import com.build.qa.build.selenium.framework.BaseFramework;
import com.build.qa.build.selenium.pageobjects.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

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
			.as("The website should load up with the Build.com desktop theme.")
			.isTrue();
	}

	/**
	 * Search for the Moen m6702bn from the search bar
	 * @assert: That the product page we land on is what is expected by checking the product brand and product id
	 * @difficulty Easy
	 */
	@Test
	public void searchForProductLandsOnCorrectProduct() {
		// TODO: Implement this test
		driver.get(getConfiguration("HOMEPAGE"));
		HomePage homePage=new HomePage(driver,wait);

		CommonMethods.sendKey(homePage.search_field, "Moen m6702b");
		CommonMethods.waitAndClick(homePage.searchButton);

		ProductPage productPage=new ProductPage(driver,wait);
		String productBrand="Moen";
		String productId="m6702bn";


		softly.assertThat(productPage.onProductDetailPage()).isTrue();
		softly.assertThat(productPage.productBrand.getText().equals(productBrand));
		softly.assertThat(productPage.productId.getText().equals(productId));



	}

	/**
	 * Go to the Bathroom Sinks category directly
	 * (https://www.ferguson.com/category/bathroom-plumbing/bathroom-faucets/bathroom-sink-faucets/_/N-zbq4i3)
	 * and add the second product on the search results (Category Drop) page to the cart.
	 * @assert: the product that is added to the cart is what is expected
	 * @difficulty Easy-Medium
	 */
	@Test
	public void addProductToCartFromCategoryDrop() {
		driver.get(getConfiguration("BathroomSinks"));
		SearchPage searchPage=new SearchPage(driver,wait);
		softly.assertThat(searchPage.onSearchPage());
		CommonMethods.waitAndClick(searchPage.BrassTonessCheckBox);



		searchPage.firstItem.click();


	}

	/**
	 * Add two different finishes of a product (such as Moen m6702bn) to cart,
	 * change the quantity of each finish on the cart page
	 * @assert that the product and cart total update as expected when the quantity is changed
	 * @difficulty Medium-Hard
	 */
	@Test
	public void addMultipleCartItemsAndChangeQuantity() {
		driver.get(getConfiguration("HOMEPAGE"));
		HomePage homePage=new HomePage(driver,wait);
//		CommonMethods.sendKey(homePage.search_field, "Minka Aire 8015985");
//		homePage.searchButton.click();

		homePage.searchAnItem("Minka Aire 8015985");

		ProductPage productPage=new ProductPage(driver,wait);

		wait.until(ExpectedConditions.elementToBeClickable(productPage.quantityBtnMinus));
		wait.until(ExpectedConditions.elementToBeClickable(productPage.quantityBtnPlus));

		CommonMethods.waitAndClick(productPage.quantityBtnPlus);
		CommonMethods.waitAndClick(productPage.quantityBtnPlus);
		CommonMethods.waitAndClick(productPage.quantityBtnMinus);

		CommonMethods.waitAndClick(productPage.addToCart);

		CommonMethods.waitAndClick(productPage.viewCard);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}


	}

	/**
	 * Go to a category drop page (such as Bathroom Faucets) and narrow by
	 * at least two filters (facets), e.g: Finish=Chromes and Brand=Brizo
	 * @assert that the correct filters are being narrowed, and the result count
	 * is correct, such that each facet selection is narrowing the product count.
	 * @difficulty Hard
	 */
	@Test
	public void facetNarrowBysResultInCorrectProductCounts() {

		driver.get(getConfiguration("BathroomSinks"));
		SearchPage searchPage=new SearchPage(driver,wait);
		softly.assertThat(searchPage.onSearchPage());
		searchPage.brandShowMore.click();


		CommonMethods.waitAndClick(searchPage.brizoBrand);
		CommonMethods.waitAndClick(searchPage.chromesCategory);

		softly.assertThat(searchPage.productCount.getText().startsWith("569"));//sorry for hardCoding.
		softly.assertThat(searchPage.productCount.getText().startsWith("569"));//sorry for hardCoding.

	}
}
