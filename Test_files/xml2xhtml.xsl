<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">

	<xsl:key name="mostCommonJournal" match="bibliography/baseRef/refJournal/journal" use="text()"/>
	<xsl:key name="mostCommonJourPublisher" match="bibliography/baseRef/refJournal/publisher" use="text()"/>
	<xsl:key name="mostCommonVenue" match="bibliography/baseRef/refConference/venue" use="text()"/>
	<xsl:key name="mostCommonLocation" match="bibliography/baseRef/refConference/location" use="text()"/>
	<xsl:key name="mostCommonBook" match="bibliography/baseRef/refBook/book" use="text()"/>
	<xsl:key name="mostCommonBookPublisher" match="bibliography/baseRef/refBook/publisher" use="text()"/>
	
 <xsl:template match="/">
  <html>
  	<head>
	      <style>
	         body {
	            font-family: Arial;
	            font-size: 12pt;
	            background-color: #EEEEEE;
	         }

	         #content {
	            padding: 20px 50px;
	            width: max-content;
	            border: 5px solid black;
	         }

	         ul {
	            padding: 0;
	            list-style-type: none;
	            display: grid;
	            grid-template-columns: max-content auto;
	         }
	   
	         li {
	            grid-column-start: 1;
	         }
	   
	         dd {
	            grid-column-start: 2;
	         }
	      </style>
	      </head>
	<body style="font-family:Arial;font-size:12pt;background-color:#EEEEEE">
	<div id="content">
		<h1>Bibliography Summary</h1>
		<h2>Journal Articles</h2>
		<ul>
		  <li>Number of journal articles</li>
			<dd>
				<xsl:for-each select="bibliography/baseRef/refJournal">
					<xsl:if test="position()=last()">
						<xsl:value-of select="position()"/>
					</xsl:if>
				</xsl:for-each>	
			</dd>
		  <li>Most frequent journal</li>
			<dd>
				<xsl:for-each select="bibliography/baseRef/refJournal/journal[generate-id() = generate-id(key('mostCommonJournal',text())[1])]">
				<xsl:sort select="count(//bibliography/baseRef/refJournal/journal[text()=current()])" order="descending"/>
				<xsl:if test="position()=1">
				<xsl:value-of select="current()"/>
				</xsl:if>
				</xsl:for-each>
			</dd>
		 <li>Most frequent publisher</li>
			<dd>
				<xsl:for-each select="bibliography/baseRef/refJournal/publisher[generate-id() = generate-id(key('mostCommonJourPublisher',text())[1])]">
				<xsl:sort select="count(//bibliography/baseRef/refJournal/publisher[text()=current()])" order="descending"/>
				<xsl:if test="position()=1">
				<xsl:value-of select="current()"/>
				</xsl:if>
				</xsl:for-each>
			</dd>
		 </ul>
		 
		 <h2>Conference proceedings</h2>
		 <ul>
		  <li>Number of conference proceedings</li>
			<dd>
				<xsl:for-each select="bibliography/baseRef/refConference">
					<xsl:if test="position()=last()">
						<xsl:value-of select="position()"/>
					</xsl:if>
				</xsl:for-each>	
			</dd>
		<li>Most frequent venue</li>
			<dd>
				<xsl:for-each select="bibliography/baseRef/refConference/venue[generate-id() = generate-id(key('mostCommonVenue',text())[1])]">
					<xsl:sort select="count(//bibliography/baseRef/refConference/venue[text()=current()])" order="descending"/>
					<xsl:if test="position()=1">
					<xsl:value-of select="current()"/>
					</xsl:if>
				</xsl:for-each>
			</dd>
		<li>Most frequent location</li>
			<dd>
				<xsl:for-each select="bibliography/baseRef/refConference/location[generate-id() = generate-id(key('mostCommonLocation',text())[1])]">
					<xsl:sort select="count(//bibliography/baseRef/refConference/location[text()=current()])" order="descending"/>
					<xsl:if test="position()=1">
					<xsl:value-of select="current()"/>
					</xsl:if>
				</xsl:for-each>
			</dd>
		</ul>
		
		 <h2>Book chapters</h2>
		 <ul>
		  <li>Number of book chapters</li>
			<dd>
				<xsl:for-each select="bibliography/baseRef/refBook">
					<xsl:if test="position()=last()">
						<xsl:value-of select="position()"/>
					</xsl:if>
				</xsl:for-each>	
			</dd>
		  
		  <li>Most frequent book</li>
			<dd>
				<xsl:for-each select="bibliography/baseRef/refBook/book[generate-id() = generate-id(key('mostCommonBook',text())[1])]">
					<xsl:sort select="count(//bibliography/baseRef/refBook/book[text()=current()])" order="descending"/>
					<xsl:if test="position()=1">
					<xsl:value-of select="current()"/>
					</xsl:if>
				</xsl:for-each>
			</dd>
		 
		 <li>Most frequent publisher</li>
			<dd>
				<xsl:for-each select="bibliography/baseRef/refBook/publisher[generate-id() = generate-id(key('mostCommonBookPublisher',text())[1])]">
					<xsl:sort select="count(//bibliography/baseRef/refBook/publisher[text()=current()])" order="descending"/>
					<xsl:if test="position()=1">
					<xsl:value-of select="current()"/>
					</xsl:if>
				</xsl:for-each>
			</dd>
		</ul>
	</div>
	</body>
  </html>
 </xsl:template>
</xsl:stylesheet>