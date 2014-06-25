package com.amc.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.amc.db.DBConnectivity;
import com.amc.forms.PaymentDetailForm;

public class PayAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		
		PaymentDetailForm pf=(PaymentDetailForm)form;
		System.out.println(pf.getCnumber());
		System.out.println(pf.getCname2());
		System.out.println(pf.getCvv2());
		DBConnectivity dbc=new DBConnectivity();
		
		String totalAmount=request.getSession().getAttribute("total_amount").toString();
		String action=request.getSession().getAttribute("actionName").toString();
		boolean xyz=dbc.validateUser(pf.getCnumber(),pf.getCname2(),pf.getCvv2(),totalAmount,action);
		
		System.out.println("VALUS IS:::"+xyz);
		
		if(xyz){
		String cname=null;
		String quantity=null;
		String actionName=null;
		String todayDate=null;
		String finalStockValue=null;
		String total_amount=null;
		String folioId=null;
		String stockExchangeValue=null;
		
		if(request.getSession().getAttribute("cname")!=null)
		cname=request.getSession().getAttribute("cname").toString();
		
		if(request.getSession().getAttribute("quantity")!=null)
		quantity=request.getSession().getAttribute("quantity").toString();
		
		if(request.getSession().getAttribute("actionName")!=null)
		actionName=request.getSession().getAttribute("actionName").toString();
		
		if(request.getSession().getAttribute("todayDate")!=null)
		todayDate=request.getSession().getAttribute("todayDate").toString();
		
		if(request.getSession().getAttribute("finalStockValue")!=null)
		finalStockValue=request.getSession().getAttribute("finalStockValue").toString();
		
		if(request.getSession().getAttribute("total_amount")!=null)
		total_amount=request.getSession().getAttribute("total_amount").toString();
		
		if(request.getSession().getAttribute("folioId")!=null)
		folioId=request.getSession().getAttribute("folioId").toString();
		
		if(request.getSession().getAttribute("stockExchangeValue")!=null)
		stockExchangeValue=request.getSession().getAttribute("stockExchangeValue").toString();
		
		DBConnectivity dbct=new DBConnectivity();
		dbct.insertTransactionInfo(cname, quantity, actionName, todayDate, finalStockValue, total_amount, folioId, stockExchangeValue);
		return mapping.findForward("success");
		}else{
		return mapping.findForward("error");	
		}
		
		}
	}

