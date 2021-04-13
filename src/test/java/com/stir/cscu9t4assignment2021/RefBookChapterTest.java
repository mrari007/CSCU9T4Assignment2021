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
public class RefBookChapterTest {
    
    public RefBookChapterTest() {
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
     * Test of 
     */
    
    /**
     * Test of getBook method, of class RefBookChapter.
     * Also tests the constructor without date added
     */
    @Test
    public void RefBookChapterWithoutDate() {
    	 System.out.println("BookChapterWithoutDate");
         String title = "Some Book Chapter";
         String book = "Some book about stuff";
         String authors = "Saemi Haraldsson, Ragnheidur Brynjolfsdottir";
         String[] authorsArr = authors.split(",");
         String doi = "10.123456/9876";
         String publisher = "Springer";
         String editor = "Scooby Doo";
         int pubyear = 2002;
         RefBookChapter instance = new RefBookChapter(title,book,authorsArr,doi,publisher,editor,pubyear);
         assertEquals(title, instance.getTitle());
         assertEquals(book, instance.getBook());
         assertEquals(authors, instance.getAuthors());
         assertEquals(doi, instance.getDoi());
         assertEquals(pubyear, instance.getPubYear());
         assertEquals(publisher, instance.getPublisher());
         assertEquals(editor, instance.getEditor());    
    }
    
    @Test
    public void RefBookChapterWithDate() {
    	 System.out.println("BookChapterWithDate");
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
         RefBookChapter instance = new RefBookChapter(title,book,authorsArr,doi,publisher,editor,pubyear, day, month, year);
         assertEquals(title, instance.getTitle());
         assertEquals(authors, instance.getAuthors());
         assertEquals(doi, instance.getDoi());
         assertEquals(pubyear, instance.getPubYear());
         assertEquals(publisher, instance.getPublisher());
         assertEquals(book, instance.getBook());
         assertEquals(editor, instance.getEditor());
         assertEquals(day, instance.getDay());
         assertEquals(month, instance.getMonth());
         assertEquals(year, instance.getYear());
         
         
    }
    @Test
    public void testGetBook() {
        System.out.println("getBook");
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
        
        //Testing constructor with date added
        RefBookChapter instance1 = new RefBookChapter(title,book,authorsArr,doi,
                publisher,editor,pubyear, day, month, year);
        String expResult1 = "Some book about stuff";
        String result1 = instance1.getBook();
        assertEquals(expResult1, result1);

        //Testing constructor without date
        RefBookChapter instance2 = new RefBookChapter(title,book,authorsArr,doi,
                                                    publisher,editor,pubyear);
        String expResult2 = "Some book about stuff";
        String result2 = instance2.getBook();
        assertEquals(expResult2, result2);
    }
    
    @Test
    public void testsetBookr() {
    	System.out.println("setBook");
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
        
        //Testing constructor with date added
        RefBookChapter instance1 = new RefBookChapter(title,book,authorsArr,doi,
                publisher,editor,pubyear, day, month, year);
        instance1.setBook("Another book");
        String expResult1 = "Another book";
        String result1 = instance1.getBook();
        assertEquals(expResult1, result1);
        
        //Testing constructor with date added
        RefBookChapter instance2 = new RefBookChapter(title,book,authorsArr,doi,
                publisher,editor,pubyear);
        instance1.setBook("Another book");
        String expResult2 = "Another book";
        String result2 = instance1.getBook();
        assertEquals(expResult1, result1);
    }
    
    @Test
    public void testgetEditor() {
        System.out.println("getBook");
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
        
        //Testing constructor with date added
        RefBookChapter instance1 = new RefBookChapter(title,book,authorsArr,doi,
                publisher,editor,pubyear, day, month, year);
        String expResult1 = "Scooby Doo";
        String result1 = instance1.getEditor();
        assertEquals(expResult1, result1);

        //Testing constructor without date
        RefBookChapter instance2 = new RefBookChapter(title,book,authorsArr,doi,
                                                    publisher,editor,pubyear);
        String expResult2 = "Scooby Doo";
        String result2 = instance2.getEditor();
        assertEquals(expResult2, result2);
    }
    
    @Test
    public void testsetEditor() {
    	System.out.println("setEditor");
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
        
        //Testing constructor with date added
        RefBookChapter instance1 = new RefBookChapter(title,book,authorsArr,doi,
                publisher,editor,pubyear, day, month, year);
        instance1.setEditor("Tom and Jerry");
        String expResult1 = "Tom and Jerry";
        String result1 = instance1.getEditor();
        assertEquals(expResult1, result1);
        
        //Testing constructor with date added
        RefBookChapter instance2 = new RefBookChapter(title,book,authorsArr,doi,
                publisher,editor,pubyear);
        instance1.setEditor("Tom and Jerry");
        String expResult2 = "Tom and Jerry";
        String result2 = instance1.getEditor();
        assertEquals(expResult1, result1);
    }

    /**
     * Test of getCitation method, of class RefBookChapter.
     * Also tests the constructor without date added
     */
    @Test
    public void testGetCitation() {
        System.out.println("getCitation");
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
        LocalDate today = LocalDate.now();
        String todayStr = today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        
        //Testing constructor with date
        RefBookChapter instance1 = new RefBookChapter(title,book,authorsArr,doi,
                                                     publisher,editor,pubyear,
                                                     day,month,year
                                                    );
        String expResult1 = "Saemi Haraldsson, Ragnheidur Brynjolfsdottir (2002),"
                           +" Some Book Chapter, in Some book about stuff, Springer,"
                            +" ed: Scooby Doo, doi:10.123456/9876. Added on: 01/01/2021\n";
        String result1 = instance1.getCitation();
        assertEquals(expResult1, result1);
        
        //Testing constructor without date
        RefBookChapter instance2 = new RefBookChapter(title,book,authorsArr,doi,
                publisher,editor,pubyear);
        String expResult2 = "Saemi Haraldsson, Ragnheidur Brynjolfsdottir (2002),"
        		+" Some Book Chapter, in Some book about stuff, Springer,"
        		+" ed: Scooby Doo, doi:10.123456/9876. Added on: " + todayStr + "\n";
        String result2 = instance2.getCitation();
        assertEquals(expResult2, result2);
        
    }
    
}
