package fr.glouglouwine.domain;

import java.time.LocalDateTime;

public class Bottle {

    private long id;
    private String owner;
    private GrapeTypes grapeType;
    private String domain;
    private int year;
    private int quantity;
    private LocalDateTime openingDate;
    private LocalDateTime finishingDate;

    // is for serialization
    public Bottle() {
    }

    // is the "functional" constructor
    public Bottle(long id, String owner, GrapeTypes grapeType, String domain, int year) {
        this.id = id;
        this.owner = owner;
        this.grapeType = grapeType;
        this.domain = domain;
        this.year = year;
        this.quantity = 100;
    }

    // is for instanciation from existing entry
    public Bottle(long id, String owner, GrapeTypes grapeType, String domain, int year, int quantity,
                  LocalDateTime openingDate, LocalDateTime finishingDate) {
        this.id = id;
        this.owner = owner;
        this.grapeType = grapeType;
        this.domain = domain;
        this.year = year;
        this.quantity = quantity;
        this.openingDate = openingDate;
        this.finishingDate = finishingDate;
    }

    public void drink(int quantity, LocalDateTime dateTime) {
        if (quantity < 0) {
            throw new IllegalArgumentException("You can not drink a null or negative quantity of the bottle. Maybe you mean you refilled it");
        }
        if (this.quantity - quantity < 0) {
            throw new IllegalArgumentException("You can not drink more than 100% of the bottle");
        }
        if (openingDate == null) {
            openingDate = dateTime;
        } else if (openingDate.isAfter(dateTime)) {
            throw new IllegalArgumentException("You can not have drinked your bottle before his opening");
        }
        this.quantity = this.quantity - quantity;
        if (this.quantity == 0) {
            finishingDate = dateTime;
        }
    }

    public long getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public GrapeTypes getGrapeType() {
        return grapeType;
    }

    public String getDomain() {
        return domain;
    }

    public int getYear() {
        return year;
    }

    public double getQuantity() {
        return quantity;
    }

    public LocalDateTime getOpeningDate() {
        return openingDate;
    }

    public LocalDateTime getFinishingDate() {
        return finishingDate;
    }

}
