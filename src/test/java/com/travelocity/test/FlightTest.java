package com.travelocity.test;

import org.testng.annotations.Test;

import com.travelocity.data.FlightData;
import com.travelocity.data.TravelForms;
import com.travelocity.data.enumdata.FlightSortBy;
import com.travelocity.pages.BookingPage;
import com.travelocity.pages.HomePage;
import com.travelocity.pages.ResultsPage;
import com.travelocity.pages.SummaryPage;

/**
 * @author william.bejarano
 *
 */
public class FlightTest extends BaseTests{

	/**
	 * Test de diligenciamiento del formulario de vuelos
	 */
	@Test
	public void testTravelocity() {
		
		FlightData flyData = new FlightData();
		HomePage travelHome = getHomePage();
		travelHome.changeToForm(TravelForms.FLIGHTS);
		travelHome.fillFlyForm(flyData);
		ResultsPage resultsPage = travelHome.getResultPage();
		resultsPage.waitForSort();
		resultsPage.sortBy(FlightSortBy.DURATION_ASC);

		ResultsPage flyReturnResults = resultsPage.selectResult(flyData);
		flyReturnResults.waitForSort();
		flyReturnResults.selectResult(flyData);
		
		SummaryPage summaryPage = flyReturnResults.getSumaryPage();
		summaryPage.checkPage(flyData);
		BookingPage bookingPage =  summaryPage.getBooking();
		bookingPage.fillBooking(flyData.getAdultsTravelers());
		
	}
}
