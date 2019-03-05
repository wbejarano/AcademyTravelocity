package com.travelocity.data;

import java.util.Calendar;

import com.travelocity.data.enumdata.Gender;

/**
 * @author william.bejarano
 *
 */
public class Traveler {
	
	private String firstName;
	private String middleName;
	private String lastName;
	private int codCountry;
	private Gender gender;
	private Calendar dateOfBird;
	
	public Traveler() {	
	}
	
	/**
	 * @description return first name
	 * @return String
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @description setting first name
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * @description return middle name
	 * @return String
	 */
	public String getMiddleName() {
		return middleName;
	}
	
	/**
	 * @description setting middle name 
	 * @param middleName
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	/**
	 * @description return last name
	 * @return String
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @description setting last name
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * @description return cod of country
	 * @return
	 */
	public int getCodCountry() {
		return codCountry;
	}
	
	/**
	 * @description setting cod of country
	 * @param codCountry int
	 */
	public void setCodCountry(int codCountry) {
		this.codCountry = codCountry;
	}
	
	/**
	 * @description return gender
	 * @return Enum
	 */
	public Gender getGender() {
		return gender;
	}
	
	/**
	 * @description setting gender
	 * @param gender Gender
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	/**
	 * @description return date of bird
	 * @return Calendar
	 */
	public Calendar getDateOfBird() {
		return dateOfBird;
	}
	
	/**
	 * @description setting 
	 * @param dateOfBird Calendar
	 */
	public void setDateOfBird(Calendar dateOfBird) {
		this.dateOfBird = dateOfBird;
	}

}
