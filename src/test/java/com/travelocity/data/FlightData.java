package com.travelocity.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.travelocity.data.enumdata.Gender;
import com.travelocity.data.enumdata.KindOfTrip;

/**
 * @author william.bejarano
 *
 */
public class FlightData {
	
	private KindOfTrip kindOfTrip;
	private String flyFrom;
	private String flyTo;
	private int daysToDeparture = 0;
	private int daysToReturn = 0;
	private int monthsToDeparture = 0;
	private int monthsToReturn = 0;
	private LocalDate dateToDeparture = null;
	private LocalDate dateToReturn = null;
	private List<Traveler> adultsTravelers;
	private List<Traveler> childrenTravelers;
	private int flyOptionDeparture = 0;
	private int flyOptionReturn = 0;
		
	
	/**
	 * @description constructor 
	 */
	public FlightData() {
		adultsTravelers = new ArrayList<Traveler>();
		childrenTravelers = new ArrayList<Traveler>();
		try {
			init();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @description initialize all variables
	 * @throws ParseException
	 */
	private void init() throws ParseException {
		kindOfTrip = KindOfTrip.ROUNDTRIP;
		flyFrom = "LAS"; 
		flyTo = "LAX";
		monthsToDeparture = 4;
		monthsToReturn = 5;
		flyOptionDeparture = 1;
		flyOptionReturn = 3;
		
		Traveler traveler = new Traveler();
		traveler.setFirstName("William");
		traveler.setMiddleName("Andres");
		traveler.setLastName("Bejarano");
		traveler.setCodCountry(57);
		traveler.setGender(Gender.MALE);
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		format.parse("02-02-1987");
		traveler.setDateOfBird(format.getCalendar());
		addAdultTraveler(traveler);
		
	}

	/**
	 * @description return a kind of trip
	 * @return Enum KindOfTrip
	 */
	public KindOfTrip getKindOfTrip() {
		return kindOfTrip;
	}

	/**
	 * @description setting kind of trip
	 * @param kindOfTrip KindOfTrip
	 */
	public void setKindOfTrip(KindOfTrip kindOfTrip) {
		this.kindOfTrip = kindOfTrip;
	}

	/**
	 * @description return fly origin
	 * @return String
	 */
	public String getFlyFrom() {
		return flyFrom;
	}

	/**
	 * @description setting kind of origin
	 * @param flyFrom
	 */
	public void setFlyFrom(String flyFrom) {
		this.flyFrom = flyFrom;
	}

	/**
	 * @description return fly destination
	 * @return String
	 */
	public String getFlyTo() {
		return flyTo;
	}

	/**
	 * @descripton setting fly destination
	 * @param flyTo String
	 */
	public void setFlyTo(String flyTo) {
		this.flyTo = flyTo;
	}

	/**
	 * @description put adult traveler to trip list
	 * @param pTraveler Traveler
	 */
	public void addAdultTraveler(Traveler pTraveler) {
		adultsTravelers.add(pTraveler);
	}
	
	/**
	 * @description return size of adult travelers of trip
	 * @return
	 */
	public int getNroAdultsTraveler() {
		return adultsTravelers.size();
	}
	
	/**
	 * @description put a child traveler to trip list
	 * @param pTraveler Traveler
	 */
	public void addChildTraveler(Traveler pTraveler) {
		childrenTravelers.add(pTraveler);
	}
	
	/**
	 * @description return number of child traveler
	 * @return int
	 */
	public int getNroChildrenTraveler() {
		return childrenTravelers.size();
	}

	/**
	 * @description return number of day to departure
	 * @return int
	 */
	public int getDaysToDeparture() {
		return daysToDeparture;
	}

	/**
	 * @description setting days to departure
	 * @param daysToDeparture int
	 */
	public void setDaysToDeparture(int daysToDeparture) {
		this.daysToDeparture = daysToDeparture;
	}

	/**
	 * @description return days to return
	 * @return int
	 */
	public int getDaysToReturn() {
		return daysToReturn;
	}

	/**
	 * @description setting days to return 
	 * @param daysToReturn
	 */
	public void setDaysToReturn(int daysToReturn) {
		this.daysToReturn = daysToReturn;
	}

	/**
	 * @description return number of months to departure
	 * @return int
	 */
	public int getMonthsToDeparture() {
		return monthsToDeparture;
	}

	/**
	 * @description setting number of months to departure
	 * @param monthsToDeparture
	 */
	public void setMonthsToDeparture(int monthsToDeparture) {
		this.monthsToDeparture = monthsToDeparture;
	}

	/**
	 * @description return number of months to return
	 * @return int
	 */
	public int getMonthsToReturn() {
		return monthsToReturn;
	}

	/**
	 * @description setting number of months to return
	 * @param monthsToReturn
	 */
	public void setMonthsToReturn(int monthsToReturn) {
		this.monthsToReturn = monthsToReturn;
	}

	/**
	 * @description return date to departure
	 * @return LocalDate 
	 */
	public LocalDate getDateToDeparture() {
		if(dateToDeparture == null) {
			dateToDeparture 
				= LocalDate.now().plusMonths(monthsToDeparture).plusDays(daysToDeparture);
		}
		return dateToDeparture;
	}

	/**
	 * @description setting date to departure
	 * @param dateToDeparture LocalDate
	 */
	public void setDateToDeparture(LocalDate dateToDeparture) {
		this.dateToDeparture = dateToDeparture;
	}

	/**
	 * @description return date to return
	 * @return LocalDate
	 */
	public LocalDate getDateToReturn() {
		if(dateToReturn == null) {
			dateToReturn
			= LocalDate.now().plusMonths(monthsToReturn).plusDays(daysToReturn);
		}
		return dateToReturn;
	}

	/**
	 * @description setting date to returns
	 * @param dateToReturn LocalDate
	 */
	public void setDateToReturn(LocalDate dateToReturn) {
		this.dateToReturn = dateToReturn;
	}

	/**
	 * @description return a list of adults travelers
	 * @return List<Traveler>
	 */
	public List<Traveler> getAdultsTravelers() {
		return adultsTravelers;
	}

	/**
	 * @description setting a list of travelers
	 * @param adultsTravelers List<Traveler>
	 */
	public void setAdultsTravelers(List<Traveler> adultsTravelers) {
		this.adultsTravelers = adultsTravelers;
	}

	/**
	 * @description return a list of child travelers
	 * @return List<Traveler> 
	 */
	public List<Traveler> getChildrenTravelers() {
		return childrenTravelers;
	}

	/**
	 * @description setting children travelers list
	 * @param childrenTravelers List<Traveler>
	 */
	public void setChildrenTravelers(List<Traveler> childrenTravelers) {
		this.childrenTravelers = childrenTravelers;
	}

	/**
	 * @description return selection of results departure
	 * @return int
	 */
	public int getFlyOptionDeparture() {
		return flyOptionDeparture;
	}

	/**
	 * @description setting selection of fly
	 * @param flyOptionDeparture int
	 */
	public void setFlyOptionDeparture(int flyOptionDeparture) {
		this.flyOptionDeparture = flyOptionDeparture;
	}

	/**
	 * @description return selection of fly 
	 * @return int
	 */
	public int getFlyOptionReturn() {
		return flyOptionReturn;
	}

	/**
	 * @description setting fly option to return
	 * @param flyOptionReturn int
	 */
	public void setFlyOptionReturn(int flyOptionReturn) {
		this.flyOptionReturn = flyOptionReturn;
	}
	
}
