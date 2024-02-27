package com.appsbyanusha.linkedinlearning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.appsbyanusha.linkedinlearning.model.Reservation;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.internal.bulk.DeleteRequest;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReservationServiceImpl implements ReservationService {

	private final ReactiveMongoOperations reactiveMongoOperations;
	
	@Autowired
	public ReservationServiceImpl(ReactiveMongoOperations reactiveMongoOperations) {
		this.reactiveMongoOperations = reactiveMongoOperations;
	}
	@Override
	public Mono<Reservation> getReservation(String id) {
		return reactiveMongoOperations.findById(id, Reservation.class);
	}

	@Override
	public Mono<Reservation> createReservation(Mono<Reservation> reservation) {
		return reactiveMongoOperations.save(reservation);
	}

	@Override
	public Mono<Reservation> updateReservation(String id, Mono<Reservation> reservation) {
		//return reactiveMongoOperations.save(reservation);
		//update just price
		return reservation.flatMap(r -> reactiveMongoOperations.findAndModify(Query.query(Criteria.where("id").is(id)),
					Update.update("price", r.getPrice()),
					Reservation.class).flatMap(
							result -> {
								result.setPrice(r.getPrice());
								return Mono.just(result);
							}));
	}

	@Override
	public Mono<Boolean> deleteReservation(String id) {
		return reactiveMongoOperations.remove(
				Query.query(Criteria.where("id").is(id)),Reservation.class
				).flatMap(deleteResult -> Mono.just(deleteResult.wasAcknowledged()));
	}
	@Override
	public Flux<Reservation> listAllReservations() {
		return reactiveMongoOperations.findAll(Reservation.class);
	}

}
