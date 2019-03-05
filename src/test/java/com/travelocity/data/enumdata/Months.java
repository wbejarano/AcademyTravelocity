package com.travelocity.data.enumdata;


/**
 * @author william.bejarano
 *
 */
public enum Months {
	JAN("Jan"), FEB("Feb"), MAR("Mar"), APR("Apr"), 
	MAY("May"), JUN("Jun"), JUL("Jul"), AUG("Aug"), 
	SEP("Sep"), OCT("Oct"), NOV("Nov"), DIC("Dic");
	
	private String month;

	/**
	 * @description constructor
	 * @param month String
	 */
	Months (String month) {
		this.month = month;	
	}
	
	/**
	 * @description return value of Enum
	 * @param id int
	 * @return String
	 */
	public static String getStringById(int id) {
		String month = null;
		
		switch (id) {
		case 1:
			month = JAN.month;
			break;
		case 2:
			month = FEB.month;
			break;
		case 3:
			month = MAR.month;
			break;
		case 4:
			month = APR.month;
			break;
		case 5:
			month = MAY.month;
			break;
		case 6:
			month = JUN.month;
			break;
		case 7:
			month = JUL.month;
			break;
		case 8:
			month = AUG.month;
			break;
		case 9:
			month = SEP.month;
			break;
		case 10:
			month = OCT.month;
			break;
		case 11:
			month = NOV.month;
			break;
		case 12:
			month = DIC.month;
			break;
		default:
			break;
		}
		return month;
	}
}
