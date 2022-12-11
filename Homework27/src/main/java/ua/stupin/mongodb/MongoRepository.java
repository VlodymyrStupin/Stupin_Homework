package ua.stupin.mongodb;

import java.util.List;

public interface MongoRepository <T>{
    void addMultipleData(List<T> data);
    void addSingleData(T data);
    void clearAllData();
    List<T> getAllData();
    T getDataByParameter(String parameter);
}
