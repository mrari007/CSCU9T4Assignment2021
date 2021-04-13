package com.stir.cscu9t4assignment2021;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXParseException;

/**
 * 
 * I used the DOMMenu class from the XML practical 1 as a template for this class with slight modification to the file paths
 * 
 */
public class DOMParser {
	
		private static DocumentBuilder builder = null;
		private static XPath path = null;
		private static Document document = null;
		private static Schema schema = null;

	  public static void main(String[] args)  {
			  String xml = "C:/Users/Lenovo/git/CSCU9T4Assignment2021/Test_files/output_xml.xml";
			  String xsd = "C:/Users/Lenovo/git/CSCU9T4Assignment2021/Test_files/bibExport.xsd";
			  try
			  {
			  loadDocument(xml);
			  if(validateDocument(xsd) == true) {
				  System.out.println("Successful validation!");
			  }
			  }catch(Exception e)
			  {
			  System.out.println("Error");
			  }
		  }
	  
	  private static void loadDocument(String filename) {
		    try {
		      // create a document builder
		      DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
		      builder = builderFactory.newDocumentBuilder();

		      // create an XPath expression
		      XPathFactory xpathFactory = XPathFactory.newInstance();
		      path = xpathFactory.newXPath();

		      // parse the document for later searching
		      document = builder.parse(new File(filename));
		    }
		    catch (Exception exception) {
		      System.out.println("Could not load document, The system cannot find the file specified ");
		      System.exit(0);																	// terminates the program
		    }
		  }
	  
	  private static Boolean validateDocument(String filename)  {
		    try {
		      String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
		      SchemaFactory factory = SchemaFactory.newInstance(language);
		      schema = factory.newSchema(new File(filename));
		      Validator validator = schema.newValidator();
		      validator.validate(new DOMSource(document));
		      return true;
		    }
		     catch (SAXParseException e) {
		    	System.out.println("The XML file and the XML schema do not match " + e);			// a useful message for the user
		      	return false;
		      }
		     catch (Exception e){
		      System.err.println(e);
		      System.err.println("Could not load schema or validate");
		      return false;
		    }
		  }
}
