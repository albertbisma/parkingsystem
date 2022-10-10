package com.apps.parkingsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apps.parkingsystem.entity.PaymentMethods;
import com.apps.parkingsystem.entity.VehicleTypes;
import com.apps.parkingsystem.model.PaymentMethodsRequest;
import com.apps.parkingsystem.model.VehicleTypesRequest;
import com.apps.parkingsystem.repository.PaymentMethodsRepository;

@Service
public class PaymentMethodsService {
	
	@Autowired
	private PaymentMethodsRepository paymentMethodsRepository;
	
	public PaymentMethods findById(Integer id) {
		return paymentMethodsRepository.findById(id).get();
	}		
	
	public PaymentMethods insert(PaymentMethodsRequest request) {
		return paymentMethodsRepository.save(new PaymentMethods(request.getCode(), request.getDescription()));
	}
	
}
