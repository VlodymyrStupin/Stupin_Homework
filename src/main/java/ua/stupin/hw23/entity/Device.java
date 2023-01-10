package ua.stupin.hw23.entity;

import java.util.Date;

public class Device {
    private final int iD;
    private String type;
    private String modelName;
    private int price;
    private Date creationDate;
    private String description;
    private boolean availabilityInWarehouse;
    private int factoryID;

    public Device(int iD, String type, String modelName, int price, Date creationDate, String description, boolean availabilityInWarehouse, int factoryID) {
        this.iD = iD;
        this.type = type;
        this.modelName = modelName;
        this.price = price;
        this.creationDate = creationDate;
        this.description = description;
        this.availabilityInWarehouse = availabilityInWarehouse;
        this.factoryID = factoryID;
    }
    public String getType() {
        return type;
    }
    public String getModelName() {
        return modelName;
    }
    public int getPrice() {
        return price;
    }
    public Date getCreationDate() {
        return creationDate;
    }
    public String getDescription() {
        return description;
    }
    public boolean isAvailabilityInWarehouse() {
        return availabilityInWarehouse;
    }
    public int getFactoryID() {
        return factoryID;
    }
    @Override
    public String toString() {
        return "Device{" +
                "iD=" + iD +
                ", type='" + type + '\'' +
                ", modelName='" + modelName + '\'' +
                ", price=" + price +
                ", creationDate=" + creationDate +
                ", description='" + description + '\'' +
                ", availabilityInWarehouse=" + availabilityInWarehouse +
                ", factoryID=" + factoryID +
                '}';
    }
}
