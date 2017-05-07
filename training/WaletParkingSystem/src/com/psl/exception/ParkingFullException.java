package com.psl.exception;

public class ParkingFullException extends Exception {

	@Override
	public void printStackTrace() {
		System.out.println("Parking Is Full Exception !");
		super.printStackTrace();
	}

	
}
