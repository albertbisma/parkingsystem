package com.apps.parkingsystem.model;

import com.apps.parkingsystem.entity.PaymentMethods;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"GenericResponse", "paymentMethods"})
@JsonInclude(Include.NON_NULL)
public class PaymentMethodsResponse extends BaseResponse{
	private PaymentMethods paymentMethods;

	public PaymentMethods getPaymentMethods() {
		return paymentMethods;
	}

	public void setPaymentMethods(PaymentMethods paymentMethods) {
		this.paymentMethods = paymentMethods;
	}
	
}
