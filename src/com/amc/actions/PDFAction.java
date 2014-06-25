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

public class PDFAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	System.out.println("FINALLPDF DONE");
	return null;
	
}}
