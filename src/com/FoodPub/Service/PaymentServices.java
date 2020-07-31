package com.FoodPub.Service;

import java.util.ArrayList;
import java.util.List;

import com.FoodPub.Model.FoodItem;
import com.FoodPub.Model.OrderDB;
import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Item;
import com.paypal.api.payments.ItemList;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

public class PaymentServices {
	private static final String CLIENT_ID = "Adl3UV_k_sUvvdT74I3qcnu5U1N_he7stujWSHIBQUt7y4_09QTb8Xgt0OCNY2clYxJJl3uvlv67RP2F";
	private static final String CLIENT_SECRET = "EJX4MJ7FNuB2ixlodopFdYdqOwj28zHXKcpR8sc0b0XdQJb2cWFe3KZhtLwA6pZkQEvK3OSEafPMub0D";
	private static final String MODE = "sandbox";

	public String authorizePayment(OrderDB orderDetail )			
			throws PayPalRESTException {		

		Payer payer = getPayerInformation(orderDetail);
		RedirectUrls redirectUrls = getRedirectURLs();
		List<Transaction> listTransaction = getTransactionInformation(orderDetail);
		
		Payment requestPayment = new Payment();
		requestPayment.setTransactions(listTransaction);
		requestPayment.setRedirectUrls(redirectUrls);
		requestPayment.setPayer(payer);
		requestPayment.setIntent("authorize");

		APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);

		Payment approvedPayment = requestPayment.create(apiContext);

		System.out.println("=== CREATED PAYMENT: ====");
		System.out.println(approvedPayment);

		return getApprovalLink(approvedPayment);

	}
	
	private Payer getPayerInformation(OrderDB orderDetail) {
		Payer payer = new Payer();
		payer.setPaymentMethod("paypal");
	
		PayerInfo payerInfo = new PayerInfo();
		payerInfo.setFirstName(orderDetail.getUserID())
				 .setLastName("")
				 .setEmail("");
		//payerInfo.setExternalReuserMeId(orderDetail.getUserID());
		payer.setPayerInfo(payerInfo);
		
		return payer;
	}
	
	private RedirectUrls getRedirectURLs() {
		RedirectUrls redirectUrls = new RedirectUrls();
		redirectUrls.setCancelUrl("http://localhost:8080/Paypal/cancel.jsp");
		redirectUrls.setReturnUrl("http://localhost:8080/ecommerce/review_payment");
		
		return redirectUrls;
	}
	
	private List<Transaction> getTransactionInformation(OrderDB orderDetail ) {
		
		System.out.println(orderDetail.getShippingFee() + "\n" + orderDetail.getTax() + "\n" + orderDetail.getSubTotal() + "\n" + orderDetail.getTotal());
		
		Details details = new Details();
		details.setShipping(String.valueOf(orderDetail.getShippingFee()));
		details.setSubtotal(String.valueOf(orderDetail.getSubTotal()));
		details.setTax(String.valueOf(orderDetail.getTax()));

		Amount amount = new Amount();
		amount.setCurrency("USD");
		amount.setTotal(String.valueOf(orderDetail.getTotal()));
		amount.setDetails(details);

		Transaction transaction = new Transaction();
		transaction.setAmount(amount);
		transaction.setCustom(orderDetail.getUserID());
		transaction.setInvoiceNumber(orderDetail.getOrderID());
		
		ItemList itemList = new ItemList();
		List<Item> items = new ArrayList<>();
		
		for(FoodItem foodItem : orderDetail.getItemList().keySet()) {			
			Item item = new Item();
			item.setCurrency("USD");
			item.setName(foodItem.getName());
			item.setSku(String.valueOf(foodItem.getItemID()));
			item.setPrice(String.valueOf(foodItem.getPrice()));
			item.setTax(String.valueOf(orderDetail.getTax()));
			item.setQuantity(String.valueOf(orderDetail.getItemList().get(foodItem)));		
			items.add(item);			
		}
		
		itemList.setItems(items);
		transaction.setItemList(itemList);
		itemList.setShippingMethod(orderDetail.getdDate());
		System.out.println("sssssssssssssssssssssssssszzzzz" + itemList.getShippingMethod());

		List<Transaction> listTransaction = new ArrayList<>();
		listTransaction.add(transaction);	
		
		return listTransaction;
	}
	
	private String getApprovalLink(Payment approvedPayment) {
		List<Links> links = approvedPayment.getLinks();
		String approvalLink = null;
		
		for (Links link : links) {
			if (link.getRel().equalsIgnoreCase("approval_url")) {
				approvalLink = link.getHref();
				break;
			}
		}		
		
		return approvalLink;
	}

	public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException {
		PaymentExecution paymentExecution = new PaymentExecution();
		paymentExecution.setPayerId(payerId);

		Payment payment = new Payment().setId(paymentId);

		APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);

		return payment.execute(apiContext, paymentExecution);
	}
	
	public Payment getPaymentDetails(String paymentId) throws PayPalRESTException {
		APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
		return Payment.get(apiContext, paymentId);
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}
}
