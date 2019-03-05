package com.travelocity.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.travelocity.data.FlightData;

/**
 * @author william.bejarano
 *
 */
public class SummaryPage extends BasePage {

	@FindBy(css=".section-header-main")
	private WebElement tittle;
	
	@FindBy(css="div.flex-card.flex-tile.details.OD0 div.flex-area-primary .airport.type-300:nth-child(2)")
	private WebElement orignDeparture;
	
	@FindBy(css="div.flex-card.flex-tile.details.OD0 div.flex-area-primary .airport.type-300:last-child")
	private WebElement destinationDeparture;
	
	@FindBy(css="div.flex-card.flex-tile.details.OD1 div.flex-area-primary .airport.type-300:nth-child(2)")
	private WebElement originReturn;
	
	@FindBy(css="div.flex-card.flex-tile.details.OD1 div.flex-area-primary .airport.type-300:last-child")
	private WebElement destinationReturn;
	
	@FindBy(id="bookButton")
	private WebElement bookButton;
	
	@FindBy(className="packagePriceTotal")
	private WebElement price;

	/**
	 * @description constructor
	 * @param pDriver
	 */
	public SummaryPage(WebDriver pDriver) {
		super(pDriver);
		List<Object> tabs = new ArrayList<Object>(pDriver.getWindowHandles());
		System.out.println(tabs.size());
		driver.switchTo().window((String) tabs.get(2));

	}

	/**
	 * @description check if page is ready
	 * @param flyData FlyData
	 */
	public void checkPage(FlightData flyData) {
		getWait().until(ExpectedConditions.textToBePresentInElement(tittle, "Review your trip"));
		Assert.assertEquals(tittle.getText(), "Review your trip");
		Assert.assertTrue(orignDeparture.getText().contains("(" + flyData.getFlyFrom() + ")"));
		Assert.assertTrue(destinationDeparture.getText().contains("(" + flyData.getFlyTo() + ")"));
		Assert.assertTrue(originReturn.getText().contains("(" + flyData.getFlyTo() + ")"));
		Assert.assertTrue(destinationReturn.getText().contains("(" + flyData.getFlyFrom() + ")"));
		bookButton.click();
	}
	
	/**
	 * @description return new bookingPage
	 * @return BookingPage
	 */
	public BookingPage getBooking() {
		return new BookingPage(driver);
	}

}
