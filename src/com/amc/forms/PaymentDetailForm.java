package com.amc.forms;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class PaymentDetailForm extends ActionForm {

	private String cnumber;
	private String cname2;
	private int cvv2;
	/**
	 * @return the cnumber
	 */
	public String getCnumber() {
		return cnumber;
	}
	/**
	 * @param cnumber the cnumber to set
	 */
	public void setCnumber(String cnumber) {
		this.cnumber = cnumber;
	}
	/**
	 * @return the cname2
	 */
	public String getCname2() {
		return cname2;
	}
	/**
	 * @param cname2 the cname2 to set
	 */
	public void setCname2(String cname2) {
		this.cname2 = cname2;
	}
	/**
	 * @return the cvv2
	 */
	public int getCvv2() {
		return cvv2;
	}
	/**
	 * @param cvv2 the cvv2 to set
	 */
	public void setCvv2(int cvv2) {
		this.cvv2 = cvv2;
	}
		

}
