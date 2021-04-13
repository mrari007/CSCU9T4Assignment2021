package com.stir.cscu9t4assignment2021;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

public class RefCollection  {
		
		private List<Ref> collection;
	
	/**
	 * A constructor
	 */
		public RefCollection() {
			collection = new ArrayList<Ref>();
		}
	
		/**
		 * Adds a new reference to the collection
		 * @param ref
		 */
		public void addCite(Ref ref) {
			for (int i = 0; i <collection.size(); i ++)			//Loops through all References in the collection
			{
				Ref count = collection.get(i);
				//Checks if a similar reference has been added to the collection already
				if (count.getTitle().equalsIgnoreCase(ref.getTitle()) && count.getAuthors().equalsIgnoreCase(ref.getAuthors()) && 
						count.getPubYear() == ref.getPubYear() && count.getPublisher().equals(ref.getPublisher()) &&
						count.getDoi().equalsIgnoreCase(ref.getDoi())) {
			    	System.out.println("Citetion already added!");
					return;
				}
			}
			collection.add(ref);
	}
	
		/**
		 * Looks for all references in the collection by a Journal's name and sorts them by the first author
		 * @param journal
		 * @return A string representation of all found journal references
		 */
		public String lookUpByJournal(String journal) {
			ListIterator<Ref> iter = collection.listIterator();				
			String result = "";
			 int count = 0;																//stores the number of found journals
			 ArrayList<String> auth = new ArrayList <String>();		//arrayList to store all the authors from the found journals
			 ArrayList<Ref> journals = new ArrayList <Ref>();		//arrayList to store all journals found from the search
			while (iter.hasNext()) {													//iterates the the whole collection
				try {
				RefJournal current = (RefJournal) iter.next()	;
				if (current.getJournal().equalsIgnoreCase(journal)) {
					auth.add(current.getAuthors());							// adds the authors from the current journal to the auth arraylist
					journals.add(current);											//adds the current journal to the journals arrayList
					count ++;
				} 
				} catch (ClassCastException e) {
					System.out.println("The object cannot be cast to class RefJournal");
				}
			}
			
			if (count == 0) {
				return "There are no refrences from this publisher.";// returns if there are no refs found
			} else {
				ArrayList<Ref> sorted = sortResult(auth, journals);	//creates anarrayList of the Refs found and sorts it based on the first author
				for (int i = 0; i <sorted.size(); i++) {							//loops through the sorted arrayList of refs and adds  them to result
					if (count == 0) {
						result = sorted.get(i).getCitation();
					} else {
						result += sorted.get(i).getCitation();
					}
				}
				return result;
			}
		}
	
		/**
		 * Looks for all references in the collection by a venue  and sorts them by the first author
		 * @param venue
		 * @return A string representation of all found conferences
		 */
		public String lookUpByVenue(String venue) {
			ListIterator<Ref> iter = collection.listIterator();
			String result = "";
			 int count = 0;																		//stores the number of found conferences
			 ArrayList<String> auth = new ArrayList <String>();				//arrayList to store all the authors from the found references
			 ArrayList<Ref> venues = new ArrayList <Ref>();					//arrayList to store all conferences found from the search
			while (iter.hasNext()) {															//iterates the the whole collection
				try {
				RefConference current = (RefConference) iter.next()	;
				if (current.getVenue().equalsIgnoreCase(venue)) {
					auth.add(current.getAuthors());									// adds the authors from the current conference to the auth arrayList
					venues.add(current);														//adds the current conference to the venues arrayList
					count ++;
				} 
				}  catch (ClassCastException e) {
					System.out.println("The object cannot be cast to class RefConference");
				}
			}
			if (count == 0) {
				return "There are no refrences from this publisher.";		// returns if there are no refs found
			} else {
				ArrayList<Ref> sorted = sortResult(auth, venues);			//creates anarrayList of the Conferences found and sorts it based on the first author
				for (int i = 0; i <sorted.size(); i++) {									//loops through the sorted arrayList of conferences and adds  them to result
					if (count == 0) {
						result = sorted.get(i).getCitation();
					} else {
						result += sorted.get(i).getCitation();
					}
				}
				return result;
			}
		}

