package com.travelocity.base;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


/**
 * @author william.bejarano
 *
 */
public class MyDriver {

	private WebDriver driver;
	
	/**
	 * @param browser
	 */
	public MyDriver(String browser) {
		switch (browser) {
			case "remoteFirefox":
				try {
					driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.firefox());
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			case "firefox":
				driver = new FirefoxDriver();
				break;
			case "chrome":
				System.setProperty("webdriver.chrome.driver", "/Users/william.bejarano/Documents/chromedriver/chromedriver.exe");
				driver = new ChromeDriver();
				break;
			default:
				break;
		}
	}

	/**
	 * @description Return main webDriver 
	 * @return WebDriver 
	 */
	public WebDriver getDriver() {
		return this.driver;
	}
	
}
