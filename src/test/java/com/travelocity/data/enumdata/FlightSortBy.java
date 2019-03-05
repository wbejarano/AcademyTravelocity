package com.travelocity.data.enumdata;

/**
 * @author william.bejarano
 *
 */
public enum FlightSortBy {
	PRICE_ASC("price:asc"),
	PRICE_DESC("price:desc"),
	DURATION_ASC("duration:asc"),
	DURATION_DESC("duration:desc"),
	DEPARTURE_ASC("departuretime:asc"),
	DEPARTURE_DESC("departuretime:desc"),
	ARRIVALTIME_ASC("arrivaltime:asc"),
	ARRIVALTIME_DESC("arrivaltime:desc");
	
	private String value;
	
	/**
	 * @description constructor
	 * @param sort
	 */
	FlightSortBy(String sort) {
		value = sort;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Enum#toString()
	 */
	public String toString() {
		return value;
	}
	
}
