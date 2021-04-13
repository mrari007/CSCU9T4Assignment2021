package com.stir.cscu9t4assignment2021;

import java.util.Date;

public class RefBookChapter extends Ref {
	
	private String book;
	private String editor;
	
	/**
	 * Constructor
	 * @param title
	 * @param book
	 * @param authors
	 * @param doi
	 * @param publisher
	 * @param editor
	 * @param pubyear
	 */
	public RefBookChapter(String title, String book, String [] authors, String doi, String publisher, String editor, int pubyear) {
		super(title, authors, doi, publisher, pubyear);
		this.book = book;
		this.editor = editor;
	}
	
	/**
	 * Another constructor
	 * @param title
	 * @param book
	 * @param authors
	 * @param doi
	 * @param publisher
	 * @param editor
	 * @param pubyear
	 * @param day
	 * @param month
	 * @param year
	 */
	public RefBookChapter(String title, String book, String [] authors, String doi, String publisher, String editor, int pubyear, int day, int month, int year) {
		super(title, authors, doi, publisher, pubyear, day, month, year);
		this.book = book;
		this.editor = editor;
		dateAdded = new Date (year - 1900, month - 1, day);
	}

	/**
	 * 
	 * @return
	 */
	public String getBook() {
		return book;
	}

	/**
	 * 
	 * @param book
	 */
	public void setBook(String book) {
		this.book = book;
	}

	public String getEditor() {
		return editor;
	}

	/**
	 * 
	 * @param editor
	 */
	public void setEditor(String editor) {
		this.editor = editor;
	}
	
	/**
	 * A String representation of the Book chapter
	 * Overridden method
	 */
	public String getCitation() {
		String result = getAuthors() + " (" + getPubYear() +"), " + getTitle() + ", in " + getBook() + ", " + 
				getPublisher() + ", ed: " +  getEditor() + ", doi:" + getDoi() + ". Added on: " + getDateAdded() + "\n";;
		return result;
	}


}