		/**
		 * Looks for all references in the collection by a publisher  and sorts them by the first author
		 * @param publisher
		 * @return A string representation of all found references
		 */
		public String lookUpByPublisher(String publisher) {
			ListIterator<Ref> iter = collection.listIterator();
			String result = "";
			 int count = 0;																		//stores the number of found references
			 ArrayList<String> auth = new ArrayList <String>();				//arrayList to store all the authors from the found references
			 ArrayList<Ref> publishers = new ArrayList <Ref>();			//arrayList to store all references found from the search
			while (iter.hasNext()) {															//iterates the the whole collection
				Ref current = iter.next()	;
				
				if (current.getPublisher().equalsIgnoreCase(publisher)) {
					auth.add(current.getAuthors());									// adds the authors from the current reference to the auth arrayList
					publishers.add(current);												//adds the current reference to the publishers arrayList
					count++;
				} 
			}			if (count == 0) {
				return "There are no refrences from this publisher.";		// returns if there are no refs found
			} else {
				ArrayList<Ref> sorted = sortResult(auth, publishers);		//creates anarrayList of the references found and sorts it based on the first author
				for (int i = 0; i <sorted.size(); i++) {									//loops through the sorted arrayList of references and adds  them to result
					if (count == 0) {
						result = sorted.get(i).getCitation();
					} else {
						result += sorted.get(i).getCitation();
					}
				}
				return result;
			}		
		}
	
