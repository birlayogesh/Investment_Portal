package com.amc.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.amc.db.DBConnectivity;
import com.amc.forms.SignUpForm;
import com.amc.utility.AMCUtility;

public class SignUpAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("FINALLY I A M IN  POSITION TO SIGN NEW USER");
		SignUpForm abcd=(SignUpForm)form;
		String firstname=abcd.getFirstName();
		String lastname=abcd.getLastName();
		String address=abcd.getAddress();
		String emailId=abcd.getEmailId();
		String panNum=abcd.getPanNum();
	
		AMCUtility amc=new AMCUtility();
		amc.sendEmail(abcd.getEmailId());
		DBConnectivity dbc=new DBConnectivity();
	    Boolean enroll=(Boolean)dbc.enrollUser(firstname, lastname, address, emailId, panNum);
		return mapping.findForward("signUp");
	}
}
