package com.travelocity.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.travelocity.data.FlightData;
import com.travelocity.data.enumdata.FlightSortBy;

/**
 * @author william.bejarano
 *
 */
public class ResultsPage extends BasePage {

	@FindBy(id = "sortDropdown")
	private WebElement sorterSelector;

	@FindBy(css = "div.uitk-col.standard-col-l-margin.all-col-shrink.display-larger-screens-only button")
	private List<WebElement> lstFly;

	private boolean returnResulst = false;
	
	private static String RETURN_DETAIL = ".toggle-pane.fade.open div:nth-child(1) div:nth-child(1) div:nth-child(2) button:nth-child(3)";
	private static String DEFAULT_DETAIL = ".toggle-pane.fade.open div:nth-child(1) div:nth-child(1) div:nth-child(2) button";
	
	/**
	 * @description constructor
	 * @param pDriver
	 */
	public ResultsPage(WebDriver pDriver) {
		super(pDriver);
	}

	/**
	 * @description wait the page to sort flights
	 */
	public void waitForSort() {
		getWait().until(ExpectedConditions.elementSelectionStateToBe(sorterSelector, false));
	}

	/**
	 * @description Sort list of flights
	 * @param flightSort FlightSortBy
	 */
	public void sortBy(FlightSortBy flightSort) {
		sorterSelector.click();
		Select dropDownSorter = new Select(sorterSelector);
		dropDownSorter.selectByValue(flightSort.toString());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		getWait().until(ExpectedConditions.elementToBeClickable(sorterSelector));
	}

	/**
	 * @description select one option into page and create a
	 * 				summary page if is necessary
	 * @param flightData FlightData
	 * @return ResultsPage
	 */
	public ResultsPage selectResult(FlightData flightData) {
		WebElement confirmButton;
		ResultsPage returnResultPage = null;
		int flightOption = 0;
		String detail;

		if (isReturnResulst()) {
			flightOption = flightData.getFlyOptionReturn();
		} else {
			returnResultPage = new ResultsPage(driver);
			returnResultPage.setReturnResulst(true);
			flightOption = flightData.getFlyOptionDeparture();
		}

		lstFly.stream().limit(lstFly.size()).collect(Collectors.toList()).get(flightOption - 1).click();
		detail = isReturnResulst() ?  RETURN_DETAIL : DEFAULT_DETAIL;
		
		if(existsElementByCss(detail)) {
			confirmButton = driver.findElement(By.cssSelector(detail));
			getWait().until(ExpectedConditions.elementToBeClickable(confirmButton));
			confirmButton.click();
		}
			
		return returnResultPage;
	}

	/**
	 * @description
	 * @return boolean
	 */
	public boolean isReturnResulst() {
		return returnResulst;
	}

	/**
	 * @param returnResulst
	 */
	public void setReturnResulst(boolean returnResulst) {
		this.returnResulst = returnResulst;
	}

	/**
	 * @return
	 */
	public SummaryPage getSumaryPage() {
		return new SummaryPage(driver);
	}

}
