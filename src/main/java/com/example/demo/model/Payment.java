package com.example.demo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Payment {
      @Id
      private int paymentMethodId;
      private String paymentType;
      private long cardNumber;
      private String expiryDate;
      private String billingAddress;
      
      @OneToOne(cascade = CascadeType.ALL)
      @JoinColumn(name = "orderId")
      private Orders o;

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Payment(int paymentMethodId, String paymentType, long cardNumber, String expiryDate, String billingAddress,
			Orders o) {
		super();
		this.paymentMethodId = paymentMethodId;
		this.paymentType = paymentType;
		this.cardNumber = cardNumber;
		this.expiryDate = expiryDate;
		this.billingAddress = billingAddress;
		this.o = o;
	}

	public int getPaymentMethodId() {
		return paymentMethodId;
	}

	public void setPaymentMethodId(int paymentMethodId) {
		this.paymentMethodId = paymentMethodId;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Orders getO() {
		return o;
	}

	public void setO(Orders o) {
		this.o = o;
	}

	
	
}
