package com.training.model;

public class Bus {
	
	private String source;
	private String destination;
	private int busId;
	private String type;
	private double fare;
	public Bus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Bus(String source, String destination, int busId, String type, double fare) {
		super();
		this.source = source;
		this.destination = destination;
		this.busId = busId;
		this.type = type;
		this.fare = fare;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getBusId() {
		return busId;
	}
	public void setBusId(int busId) {
		this.busId = busId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	@Override
	public String toString() {
		return "Bus [source=" + source + ", destination=" + destination + ", busId=" + busId + ", type=" + type
				+ ", fare=" + fare + "]";
	}
	
	


}
