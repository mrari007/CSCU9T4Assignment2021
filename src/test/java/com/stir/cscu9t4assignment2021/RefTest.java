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
public class RefTest {
    
    public RefTest() {
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
    public void testRefWithoutDate() {
    	 System.out.println("RefWithoutDate");
         String title = "Some Ref";
         String authors = "Albert Einstein, Isaac Newton, Galileo Galilei";
         String[] authorsArr = authors.split(",");
         String doi = "10.123456/9876";
         String publisher = "ACM";
         int pubyear = 2002;
         Ref instance = new Ref(title,authorsArr,doi,publisher,pubyear);
         
         assertEquals(title, instance.getTitle());
         assertEquals(authors, instance.getAuthors());
         assertEquals(doi, instance.getDoi());
         assertEquals(pubyear, instance.getPubYear());
         assertEquals(publisher, instance.getPublisher());


    }
    
    @Test
    public void testRefWithDate() {
    	 System.out.println("RefWithoutDate");
         String title = "Some Ref";
         String authors = "Albert Einstein, Isaac Newton, Galileo Galilei";
         String[] authorsArr = authors.split(",");
         String doi = "10.123456/9876";
         String publisher = "ACM";
         int pubyear = 2002;
         int day = 1;
         int month = 1;
         int year = 2021;
         Ref instance = new Ref(title,authorsArr,doi,publisher,pubyear, day,month,year);
         
         assertEquals(title, instance.getTitle());
         assertEquals(authors, instance.getAuthors());
         assertEquals(doi, instance.getDoi());
         assertEquals(pubyear, instance.getPubYear());
         assertEquals(publisher, instance.getPublisher());
         assertEquals(day, instance.getDay());
         assertEquals(month, instance.getMonth());
         assertEquals(year, instance.getYear());


    }

    /**
     * Test of getTitle method, of class Ref.
     */
    @Test
    public void testGetTitle() {
    	 System.out.println("getTitle");
         String title = "Some Ref";
         String authors = "Albert Einstein, Isaac Newton, Galileo Galilei";
         String[] authorsArr = authors.split(",");
         String doi = "10.123456/9876";
         String publisher = "ACM";
         int pubyear = 2002;
         int day = 1;
         int month = 1;
         int year = 2021;
         
         //Testing constructor with date
         Ref instance1 = new Ref(title,authorsArr,doi,publisher,pubyear, day,month,year);
         String expResult1 = "Some Ref";
         String result1 = instance1.getTitle();
         assertEquals(expResult1, result1);
         
         //Testing constructor without date
         Ref instance2 = new Ref(title,authorsArr,doi,publisher,pubyear);
         String expResult2 = "Some Ref";
         String result2 = instance2.getTitle();
         assertEquals(expResult2, result2);
    }
    
    @Test
    public void testSetTitle() {
    	 System.out.println("setTitle");
         String title = "Some Ref";
         String authors = "Albert Einstein, Isaac Newton, Galileo Galilei";
         String[] authorsArr = authors.split(",");
         String doi = "10.123456/9876";
         String publisher = "ACM";
         int pubyear = 2002;
         int day = 1;
         int month = 1;
         int year = 2021;
         
         //Testing constructor with date
         Ref instance1 = new Ref(title,authorsArr,doi,publisher,pubyear, day,month,year);
         instance1.setTitle("Another Ref");
         String expResult1 = "Another Ref";
         String result1 = instance1.getTitle();
         assertEquals(expResult1, result1);
         
         //Testing constructor without date
         Ref instance2 = new Ref(title,authorsArr,doi,publisher,pubyear);
         instance2.setTitle("Another Ref");
         String expResult2 = "Another Ref";
         String result2 = instance2.getTitle();
         assertEquals(expResult2, result2);
    }
    

    /**
     * Test of getAuthors method, of class Ref.
     */
    @Test
    public void testGetAuthors() {
   	 System.out.println("getAuthors");
        String title = "Some Ref";
        String authors = "Albert Einstein, Isaac Newton, Galileo Galilei";
        String[] authorsArr = authors.split(",");
        String doi = "10.123456/9876";
        String publisher = "ACM";
        int pubyear = 2002;
        int day = 1;
        int month = 1;
        int year = 2021;
        
        //Testing constructor with date
        Ref instance1 = new Ref(title,authorsArr,doi,publisher,pubyear, day,month,year);
        String expResult1 = "Albert Einstein, Isaac Newton, Galileo Galilei";
        String result1 = instance1.getAuthors();
        assertEquals(expResult1, result1);
        
        //Testing constructor without date
        Ref instance2 = new Ref(title,authorsArr,doi,publisher,pubyear);
        String expResult2 = "Albert Einstein, Isaac Newton, Galileo Galilei";
        String result2 = instance2.getAuthors();
        assertEquals(expResult2, result2);
        
   }

    /**
     * Test of getPubYear method, of class Ref.
     */
    @Test
    public void testGetPubYear() {
      	 System.out.println("getPubYear");
         String title = "Some Ref";
         String authors = "Albert Einstein, Isaac Newton, Galileo Galilei";
         String[] authorsArr = authors.split(",");
         String doi = "10.123456/9876";
         String publisher = "ACM";
         int pubyear = 2002;
         int day = 1;
         int month = 1;
         int year = 2021;
         
         //Testing constructor with date
         Ref instance1 = new Ref(title,authorsArr,doi,publisher,pubyear, day,month,year);
         int expResult1 = 2002;
         int result1 = instance1.getPubYear();
         assertEquals(expResult1, result1);
         
         //Testing constructor without date
         Ref instance2 = new Ref(title,authorsArr,doi,publisher,pubyear);
         int expResult2 = 2002;
         int result2 = instance2.getPubYear();
         assertEquals(expResult2, result2);
    }

    /**
     * Test of getPublisher method, of class Ref.
     */
    @Test
    public void testGetPublisher() {
    	 System.out.println("getPublisher");
         String title = "Some Ref";
         String authors = "Albert Einstein, Isaac Newton, Galileo Galilei";
         String[] authorsArr = authors.split(",");
         String doi = "10.123456/9876";
         String publisher = "ACM";
         int pubyear = 2002;
         int day = 1;
         int month = 1;
         int year = 2021;
         
         //Testing constructor with date
         Ref instance1 = new Ref(title,authorsArr,doi,publisher,pubyear, day,month,year);
         String expResult1 = "ACM";
         String result1 = instance1.getPublisher();
         assertEquals(expResult1, result1);
         
         //Testing constructor without date
         Ref instance2 = new Ref(title,authorsArr,doi,publisher,pubyear);
         String expResult2 = "ACM";
         String result2 = instance2.getPublisher();
         assertEquals(expResult2, result2);
    }
    
    @Test
    public void testSetPublisher() {
      	 System.out.println("setDoi");
           String title = "Some Ref";
           String authors = "Albert Einstein, Isaac Newton, Galileo Galilei";
           String[] authorsArr = authors.split(",");
           String doi = "10.123456/9876";
           String publisher = "ACM";
           int pubyear = 2002;
           int day = 1;
           int month = 1;
           int year = 2021;
           
           //Testing constructor with date
           Ref instance1 = new Ref(title,authorsArr,doi,publisher,pubyear, day,month,year);
           instance1.setPublisher("Springer");
           String expResult1 = "Springer";
           String result1 = instance1.getPublisher();
           assertEquals(expResult1, result1);
           
           //Testing constructor without date
           Ref instance2 = new Ref(title,authorsArr,doi,publisher,pubyear);
           instance2.setPublisher("Springer");
           String expResult2 = "Springer";
           String result2 = instance2.getPublisher();
           assertEquals(expResult2, result2);
      }

    /**
     * Test of getDoi method, of class Ref.
     */
    @Test
    public void testGetDoi() {
   	 System.out.println("getDOI");
     String title = "Some Ref";
     String authors = "Albert Einstein, Isaac Newton, Galileo Galilei";
     String[] authorsArr = authors.split(",");
     String doi = "10.123456/9876";
     String publisher = "ACM";
     int pubyear = 2002;
     int day = 1;
     int month = 1;
     int year = 2021;
     
     //Testing constructor with date
     Ref instance1 = new Ref(title,authorsArr,doi,publisher,pubyear, day,month,year);
     String expResult1 = "10.123456/9876";
     String result1 = instance1.getDoi();
     assertEquals(expResult1, result1);
     
     //Testing constructor without date
     Ref instance2 = new Ref(title,authorsArr,doi,publisher,pubyear);
     String expResult2 = "10.123456/9876";
     String result2 = instance2.getDoi();
     assertEquals(expResult2, result2);
    }
    
    @Test
    public void testSetDoi() {
   	 System.out.println("setDoi");
        String title = "Some Ref";
        String authors = "Albert Einstein, Isaac Newton, Galileo Galilei";
        String[] authorsArr = authors.split(",");
        String doi = "10.123456/9876";
        String publisher = "ACM";
        int pubyear = 2002;
        int day = 1;
        int month = 1;
        int year = 2021;
        
        //Testing constructor with date
        Ref instance1 = new Ref(title,authorsArr,doi,publisher,pubyear, day,month,year);
        instance1.setDoi("123123.56/5656");
        String expResult1 = "123123.56/5656";
        String result1 = instance1.getDoi();
        assertEquals(expResult1, result1);
        
        //Testing constructor without date
        Ref instance2 = new Ref(title,authorsArr,doi,publisher,pubyear);
        instance2.setDoi("123123.56/5656");
        String expResult2 = "123123.56/5656";
        String result2 = instance2.getDoi();
        assertEquals(expResult2, result2);
   }

    /**
     * Test of getDateAdded method, of class Ref.
     */
    @Test
    public void testGetDateAdded() {
      	 System.out.println("getDOI");
         String title = "Some Ref";
         String authors = "Albert Einstein, Isaac Newton, Galileo Galilei";
         String[] authorsArr = authors.split(",");
         String doi = "10.123456/9876";
         String publisher = "ACM";
         int pubyear = 2002;
         int day = 1;
         int month = 1;
         int year = 2021;

         LocalDate today = LocalDate.now();
         String todayStr = today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
         
         //Testing constructor with date
         Ref instance1 = new Ref(title,authorsArr,doi,publisher,pubyear, day,month,year);
         String expResult1 = "01/01/2021";
         String result1 = instance1.getDateAdded();
         assertEquals(expResult1, result1);
         
         //Testing constructor without date
         Ref instance2 = new Ref(title,authorsArr,doi,publisher,pubyear);
         String expResult2 = todayStr;
         String result2 = instance2.getDateAdded();
         assertEquals(expResult2, result2);
    }

    /**
     * Test of getCitation method, of class Ref.
     */
    @Test
    public void testGetCitation() {
     	 System.out.println("getDOI");
         String title = "Some Ref";
         String authors = "Albert Einstein, Isaac Newton, Galileo Galilei";
         String[] authorsArr = authors.split(",");
         String doi = "10.123456/9876";
         String publisher = "ACM";
         int pubyear = 2002;
         int day = 1;
         int month = 1;
         int year = 2021;

         LocalDate today = LocalDate.now();
         String todayStr = today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
         
         //Testing constructor with date
         Ref instance1 = new Ref(title,authorsArr,doi,publisher,pubyear, day,month,year);
         String expResult1 = "Albert Einstein, Isaac Newton, Galileo Galilei (2002), Some Ref, ACM,"
        		 					+ " doi:10.123456/9876. Added on: 01/01/2021\n";
         String result1 = instance1.getCitation();
         assertEquals(expResult1, result1);
         
         //Testing constructor without date
         Ref instance2 = new Ref(title,authorsArr,doi,publisher,pubyear);
         String expResult2 = "Albert Einstein, Isaac Newton, Galileo Galilei (2002), Some Ref, ACM,"
					+ " doi:10.123456/9876. Added on: " + todayStr + "\n";
         String result2 = instance2.getCitation();
         assertEquals(expResult2, result2);
    }
    
    @Test
    public void testGetDay() {
      	 System.out.println("getDay");
         String title = "Some Ref";
         String authors = "Albert Einstein, Isaac Newton, Galileo Galilei";
         String[] authorsArr = authors.split(",");
         String doi = "10.123456/9876";
         String publisher = "ACM";
         int pubyear = 2002;
         int day = 1;
         int month = 1;
         int year = 2021;

         
         Ref instance = new Ref(title,authorsArr,doi,publisher,pubyear, day,month,year);
         int expResult = 1;
         int result = instance.getDay();
         assertEquals(expResult, result);
    }
    
    @Test
    public void testSetDay() {
      	 System.out.println("setDay");
         String title = "Some Ref";
         String authors = "Albert Einstein, Isaac Newton, Galileo Galilei";
         String[] authorsArr = authors.split(",");
         String doi = "10.123456/9876";
         String publisher = "ACM";
         int pubyear = 2002;
         int day = 1;
         int month = 1;
         int year = 2021;

         
         Ref instance = new Ref(title,authorsArr,doi,publisher,pubyear, day,month,year);
         instance.setDay(15);
         int expResult = 15;
         int result = instance.getDay();
         assertEquals(expResult, result);
    
    }
    
    @Test
    public void testGetMonth() {
      	 System.out.println("getMonth");
         String title = "Some Ref";
         String authors = "Albert Einstein, Isaac Newton, Galileo Galilei";
         String[] authorsArr = authors.split(",");
         String doi = "10.123456/9876";
         String publisher = "ACM";
         int pubyear = 2002;
         int day = 1;
         int month = 1;
         int year = 2021;

         
         Ref instance = new Ref(title,authorsArr,doi,publisher,pubyear, day,month,year);
         int expResult = 1;
         int result = instance.getMonth();
         assertEquals(expResult, result);
    
    }
    
    @Test
    public void testSetMonth() {
      	 System.out.println("setMonth");
         String title = "Some Ref";
         String authors = "Albert Einstein, Isaac Newton, Galileo Galilei";
         String[] authorsArr = authors.split(",");
         String doi = "10.123456/9876";
         String publisher = "ACM";
         int pubyear = 2002;
         int day = 1;
         int month = 1;
         int year = 2021;

         
         Ref instance = new Ref(title,authorsArr,doi,publisher,pubyear, day,month,year);
         instance.setMonth(7);
         int expResult = 7;
         int result = instance.getMonth();
         assertEquals(expResult, result);
    
    }
    
    @Test
    public void testGetYear() {
      	 System.out.println("getYear");
         String title = "Some Ref";
         String authors = "Albert Einstein, Isaac Newton, Galileo Galilei";
         String[] authorsArr = authors.split(",");
         String doi = "10.123456/9876";
         String publisher = "ACM";
         int pubyear = 2002;
         int day = 1;
         int month = 1;
         int year = 2021;

         
         Ref instance = new Ref(title,authorsArr,doi,publisher,pubyear, day,month,year);
         int expResult = 2021;
         int result = instance.getYear();
         assertEquals(expResult, result);
    
    }
    
    @Test
    public void testSetYear() {
      	 System.out.println("setYear");
         String title = "Some Ref";
         String authors = "Albert Einstein, Isaac Newton, Galileo Galilei";
         String[] authorsArr = authors.split(",");
         String doi = "10.123456/9876";
         String publisher = "ACM";
         int pubyear = 2002;
         int day = 1;
         int month = 1;
         int year = 1999;

         
         Ref instance = new Ref(title,authorsArr,doi,publisher,pubyear, day,month,year);
         instance.setYear(1999);
         int expResult = 1999;
         int result = instance.getYear();
         assertEquals(expResult, result);
    
    }
}
