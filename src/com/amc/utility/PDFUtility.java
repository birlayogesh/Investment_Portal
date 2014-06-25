package com.amc.utility;

import java.io.*;
import java.util.List;

import com.amc.db.DBConnectivity;
import com.lowagie.text.pdf.*;
import com.lowagie.text.*;
import com.sun.org.apache.xml.internal.serialize.LineSeparator;

public class PDFUtility {
	public void generatePDF(String folioId) {
		System.out.println("AAAA");
		Document document = new Document();
		try {
	    PdfWriter.getInstance(document, new FileOutputStream("downloadStatement.pdf"));
		document.open();
		
		DBConnectivity dbconn=new DBConnectivity();
		
		List<String[]> abc=(List<String[]>)dbconn.getTransactionInfo(folioId);
		document.add(new Paragraph("ACCOUNT STATEMENT FOR "));
		document.add(new Paragraph());
		document.add(new Paragraph());
		document.add(new Paragraph("    FolioId    | Action | Date           |  CompanyName    | StockExchange|Quantity|PurchaseValue"));
		document.add(new Paragraph());
		String a1[]=new String[100];
		int j=1;
		for (String[] lineTokens : abc) {
	   int i=0;
			for (String token : lineTokens) {
				a1[i++]=token;
	        }
		document.add(new Paragraph(j+".  " + a1[0]+ "      "+a1[6]+"      "+a1[1]+"      "+a1[2]+"      "+a1[7]+"    "+a1[3]+"      "+a1[4]));
		document.add(new Paragraph());
		document.add(new Paragraph());
		j++;
	    }
		
		
		
		document.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
	}
}
