/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stir.cscu9t4assignment2021;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


import java.lang.Number;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author saemundur
 */
public class RefSystemGUI extends JFrame implements ActionListener {
    
    private RefCollection bibliography = new RefCollection();
    
    private String [] types = {"Journals", "Conferences", "Book chapters"}; 	//used in the comboBox for types
    
    private JTextField title = new JTextField(20);
    private JComboBox<String> comboBox = new JComboBox<String>(types);
    private JTextField authors = new JTextField(25);
    private JTextField publicationYear = new JTextField(5);
    private JTextField publisher = new JTextField(7);;
    private JTextField doi = new JTextField(7);
    private JLabel labTitle = new JLabel("Title:");
    private JLabel labTypes = new JLabel(" Publication type:");
    private JLabel labAuthors = new JLabel(" Authors:");
    private JLabel labPublicationYear = new JLabel ("Year of publication:");
    private JLabel labPublisher = new JLabel ("Publisher:");
    private JLabel labDoi = new JLabel (" DOI:");
    
    private JPanel panel = new JPanel();
    private JTextField journalName = new JTextField(8);
    private JTextField journalVolume = new JTextField(4);
    private JTextField journalIssue = new JTextField(4);
    private JLabel labJournalName = new JLabel("Journal name:");
    private JLabel labJournalVolume = new JLabel("Volume:");
    private JLabel labJournalIssue = new JLabel("Issue:");
    

    private JTextField conVenue = new JTextField(8);
    private JTextField conLocation = new JTextField(8);
    private JLabel labConVenue = new JLabel("Conference venue:");
    private JLabel labConLocation = new JLabel("Location:");
    

    private JTextField bookTitle = new JTextField(8);
    private JTextField editorName = new JTextField(8);
    private JLabel labBookTitle = new JLabel("Book title:");
    private JLabel labEditorName = new JLabel("Editor name:");
    
    private JPanel panelDate = new JPanel();
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(5);
    
    private JLabel labDay = new JLabel("Date        day:");
    private JLabel labMonth = new JLabel("month:");
    private JLabel labYear = new JLabel("year:");
    
    private JButton add = new JButton ("Add reference");
    
    private JPanel panelFind = new JPanel();
    private JButton findByJournal = new JButton ("Find all from journal name");
    private JButton findByVenue = new JButton ("Find all from conference venue");
    private JButton findByPublisher = new JButton ("Find all from publisher");
    private JTextField byJournal = new JTextField(8);
    private JTextField byVenue = new JTextField(8);
    private JTextField byPublisher = new JTextField(8);
    
    private JLabel labImport = new JLabel ("Import: ");
    private String [] importTypes = {"Journals only", "Conferences only", "Book chapters only", "All data"};
    private JComboBox<String> importBox = new JComboBox<String>(importTypes);
    private JButton exportB = new JButton ("Export all to:");
    private String [] exportTypes = {".txt", ".xml",};
    private JComboBox<String> exportBox = new JComboBox<String>(exportTypes);
    private JTextArea outputArea = new JTextArea(20, 80);
    

    public static void main(String[] args) {
        RefSystemGUI applic = new RefSystemGUI();
        applic.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    /**
     * Creates the GUI and adds all the privately created text fields, labels, buttons, combo boxes etc.
     */
    public RefSystemGUI() {
        super("Bibliography");
        setLayout(new FlowLayout(FlowLayout.LEFT, 5, 10));
        add(labTitle);
        add(title);
        title.setEditable(true);
        
        add(labTypes);
        add(comboBox);
        comboBox.addActionListener(this);
        comboBox.setEditable(false);
        
        add(labAuthors);
        add(authors);
        authors.setEditable(true);
        
        add(labPublicationYear);
        add(publicationYear);
        publicationYear.setEditable(true);
        
        add(labPublisher);
        add(publisher);
        publisher.setEditable(true);
        
        add(labDoi);
        add(doi);
        doi.setEditable(true);
        
        panel.setPreferredSize(new Dimension(410,90));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT,5,8));
        panel.add(labJournalName);
        panel.add(journalName);
        journalName.setEditable(true);
        panel.add(labJournalVolume);
        panel.add(journalVolume);
        journalVolume.setEditable(true);
        panel.add(labJournalIssue);
        panel.add(journalIssue);
        journalIssue.setEditable(true);
        add(panel);
        

        panel.add(labConVenue);
        panel.add(conVenue);
        conVenue.setEditable(true);
        panel.add(labConLocation);
        panel.add(conLocation);
        conLocation.setEditable(true);
        
        panel.add(labBookTitle);
        panel.add(bookTitle);
        bookTitle.setEditable(true);
        panel.add(labEditorName);
        panel.add(editorName);
        editorName.setEditable(true);
        
