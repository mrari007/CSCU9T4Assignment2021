package com.stir.cscu9t4assignment2021;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Ref {

	private String title;				//get, set
	private String[] authors;
	private String doi;
	private String publisher;// get, set
	private int pubyear;				//get, set
	protected  Date dateAdded;
	private int day;
	private int month;
	private int year;

	/**
	 *  Constructor
	 * @param title
	 * @param authors
	 * @param doi
	 * @param publisher
	 * @param pubyear
	 */
	public Ref (String title, String []  authors, String doi, String publisher, int pubyear) {
		this.title = title;
		this.authors = authors; 
		this.doi = doi;
		this.publisher = publisher;
		this.pubyear = pubyear;
	}
	
	/**
	 *  Another constructor
	 * @param title
	 * @param authors
	 * @param doi
	 * @param pubyear
	 * @param day
	 * @param month
	 * @param year
	 */
	public Ref (String title, String [] authors, String doi, String publisher, int pubyear, int day, int month, int year ) {
		this.title = title;
		this.authors = authors;
		this.doi = doi;
		this.publisher = publisher;
		this.pubyear = pubyear;
		this.dateAdded = new Date(year - 1900, month - 1, day);
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * 
	 * @param newTitle
	 */
	public void setTitle(String newTitle) {
		this.title = newTitle;
	}
	
	/**
	 * Converts the array of authors into a String
	 * @return
	 */
	public String getAuthors() {
		String result = "";
		for (int i = 0; i < authors.length; i ++) {
			if(i == authors.length - 1) {
				result += authors[i];				//Do not add a comma after the last author
			} else {
			result += authors[i] + ",";
			}
		}
		return result;
	}

	/**
	 * 
	 * @return
	 */
	public String getDoi() {
		return doi;
	}
	
	/**
	 * 
	 * @param newDoi
	 */
	public void setDoi(String newDoi) {
		this.doi = newDoi;
	}

	/**
	 * 
	 * @return
	 */
	public String getPublisher() {
		return publisher;
	}
	
	/**
	 * 
	 * @param newPublisher
	 */
	public void setPublisher(String newPublisher) {
		this.publisher = newPublisher;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getPubYear() {
		return pubyear;
	}
	
	public void setPubYear(int newPubyear) {
		this.pubyear = newPubyear;
	}
	/**
	 * 
	 * @return
	 */
	public String getDateAdded() {
	       String result = "";
	        LocalDate today = LocalDate.now();
	        String todayStr = today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	        if(getDay() == 0 || getMonth() == 0 || getYear() == 0) {
	        	result = todayStr;																						//If the text fields for either day, month or year are blank - sets the result to the current date
	        } else {
		        SimpleDateFormat form = new SimpleDateFormat("dd/MM/yyyy");
		        String dateStr = form.format(dateAdded);
	        	result = dateStr;																						// sets the result to the date specified by the user
	        }
	        return result;
	}
	
	/**
	 * A String representation of the Reference
	 * @return
	 */
	public String getCitation() {

		String result = getAuthors() + " (" + getPubYear() +"), " + getTitle() + ", " + getPublisher() 
				 + ", doi:" + getDoi() + ". Added on: " +getDateAdded() +  "\n";
			return result;

	}
	
	
	/**
	 * Used in the getDateAdded method
	 * @return
	 */
	public int getDay() {
		return day;
	}
	
	/**
	 * 
	 * @param newDay
	 */
	public void setDay(int newDay) {
		this.day = newDay;
	}
	
	/**
	 *  Used in the getDateAdded method
	 * @return
	 */
	public int getMonth() {
		return month;
	}
	
	/**
	 * 
	 * @param newMonth
	 */
	public void setMonth(int newMonth) {
		this.month = newMonth;
	}
	
	/**
	 *  Used in the getDateAdded method
	 * @return
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * 
	 * @param newYear
	 */
	public void setYear(int newYear) {
		this.year = newYear;
	}
	
}
