package com.travelocity.pages;

import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.travelocity.data.Traveler;
import com.travelocity.data.enumdata.Gender;

/**
 * @author william.bejarano
 *
 */
public class BookingPage extends BasePage{

	@FindBy(id="firstname[0]")
	private WebElement firstName;
	
	@FindBy(id="middlename[0]")
	private WebElement middleName;
	
	@FindBy(id="lastname[0]")
	private WebElement lastName;
	
	@FindBy(id="country_code[0]")
	private WebElement listCountries;
	
	@FindBy(id="gender_male[0]")
	private WebElement maleRadioButton;
	
	@FindBy(id="gender_female[0]")
	private WebElement femaleRadioButton;
	
	@FindBy(id="date_of_birth_year[0]")
	private WebElement listYearBirth;
	
	@FindBy(id="date_of_birth_month0")
	private WebElement listMonthBirth;
	
	@FindBy(id="date_of_birth_day[0]")
	private WebElement listDayBirth;
	
	private Select selects;
	
	/**
	 * @description constructor
	 * @param pDriver
	 */
	public BookingPage(WebDriver pDriver) {
		super(pDriver);
	}
	
	/**
	 * @description setting first name field
	 * @param name String
	 */
	public void setFirstName(String name) {
		firstName.sendKeys(name);
	}
	
	/**
	 * @description setting middle name field
	 * @param midlename String
	 */
	public void setMiddleName(String middlename) {
		middleName.sendKeys(middlename);
	}
	
	/**
	 * @description setting last name field
	 * @param lastname String
	 */
	public void setLastName(String lastname) {
		lastName.sendKeys(lastname);
	}
	
	/**
	 * @description setting country phone code
	 * @param countryCode int
	 */
	public void setCountry(int countryCode) {
		selects = new Select(listCountries);
		selects.selectByValue(countryCode + "");
	}
	
	/**
	 * @description select a gender
	 * @param gender Gender
	 */
	public void selectGender(Gender gender) {
		switch (gender) {
		case MALE:
			maleRadioButton.click();
			break;
		case FEMALE:
			femaleRadioButton.click();
		default:
			break;
		}
	}
	
	/**
	 * @description select year of birth field
	 * @param year String
	 */
	public void selectYearBirth(String year) {
		selects = new Select(listYearBirth);
		selects.selectByValue(year);
	}
	
	/**
	 * @description select month of bird field
	 * @param month
	 */
	public void selectMonthBirth(String month) {
		selects = new Select(listMonthBirth);
		selects.selectByValue(month);
	}
	
	/**
	 * @description select day of bird field
	 * @param day
	 */
	public void selectDayBirth(String day) {
		selects = new Select(listDayBirth);
		selects.selectByValue(day);
	}

	/**
	 * @description fill all booking form
	 * @param adultsTravelers List<Traveler>
	 */
	public void fillBooking(List<Traveler> adultsTravelers) {
		
		for (Traveler traveler : adultsTravelers) {
			String monthFormated = String.format("%02d", traveler.getDateOfBird().get(Calendar.MONTH));
			String dayFormated = String.format("%02d", traveler.getDateOfBird().get(Calendar.DAY_OF_MONTH));
			
			setFirstName(traveler.getFirstName());
			setMiddleName(traveler.getMiddleName() == null ? "": traveler.getMiddleName());
			setLastName(traveler.getLastName());
			setCountry(traveler.getCodCountry());
			selectGender(traveler.getGender());
			selectYearBirth(traveler.getDateOfBird().get(Calendar.YEAR) + "");
			selectMonthBirth(monthFormated);
			selectDayBirth(dayFormated);
		}
	}
	
}
