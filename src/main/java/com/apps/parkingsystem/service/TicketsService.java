package com.apps.parkingsystem.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apps.parkingsystem.entity.Tickets;
import com.apps.parkingsystem.model.TicketsRequest;
import com.apps.parkingsystem.repository.TicketsRepository;

@Service
public class TicketsService {
	
	@Autowired
	private TicketsRepository ticketsRepository;
	
	public Tickets findById(Integer id) {
		return ticketsRepository.findById(id).get();
	}		
	
	public void generateTicketCheckIn(TicketsRequest ticketsRequest) {
		Tickets tickets = new Tickets();
		String barcode = generateBarcode();
		String ticketNumber = generateTicketNumber(ticketsRequest.getIdVehicleTypes());
		String platNumber = ticketsRequest.getPlatNumber().isEmpty()?null:ticketsRequest.getPlatNumber();
		
		ticketsRepository.save(new Tickets(ticketNumber, new Date(), null, barcode, null, null, platNumber, false, null, null));
		
	}
	
	private String generateBarcode() {
		return UUID.randomUUID().toString().replace("-", "").substring(0, 22).toUpperCase();
	}
	
	private String generateTicketNumber(Integer idVehicleTypes) {
		String ticketNumber = String.valueOf((ticketsRepository.getLastIdFromTickets()+1)).concat("|");
		switch (idVehicleTypes) {
		case 1:
			ticketNumber.concat("M02");
			break;
		case 2:
			ticketNumber.concat("C04");
			break;
		default:
			ticketNumber.concat("V00");
			break;
		}
		return ticketNumber; 
	}
	
}
