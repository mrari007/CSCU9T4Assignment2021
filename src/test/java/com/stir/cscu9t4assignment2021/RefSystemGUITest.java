/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stir.cscu9t4assignment2021;

import java.awt.event.ActionEvent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author saemundur
 */
public class RefSystemGUITest {
    
    public RefSystemGUITest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of main method, of class RefSystemGUI.
     * Just tests if the GUI initiates without explicit fail
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        RefSystemGUI.main(args);
    }

    /**
     * Test of actionPerformed method, of class RefSystemGUI.
     * You might want to add an action and a few more test cases with 
     * different actions
     */
    @Test
    public void testActionPerformed() {
        System.out.println("actionPerformed");
        ActionEvent event = null;
        RefSystemGUI instance = new RefSystemGUI();
        
        instance.actionPerformed(event);
    }
    
    @Test
    public void testAddRef(){
        System.out.println("addRef");
        RefSystemGUI instance = new RefSystemGUI();
        System.out.println("getJournal");
        String title = "Some Journal";
        String authors = "Charles Babbage, Alan Turing, Ada Lovelace";
        String[] authorsArr = authors.split(",");
        String doi = "10.123456/9876";
        String publisher = "ACM";
        int pubyear = 2002;
        String journal = "Computing Science History";
        int volume = 2;
        int issue = 2;
        int day = 1;
        int month = 1;
        int year = 2021;
        
        //Testing constructor with date
        RefJournal ref = new RefJournal(title,journal,authorsArr,doi,
                                                     publisher,pubyear, volume, issue, day,month,year);
        instance.journalFillDisplay(ref);
        String expResult = "Journal reference added!";
        assertEquals(expResult,instance.addReference());
    }
    
    @Test
    public void testFindByJournal(){
        System.out.println("FindByJournal");
        RefSystemGUI instance = new RefSystemGUI();
        String title = "Some Journal";
        String authors = "Charles Babbage, Alan Turing, Ada Lovelace";
        String[] authorsArr = authors.split(",");
        String doi = "10.123456/9876";
        String publisher = "ACM";
        int pubyear = 2002;
        String journal = "Computing Science History";
        int volume = 2;
        int issue = 2;
        int day = 1;
        int month = 1;
        int year = 2021;
        
        String journalFind = "Computing Science History";
        String venueFind = "";
        String publisherFind = "";
        //Testing constructor with date
        RefJournal ref = new RefJournal(title,journal,authorsArr,doi,
                                                     publisher,pubyear, volume, issue, day,month,year);
        instance.journalFillDisplay(ref);
        instance.addReference();
        instance.findFillFields(journalFind, venueFind, publisherFind);
        String expResult = "Charles Babbage, Alan Turing, Ada Lovelace (2002), Some Journal."
                +" Computing Science History, (vol 2, iss 2), ACM,"
                +" doi:10.123456/9876. Added on: 01/01/2021\n";
        assertEquals(expResult, instance.FindByJournal());
    }
    
    @Test
    public void testFindByVenue(){
        System.out.println("FindByVenue");
        RefSystemGUI instance = new RefSystemGUI();
        String title = "Some Conference";
        String authors = "Ed Sheeran, Taylor Swift";
        String[] authorsArr = authors.split(",");
        String doi = "10.123456/9876";
        String publisher = "IEEE";
        String venue = "Wembley";
        String location = "London";
        int pubyear = 2002;
        int day = 1;
        int month = 1;
        int year = 2021;
        
        String journalFind = "";
        String venueFind = "Wembley";
        String publisherFind = "";
        RefConference ref = new RefConference(title,venue,authorsArr,doi,
                                                     publisher,location,pubyear,day,month,year);
        
        instance.conferenceFillDisplay(ref);
        instance.addReference();
        instance.findFillFields(journalFind, venueFind, publisherFind);
        String expResult = "Ed Sheeran, Taylor Swift (2002),"
                +" Some Conference, at Wembley(London), IEEE,"
                +" doi:10.123456/9876. Added on: 01/01/2021\n";
        assertEquals(expResult, instance.FindByVenue());
    }
    
    @Test
    public void testFindByPublisher(){
        System.out.println("FindByPublisher");
        RefSystemGUI instance = new RefSystemGUI();
        String title = "Some Book Chapter";
        String book = "Some book about stuff";
        String authors = "Saemi Haraldsson, Ragnheidur Brynjolfsdottir";
        String[] authorsArr = authors.split(",");
        String doi = "10.123456/9876";
        String publisher = "Springer";
        String editor = "Scooby Doo";
        int pubyear = 2002;
        int day = 1;
        int month = 1;
        int year = 2021;
        
        String journalFind = "";
        String venueFind = "";
        String publisherFind = "Springer";
        RefBookChapter ref = new RefBookChapter(title,book,authorsArr,doi,
                                                     publisher,editor,pubyear,day,month,year);
        
        instance.bookChapterFillDisplay(ref);
        instance.addReference();
        instance.findFillFields(journalFind, venueFind, publisherFind);
        String expResult ="Saemi Haraldsson, Ragnheidur Brynjolfsdottir (2002),"
                +" Some Book Chapter, in Some book about stuff, Springer,"
                +" ed: Scooby Doo, doi:10.123456/9876. Added on: 01/01/2021\n";
        assertEquals(expResult, instance.FindByPublisher());
    }
    
    /**
     * Test of blank method by executing it to check if it doesn't throw an exception
     */
    @Test
    public void testBlank() {
        System.out.println("blank");
        RefSystemGUI instance = new RefSystemGUI();
        instance.blank();
    }
 
    
    @Test
    public void testExportAllGUI() {
        System.out.println("ExportAllGUI");
        RefSystemGUI instance = new RefSystemGUI();
        String title = "Some Conference";
        String authors = "Ed Sheeran, Taylor Swift";
        String[] authorsArr = authors.split(",");
        String doi = "10.123456/9876";
        String publisher = "IEEE";
        String venue = "Wembley";
        String location = "London";
        int pubyear = 2002;
        int day = 1;
        int month = 1;
        int year = 2021;

        RefConference ref = new RefConference(title,venue,authorsArr,doi,
                                                     publisher,location,pubyear,day,month,year);
        
        String expResult = "Could not export any data because he bibliography is empty";
        assertEquals(expResult, instance.exportAllGUI());
        
        instance.conferenceFillDisplay(ref);
        instance.addReference();
        String expResult2 = "All the data was written to a txt file!";
        assertEquals(expResult2, instance.exportAllGUI());
    }
    
    @Test
    public void testimportManyGUI() {
        System.out.println("importMany");
        RefSystemGUI instance = new RefSystemGUI();

        instance.setImportBoxValue(0);
        
        String expResult = "Journals data exported to the file";
        assertEquals(expResult, instance.importManyGUI());
        

    
}
}