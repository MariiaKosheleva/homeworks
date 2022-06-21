package ua.kosheleva.hw26.utils;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

public class MongoDBUtil {
    private static MongoClient mongoClient;

    public static MongoDatabase connect(String dataBaseName) {
        return getMongoClient(null).getDatabase(dataBaseName);
    }

    public static MongoDatabase connect(String dataBaseName, MongoCredential credential) {
        return getMongoClient(credential).getDatabase(dataBaseName);
    }

    private static MongoClient getMongoClient(MongoCredential credential) {
        if (mongoClient != null) return mongoClient;

        final MongoClientOptions.Builder options = MongoClientOptions.builder();

        return credential == null
                ? new MongoClient("localhost", 27017)
                : new MongoClient(
                new ServerAddress("localhost", 27017),
                credential,
                options.build());
    }


}
