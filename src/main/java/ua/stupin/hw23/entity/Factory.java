package ua.stupin.hw23.entity;

public class Factory {
    int iD;
    String name;
    String country;
    public Factory(int iD, String name, String country) {
        this.iD = iD;
        this.name = name;
        this.country = country;
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