        add(add);
        add.addActionListener(this);
        
        panelDate.setPreferredSize(new Dimension(410,30));
        panelDate.setBackground(Color.LIGHT_GRAY);
        panelDate.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelDate.add(labDay);
        panelDate.add(day);
        day.setEditable(true);
        panelDate.add(labMonth);
        panelDate.add(month);
        month.setEditable(true);
        panelDate.add(labYear);
        panelDate.add(year);
        year.setEditable(true);
        add(panelDate);

        
        panelFind.setPreferredSize(new Dimension(410,129));
        panelFind.setBackground(Color.LIGHT_GRAY);
        panelFind.setLayout(new FlowLayout(FlowLayout.LEFT,5,12));
        add(panelFind);
        panelFind.add(findByJournal);
        findByJournal.addActionListener(this);
        panelFind.add(byJournal);
        byJournal.setEditable(true);
        panelFind. add(findByVenue);
        findByVenue.addActionListener(this);
        panelFind.add(byVenue);
        byVenue.setEditable(true);
        panelFind. add(findByPublisher);
        findByPublisher.addActionListener(this);
        panelFind.add(byPublisher);
        byPublisher.setEditable(true);

        add(labImport);
        add(importBox);
        importBox.addActionListener(this);
        importBox.setEditable(false);
        add(exportB);
        exportB.addActionListener(this);
        add(exportBox);
        exportBox.addActionListener(this);
        exportBox.setEditable(false);
        
        
        add(outputArea);
        outputArea.setEditable(false);
        setSize(843, 750);
        setVisible(true);
    }
    
    /**
     * Performs an action based on what element caused the event
     */
    public void actionPerformed(ActionEvent event) {
    	String message = "";
    	
    	if(event.getSource() == comboBox)
    	{

        	String value = comboBox.getSelectedItem().toString();
    		if(value.equalsIgnoreCase("Journals")) {	//disables the text fields which require information for other types than RefJournals
    			journalName.setEnabled(true);
    			journalVolume.setEnabled(true);
    			journalIssue.setEnabled(true);
    			conVenue.setEnabled(false);
    			conLocation.setEnabled(false);
    			bookTitle.setEnabled(false);
    			editorName.setEnabled(false);
    			
    		} else if (value.equalsIgnoreCase("Conferences")) {	//disables the text fields which require information for other types than RefConferences
    			conVenue.setEnabled(true);
    			conLocation.setEnabled(true);
    			journalName.setEnabled(false);
    			journalVolume.setEnabled(false);
    			journalIssue.setEnabled(false);
    			bookTitle.setEnabled(false);
    			editorName.setEnabled(false);
    			
    		} else {		//disables the text fields which require information for other types than RefBookChapters
    			bookTitle.setEnabled(true);
    			editorName.setEnabled(true);
    			journalName.setEnabled(false);
    			journalVolume.setEnabled(false);
    			journalIssue.setEnabled(false);
    			conVenue.setEnabled(false);
    			conLocation.setEnabled(false);
    		}
    		outputArea.setText(message);
    	} 
    	if (event.getSource() == add) {		//do if the event is caused by the add button
    		message = addReference();
        	blank();
    	}

    	if(event.getSource() == findByJournal) { //do if the event is caused by the findByJournal button
    		message = FindByJournal();
    		blank();
    	}
    	
    	if(event.getSource() == findByVenue) {		//do if the event is caused by the findByVenue button
    		message = FindByVenue();
    		blank();
    	}
    	
    	if(event.getSource() == findByPublisher) {	//do if the event is caused by the findByPublisher button
    		message = FindByPublisher();
    		blank();
    	}
    	
    	if(event.getSource() == importBox) {	//do if the event is caused by the importBox combo box
    		message = importManyGUI();
    		blank();
    		
    	}
    	
    	if (event.getSource()== exportB) { 	//do if the event is caused by the exportB button
    		message = exportAllGUI();
    		blank();
    	}
		outputArea.setText(message);			//outputs the message to the outputArea
    	}
    
    /**
     * Adding a citation to the bibliography
     * @return
     */
    public String addReference () {
    	String output = "";
    	String value =  comboBox.getSelectedItem().toString();
    	String titleS = title.getText()	;
    	String authorsS = authors.getText();
    	String [] authorsArr = authorsS.split(";");
    	String pub = publisher.getText()	;
    	String doiS = doi.getText();
    	int yearS = 0;
    	int d = 0;
		int m = 0;
		int y = 0;
    	
    	
    	if (title.getText().isEmpty() ||  authors.getText().isEmpty() || publisher.getText().isEmpty() || doi.getText().isEmpty()) {
    		return "Please provide thorough information in order to add Reference.";
    	} else {	//if complete information is provided
        	try {
        		 yearS = Integer.parseInt(publicationYear.getText());
        	} catch (NumberFormatException e) {
        		 return "Please enter a number for Year of publication.";

        	}
        	
        	Boolean thereIsDate = true;		//checks if there is date
        	if(day.getText().isEmpty() && month.getText().isEmpty() && year.getText().isEmpty()) {
        		thereIsDate = false;
        	} else {
            	try {
            		thereIsDate = true;
            		 d = Integer.parseInt(day.getText());
            		 m = Integer.parseInt(month.getText());
            		 y = Integer.parseInt(year.getText());
            		 if((d >31 || d < 1) || (m > 12 || m < 1) || y < 1) {
            			 return "Please enter a valid number for day/month/year";
            		 } else {
            			 
            		 }
            	} catch (NumberFormatException e) {
            		return "Please enter a number for day/month/year";

            	}
        	}
        	
    		if (value.equalsIgnoreCase("Journals")) {		// if the current value from the comboBox for types is Journals
    			String journalNameS = journalName.getText()	;
        		if (journalName.getText().isEmpty() || journalVolume.getText().isEmpty() || journalIssue.getText().isEmpty()) {
        			output = "Please enter all journal's details";
        		} else {
        			try {
        				int volumeInt = Integer.parseInt(journalVolume.getText());
        				int issueInt = Integer.parseInt(journalIssue.getText());
        				
        				//Creates a RefJournal object with the date provided by the user
        				if(thereIsDate) {
            				RefJournal journalWithDate = new RefJournal(titleS,journalNameS, authorsArr, doiS, pub, yearS, volumeInt, issueInt, d, m, y);
            				bibliography.addCite(journalWithDate);
            				System.out.println(journalWithDate.getCitation());
            				
            				//Creates a RefJournal object with the current day (obtained automatically)
        				} else {
        					RefJournal journalWithoutDate = new RefJournal(titleS,journalNameS, authorsArr, doiS, pub, yearS, volumeInt, issueInt);
        					bibliography.addCite(journalWithoutDate);
        					System.out.println(journalWithoutDate.getCitation());
        					
        				}
        				
        				output = "Journal reference added!";
        				
        			} catch (Exception e) {
        				return "Please enter a number for volume/issue";
        			}
        		}
        		
        	} else if (value.equalsIgnoreCase("Conferences")) {		// if the current value from the comboBox for types is Conferences
        		if (conVenue.getText().isEmpty() || conLocation.getText().isEmpty()) {
        			return "Please enter all conference's details";
        		} else {
        			String conVenueS = conVenue.getText();
        			String conLocationS = conLocation.getText();
        			
        			//Creates a RefConference object with the date provided by the user
        			if(thereIsDate) {
        				RefConference conferenceWithDate = new RefConference(titleS,conVenueS, authorsArr, doiS, pub, conLocationS, yearS, d, m, y);	
        				bibliography.addCite(conferenceWithDate);
        				System.out.println(conferenceWithDate.getCitation());

        				//Creates a RefConference object with the current day (obtained automatically)
    				} else {
    					RefConference conferenceWithoutDate = new RefConference(titleS, conVenueS, authorsArr, doiS, pub, conLocationS, yearS);
    					bibliography.addCite(conferenceWithoutDate);
    					System.out.println(conferenceWithoutDate.getCitation());
    				}
        			output = "Conference reference added!";
        		}
        		
        	} else {	// if the current value from the comboBox for types is Book chapters
        		if (bookTitle.getText().isEmpty() || editorName.getText().isEmpty()) {
        			return "Please enter all book chapter's details";
        		} else {
        			String bookTitleS = bookTitle.getText();
        			String editorNameS = editorName.getText();
        			
        			//Creates a RefBookChapter object with the date provided by the user
        			if(thereIsDate) {
        				RefBookChapter BookChapterWithDate = new RefBookChapter(titleS,bookTitleS, authorsArr, doiS, pub, editorNameS, yearS, d, m, y);
        				bibliography.addCite(BookChapterWithDate);
        				System.out.println(BookChapterWithDate.getCitation());

        				//Creates a RefBookChapter object with the current day (obtained automatically)
    				} else {
    					RefBookChapter BookChapterWithoutDate = new RefBookChapter(titleS,bookTitleS, authorsArr, doiS, pub, editorNameS, yearS);
    					bibliography.addCite(BookChapterWithoutDate);
    					System.out.println(BookChapterWithoutDate.getCitation());
    				}
        			output = "Book chapter added!";
        		}
        	}
    	}
    	//System.out.println(bibliography.getNumberOfRefs("all")); //for testing
    	return output;
    }
    
    /**
     * Finds all journals that have the same journal name as the one specified by the user
     * @return
     */
    public String FindByJournal() {
    	String message = bibliography.lookUpByJournal( byJournal.getText());
    	return message;
    }
    
    /**
     * Finds all conferences that have the same venue as the one specified by the user
     * @return
     */
    public String FindByVenue() {
    	String message = bibliography.lookUpByVenue(byVenue.getText());
    	return message;
    }
    
    /**
     * Finds all references that have the same publisher as the one specified by the user
     * @return
     */
    public String FindByPublisher() {
    	String message = bibliography.lookUpByPublisher( byPublisher.getText());
    	return message;
    }
    
    /**
     * Imports the specified references type to the bibliography based on the importBox combo box current selected element
     * @return
     */
    public String importManyGUI() {
    	String message = bibliography.importMany(importBox.getSelectedItem().toString());
    	System.out.println(bibliography.getNumberOfRefs("al"));
    	return message;
    }
    
    /**
     * exports all the references from the bibliography to a txt file
     * @return
     */
    public String exportAllGUI() {
    	String message = bibliography.exportAll(exportBox.getSelectedItem().toString());
    	return message;
    	}
    
    /**
     *  Clears the TextFields
     */
    public void blank() {
    	title.setText("");
    	authors.setText("");
    	publicationYear.setText("");
    	publisher.setText("");
    	doi.setText("");
    	journalName.setText("");
    	journalVolume.setText("");
    	journalIssue.setText("");    	
    	conVenue.setText("");
    	conLocation.setText("");
    	bookTitle.setText("");
    	editorName.setText("");
    	day.setText("");
    	month.setText("");
    	year.setText("");
    	byJournal.setText("");
    	byVenue.setText("");
    	byPublisher.setText("");
    	
    }
    
    /**
     * Fills the display with information needed for Journals
     * For Testing purposes
     * @param ref
     */
    public void journalFillDisplay(RefJournal ref) {
        title.setText(ref.getTitle());
        authors.setText(ref.getAuthors());
        publicationYear.setText(String.valueOf(ref.getPubYear()));
        publisher.setText(ref.getPublisher());
        doi.setText(ref.getDoi());
        journalName.setText(ref.getJournal());
        journalVolume.setText(String.valueOf(ref.getVolume()));
        journalIssue.setText(String.valueOf(ref.getIssue()));
        day.setText(String.valueOf(ref.getDay()));
        month.setText(String.valueOf(ref.getMonth()));
        year.setText(String.valueOf(ref.getYear()));
        comboBox.setSelectedIndex(0);
        
    }
    
    /**
     * Fills the display with information needed for Conferences
     * For Testing purposes
     * @param ref
     */
    public void conferenceFillDisplay(RefConference ref) {
        title.setText(ref.getTitle());
        authors.setText(ref.getAuthors());
        publicationYear.setText(String.valueOf(ref.getPubYear()));
        publisher.setText(ref.getPublisher());
        doi.setText(ref.getDoi());
        conVenue.setText(ref.getVenue());
        conLocation.setText(ref.getLocation());
        day.setText(String.valueOf(ref.getDay()));
        month.setText(String.valueOf(ref.getMonth()));
        year.setText(String.valueOf(ref.getYear()));
        comboBox.setSelectedIndex(1);
        
    }
    
    /**
     * Fills the display with information needed for Book chapters
     * For Testing purposes
     * @param ref
     */
    public void bookChapterFillDisplay(RefBookChapter ref) {
        title.setText(ref.getTitle());
        authors.setText(ref.getAuthors());
        publicationYear.setText(String.valueOf(ref.getPubYear()));
        publisher.setText(ref.getPublisher());
        doi.setText(ref.getDoi());
        editorName.setText(ref.getEditor());
        bookTitle.setText(ref.getBook());
        day.setText(String.valueOf(ref.getDay()));
        month.setText(String.valueOf(ref.getMonth()));
        year.setText(String.valueOf(ref.getYear()));
        comboBox.setSelectedIndex(2);
        
    }
    
 /**
  * Fills the text fields for the searches
  * For Testing purposes
  * @param journal
  * @param venue
  * @param publisher
  */
    public void findFillFields(String journal, String venue, String publisher ) {
    	byJournal.setText(journal);
    	byVenue.setText(venue);
    	byPublisher.setText(publisher);
        
    }
    
/**
 * Setting the value of the import combo Box
 * For testing purposes
 * @param value
 */
    public void setImportBoxValue(int value) {
    	importBox.setSelectedIndex(value);
        
    }
    }
    
