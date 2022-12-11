package ua.stupin.mongodb;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import static utils.PropertiesCache.getInstance;

public class MongoDbClient {
    private static final CodecRegistry codecRegistry =
            fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                    fromProviders(PojoCodecProvider.builder().automatic(true).build()));

    private static final MongoClientSettings mongoSettings = MongoClientSettings.builder()
            .applyConnectionString(
                    new ConnectionString(getInstance().getProperty("mongodb.database.url")))
            .codecRegistry(codecRegistry)
            .build();
    private static final MongoClient mongoClient =
            MongoClients.create(mongoSettings);

    private static final MongoDatabase database =
            mongoClient.getDatabase(getInstance().getProperty("mongodb.database.name"));

    public static <T> MongoCollection<T> createMongoCollection(Class<T> clazz) {
        return database.getCollection(clazz.getName(), clazz);
    }
}
