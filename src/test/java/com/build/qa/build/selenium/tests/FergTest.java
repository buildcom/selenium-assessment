package com.build.qa.build.selenium.tests;

import com.build.qa.build.selenium.pageobjects.pages.ProductPage;
import com.build.qa.build.selenium.pageobjects.pages.SearchPage;
import org.junit.Assert;
import org.junit.Test;

import com.build.qa.build.selenium.framework.BaseFramework;
import com.build.qa.build.selenium.pageobjects.pages.HomePage;




import static com.build.qa.build.selenium.CommonMethods.CommonMethods.*;

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
	 *
	 *
	 */
	@Test
	public void searchForProductLandsOnCorrectProduct() {

		driver.get(getConfiguration("HOMEPAGE"));
		HomePage homePage=new HomePage(driver,wait);
		ProductPage productPage=new ProductPage(driver,wait);

		String productBrand="Moen";
		String productId="m6702bn";
		homePage.searchAnItem(productBrand+" "+productId);
		waitPageLoad();

		softly.assertThat(productPage.productBrand.getText().
				equals(productBrand)).as("Product brand is "+productBrand).isTrue();

		softly.assertThat(productPage.productId.getText().contains(productId.toUpperCase()));




	}

	/**
	 * Go to the Bathroom Sinks category directly
	 * (https://www.ferguson.com/category/bathroom-plumbing/bathroom-faucets/bathroom-sink-faucets/_/N-zbq4i3)
	 * and add the second product on the search results (Category Drop) page to the cart.
	 * @assert: the product that is added to the cart is what is expected
	 * @difficulty Easy-Medium
	 * TODO: Completed, PASSED
	 */
	@Test
	public void addProductToCartFromCategoryDrop() {
		driver.get(getConfiguration("BathroomSinks"));
		SearchPage searchPage=new SearchPage(driver,wait);
		ProductPage productPage=new ProductPage(driver,wait);
		softly.assertThat(searchPage.onSearchPage());


		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		waitAndClick(searchPage.BrassTonessCheckBox);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		String nameOfItemClick= searchPage.fItem.getText();

		waitPageLoad();

		waitAndClick(searchPage.fItem);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		String productBrand=productPage.productBrand.getText();
		String itemName=productPage.itemName.getText();

		Assert.assertTrue(nameOfItemClick.equals(productBrand+" "+itemName));
		softly.assertThat(nameOfItemClick.equals(productBrand+" "+itemName));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

	}

	/**
	 * Add two different finishes of a product (such as Moen m6702bn) to cart,
	 * change the quantity of each finish on the cart page
	 * @assert that the product and cart total update as expected when the quantity is changed
	 * @difficulty Medium-Hard
	 *
	 *
	 */
	@Test
	public void addMultipleCartItemsAndChangeQuantity() {
		driver.get(getConfiguration("HOMEPAGE"));
		HomePage homePage=new HomePage(driver,wait);
		ProductPage productPage=new ProductPage(driver,wait);
		homePage.searchAnItem("Minka Aire 8015985");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		waitPageLoad();
		int quantity=1;
		double priceOfItem=getDoubleValue(productPage.priceOfItem.getAttribute("content"));
		waitAndClick(productPage.quantityBtnPlus);
		quantity++;

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		waitAndClick(productPage.addToCart);
		waitPageLoad();
		waitAndClick(productPage.viewCard);
		waitPageLoad();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		double totalPriceAfterQuan=getTotalPrice(productPage.totalPrice$.getText());

		softly.assertThat(totalPriceAfterQuan==priceOfItem *quantity);


	}

	/**
	 * Go to a category drop page (such as Bathroom Faucets) and narrow by
	 * at least two filters (facets), e.g: Finish=Chromes and Brand=Brizo
	 * @assert that the correct filters are being narrowed, and the result count
	 * is correct, such that each facet selection is narrowing the product count.
	 * @difficulty Hard
	 *
	 *
	 */
	@Test
	public void facetNarrowBysResultInCorrectProductCounts() {

		driver.get(getConfiguration("BathroomSinks"));
		SearchPage searchPage=new SearchPage(driver,wait);
		softly.assertThat(searchPage.onSearchPage());

		waitPageLoad();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		waitAndClick(searchPage.brandShowMore);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

		waitAndClick(searchPage.brizoBrand);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		waitAndClick(searchPage.chromesCategory);

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}


		softly.assertThat(searchPage.productCount.getText().startsWith("569"));
		softly.assertThat(searchPage.productCount.getText().startsWith("569"));


		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}

	}
}
