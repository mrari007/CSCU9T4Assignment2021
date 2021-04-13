package com.stir.cscu9t4assignment2021;

import java.util.Date;

public class RefJournal extends Ref{

	private String journal;
	private int volume;
	private int issue;
	
	/**
	 *  Constructor
	 * @param title
	 * @param journal
	 * @param authors
	 * @param doi
	 * @param publisher
	 * @param pubyear
	 * @param volume
	 * @param issue
	 */
	public RefJournal(String title, String journal, String [] authors, String doi, String publisher, int pubyear, int volume, int issue) {
		super(title, authors, doi, publisher, pubyear);
		this.journal = journal;
		this.volume = volume;
		this.issue = issue;
	}
	
	/**
	 * Another constructor
	 * @param title
	 * @param journal
	 * @param authors
	 * @param doi
	 * @param publisher
	 * @param pubyear
	 * @param volume
	 * @param issue
	 * @param day
	 * @param month
	 * @param year
	 */
		public RefJournal(String title, String journal, String[] authors, String doi, String publisher, int pubyear, int volume, int issue, int day, int month, int year) {
			super(title, authors, doi, publisher, pubyear, day, month, year);
			this.journal = journal;
			this.volume = volume;
			this.issue = issue;
			dateAdded = new Date (year - 1900, month - 1, day);
				
	}
		/**
		 * 
		 * @return
		 */
		public String getJournal() {
			return journal;
		}
		
		/**
		 * 
		 * @param journal
		 */
		public void setJournal(String journal) {
			this.journal = journal;
		}
		
		/**
		 * 
		 * @return
		 */
		public int getVolume() {
			return volume;
		}
		
		/**
		 * 
		 * @param volume
		 */
		public void setVolume(int volume) {
			this.volume = volume;
		}
		
		/**
		 * 
		 * @return
		 */
		public int getIssue() {
			return issue;
		}
		
		/**
		 * 
		 * @param issue
		 */
		public void setIssue(int issue) {
			this.issue = issue;
		}
		
		/**
		 * A String representation of the Journal
		 *  Overridden method 
		 */
		public String getCitation() {
			String result = getAuthors() + " (" + getPubYear() +"), " + getTitle() + ". " + getJournal() + ", (vol " + 
					getVolume() + ", iss " +  getIssue() + "), " + getPublisher() + ", doi:" + getDoi() + ". Added on: " +getDateAdded() +  "\n";
			return result;
		}
		
}