		/**
		 * returns all the references from a selected type
		 * @param type
		 * @return the number of references in the collection
		 */
		public int getNumberOfRefs(String type) {
			int count = 0;
			ListIterator<Ref> iter = collection.listIterator();						//iterates through all the elements in the collection
			while (iter.hasNext()) {
				
				if (type.equalsIgnoreCase("journals")) {							//counts only the journals
					try {
						RefJournal current = (RefJournal) iter.next()	;
						count ++;
						}  catch (ClassCastException e) {
							System.out.println("The object cannot be cast to class RefJournal");
						}
				} else if (type.equalsIgnoreCase("conferences")) {				//counts only the conferences
					
					try {
						RefConference current = (RefConference) iter.next()	;
						count ++;
						}  catch (ClassCastException e) {
							System.out.println("The object cannot be cast to class RefConference");
						}
				} else if (type.equalsIgnoreCase("book chapters")) {			//counts only the book chapters
					
					try {
						RefBookChapter current = (RefBookChapter) iter.next()	;
						count ++;
						}  catch (ClassCastException e) {
							System.out.println("The object cannot be cast to class RefBookChapter");
						}
				} else {																				//counts all of the references
					return collection.size();
				}
		}
			return count;
			}
		
	
		/**
		 * Writes all the references currently in the collection to a .txt file
		 * @return
		 */
		public String exportAll(String filePath) {
			//Exporting the all the information from the collection to a txt file
			if(filePath.equalsIgnoreCase(".txt")) {
			File outFileTxt = new File ("C:/Users/Lenovo/git/CSCU9T4Assignment2021/Test_files/output.txt");
			String message = "All the data was written to a txt file!";
			try {
				FileWriter writer = new FileWriter(outFileTxt);
				if(collection.size() == 0) {
					message =  "Could not export any data because he bibliography is empty";		//if there is no refs added to the collection
				} else {
				for (int i = 0; i < collection.size(); i ++) {
					writer.write(collection.get(i).getCitation());				//if the collection has 1 or more refs in it, writes all of the refs to a txt file (output.txt)
				}
				writer.close();
				}
			} catch (FileNotFoundException e) {
				return "Could not find the file";
			} catch (IOException e) {
				return "Error in the input data";
			}
			
			return message;
			//Exporting the all the information from the collection to a xml file
		} else {
			String result = "";
			File outFileXml = new File ("C:/Users/Lenovo/git/CSCU9T4Assignment2021/Test_files/output_xml.xml");
			ListIterator<Ref> iter = collection.listIterator();
			String message = "All the data was written to a xml file!";
			try {
				FileWriter writer = new FileWriter(outFileXml);
				while(iter.hasNext()) {
					Ref current = iter.next();
					// with these 3 try blocks I check whether the current element is of type RefJournal,
					//RefConference, or RefBookChapter
					try {
						RefJournal currentJournal = (RefJournal) current;
						result = result +"  <baseRef>\n" +"    <refJournal category=\"journalRefs\">\n" + "  \t<title>" + currentJournal.getTitle() + "</title>\n"
						+ "\t<authors>" + currentJournal.getAuthors() + "</authors>\n" 
						+ "\t<pubYear>" + currentJournal.getPubYear()+ "</pubYear>\n" 
						+ "\t<publisher>" + currentJournal.getPublisher() + "</publisher>\n" 
						+ "\t<doi>" +currentJournal.getDoi() + "</doi>\n" 
						+ "\t<date>" + currentJournal.getDateAdded() + "</date>\n"
						+ "\t<journal>" + currentJournal.getJournal() + "</journal>\n"
						+ "\t<volume>" + currentJournal.getVolume() + "</volume>\n"
						+ "\t<issue>" + currentJournal.getIssue() + "</issue>\n" + "    </refJournal>\n" + "  </baseRef>\n";
						}  catch (ClassCastException e) {
							System.out.println("The object cannot be cast to class RefJournal");
						}
					try {
						RefConference currentConference = (RefConference) current;
						result = result +"  <baseRef>\n" + "    <refConference category=\"conferenceRefs\">\n" + "\t<title>" + currentConference.getTitle() + "</title>\n" 
						+ "\t<authors>" + currentConference.getAuthors() + "</authors>\n"
						+ "\t<pubYear>" + currentConference.getPubYear() + "</pubYear>\n" 
						+ "\t<publisher>" + currentConference.getPublisher() + "</publisher>\n"
						+ "\t<doi>" +currentConference.getDoi() + "</doi>\n"
						+ "\t<date>" + currentConference.getDateAdded()+ "</date>\n"
						+ "\t<venue>" + currentConference.getVenue() + "</venue>\n"
						+ "\t<location>" + currentConference.getLocation() + "</location>\n" + "    </refConference>\n" + "  </baseRef>\n";
						}  catch (ClassCastException e) {
							System.out.println("The object cannot be cast to class RefConference");
						}
					try {
						RefBookChapter currentBook = (RefBookChapter) current;
						result = result +"  <baseRef>\n" + "    <refBook category=\"bookRefs\">\n" +"\t<title>" + currentBook.getTitle() + "</title>\n"
						+ "\t<authors>" +currentBook.getAuthors() + "</authors>\n"
						+ "\t<pubYear>" + currentBook.getPubYear() + "</pubYear>\n" 
						+ "\t<publisher>" + currentBook.getPublisher() + "</publisher>\n"
						+ "\t<doi>" +currentBook.getDoi() + "</doi>\n"
						+ "\t<date>" + currentBook.getDateAdded() + "</date>\n"
						+ "\t<book>" + currentBook.getBook() + "</book>\n"
						+ "\t<editor>" + currentBook.getEditor() + "</editor>\n" + "    </refBook>\n" + "  </baseRef>\n";
						}  catch (ClassCastException e) {
							System.out.println("The object cannot be cast to class RefBookChapter");
						}
				}
				result = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<bibliography>\n" + result + "</bibliography>\n";
				writer.write(result);
				writer.close();
			} catch (FileNotFoundException e) {
				return "Could not find the file";
			} catch (IOException e) {
				return "Error in the input data";
			}
			return message;
		}
		}
	
