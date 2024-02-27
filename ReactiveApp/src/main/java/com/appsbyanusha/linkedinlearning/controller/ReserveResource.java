package com.appsbyanusha.linkedinlearning.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appsbyanusha.linkedinlearning.model.Reservation;
import com.appsbyanusha.linkedinlearning.service.ReservationService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(ReserveResource.ROOM_V1_RESERVATION)
@CrossOrigin
public class ReserveResource {

	public static final String ROOM_V1_RESERVATION = "/room/v1/reservation/";
	
	@Autowired
	private ReservationService reservationService;
	
	@GetMapping(path = "{roomId}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Mono<Reservation> getReservationById(@PathVariable("roomId") String roomId){
		return reservationService.getReservation(roomId);
	}
	
	@PostMapping(path = "", produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Reservation> createReservation(@RequestBody Mono<Reservation> reservation){
		return reservationService.createReservation(reservation);
	}
	
	@PutMapping(path = "{roomId}", produces=MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Mono<Reservation> updateReservation(@PathVariable String roomId, @RequestBody Mono<Reservation> reservation){
		return reservationService.updateReservation(roomId, reservation);
	}
	
	@DeleteMapping(path = "{roomId}")
	public Mono<Boolean> deleteReservation(@PathVariable String roomId){
		return reservationService.deleteReservation(roomId);
	}
	
	@GetMapping(path = "", produces=MediaType.APPLICATION_JSON_VALUE)
	public Flux<Reservation> getAllReservations(){
		System.out.println(reservationService.listAllReservations());
		return reservationService.listAllReservations();
	}

}
