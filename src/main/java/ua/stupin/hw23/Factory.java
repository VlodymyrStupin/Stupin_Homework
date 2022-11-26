package ua.stupin.hw23;

public class Factory {
    public Factory(int iD, String name, String country) {
        this.iD = iD;
        this.name = name;
        this.country = country;
    }

    int iD;
    String name;
    String country;



    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
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
