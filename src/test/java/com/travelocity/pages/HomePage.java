package com.travelocity.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.travelocity.data.FlightData;
import com.travelocity.data.TravelForms;
import com.travelocity.pages.forms.FlyForm;
import com.travelocity.pages.ResultsPage;

/**
 * @author william.bejarano
 *
 */
public class HomePage extends BasePage {

	@FindBy(id = "tab-flight-tab-hp")
	private WebElement btnFlight;

	private FlyForm flyForm;
	private ResultsPage resultPage;
	
	public HomePage(WebDriver pDriver, String urlHome) {
		super(pDriver);
		driver.get(urlHome);
		driver.manage().window().maximize();
	}

	/**
	 * Select some form to fill
	 */
	public void changeToForm(TravelForms form) {
		switch (form) {
		case FLIGHTS:
			btnFlight.click();
			flyForm = new FlyForm(getWait(), driver);
			getWait().until(ExpectedConditions.elementToBeClickable(btnFlight));
			break;
		case HOTELS:
			break;
		case PACKAGES:
			break;
		case CARS:
			break;
		case CRUISES:
			break;
		case ACTIVITIES:
			break;
		default:
			break;
		}
	}

	/**
	 * @description fill fly form
	 * @param flyData
	 */
	public void fillFlyForm(FlightData flyData) {
		
		flyForm.selectKindTrip(flyData.getKindOfTrip());
		flyForm.fillFlyOrigin(flyData.getFlyFrom());
		flyForm.fillFlyDestination(flyData.getFlyTo());
		flyForm.fillDateDeparture(flyData.getDateToDeparture());
		flyForm.fillDateReturning(flyData.getDateToReturn());
		flyForm.fillAdults(flyData.getNroAdultsTraveler());
		flyForm.fillChildren(flyData.getNroChildrenTraveler());
		resultPage = flyForm.searchFly();
		
	}

	/**
	 * @description return a new ResultPage object
	 * @return ResultsPage
	 */
	public ResultsPage getResultPage() {
		return this.resultPage;
	}
}
