package com.stir.cscu9t4assignment2021;

import java.util.Date;

public class RefConference extends Ref {
	private String venue;
	private String location;
	
	/**
	 * Constructor
	 * @param title
	 * @param venue
	 * @param authors
	 * @param doi
	 * @param publisher
	 * @param location
	 * @param pubyear
	 */
	public RefConference(String title, String venue, String [] authors, String doi, String publisher, String location, int pubyear) {
		super(title, authors, doi, publisher, pubyear);
		this.venue = venue;
		this.location = location;
	}
	
	/**
	 * Another constructor
	 * @param title
	 * @param venue
	 * @param authors
	 * @param doi
	 * @param publisher
	 * @param location
	 * @param pubyear
	 * @param day
	 * @param month
	 * @param year
	 */
	public RefConference(String title, String venue, String [] authors, String doi, String publisher, String location, int pubyear, int day, int month, int year) {
		super(title, authors, doi, publisher, pubyear, day, month, year);
		this.venue = venue;
		this.location = location;
		dateAdded = new Date (year - 1900, month - 1, day);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getVenue() {
		return venue;
	}

	/**
	 * 
	 * @param venue
	 */
	public void setVenue(String venue) {
		this.venue = venue;
	}

	/**
	 * 
	 * @return
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * 
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * A String representation of the Conference
	 * @return
	 */
	public String getCitation()
	{
		String result = getAuthors() + " (" + getPubYear() +"), " + getTitle() + ", at " + getVenue() + "(" + 
				getLocation() + "), " +  getPublisher() + ", doi:" + getDoi() + ". Added on: " + getDateAdded() + "\n";
		return result;
	}
	
}
