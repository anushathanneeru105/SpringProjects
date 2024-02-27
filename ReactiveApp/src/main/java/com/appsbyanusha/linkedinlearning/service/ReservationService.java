package com.appsbyanusha.linkedinlearning.service;

import org.springframework.stereotype.Service;

import com.appsbyanusha.linkedinlearning.model.Reservation;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface ReservationService {
	Mono<Reservation> getReservation(String id);
	Mono<Reservation> createReservation(Mono<Reservation> reservation);
	Mono<Reservation> updateReservation(String id, Mono<Reservation> reservation);
	Mono<Boolean> deleteReservation(String id);
	Flux<Reservation> listAllReservations();
	
}
