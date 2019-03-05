package com.travelocity.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.travelocity.base.MyDriver;
import com.travelocity.pages.HomePage;

/**
 * @author william.bejarano
 *
 */
public class BaseTests {
	
	private MyDriver myDriver;
	private HomePage travelHome;
	
	/**
	 * Inicialización de la suite
	 * @param browser String
	 * @param urlHome String
	 */
	@BeforeSuite(alwaysRun=true)
	@Parameters({"browser", "urlHome"})
	public void beforeSuite(String browser, String urlHome) {
		myDriver = new MyDriver(browser);
		travelHome = new HomePage(myDriver.getDriver(), urlHome);
	}
	
	/**
	 * Finalización de la suite
	 */
	@AfterSuite(alwaysRun=true)
	public void afterSuite() {
		travelHome.dispose();
	}
	
	/**
	 * Retorna la página principal
	 * @return
	 */
	public HomePage getHomePage() {
		return travelHome;
	}

}
