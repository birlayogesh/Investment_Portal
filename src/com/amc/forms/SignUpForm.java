package com.amc.forms;

import org.apache.struts.action.ActionForm;

public class SignUpForm extends ActionForm {



	private String firstName = null;
	private String lastName = null;
    private String address=null;
    private String emailId=null;
    private String panNum=null;
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * @param emailId the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	/**
	 * @return the panNum
	 */
	public String getPanNum() {
		return panNum;
	}
	/**
	 * @param panNum the panNum to set
	 */
	public void setPanNum(String panNum) {
		this.panNum = panNum;
	}
    


}