		/**
		 * Imports data from 4 given files to the collection of refs
		 * @param filePath
		 * @return
		 */
		public String importMany(String filePath) {
			//the 4 files for importing data
			File allData = new File ("C:/Users/Lenovo/git/CSCU9T4Assignment2021/Test_files/all_data_corrected.csv");
			File journalsOnly = new File ("C:/Users/Lenovo/git/CSCU9T4Assignment2021/Test_files/only_journals.csv");
			File conferencesOnly = new File ("C:/Users/Lenovo/git/CSCU9T4Assignment2021/Test_files/only_conferences.csv");
			File bookChapterOnly = new File ("C:/Users/Lenovo/git/CSCU9T4Assignment2021/Test_files/only_books.csv");
			String result = "";
			try {
				if(filePath.equalsIgnoreCase("Journals only")) {		//imports only journals if the file specified is only_journals.csv
					int count = 0;
	                Scanner sc = new Scanner(journalsOnly);		// scanner for the only_journals.csv file
	                while (sc.hasNextLine()) {
	                    String line = sc.nextLine();
	                        String [] attributes = line.split(",");		//splits the current line to elements and stores them in an array
	                        if(count > 0) {		//skips the first line from the file
	                        RefJournal refJ = createRefJournal(attributes);		//creates a RefJournal object from the array "attributes"
	                        addCite(refJ);
	                        }
	                        count ++;
	                    }        
					result = "Journals data exported to the file";
					  sc.close();
					  
				} else if (filePath.equalsIgnoreCase("conferences only")) {		//imports only journals if the file specified is only_conferences.csv
					int count = 0;
	                Scanner sc = new Scanner(conferencesOnly);	// scanner for the only_conferences.csv file
	                while (sc.hasNextLine()) {
	                    String line = sc.nextLine();
	                        String [] attributes = line.split(",");		//splits the current line to elements and stores them in an array
	                        if(count > 0) {		//skips the first line from the file
	                        	RefConference refCon = createRefConference(attributes);	//creates a RefConference object from the array "attributes"
	                        addCite(refCon);
	                        }
	                        count ++;
	                    }
	                result = "Conference data exported to the file";
	                sc.close();
	                
				}  else if (filePath.equalsIgnoreCase("book chapters only")) {	//imports only journals if the file specified is only_books.csv
					int count = 0;
	                Scanner sc = new Scanner(bookChapterOnly);		//scanner for the  only_books.csv file
	                while (sc.hasNextLine()) {
	                    String line = sc.nextLine();
	                        String [] attributes = line.split(",");			//splits the current line to elements and stores them in an array
	                        if(count > 0) {		//skips the first line from the file
	                        	RefBookChapter refBook = createRefBookChapter(attributes);	//creates a RefBookChapter object from the array "attributes"
	                        addCite(refBook);
	                        }
	                        count ++;
	                    }
	                result = "Book chapter data exported to the file";
	                sc.close();
	                
				} else {		//imports all the types of refs (journals, conferences and books) to the collection
					int count = 0;
	                Scanner sc = new Scanner(allData);		//scanner for the all_data.csv file
	                while (sc.hasNextLine()) {
	                    String line = sc.nextLine();
	                        String [] attributes = line.split(",");
	                        if(count > 0) {		//skips the first line from the file
	                        	int isEmptyCount = 0;
	                        	//The string "line" has a specific length based on what object is stored in the line :
	                        	// 9 - if the obj is a journal, 11 - if the obj is a conference, 13 - if the obj is a book chapter
	                        	// based on these length, creates the proper type of object from the attribute array.
	                        	if (attributes.length == 9) {
		                			for(int i = 0; i < attributes.length; i ++) {
		                				if(attributes[i].isEmpty()) {
		                					isEmptyCount++;
		                				}
		                			} if(isEmptyCount == 0) {
		    	                        RefJournal refJ = createRefJournal(attributes);
		    	                        addCite(refJ);
		                			}
	                        	} else if (attributes.length == 11) {
		                			for(int i = 0; i < attributes.length; i ++) {
		                				if(attributes[i].isEmpty()) {
		                					isEmptyCount++;
		                				}
		                			} 
		                			if(isEmptyCount == 3) {
			                        	RefConference refCon = createRefConference(attributes);
				                        addCite(refCon);
		                			}
	                        	} else if (attributes.length == 13) {
		                			for(int i = 0; i < attributes.length; i ++) {
		                				if(attributes[i].isEmpty()) {
		                					isEmptyCount++;
		                				}
		                			} 
		                			if(isEmptyCount == 5) {
	                        		RefBookChapter refBook = createRefBookChapter(attributes);
	    	                        addCite(refBook);
		                			}
	                        	}
	                        	
	                        }
	                        count ++;
	                    }
	                result = "All data exported to the file";
	                sc.close();
				}
			} catch (FileNotFoundException e) {
				System.out.println("Could not find the file");
			}
			return result;
		}
		/**
		 * Taking an arraylist of authors and arralist of Refs and sorts the arraylist of Refs based on their authors
		 * @param auth
		 * @param small
		 * @return the sorted arraylist of Refs
		 */
		public ArrayList<Ref> sortResult (ArrayList<String> auth, ArrayList<Ref> small) {
			ArrayList<Ref> sorted = new ArrayList <Ref>();
			for (int i = 0; i < small.size(); i++) {
				auth.set(i, small.get(i).getAuthors());					//populates  auth from the authors in small
			}
			Collections.sort(auth);											//sorts the arraylist of authors
			ArrayList<String> noDuplicates = new ArrayList<String>();	 	// the same arrayList as "auth" but wtih no duplicates
			for (String element : auth) {		//populates the "noDuplicates" arrayList with unique elements from "auth"
				if (!noDuplicates.contains(element) ) {	
					noDuplicates.add(element);
				}
			}
			
			//puts all the data in "small" in the "sorted" arrayList, sorted based on the first author
			for(int i = 0; i < noDuplicates.size(); i++) {
				for(int j = 0; j < small.size(); j++) {
					if(small.get(j).getAuthors().equalsIgnoreCase(noDuplicates.get(i))){
						sorted.add(small.get(j));
					}
				}
			}
			return sorted;
		}
		
