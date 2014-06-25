package com.amc.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.amc.db.DBConnectivity;
import com.amc.forms.LogonForm;
import com.amc.utility.AMCUtility;

public class LogonAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("FINALLY I A M IN  POSITION TO CALL DATABASE");
		LogonForm abcd=(LogonForm)form;
		System.out.println("FOLIO ALA RE AALA"+abcd.getFolioNumber());
		System.out.println("PIN ALI RE AALI"+abcd.getPin());
		
		ActionErrors errors = new ActionErrors();
		  if ((abcd.getFolioNumber()==null) || (abcd.getFolioNumber().length() < 1)) 
		      errors.add("folioNumber", new ActionError("error.folioNumber.required"));
		  
		  
		  
		DBConnectivity dbc=new DBConnectivity();
		boolean val=dbc.validateUser(abcd.getFolioNumber(), abcd.getPin());
		if(val){
			request.getSession().setAttribute("folioId",abcd.getFolioNumber());
			String name=dbc.getName(abcd.getFolioNumber());
			request.getSession().setAttribute("name",name);
			return mapping.findForward("dbCall");
		}
		else
			return mapping.findForward("error");
		
	}
}
