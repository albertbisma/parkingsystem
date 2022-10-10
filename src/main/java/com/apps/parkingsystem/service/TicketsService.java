package com.apps.parkingsystem.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import com.apps.parkingsystem.entity.Tickets;
import com.apps.parkingsystem.model.ParkingLotRequest;
import com.apps.parkingsystem.model.ParkingLotResponse;
import com.apps.parkingsystem.model.TicketCheckOutRequest;
import com.apps.parkingsystem.model.TicketPutRequest;
import com.apps.parkingsystem.model.TicketsRequest;
import com.apps.parkingsystem.model.TicketsResponse;
import com.apps.parkingsystem.model.VehicleTypesResponse;
import com.apps.parkingsystem.repository.TicketsRepository;

@Service
public class TicketsService {
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private TicketsRepository ticketsRepository;
	
	final String uri = "http://localhost:8080";
	
	public Tickets findById(Integer id) {
		return ticketsRepository.findById(id).get();
	}		
	
	public TicketsResponse generateTicketCheckIn(TicketsRequest ticketsRequest) {
		Date dateTimeIn = new Date();
		TicketsResponse response = new TicketsResponse();
		String barcode = generateBarcode();
		String ticketNumber = generateTicketNumber(ticketsRequest.getIdVehicleTypes());
//		String platNumber = ticketsRequest.getPlatNumber().isEmpty()?null:ticketsRequest.getPlatNumber();
		ParkingLotResponse parkingLotResponse= restTemplate.getForObject(uri.concat("/parkingLot/"+ticketsRequest.getIdVehicleTypes()), ParkingLotResponse.class);
		
		ParkingLotRequest parkingLotRequest = new ParkingLotRequest();
		parkingLotRequest.setFilledLot(parkingLotResponse.getParkingLot().getFilledLot()+1);
		
		ticketsRepository.save(new Tickets(ticketNumber, dateTimeIn, null, barcode, null, null, null, false, ticketsRequest.getIdVehicleTypes(), null, null));
		restTemplate.put(uri.concat("/parkingLot/filledLot/"+parkingLotResponse.getParkingLot().getId()), parkingLotRequest);
		
		response.setBarcode(barcode);
		response.setTicketNumber(ticketNumber);
		response.setDateTimeIn(dateTimeIn);
		return response;
	}
	
	public TicketsResponse generateTicketCheckOut(TicketCheckOutRequest ticketCheckOutRequest) {
		Tickets tickets = ticketsRepository.findByIdorBarcode(ticketCheckOutRequest.getId(), ticketCheckOutRequest.getBarcode());
		Date dateTimeCheckOut = new Date();
		TicketsResponse response = new TicketsResponse();
		Integer idVehicleTypes = tickets.getIdVehicleTypes();
		
		if(!ObjectUtils.isEmpty(ticketCheckOutRequest.getIdVehicleTypes())) {
			idVehicleTypes = ticketCheckOutRequest.getIdVehicleTypes();
		}
				
		long difference_In_Time = dateTimeCheckOut.getTime() - tickets.getDateTimeIn().getTime();
	    Long totalHour = (difference_In_Time / (60 * 60 * 1000));
	    
	    VehicleTypesResponse vehicleTypesResponse = restTemplate.getForObject(uri.concat("/vehicleTypes/"+ticketCheckOutRequest.getIdVehicleTypes()), VehicleTypesResponse.class);
	    Long totalCost = totalHour * Long.parseLong(vehicleTypesResponse.getVehicleTypes().getCostPerHour().toString());
	    
		ParkingLotResponse parkingLotResponse= restTemplate.getForObject(uri.concat("/parkingLot/"+ticketCheckOutRequest.getIdVehicleTypes()), ParkingLotResponse.class);
		
		ParkingLotRequest parkingLotRequest = new ParkingLotRequest();
		parkingLotRequest.setFilledLot(parkingLotResponse.getParkingLot().getFilledLot()-1);
		
		restTemplate.put(uri.concat("/tickets/checkOut/"+tickets.getId()), new TicketPutRequest(dateTimeCheckOut, ticketCheckOutRequest.getIdPaymentMethods(), idVehicleTypes, ticketCheckOutRequest.getCheckOutBy(), ticketCheckOutRequest.getPlatNumber(), true, totalCost, totalHour.intValue()));
		restTemplate.put(uri.concat("/parkingLot/filledLot/"+parkingLotResponse.getParkingLot().getId()), parkingLotRequest);
		
		response.setTotalCost(totalCost);
		response.setTotalHour(totalHour.intValue());
		response.setIsPayment(true);
		response.setDateTimeOut(dateTimeCheckOut);
		response.setCheckoutBy(ticketCheckOutRequest.getCheckOutBy());
		return response;
	}
	
	public void update(TicketPutRequest request, Integer id) {
		 ticketsRepository.findById(id).map(tickets -> {
			tickets.setDateTimeOut(request.getDateTimeOut());
			tickets.setIdPaymentMethods(request.getIdPaymentMethods());
			tickets.setCheckoutBy(request.getCheckOutBy());
			tickets.setPlatNumber(request.getPlatNumber());
			tickets.setIsPayment(request.getIsPayment());
			tickets.setIdVehicleTypes(request.getIdVehicleTypes());
			tickets.setTotalCost(request.getTotalCost());
			tickets.setTotalHour(request.getTotalHour());
			return ticketsRepository.save(tickets);
		}).get();
	}
	
//	 public void updateProductWithExchange() {
//	        RestTemplate restTemplate = new RestTemplate();
//
//	        String resourceUrl
//	          = "http://localhost:8080/products";
//
//	        // Create the request body by wrapping
//	        // the object in HttpEntity 
//	        HttpEntity<Product> request = new HttpEntity<Product>(
//	            new Product("Television", "Samsung",1145.67,"S001"));
//
//	        // Send the PUT method as a method parameter
//	        restTemplate.exchange(
//	            resourceUrl, 
//	            HttpMethod.PUT, 
//	            request, 
//	            Void.class);
//	        
//	        
//	    }
//	
	

//	Map<String, String> params = new HashMap<String, String>();
//	params.put("id", "2");
//
//	User updatedUser = new User(1, "Alex", "Golan", "a@mail.com");
//	User user = restTemplate.put(URI_USERS_ID, updatedUser, User.class);
	
	private String generateBarcode() {
		return UUID.randomUUID().toString().replace("-", "").substring(0, 22).toUpperCase();
	}
	
	private String generateTicketNumber(Integer idVehicleTypes) {
		Integer maxId = ticketsRepository.getLastIdFromTickets();
		String ticketNumber = String.valueOf((maxId == null?0+1:maxId+1)).concat("|");
		switch (idVehicleTypes) {
		case 1:
			ticketNumber = ticketNumber.concat("M02");
			break;
		case 2:
			ticketNumber = ticketNumber.concat("C04");
			break;
		default:
			ticketNumber = ticketNumber.concat("V00");
			break;
		}
		return ticketNumber; 
	}
	
}