		/**
		 * Creates a RefJournal object from a specifically obtained array of strings
		 * Used in the importMany method
		 * @param data
		 * @return The RefJournal object
		 */
		public RefJournal createRefJournal (String [] data) {
			String title = data[0];
			String authors = data[1];
			String [] authorsArr = authors.split(";");
			int year = Integer.parseInt(data[2]);

			String publisher = data[3];
			String doi = data[4];
			
			String date = data[5];
			String [] mdy = date.split("/"); 
			int d = 0;
			int m = 0;
			int y = 0;
			for (int i = 0; i < mdy.length; i++) {
				d = Integer.parseInt(mdy[0]);
				m = Integer.parseInt(mdy[1]);
				y = Integer.parseInt(mdy[2]);
			}
			String journal = data[6];
			int volume = Integer.parseInt(data[7]);
			int issue = Integer.parseInt(data[8]);

			return new RefJournal(title, journal, authorsArr, doi, publisher, year, volume, issue, d, m, y);

		}
		
		/**
		 * Creates a RefConference object from a specifically obtained array of strings
		 * 	Used in the importMany method
		 * @param data
		 * @return The RefConference object
		 */
		public RefConference createRefConference (String [] data) {
			String title = data[0];
			String authors = data[1];
			String [] authorsArr = authors.split(";");
			int year = Integer.parseInt(data[2]);

			String publisher = data[3];
			String doi = data[4];
			String venue = "";
			String location = "";
			String date = data[5];
			String [] mdy = date.split("/"); 
			int d = 0;
			int m = 0;
			int y = 0;
			for (int i = 0; i < mdy.length; i++) {
				d = Integer.parseInt(mdy[0]);
				m = Integer.parseInt(mdy[1]);
				y = Integer.parseInt(mdy[2]);
			}
			
			if(data.length == 8) {	//if the array of strings (created from by split method for a current line) is obtained by reading the only_conferences.csv file
				venue = data[6];
				location = data[7];
			} else {							//if the array of strings (created from by split method for a current line) is obtained by reading the all_data.csv file
				venue = data[9];
				location = data[10];
			}

			return  new RefConference(title, venue, authorsArr, doi, publisher, location, year, d, m, y);

		}
		
		/**
		 * Creates a RefBookChapter object from a specifically obtained array of strings
		 * Used in the importMany method
		 * @param data
		 * @return The RefBookChapter object
		 */
		public RefBookChapter createRefBookChapter (String [] data) {
			String title = data[0];
			String authors = data[1];
			String [] authorsArr = authors.split(";");
			int year = Integer.parseInt(data[2]);

			String publisher = data[3];
			String doi = data[4];
			
			String date = data[5];
			String book = "";
			String editor = "";
			String [] mdy = date.split("/"); 
			int d = 0;
			int m = 0;
			int y = 0;
			for (int i = 0; i < mdy.length; i++) {
				d = Integer.parseInt(mdy[0]);
				m = Integer.parseInt(mdy[1]);
				y = Integer.parseInt(mdy[2]);
			}
			
			if (data.length == 8) {	//if the array of strings (created from by split method for a current line) is obtained by reading the only_books.csv file
				 book = data[6];
				 editor = data[7];
			} else {							//if the array of strings (created from by split method for a current line) is obtained by reading the all_data.csv file
				 book = data[11];
				 editor = data[12];
			}
			return new RefBookChapter(title, book, authorsArr, doi, publisher, editor, year, d, m, y);	
		}
}
