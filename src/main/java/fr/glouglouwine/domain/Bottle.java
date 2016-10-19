package fr.glouglouwine.domain;

import java.time.LocalDateTime;

public class Bottle {

    private long bottleId;
    private String owner;
    private GrapeTypes grapeType;
    private String domain;
    private String year;
    private int quantity;
    private LocalDateTime openingDate;
    private LocalDateTime finishingDate;

    public Bottle() {
    }

    public Bottle(long bottleId, String owner, GrapeTypes grapeType, String domain, String year) {
        this.bottleId = bottleId;
        this.owner = owner;
        this.grapeType = grapeType;
        this.domain = domain;
        this.year = year;
        this.quantity = 100;
    }

    public Bottle(long bottleId, String owner, GrapeTypes grapeType, String domain, String year, int quantity,
                  LocalDateTime openingDate, LocalDateTime finishingDate) {
        this.bottleId = bottleId;
        this.owner = owner;
        this.grapeType = grapeType;
        this.domain = domain;
        this.year = year;
        this.quantity = quantity;
        this.openingDate = openingDate;
        this.finishingDate = finishingDate;
    }

    public long getBottleId() {
        return bottleId;
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

    public String getYear() {
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

    public void drink(int quantity, LocalDateTime dateTime) {
        if (quantity < 0) {
            throw new IllegalArgumentException("You can not drink a negative quantity of the bottle. Maybe you mean you refilled it");
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

}
