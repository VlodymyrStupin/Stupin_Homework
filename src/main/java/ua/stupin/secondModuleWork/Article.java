package ua.stupin.secondModuleWork;

import com.opencsv.bean.CsvBindByName;

public class Article {
    @CsvBindByName(column = "type")
    private String type;

    @CsvBindByName(column = "series")
    private String series;

    @CsvBindByName(column = "model")
    private String model;

    @CsvBindByName(column = "diagonal")
    private String diagonal;


    @CsvBindByName(column = "screen t" +
            "ype")
    private String screenType;


    @CsvBindByName(column = "country")
    private String country;


    @CsvBindByName(column = "price")
    private String price;

    public String getType() {
        return type;
    }

    public String getSeries() {
        return series;
    }

    public String getModel() {
        return model;
    }

    public String getDiagonal() {
        return diagonal;
    }


    public String getScreenType() {
        return screenType;
    }


    public String getCountry() {
        return country;
    }


    public String getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return '{' + "type='" + type + '\'' +
                ", series='" + series + '\'' +
                ", model='" + model + '\'' +
                ", diagonal='" + diagonal + '\'' +
                ", screenType='" + screenType + '\'' +
                ", country='" + country + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
