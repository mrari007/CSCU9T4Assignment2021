/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stir.cscu9t4assignment2021;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author saemundur
 */
public class RefJournalTest {
    
    public RefJournalTest() {
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

    @Test
    public void testRefJournalWithoutDate() {
        System.out.println("RefJournalWithoutDate");
        String title = "Some Journal";
        String authors = "Charles Babbage, Alan Turing, Ada Lovelace";
        String[] authorsArr = authors.split(",");
        String doi = "10.123456/9876";
        String publisher = "ACM";
        int pubyear = 2002;
        String journal = "Computing Science History";
        int volume = 2;
        int issue = 2;
        
        RefJournal instance = new RefJournal(title,journal,authorsArr,doi,publisher,pubyear,volume, issue);
        
        assertEquals(title, instance.getTitle());
        assertEquals(authors, instance.getAuthors());
        assertEquals(doi, instance.getDoi());
        assertEquals(pubyear, instance.getPubYear());
        assertEquals(publisher, instance.getPublisher());
        assertEquals(journal, instance.getJournal());
        assertEquals(volume, instance.getVolume());    
        assertEquals(issue, instance.getIssue());    
    }
    
    @Test
    public void testRefJournalWithDate() {
        System.out.println("RefJournalWithDate");
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
        RefJournal instance = new RefJournal(title,journal,authorsArr,doi,publisher,pubyear,volume, issue, day,month,year);
        
        assertEquals(title, instance.getTitle());
        assertEquals(authors, instance.getAuthors());
        assertEquals(doi, instance.getDoi());
        assertEquals(pubyear, instance.getPubYear());
        assertEquals(publisher, instance.getPublisher());
        assertEquals(journal, instance.getJournal());
        assertEquals(volume, instance.getVolume());    
        assertEquals(issue, instance.getIssue());    
        assertEquals(day, instance.getDay());
        assertEquals(month, instance.getMonth());
        assertEquals(year, instance.getYear());
    }
    /**
     * Test of getJournal method, of class RefJournal.
     */
    @Test
    public void testGetJournal() {
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
        RefJournal instance1 = new RefJournal(title,journal,authorsArr,doi,
                                                     publisher,pubyear, volume, issue, day,month,year);
        String expResult1 = "Computing Science History";
        String result1 = instance1.getJournal();
        assertEquals(expResult1, result1);
        
        //Testing constructor without date
        RefJournal instance2 = new RefJournal(title,journal,authorsArr,doi,
                publisher,pubyear,volume, issue);
        String expResult2 = "Computing Science History";
        String result2 = instance2.getJournal();
        assertEquals(expResult2, result2);
        
    }
    
    @Test
    public void testSetJournal() {
        System.out.println("setJournal");
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
        RefJournal instance1 = new RefJournal(title,journal,authorsArr,doi,
                                                     publisher,pubyear, volume, issue, day,month,year);
        instance1.setJournal("Another Journal");
        String expResult1 = "Another Journal";
        String result1 = instance1.getJournal();
        assertEquals(expResult1, result1);
        
        //Testing constructor without date
        RefJournal instance2 = new RefJournal(title,journal,authorsArr,doi,
                publisher,pubyear,volume, issue);
        instance2.setJournal("Another Journal");
        String expResult2 = "Another Journal";
        String result2 = instance2.getJournal();
        assertEquals(expResult2, result2);
        
    }
    
    @Test
    public void testGetVolume() {
        System.out.println("getVolume");
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
        RefJournal instance1 = new RefJournal(title,journal,authorsArr,doi,
                                                     publisher,pubyear, volume, issue, day,month,year);
        int expResult1 = 2;
        int result1 = instance1.getVolume();
        assertEquals(expResult1, result1);
        
        //Testing constructor without date
        RefJournal instance2 = new RefJournal(title,journal,authorsArr,doi,
                publisher,pubyear,volume, issue);
        int expResult2 = 2;
        int result2 = instance2.getVolume();
        assertEquals(expResult2, result2);
        
    }
    
    @Test
    public void testSetVolume() {
        System.out.println("setJournal");
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
        RefJournal instance1 = new RefJournal(title,journal,authorsArr,doi,
                                                     publisher,pubyear, volume, issue, day,month,year);
        instance1.setVolume(3);
        int expResult1 = 3;
        int result1 = instance1.getVolume();
        assertEquals(expResult1, result1);
        
        //Testing constructor without date
        RefJournal instance2 = new RefJournal(title,journal,authorsArr,doi,
                publisher,pubyear,volume, issue);
        instance2.setVolume(3);
        int expResult2 = 3;
        int result2 = instance2.getVolume();
        assertEquals(expResult2, result2);
        
    }
    
    @Test
    public void testGetIssuee() {
        System.out.println("getIssue");
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
        RefJournal instance1 = new RefJournal(title,journal,authorsArr,doi,
                                                     publisher,pubyear, volume, issue, day,month,year);
        int expResult1 = 2;
        int result1 = instance1.getIssue();
        assertEquals(expResult1, result1);
        
        //Testing constructor without date
        RefJournal instance2 = new RefJournal(title,journal,authorsArr,doi,
                publisher,pubyear,volume, issue);
        int expResult2 = 2;
        int result2 = instance2.getIssue();
        assertEquals(expResult2, result2);
        
    }
    
    @Test
    public void testSetIssue() {
        System.out.println("setJournal");
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
        RefJournal instance1 = new RefJournal(title,journal,authorsArr,doi,
                                                     publisher,pubyear, volume, issue, day,month,year);
        instance1.setIssue(3);
        int expResult1 = 3;
        int result1 = instance1.getIssue();
        assertEquals(expResult1, result1);
        
        //Testing constructor without date
        RefJournal instance2 = new RefJournal(title,journal,authorsArr,doi,
                publisher,pubyear,volume, issue);
        instance2.setIssue(3);
        int expResult2 = 3;
        int result2 = instance2.getIssue();
        assertEquals(expResult2, result2);
        
    }

    /**
     * Test of getCitation method, of class RefJournal.
     */
    @Test
    public void testGetCitation() {
        System.out.println("getCitation");
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
        LocalDate today = LocalDate.now();
        String todayStr = today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
        //Testing constructor with date
        RefJournal instance1 = new RefJournal(title,journal,authorsArr,doi,
                                                     publisher,pubyear, volume, issue, day,month,year);
        String expResult1 = "Charles Babbage, Alan Turing, Ada Lovelace (2002), Some Journal."
                           +" Computing Science History, (vol 2, iss 2), ACM,"
                            +" doi:10.123456/9876. Added on: 01/01/2021\n";
        String result1 = instance1.getCitation();
        assertEquals(expResult1, result1);
        
        //Testing constructor without date
        RefJournal instance2 = new RefJournal(title,journal,authorsArr,doi,
                publisher,pubyear,volume, issue);
        String expResult2 = "Charles Babbage, Alan Turing, Ada Lovelace (2002), Some Journal."
                +" Computing Science History, (vol 2, iss 2), ACM,"
                 +" doi:10.123456/9876. Added on: " + todayStr + "\n";
        String result2 = instance2.getCitation();
        assertEquals(expResult2, result2);
        
    }
    
}
