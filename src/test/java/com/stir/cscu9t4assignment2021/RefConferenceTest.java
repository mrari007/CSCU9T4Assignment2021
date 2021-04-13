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
public class RefConferenceTest {
    
    public RefConferenceTest() {
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
    public void testRefConferenceWithoutDate() {
    	System.out.println("RefConferenceWithoutDate");
        String title = "Some Conference";
        String authors = "Ed Sheeran, Taylor Swift";
        String[] authorsArr = authors.split(",");
        String doi = "10.123456/9876";
        String publisher = "IEEE";
        String venue = "Wembley";
        String location = "Bath";
        int pubyear = 2002;

        
        RefConference instance = new RefConference(title,venue,authorsArr,doi,publisher,location,pubyear);
        
        assertEquals(title, instance.getTitle());
        assertEquals(authors, instance.getAuthors());
        assertEquals(doi, instance.getDoi());
        assertEquals(pubyear, instance.getPubYear());
        assertEquals(publisher, instance.getPublisher());
        assertEquals(venue, instance.getVenue());    
        assertEquals(location, instance.getLocation());
    }
    
    @Test
    public void testRefConferenceWithDate() {
    	System.out.println("RefConferenceWithDate");
        String title = "Some Conference";
        String authors = "Ed Sheeran, Taylor Swift";
        String[] authorsArr = authors.split(",");
        String doi = "10.123456/9876";
        String publisher = "IEEE";
        String venue = "Wembley";
        String location = "Bath";
        int pubyear = 2002;
        int day = 1;
        int month = 1;
        int year = 2021;
        
        RefConference instance = new RefConference(title,venue,authorsArr,doi,
                publisher,location,pubyear, day, month, year);
        
        assertEquals(title, instance.getTitle());
        assertEquals(authors, instance.getAuthors());
        assertEquals(doi, instance.getDoi());
        assertEquals(pubyear, instance.getPubYear());
        assertEquals(publisher, instance.getPublisher());
        assertEquals(venue, instance.getVenue());    
        assertEquals(location, instance.getLocation());
        assertEquals(day, instance.getDay());
        assertEquals(month, instance.getMonth());
        assertEquals(year, instance.getYear());
    }
    /**
     * Test of getVenue method, of class RefConference.
     */
    @Test
    public void testGetVenue() {
    	System.out.println("getVenue");
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
        
        //Testing constructor with date added
        RefConference instance1 = new RefConference(title,venue,authorsArr,doi,
                publisher,location,pubyear, day, month, year);
        String expResult1 = "Wembley";
        String result1 = instance1.getVenue();
        assertEquals(expResult1, result1);

        //Testing constructor without date
        RefConference instance2 = new RefConference(title,venue,authorsArr,doi,
                                                    publisher,location,pubyear);
        String expResult2 = "Wembley";
        String result2 = instance2.getVenue();
        assertEquals(expResult2, result2);
    }
    
    @Test
    public void testSetVenue() {
    	System.out.println("setVenue");
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
        
        //Testing constructor with date added
        RefConference instance1 = new RefConference(title,venue,authorsArr,doi,
                publisher,location,pubyear, day, month, year);
        instance1.setVenue("Twickenham");
        String expResult1 = "Twickenham";
        String result1 = instance1.getVenue();
        assertEquals(expResult1, result1);

        //Testing constructor without date
        RefConference instance2 = new RefConference(title,venue,authorsArr,doi,
                                                    publisher,location,pubyear);
        instance2.setVenue("Twickenham");
        String expResult2 = "Twickenham";
        String result2 = instance2.getVenue();
        assertEquals(expResult2, result2);
    }

    /**
     * Test of getCitation method, of class RefConference.
     */
    @Test
    public void testGetLocatin() {
    	System.out.println("getLocation");
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
        
        //Testing constructor with date added
        RefConference instance1 = new RefConference(title,venue,authorsArr,doi,
                publisher,location,pubyear, day, month, year);
        String expResult1 = "London";
        String result1 = instance1.getLocation();
        assertEquals(expResult1, result1);

        //Testing constructor without date
        RefConference instance2 = new RefConference(title,venue,authorsArr,doi,
                                                    publisher,location,pubyear);
        String expResult2 = "London";
        String result2 = instance2.getLocation();
        assertEquals(expResult2, result2);
    }
    
    @Test
    public void testSetLocation() {
    	System.out.println("setLocation");
        String title = "Some Conference";
        String authors = "Ed Sheeran, Taylor Swift";
        String[] authorsArr = authors.split(",");
        String doi = "10.123456/9876";
        String publisher = "IEEE";
        String venue = "Wembley";
        String location = "Bath";
        int pubyear = 2002;
        int day = 1;
        int month = 1;
        int year = 2021;
        
        //Testing constructor with date added
        RefConference instance1 = new RefConference(title,venue,authorsArr,doi,
                publisher,location,pubyear, day, month, year);
        instance1.setLocation("Bath");
        String expResult1 = "Bath";
        String result1 = instance1.getLocation();
        assertEquals(expResult1, result1);

        //Testing constructor without date
        RefConference instance2 = new RefConference(title,venue,authorsArr,doi,
                                                    publisher,location,pubyear);
        instance2.setLocation("Bath");
        String expResult2 = "Bath";
        String result2 = instance2.getLocation();
        assertEquals(expResult2, result2);
    }
    
    @Test
    public void testGetCitation() {
    	System.out.println("getCitation");
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
        LocalDate today = LocalDate.now();
        String todayStr = today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
        //Testing constructor with date added
        RefConference instance1 = new RefConference(title,venue,authorsArr,doi,
                publisher,location,pubyear, day, month, year);
        String expResult1 = "Ed Sheeran, Taylor Swift (2002),"
                +" Some Conference, at Wembley(London), IEEE,"
                +" doi:10.123456/9876. Added on: 01/01/2021\n";
        String result1 = instance1.getCitation();
        assertEquals(expResult1, result1);

        //Testing constructor without date
        RefConference instance2 = new RefConference(title,venue,authorsArr,doi,
                                                    publisher,location,pubyear);
        String expResult2 = "Ed Sheeran, Taylor Swift (2002),"
                +" Some Conference, at Wembley(London), IEEE,"
                +" doi:10.123456/9876. Added on: " + todayStr + "\n";
        String result2 = instance2.getCitation();
        assertEquals(expResult2, result2);
    }

    
}
