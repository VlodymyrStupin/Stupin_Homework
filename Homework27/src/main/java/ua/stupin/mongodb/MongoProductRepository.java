package ua.stupin.mongodb;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;

import java.util.ArrayList;
import java.util.List;

public class MongoProductRepository<T> implements MongoRepository<T> {

    private final MongoCollection<T> mongoCollection;

    public MongoProductRepository(Class<T> clazz) {
        this.mongoCollection = MongoDbClient.createMongoCollection(clazz);
    }

    @Override
    public void addMultipleData(List<T> data) {
        mongoCollection.insertMany(data);
    }

    @Override
    public void addSingleData(T data) {
        mongoCollection.insertOne(data);
    }

    @Override
    public List<T> getAllData() {
        List<T> list = new ArrayList<>();
        mongoCollection.find().forEach(list::add);
        return list;
    }

    @Override
    public T getDataByParameter(String parameter) {
        return mongoCollection.find(Filters.eq("name", parameter)).first();
    }

    @Override
    public void clearAllData() {
        mongoCollection.drop();
    }
}