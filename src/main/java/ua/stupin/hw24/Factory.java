package ua.stupin.hw24;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "factory")
public class Factory {
    private Set<Device> device;
    int iD;
    private String name;
    private String country;

    public Factory() {

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

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @OneToMany
    @JoinColumn(name = "factoryID")
    private Set<Device> getDevice() {
        return device;
    }

    public void setDevice(Set<Device> device) {
        this.device = device;
    }

    @Override
    public String toString() {
        return "Factory{" +
                "iD=" + iD +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}