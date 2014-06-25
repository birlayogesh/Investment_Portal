package com.amc.forms;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class PurchaseForm extends ActionForm {

	private String action = null;
	private String companyName;
	private int quantity;
	private String disclaimer;
	private String disclaimerCheck;
	/**
	 * @return the disclaimerCheck
	 */
	public String getDisclaimerCheck() {
		return disclaimerCheck;
	}
	/**
	 * @param disclaimerCheck the disclaimerCheck to set
	 */
	public void setDisclaimerCheck(String disclaimerCheck) {
		this.disclaimerCheck = disclaimerCheck;
	}
	/**
	 * @return the disclaimer
	 */
	public String getDisclaimer() {
		return disclaimer;
	}
	/**
	 * @param disclaimer the disclaimer to set
	 */
	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}
	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}
	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}
	
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
