package ua.stupin.hw24;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "Device")
public class Device {
    private Factory factory;
    private int iD;
    private String type;
    private String modelName;
    private int price;
    private Date creationDate;
    private String description;
    private boolean availabilityInWarehouse;
    private int factoryID;

    public Device() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "modelName")
    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Column(name = "creationDate")
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "availabilityInWarehouse")
    public boolean isAvailabilityInWarehouse() {
        return availabilityInWarehouse;
    }

    public void setAvailabilityInWarehouse(boolean availabilityInWarehouse) {
        this.availabilityInWarehouse = availabilityInWarehouse;
    }

    @Column(name = "factoryID")
    public int getFactoryID() {
        return factoryID;
    }

    public void setFactoryID(int factoryID) {
        this.factoryID = factoryID;
    }

    @ManyToOne
    @JoinColumn(name = "factoryID", insertable = false, updatable = false)
    private Factory getFactory() {
        return factory;
    }

    private void setFactory(Factory factory) {
        this.factory = factory;
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