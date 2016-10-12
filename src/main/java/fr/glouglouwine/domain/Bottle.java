package fr.glouglouwine.domain;

import java.time.LocalDateTime;

public class Bottle {
	public Bottle(long bottleId, String ownerId, GrapeTypes grapeType, String domain, String year) {
		super();
		this.bottleId = bottleId;
		this.ownerId = ownerId;
		this.grapeType = grapeType;
		this.domain = domain;
		this.year = year;
		this.quantity = 1.0;
	}
	private long bottleId;
	private String ownerId;
	private GrapeTypes grapeType;
	private String domain;
	private String year;
	private double quantity;
	private LocalDateTime openingDate;
	private LocalDateTime finishingDate;
	
	public void drink(double quantity,LocalDateTime dateTime){
		
	}
	
}
