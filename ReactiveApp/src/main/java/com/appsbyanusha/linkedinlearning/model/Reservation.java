package com.appsbyanusha.linkedinlearning.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Document
public class Reservation {

	private Long roomNumber;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDate checkIn;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDate checkOut;
	private Integer price;
	
	@Id
	private String ID;
	
	public Reservation() {
		
	}
	
	public Reservation(Long roomNumber, LocalDate checkin, LocalDate checkOut, Integer price) {
		super();
		this.roomNumber = roomNumber;
		this.checkIn = checkin;
		this.checkOut = checkOut;
		this.price = price;
	}

	/**
	 * @return the roomNumber
	 */
	public Long getRoomNumber() {
		return roomNumber;
	}

	/**
	 * @param roomNumber the roomNumber to set
	 */
	public void setRoomNumber(Long roomNumber) {
		this.roomNumber = roomNumber;
	}

	/**
	 * @return the checkin
	 */
	public LocalDate getCheckin() {
		return checkIn;
	}

	/**
	 * @param checkin the checkin to set
	 */
	public void setCheckin(LocalDate checkin) {
		this.checkIn = checkin;
	}

	/**
	 * @return the checkOut
	 */
	public LocalDate getCheckOut() {
		return checkOut;
	}

	/**
	 * @param checkOut the checkOut to set
	 */
	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	/**
	 * @return the price
	 */
	public Integer getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}

	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}
	
	
}
