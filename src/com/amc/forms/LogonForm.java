package com.amc.forms;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class LogonForm extends ActionForm {



	/**
	 * 
	 */
	private String folioNumber = null;
	private String pin = null;

	public String getFolioNumber() {
		return folioNumber;
	}

	public void setFolioNumber(String folioNumber) {
		this.folioNumber = folioNumber;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

@Override
public void reset(ActionMapping arg0, HttpServletRequest arg1) {
	// TODO Auto-generated method stub
	this.folioNumber=null;
	this.pin=null;
}
 @Override
public ActionErrors validate(ActionMapping arg0, HttpServletRequest arg1) {
	// TODO Auto-generated method stub
	 ActionErrors errors = new ActionErrors();
	  if ((this.folioNumber==null) || (this.folioNumber.length() < 1)) 
	      errors.add("folioNumber", new ActionError("error.folioNumber.required"));
	  return errors;
}
}
