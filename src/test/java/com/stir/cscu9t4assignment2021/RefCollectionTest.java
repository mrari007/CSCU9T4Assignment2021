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

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author saemundur
 */
public class RefCollectionTest {
    
    public RefCollectionTest() {
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
     * Test of addCite method, of class RefCollection.
     */
    @Test
    public void testAddCite() {
    	System.out.println("addCite");
    	
    	//Creating a RefJournal object
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
        RefJournal refJour = new RefJournal(title,journal,authorsArr,doi,
                                                     publisher,pubyear, volume, issue, day,month,year);
        
      //Creating a RefConference object
        String title2 = "Some Conference";
        String authors2 = "Ed Sheeran, Taylor Swift";
        String[] authorsArr2 = authors.split(",");
        String doi2 = "10.123456/9876";
        String publisher2 = "IEEE";
        String venue = "London";
        String location = "Bath";
        int pubyear2 = 2002;
        int day2 = 1;
        int month2 = 1;
        int year2 = 2021;
        RefConference refCon = new RefConference(title2,venue,authorsArr2,doi2,
                publisher2,location,pubyear2, day2, month2, year2);
        
        //Creating a RefBookChapter object
        String title3 = "Some Book Chapter";
        String book = "Some book about stuff";
        String authors3 = "Saemi Haraldsson, Ragnheidur Brynjolfsdottir";
        String[] authorsArr3 = authors.split(",");
        String doi3 = "10.123456/9876";
        String publisher3 = "Springer";
        String editor = "Scooby Doo";
        int pubyear3 = 2002;
        int day3 = 1;
        int month3 = 1;
        int year3 = 2021;
        
        RefBookChapter refBook = new RefBookChapter(title3,book,authorsArr3,doi3,
                publisher3,editor,pubyear3, day3, month3, year3);
        
        RefCollection instance = new RefCollection();
        instance.addCite(refJour);																	//adding the journal to the collection
        assertEquals(1, instance.getNumberOfRefs("journals"));
        instance.addCite(refCon);																	//adding the conference to the collection
        assertEquals(1, instance.getNumberOfRefs("conferences"));
        instance.addCite(refBook);																//adding the book chapter to the collection
        assertEquals(1, instance.getNumberOfRefs("book chapters"));
        assertEquals(3, instance.getNumberOfRefs("all"));
    }

    /**
     * Test of lookUpByJournal method, of class RefCollection.
     */
    @Test
    public void testLookUpByJournal() {
    	System.out.println("lookUpByJournal");
    	
    	//Creating a RefJournal object
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
        RefJournal refJour = new RefJournal(title,journal,authorsArr,doi,
                                                     publisher,pubyear, volume, issue, day,month,year);
        
    	//Creating a RefJournal object
        String title2 = "Some Other Journal";
        LocalDate today = LocalDate.now();
        String todayStr = today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        RefJournal refJour2 = new RefJournal(title2,journal,authorsArr,doi,
                publisher,pubyear, volume, issue);
        
        RefCollection instance = new RefCollection();
        instance.addCite(refJour);														
        instance.addCite(refJour2);					
        String expResult = "Charles Babbage, Alan Turing, Ada Lovelace (2002), Some Journal."
                +" Computing Science History, (vol 2, iss 2), ACM,"
                +" doi:10.123456/9876. Added on: 01/01/2021\n" +
                "Charles Babbage, Alan Turing, Ada Lovelace (2002), Some Other Journal."
                +" Computing Science History, (vol 2, iss 2), ACM,"
                 +" doi:10.123456/9876. Added on: " + todayStr + "\n";
        assertEquals(expResult, instance.lookUpByJournal( "Computing Science History"));
        
    }

    /**
     * Test of loopUpByVenue method, of class RefCollection.
     */
    @Test
    public void testLookUpByVenue() {
    	System.out.println("lookUpByVenue");
    	
    	 //Creating a RefConference object
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
        RefConference refCon = new RefConference(title,venue,authorsArr,doi,
                publisher,location,pubyear, day, month, year);
        
        //Creating a RefConference object
        String title2 = "Some Other Conference";
        LocalDate today = LocalDate.now();
        String todayStr = today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        RefConference refCon2 = new RefConference(title2,venue,authorsArr,doi,
                publisher,location,pubyear);
        
        RefCollection instance = new RefCollection();
        instance.addCite(refCon);														
        instance.addCite(refCon2);	
        String expResult = "Ed Sheeran, Taylor Swift (2002),"
                +" Some Conference, at Wembley(London), IEEE,"
                +" doi:10.123456/9876. Added on: 01/01/2021\n" +
                "Ed Sheeran, Taylor Swift (2002),"
                +" Some Other Conference, at Wembley(London), IEEE,"
                +" doi:10.123456/9876. Added on: " + todayStr + "\n";
        assertEquals(expResult, instance.lookUpByVenue( "Wembley"));
    }

    /**
     * Test of lookUpByPublisher method, of class RefCollection.
     */
    @Test
    public void testLookUpByPublisher() {
        //Creating a RefBookChapter object
        System.out.println("lookUpByPublisher");
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
        RefBookChapter refBook = new RefBookChapter(title,book,authorsArr,doi,publisher,editor,pubyear,
                day,month,year);
        
        //Creating a RefBookChapter object
        String title2 = "Some other Book Chapter";
        LocalDate today = LocalDate.now();
        String todayStr = today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        RefBookChapter refBook2 = new RefBookChapter(title2,book,authorsArr,doi,publisher,editor,pubyear);
        
        RefCollection instance = new RefCollection();
        instance.addCite(refBook);														
        instance.addCite(refBook2);
        String expResult = "Saemi Haraldsson, Ragnheidur Brynjolfsdottir (2002),"
                +" Some Book Chapter, in Some book about stuff, Springer,"
                +" ed: Scooby Doo, doi:10.123456/9876. Added on: 01/01/2021\n" + 
                "Saemi Haraldsson, Ragnheidur Brynjolfsdottir (2002),"
        		+" Some other Book Chapter, in Some book about stuff, Springer,"
        		+" ed: Scooby Doo, doi:10.123456/9876. Added on: " + todayStr + "\n";
        assertEquals(expResult, instance.lookUpByPublisher("Springer"));
        
    }

    /**
     * Test of getNumberOfRefs method, of class RefCollection.
     */
    @Test
    public void testGetNumberOfRefs() {
        System.out.println("getNumberOfRefs");
        
      //Creating a RefJournal object
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
        RefJournal refJour = new RefJournal(title,journal,authorsArr,doi,
                                                     publisher,pubyear, volume, issue, day,month,year);
        
      //Creating a RefJournal object
        String title2 = "Some Other Journal";
        RefJournal refJour2 = new RefJournal(title2,journal,authorsArr,doi,
                                                     publisher,pubyear, volume, issue, day,month,year);
        
      //Creating a RefJournal object
        String title3 = "Another Journal";
        RefJournal refJour3 = new RefJournal(title3,journal,authorsArr,doi,
                                                     publisher,pubyear, volume, issue);
        
        RefCollection instance = new RefCollection();
        assertEquals(0, instance.getNumberOfRefs("journals"));
        instance.addCite(refJour);	
        assertEquals(1, instance.getNumberOfRefs("journals"));
        instance.addCite(refJour2);			
        assertEquals(2, instance.getNumberOfRefs("journals"));
        instance.addCite(refJour3);
        assertEquals(3, instance.getNumberOfRefs("journals"));
    }

    /**
     * Test of exportAll method, of class RefCollection.
     */
    @Test
    public void testExportAll() {
        System.out.println("exportAll");
        File journalsOnly = new File ("C:/Users/Lenovo/git/CSCU9T4Assignment2021/Test_files/only_journals.csv");
        String filePath = "Journals only";

        RefCollection instance = new RefCollection();
        instance.importMany(filePath);
        String result = instance.exportAll(".txt");
        assertEquals("All the data was written to a txt file!", result);

    }

    /**
     * Test of importMany method, of class RefCollection.
     */
    @Test
    public void testImportMany() {
        System.out.println("importMany");
        File journalsOnly = new File ("C:/Users/Lenovo/git/CSCU9T4Assignment2021/Test_files/only_journals.csv");
        File conferencesOnly = new File ("C:/Users/Lenovo/git/CSCU9T4Assignment2021/Test_files/only_conferences.csv");
        String filePath = "Journals only";
        String filePath2 = "Conferences only";
        RefCollection instance = new RefCollection();
        instance.importMany(filePath);
        assertEquals(100, instance.getNumberOfRefs("journals"));
        instance.importMany(filePath2);
        assertEquals(100, instance.getNumberOfRefs("conferences"));
        assertEquals(200, instance.getNumberOfRefs("all"));
    }
    
    @Test
    public void testSortResult() {
    	 System.out.println("sortResult");
    	 //Creating a RefConference object
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
         RefConference refCon = new RefConference(title,venue,authorsArr,doi,
                 publisher,location,pubyear, day, month, year);
         
         //Creating a RefConference object
         String title2 = "Some Other Conference";
         String authors2 = "Ariana Grande, Ed Sheeran, Taylor Swift";
         String[] authorsArr2 = authors2.split(",");
         RefConference refCon2 = new RefConference(title2,venue,authorsArr2,doi,
                 publisher,location,pubyear, day, month, year);
         
         RefCollection instance = new RefCollection();
         instance.addCite(refCon);
         instance.addCite(refCon2);
         ArrayList<String> auth = new ArrayList<String>();
         ArrayList<Ref> small = new ArrayList<Ref>();
         small.add(refCon);
         small.add(refCon2);
         auth.add(authors);
         auth.add(authors2);
         instance.sortResult(auth, small);
         
         String expResult = "Ariana Grande, Ed Sheeran, Taylor Swift (2002), Some Other Conference, at Wembley(London), IEEE,"
         		+ " doi:10.123456/9876. Added on: 01/01/2021\n" 
        		 +"Ed Sheeran, Taylor Swift (2002),"
                 +" Some Conference, at Wembley(London), IEEE,"
                 +" doi:10.123456/9876. Added on: 01/01/2021\n";
         
         assertEquals(expResult, instance.lookUpByPublisher(publisher));
         
    }
    
    
    
    @Test
    public void testCreateRefBookChapter() {
        System.out.println("createRefBookChapter");
        String [] arr= {"Some Book Chapter", "Saemi Haraldsson, Ragnheidur Brynjolfsdottir","2002", "Springer",
        		"10.123456/9876", "01/01/2021", "Some book about stuff", "Scooby Doo"};
        

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
        
        RefCollection instance = new RefCollection();
        //Testing constructor with date
        RefBookChapter refBook = new RefBookChapter(title,book,authorsArr,doi,publisher,editor,pubyear,
                                                     day,month,year);
        
        assertEquals(refBook.getTitle(), instance.createRefBookChapter(arr).getTitle());
        assertEquals(refBook.getAuthors(), instance.createRefBookChapter(arr).getAuthors());
        assertEquals(refBook.getDoi(), instance.createRefBookChapter(arr).getDoi());
        assertEquals(refBook.getPubYear(), instance.createRefBookChapter(arr).getPubYear());
        assertEquals(refBook.getPublisher(), instance.createRefBookChapter(arr).getPublisher());
        assertEquals(refBook.getBook(), instance.createRefBookChapter(arr).getBook());
        assertEquals(refBook.getEditor(), instance.createRefBookChapter(arr).getEditor());
        assertEquals(refBook.getDay(), instance.createRefBookChapter(arr).getDay());
        assertEquals(refBook.getMonth(), instance.createRefBookChapter(arr).getMonth());
        assertEquals(refBook.getYear(), instance.createRefBookChapter(arr).getYear());

    }
    
    @Test
    public void testCreateRefJournal() {
        System.out.println("createRefJournal");
        String [] arr= {"Some Journal", "Charles Babbage, Alan Turing, Ada Lovelace", "2002", "ACM", "10.123456/9876",  "01/01/2021",
        		"Computing Science History", "2", "2"};
        
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
        
        RefCollection instance = new RefCollection();
        //Testing constructor with date
        RefJournal refJour = new RefJournal(title,journal,authorsArr,doi,publisher,pubyear, volume, issue,
                                                     day,month,year);
        
        assertEquals(refJour.getTitle(), instance.createRefJournal(arr).getTitle());
        assertEquals(refJour.getAuthors(), instance.createRefJournal(arr).getAuthors());
        assertEquals(refJour.getDoi(), instance.createRefJournal(arr).getDoi());
        assertEquals(refJour.getPubYear(), instance.createRefJournal(arr).getPubYear());
        assertEquals(refJour.getPublisher(), instance.createRefJournal(arr).getPublisher());
        assertEquals(refJour.getJournal(), instance.createRefJournal(arr).getJournal());
        assertEquals(refJour.getIssue(), instance.createRefJournal(arr).getIssue());
        assertEquals(refJour.getVolume(), instance.createRefJournal(arr).getVolume());
        assertEquals(refJour.getDay(), instance.createRefJournal(arr).getDay());
        assertEquals(refJour.getMonth(), instance.createRefJournal(arr).getMonth());
        assertEquals(refJour.getYear(), instance.createRefJournal(arr).getYear());
    }
    
    @Test
    public void testCreateRefConference() {
        System.out.println("createRefConference");
        String [] arr= {"Some Conference", "Ed Sheeran, Taylor Swift","2002", "IEEE",
        		"10.123456/9876", "01/01/2021", "Wembley", "London"};
        

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
        
        RefCollection instance = new RefCollection();
        //Testing constructor with date
        RefConference refCon = new RefConference(title,venue,authorsArr,doi,publisher,location,pubyear,
                                                     day,month,year);
        
        assertEquals(refCon.getTitle(), instance.createRefConference(arr).getTitle());
        assertEquals(refCon.getAuthors(), instance.createRefConference(arr).getAuthors());
        assertEquals(refCon.getDoi(), instance.createRefConference(arr).getDoi());
        assertEquals(refCon.getPubYear(), instance.createRefConference(arr).getPubYear());
        assertEquals(refCon.getPublisher(), instance.createRefConference(arr).getPublisher());
        assertEquals(refCon.getVenue(), instance.createRefConference(arr).getVenue());
        assertEquals(refCon.getLocation(), instance.createRefConference(arr).getLocation());
        assertEquals(refCon.getDay(), instance.createRefConference(arr).getDay());
        assertEquals(refCon.getMonth(), instance.createRefConference(arr).getMonth());
        assertEquals(refCon.getYear(), instance.createRefConference(arr).getYear());

    }
}
