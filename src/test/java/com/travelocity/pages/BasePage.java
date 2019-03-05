package com.travelocity.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author william.bejarano
 *
 */
public class BasePage {
	protected WebDriver driver;
	private WebDriverWait wait;
	
	/**
	 * @param pDriver
	 */
	public BasePage(WebDriver pDriver) {
		PageFactory.initElements(pDriver, this);
		wait = new WebDriverWait(pDriver, 20);
		driver = pDriver;
	}
	
	/**
	 * Retorna el objeto de espera
	 * @return
	 */
	public WebDriverWait getWait() {
		return wait;
	}
	
	/**
	 * Genera las esperas necesarias de un click
	 * @param element
	 */
	protected void waitClickable(WebElement element) {
		getWait().until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * Devulve driver
	 * @return
	 */
	public WebDriver getDriver() {
		return driver;
	}
	
	/**
	 * Finaliza el driver
	 */
	public void dispose() {
		if(driver != null) {
			driver.quit();
		}
	}
	
	/**
	 * @param id
	 * @return
	 */
	protected boolean existsElementById(String id) {
	    try {
	        driver.findElement(By.id(id));
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	    return true;
	}
	
	/**
	 * @param css
	 * @return
	 */
	protected boolean existsElementByCss(String css) {
	    try {
	        driver.findElement(By.cssSelector(css));
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	    return true;
	}
	
}
