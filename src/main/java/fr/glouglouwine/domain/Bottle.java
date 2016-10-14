package fr.glouglouwine.domain;

import java.time.LocalDateTime;

public class Bottle {

    private long bottleId;
    private String owner;
    private GrapeTypes grapeType;
    private String domain;
    private int year;
    // TODO percentage ?
    private int percentage;
    private LocalDateTime openingDate;
    private LocalDateTime finishingDate;

    // is for serialization
    public Bottle() {
    }

    // is the "functional" constructor
    public Bottle(long bottleId, String owner, GrapeTypes grapeType, String domain, int year) {
        this.bottleId = bottleId;
        this.owner = owner;
        this.grapeType = grapeType;
        this.domain = domain;
        this.year = year;
        this.percentage = 100;
    }

    // is for instanciation from existing entry
    public Bottle(long bottleId, String owner, GrapeTypes grapeType, String domain, int year, int percentage,
                  LocalDateTime openingDate, LocalDateTime finishingDate) {
        this.bottleId = bottleId;
        this.owner = owner;
        this.grapeType = grapeType;
        this.domain = domain;
        this.year = year;
        this.percentage = percentage;
        this.openingDate = openingDate;
        this.finishingDate = finishingDate;
    }

    public void drink(int quantity, LocalDateTime dateTime) {
        if (quantity < 0) {
            throw new IllegalArgumentException("You can not drink a null or negative percentage of the bottle. Maybe you mean you refilled it");
        }
        if (this.percentage - quantity < 0) {
            throw new IllegalArgumentException("You can not drink more than 100% of the bottle");
        }
        if (openingDate == null) {
            openingDate = dateTime;
        } else if (openingDate.isAfter(dateTime)) {
            throw new IllegalArgumentException("You can not have drinked your bottle before his opening");
        }
        this.percentage = this.percentage - quantity;
        if (this.percentage == 0) {
            finishingDate = dateTime;
        }
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

    public int getYear() {
        return year;
    }

    public double getPercentage() {
        return percentage;
    }

    public LocalDateTime getOpeningDate() {
        return openingDate;
    }

    public LocalDateTime getFinishingDate() {
        return finishingDate;
    }

}
