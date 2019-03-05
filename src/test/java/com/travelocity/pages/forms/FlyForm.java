package com.travelocity.pages.forms;

import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.travelocity.data.enumdata.KindOfTrip;
import com.travelocity.data.enumdata.Months;
import com.travelocity.pages.BasePage;
import com.travelocity.pages.ResultsPage;

/**
 * @author william.bejarano
 *
 */
public class FlyForm extends BasePage{

	@FindBy(id = "flight-type-roundtrip-label-hp-flight")
	private WebElement btnFlightRound;

	@FindBy(id = "flight-origin-hp-flight")
	private WebElement txtFlightOrigin;

	@FindBy(id = "flight-destination-hp-flight")
	private WebElement txtFlightDestination;

	@FindBy(id = "flight-departing-hp-flight")
	private WebElement dateFlightDeparture;

	@FindBy(id = "flight-returning-hp-flight")
	private WebElement dateFlightReturning;

	@FindBy(id = "flight-adults-hp-flight")
	private WebElement dDownFlightAdults;

	@FindBy(id = "flight-children-hp-flight")
	private WebElement dDownFlightChild;

	@FindBy(css = "div.cols-nested .col.search-btn-col .btn-primary.btn-action.gcw-submit")
	private WebElement btnSearch;

	@FindBy(css = ".datepicker-paging.datepicker-next.btn-paging.btn-secondary.next")
	private WebElement btnNextMonth;

	public FlyForm(WebDriverWait wait, WebDriver driver) {
		super(driver);
	}
	
	/**
	 * @description select a kind of trip
	 * @param kindOfTrip
	 */
	public void selectKindTrip(KindOfTrip kindOfTrip) {
		
		switch (kindOfTrip) {
		case ROUNDTRIP:
			waitClickable(btnFlightRound);
			btnFlightRound.click();
			break;
		case ONE_WAY:
			break;
		case MULTI_CITY:
			break;
		default:
			break;
		}
		
	}
	
	
	/**
	 * @description fill flight origin field
	 * @param origin String
	 */
	public void fillFlyOrigin(String origin) {
		txtFlightOrigin.click();
		waitClickable(txtFlightOrigin);
		txtFlightOrigin.sendKeys(origin);
	}
	
	/**
	 * @description fill flight destination field
	 * @param destination String
	 */
	public void fillFlyDestination(String destination) {
		txtFlightDestination.click();
		waitClickable(txtFlightDestination);
		txtFlightDestination.sendKeys(destination);
	}
	
	/**
	 * @description fill number of adult to travel field
	 * @param indSelector
	 */
	public void fillAdults(int indSelector) {
		Select dropDownAdult = new Select(dDownFlightAdults);
		dropDownAdult.selectByValue("" + indSelector);
	}
	
	/**
	 * @description fill number of child to travel field
	 * @param indSelector int
	 */
	public void fillChildren(int indSelector) {
		Select dropDownChild = new Select(dDownFlightChild);
		dropDownChild.selectByValue("" + indSelector);
	}
	
	/**
	 * @description fill date to departure field
	 * @param localDate LocalDate
	 */
	public void fillDateDeparture(LocalDate localDate) {
		dateFlightDeparture.click();
		findMonthOnDatePicker(Months.getStringById(localDate.getMonthValue()));
		findDayOnDatePicker(localDate.getDayOfMonth());
	}
	
	/**
	 * @description fill date to return field
	 * @param localDate LocalDate
	 */
	public void fillDateReturning(LocalDate localDate) {
		dateFlightReturning.click();
		findMonthOnDatePicker(Months.getStringById(localDate.getMonthValue()));
		findDayOnDatePicker(localDate.getDayOfMonth());
	}
	
	/**
	 * @description find month on date picker
	 * @param month
	 */
	private void findMonthOnDatePicker(String month) {
		
		boolean found = false;
		while (!found) {
			List<WebElement> linkElements = driver.findElements(By.cssSelector(".datepicker-cal-month-header"));
			if (linkElements.get(0).getText().contains(month)) {
				found = true;
			} else {
				btnNextMonth.click();
			}
		}
	}
	
	/**
	 * @description find a day on date picker
	 * @param day
	 */
	private void findDayOnDatePicker(int day) {
		List<WebElement> linkElements = driver.findElements(By.cssSelector("td button.datepicker-cal-date"));
		for (WebElement webElement : linkElements) {
			if (webElement.getAttribute("data-day").contentEquals("" + day)) {
				webElement.click();
				break;
			}
		}
	}

	/**
	 * @description click on search button and select results page
	 * @return
	 */
	public ResultsPage searchFly() {
		getWait().until(ExpectedConditions.elementToBeClickable(btnSearch));
		btnSearch.click();
		for (String winHandle : driver.getWindowHandles()) {
			System.out.println(winHandle);
			driver.switchTo().window(winHandle);
			break;
		}
		return new ResultsPage(driver);
	}

}
