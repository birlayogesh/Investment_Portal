package com.amc.actions;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.amc.db.DBConnectivity;
import com.amc.forms.PurchaseForm;

public class BuySellAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("IN BUY SELL ACTION");
		PurchaseForm abcd=(PurchaseForm)form;
		abcd.getDisclaimer();
		if(request.getParameter("disclaimerCheck").equals("error")){
			request.getSession().setAttribute("errorMessage","errorMessage");
			return mapping.findForward("error");	
		}
		else{
		PurchaseForm pf=(PurchaseForm)form;
		request.getSession().setAttribute("cname",pf.getCompanyName());
		request.getSession().setAttribute("quantity",pf.getQuantity());
		request.getSession().setAttribute("actionName",pf.getAction());
		request.getSession().setAttribute("todayDate",new Date().toString());
		
		System.out.println("final stock Value::"+request.getSession().getAttribute("finalStockValue"));
		
		String a1=request.getSession().getAttribute("finalStockValue").toString();
		double val=Double.parseDouble(a1);
		String a2=request.getSession().getAttribute("quantity").toString();
		double quant=Double.parseDouble(a2);
		double total_amount=val*quant;
		request.getSession().setAttribute("total_amount",total_amount);
		if(abcd.getAction().equalsIgnoreCase("buy"))
		return mapping.findForward("buy");
		else
		return mapping.findForward("sell");	
		}
	}
}
