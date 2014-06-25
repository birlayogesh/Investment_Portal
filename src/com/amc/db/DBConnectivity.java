package com.amc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBConnectivity {
	String URL = "jdbc:derby:net://localhost:50000/AMCDB";
	String USER = "devuser";
	String PASS = "Password1";
	Statement stmt = null;

	public void createConnection() {
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");

			System.out.println("Connecting to a selected database...");
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("Connected database successfully...");

		} catch (Exception ex) {
			System.out.println("Error: unable to load driver class!");
			System.exit(1);
		}
	}

	public void insertUserRecord(String folio, String pin) {
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			System.out.println("Connecting to a selected database...");
			Connection conn = DriverManager.getConnection(URL, USER, PASS);

			System.out.println("Inserting records into the table...");
			stmt = conn.createStatement();
			String sql = "INSERT INTO LOGINUSER " + "VALUES (default,'" + folio
					+ "','" + pin + "')";
			System.out.println("QUERY:::" + sql);
			stmt.executeUpdate(sql);
			System.out.println("Record inserted into the table...");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean validateUser(String folio, String pin) {
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");

			System.out.println("Connecting to a selected database...");
			Connection conn = DriverManager.getConnection(URL, USER, PASS);

			System.out.println("Selecting records into the table...");
			stmt = conn.createStatement();
			String sql = "Select * from LOGINUSER";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String folioNo = rs.getString("FOLIO");
				System.out.println("FOLIO::" + folioNo);

				String pinNo = rs.getString("PIN");
				System.out.println("FOLIO::" + pinNo);

				if (folioNo.equals(folioNo) && pin.equals(pinNo))
					return true;
			}
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean enrollUser(String firstname, String lastname,
			String address, String emailId, String panNum) {
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			System.out.println("Connecting to a selected database...");
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("Inserting records into the table...");
			stmt = conn.createStatement();
			String sql = "INSERT INTO USERINFO " + "VALUES (default,'"
					+ firstname + "','" + lastname + "','" + address + "','"
					+ emailId + "','" + panNum + "')";
			System.out.println("QUERY:::" + sql);
			stmt.executeUpdate(sql);
			System.out.println("Record inserted into the table...");
			String abc[] = (String[]) getStockCompanyInfo();
			for (int i = 0; i < abc.length; i++)
				abc[i] = "Abc";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public String[] getStockCompanyInfo() {
		List<String> myList = new ArrayList<String>();
		String a1[] = new String[100];
		String s1 = null;
		int i = 0;
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			System.out.println("Connecting to a selected database...");
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("Selecting records into the table...");
			stmt = conn.createStatement();
			String sql = "Select * from STOCKCOMPANYINFO";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String name = rs.getString("NAME");
				myList.add(name);
				a1[i] = name;
				i++;
			}

			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return a1;
	}

	public String getCompanyId(String companyName) {
		String companyID = null;
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			System.out.println("Connecting to a selected database...");
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("Selecting records into the table...");
			stmt = conn.createStatement();
			String sql = "Select * from STOCKCOMPANYINFO";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String name = rs.getString("NAME");
				System.out.println("NAME IS:" + name);
				if (name.equals(companyName)) {
					companyID = rs.getString("COMPANY_CODE");
					break;
				}

			}
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return companyID;
	}

	public String getName(String folioId) {
		String firstname = null;
		String lastname = null;
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			System.out.println("Connecting to a selected database...");
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("Selecting records into the table...");
			stmt = conn.createStatement();
			String sql = "Select * from USERINFO";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String name = rs.getString("folioid");
				System.out.println("NAME IS:" + name);
				if (name.equals(folioId)) {
					firstname = rs.getString("firstname");
					lastname = rs.getString("lastname");
					break;
				}

			}
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return firstname + " " + lastname;
	}

	public void insertTransactionInfo(String cname, String quantity,
			String actionName, String todayDate, String finalStockValue,
			String total_amount, String folioId, String stockExchangeValue) {

		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");// dd/MM/yyyy
		Date now = new Date();
		String strDate = sdfDate.format(now);
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			System.out.println("Connecting to a selected database...");
			Connection conn = DriverManager.getConnection(URL, USER, PASS);

			System.out.println("Inserting records into the table...");
			stmt = conn.createStatement();
			String sql = "INSERT INTO TRANSACTION_INFO " + "VALUES (default,'"
					+ folioId + "','" + strDate + "','" + cname + "','"
					+ quantity + "','" + finalStockValue + "','" + total_amount
					+ "','" + actionName + "','" + stockExchangeValue + "')";
			System.out.println("QUERY:::" + sql);
			stmt.executeUpdate(sql);
			System.out.println("Record inserted into the table...");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public List<String[]> getTransactionInfo(String folioId) {
		List<String[]> myList = new ArrayList<String[]>();
		String s1 = null;
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			System.out.println("Connecting to a selected database...");
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("Selecting records into the table...");
			stmt = conn.createStatement();
			String sql = "Select * from TRANSACTION_INFO";
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int i = 0;
				String a1[] = new String[100];
				if (rs.getString("FOLIOID").equals(folioId)) {
					a1[i++] = rs.getString("FOLIOID");
					a1[i++] = rs.getString("DATE");
					a1[i++] = rs.getString("COMPANY_NAME");
					a1[i++] = rs.getString("QUANTITY");
					a1[i++] = rs.getString("REALTIMEVALUE");
					a1[i++] = rs.getString("TOTAL_AMOUNT");
					a1[i++] = rs.getString("ACTION");
					a1[i++] = rs.getString("STOCKEXCHANGE");
					myList.add(a1);
				}
			}

			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return myList;
	}

	public boolean validateUser(String cardNumber, String cname, int pin,
			String totalAmount,String action) {

		String cardNumberdb = null;
		String pindb = null;
		double amount = new Double(totalAmount);
		String card_holder = null;
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			System.out.println("Connecting to a selected database...");
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("Selecting records into the table...");
			stmt = conn.createStatement();
			String sql = "Select * from USER_PMT_INFO";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				if(action.equalsIgnoreCase("sell")){
				double dbamount = new Double(rs.getString("BALANCE_AMOUNT"));
				double remainingAmount = dbamount + amount;
				String remAmount = String.valueOf(remainingAmount);
				String sql2 = "update USER_PMT_INFO set balance_amount="
						+ "'"
						+ remAmount
						+ "'"
						+ " where cvv_number='333'";
						//+ "'" + pindb + "'";
				System.out.println("QUERY:::" + sql2);
				stmt.executeUpdate(sql2);
				return true;
			}else{
					
				cardNumberdb = rs.getString("CARD_NUMBER");
				pindb = rs.getString("CVV_NUMBER");
				card_holder = rs.getString("CARD_HOLDER");
				int val = new Integer(pindb);
				if (cardNumberdb.equals(cardNumber) && val == pin) {
					double dbamount = new Double(rs.getString("BALANCE_AMOUNT"));
					if (dbamount > amount) {
						double remainingAmount = dbamount - amount;
						String remAmount = String.valueOf(remainingAmount);
						String sql2 = "update USER_PMT_INFO set balance_amount="
								+ "'"
								+ remAmount
								+ "'"
								+ " where cvv_number="
								+ "'" + pindb + "'";
						System.out.println("QUERY:::" + sql2);
						stmt.executeUpdate(sql2);

					}}
					return true;
				}

			}
			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public String[] getTransactionCompanyInfo(String folioId) {
		String a1[] = new String[100];
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			System.out.println("Connecting to a selected database...");
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("Selecting records into the table...");
			stmt = conn.createStatement();
			String sql = "Select * from TRANSACTION_INFO";
			ResultSet rs = stmt.executeQuery(sql);

			String cname[] = new String[100];
			int i = 0;
			System.out.println("Result Set is::" + rs);
			System.out.println("IN COMING FOLIO ID::" + folioId);
			while (rs.next()) {
				if (rs.getString("FOLIOID").equals(folioId)) {
					System.out.println("FOLIO ID::" + rs.getString("FOLIOID"));
					cname[i++] = rs.getString("COMPANY_NAME");
					System.out.println("VAL IS::" + cname[i]);
				}
			}
			rs.close();			
			int i1 = 0;
			String sql1 = "Select * from STOCKCOMPANYINFO";
			
			for (int j = 0; j < cname.length ; j++) {
				if(cname[j]!=null){
			ResultSet rs1 = stmt.executeQuery(sql1);
				while (rs1.next()) {
					String name = rs1.getString("NAME");
					if (cname[j].equals(name)) {
						a1[i1] = name;
						i1++;
					}
				}
			}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a1;
	}
	public String[] getUserInfo(String folioID) {
		List<String> myList = new ArrayList<String>();
		String a1[] = new String[100];
		String s1 = null;
		int i = 0;
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			System.out.println("Connecting to a selected database...");
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("Selecting records into the table...");
			stmt = conn.createStatement();
			String sql = "Select * from userinfo";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String id = rs.getString("folioid");
				if(folioID.equals(id)){
				a1[i++] = rs.getString("firstname");
				a1[i++] = rs.getString("lastname");
				a1[i++] = rs.getString("address");
				a1[i++] = rs.getString("emailid");
				a1[i++] = rs.getString("pannum");
				break;
				}
			}

			rs.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return a1;
	}
}
