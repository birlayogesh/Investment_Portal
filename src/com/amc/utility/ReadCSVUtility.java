package com.amc.utility;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.util.concurrent.CountDownLatch;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import au.com.bytecode.opencsv.CSVReader;

public class ReadCSVUtility {

	/*
	 * public void manageFiles() { String strFile = null; File dir = new File(
	 * "F:/Documents and Settings/Administrator/My Documents/Downloads"); File[]
	 * listFiles = dir.listFiles(new FileFilter() { public boolean accept(File
	 * file) {
	 * 
	 * String name = file.getName().toLowerCase(); return
	 * name.startsWith("quotes(");
	 * 
	 * }
	 * 
	 * });
	 * 
	 * for (int i = 0; i < listFiles.length; i++) listFiles[i].delete();
	 * System.out.println("Searching for file");
	 * 
	 * File f = new File(
	 * "F:/Documents and Settings/Administrator/My Documents/Downloads/quotes.csv"
	 * ); if (f.exists()) { System.out.println("In IF LOOP"); strFile =
	 * "F:\\Documents and Settings\\Administrator\\My Documents\\Downloads\\quotes.csv"
	 * ; } else { System.out.println("In else LOOP"); strFile =
	 * "F:\\Documents and Settings\\Administrator\\My Documents\\Downloads\\quotes.csv"
	 * ; } System.out.println("File found"); // COMAPNY VALUE READER API
	 * CSVReader reader = null; try { reader = new CSVReader(new
	 * FileReader(strFile)); } catch (FileNotFoundException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } String[] nextLine; int
	 * lineNumber = 0; String cscompanyName = null; String openingVale = null;
	 * String valueChange = null; String previousClose = null; String daysLow =
	 * null; String daysHigh = null; int realTimeValue = 0; String percentChange
	 * = null;
	 * 
	 * try { while ((nextLine = reader.readNext()) != null) { lineNumber++;
	 * cscompanyName = nextLine[0]; openingVale = nextLine[1]; valueChange =
	 * nextLine[2]; previousClose = nextLine[3]; daysLow = nextLine[4]; daysHigh
	 * = nextLine[5]; // realTimeValue = Integer.valueOf(valueChange) + //
	 * Integer.valueOf(previousClose); // percentChange=nextLine[6]; //
	 * stockExchange=nextLine[7]; } } catch (IOException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 * 
	 * }
	 */

	public static void fileUrl(String cmp_id,HttpServletRequest request) {

		try {
			URL url = new URL(
					"http://quote.yahoo.com/d/quotes.csv?f=noc6pghcx&s="
							+ cmp_id);
			String cscompanyName = null;
			String openingValue = null;
			String valueChange = null;
			String previousClose = null;
			String daysLow = null;
			String daysHigh = null;
			String percentChange = null;
			String stockExchange = null;
			Double realTimeValue = 0.0;
			URLConnection conn = url.openConnection();
			String add = null;
			BufferedReader in = new BufferedReader(new InputStreamReader(conn
					.getInputStream()));

			String line;
			while ((line = in.readLine()) != null) {
				String[] ar = line.split(",");
				cscompanyName = ar[0];

				openingValue = ar[1];

				valueChange = ar[2];
				valueChange = valueChange.replaceAll("^\"|\"$", "");
				previousClose = ar[3];
				daysLow = ar[4];

				daysHigh = ar[5];

				if (valueChange.contains("+"))
					add = "profit";
				else
					add = "loss";
				valueChange = valueChange.replaceAll("[+-]","");
				DecimalFormat df = new DecimalFormat("#.##");
				
				Double d1=Double.parseDouble(previousClose);
				Double d2=Double.parseDouble(valueChange);			    
				if (add.equals("profit"))
					realTimeValue =d1+d2;		
				else
					realTimeValue =d1-d2;				
			   
				percentChange = ar[6];
				stockExchange = ar[7];
			}
			request.setAttribute("add",add);
			request.setAttribute("realTimeValue", realTimeValue);
			request.setAttribute("stockExchange", stockExchange);
			request.setAttribute("daysLow", daysLow);
			request.setAttribute("daysHigh", daysHigh);
			request.setAttribute("openingValue", openingValue);
			request.setAttribute("previousClose", previousClose);
			request.setAttribute("valueChange", valueChange);
			
			request.getSession().setAttribute("finalStockValue", realTimeValue);
			request.getSession().setAttribute("stockExchangeValue", stockExchange);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
