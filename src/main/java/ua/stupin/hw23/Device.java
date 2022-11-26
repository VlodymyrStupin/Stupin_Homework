package ua.stupin.hw23;

import java.util.Date;

public class Device {
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

    int iD;
    String type;
    String modelName;
    int price;
    Date creationDate;
    String description;
    boolean availabilityInWarehouse;
    int factoryID;


    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailabilityInWarehouse() {
        return availabilityInWarehouse;
    }

    public void setAvailabilityInWarehouse(boolean availabilityInWarehouse) {
        this.availabilityInWarehouse = availabilityInWarehouse;
    }

    public int getFactoryID() {
        return factoryID;
    }

    public void setFactoryID(int factoryID) {
        this.factoryID = factoryID;
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
