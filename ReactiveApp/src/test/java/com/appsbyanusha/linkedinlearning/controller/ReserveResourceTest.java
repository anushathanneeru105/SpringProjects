package com.appsbyanusha.linkedinlearning.controller;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import com.appsbyanusha.linkedinlearning.model.Reservation;

import reactor.core.publisher.Mono;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReserveResourceTest {

	@Autowired
	private ApplicationContext context;
	
	private WebTestClient webTestClient;

	private Reservation reservation;
	
	
	@Before
	public void setUp() throws Exception {
		webTestClient =  WebTestClient.bindToApplicationContext(context).build();
		
		reservation = new Reservation(123l,LocalDate.now(),LocalDate.now().plus(10, ChronoUnit.DAYS),250);
	}

	@Test
	public void testCreateReservation() {
		webTestClient.post().uri(ReserveResource.ROOM_V1_RESERVATION).
		body(Mono.just(reservation),Reservation.class).exchange().
		expectStatus().isOk().expectHeader().contentType(MediaType.APPLICATION_JSON_VALUE).
		expectBody(Reservation.class);
	}
	@Test
	public void testGetAllReservations() {
		webTestClient.get().uri(ReserveResource.ROOM_V1_RESERVATION).exchange().
		expectStatus().isOk().expectBodyList(Reservation.class);
	}

}
