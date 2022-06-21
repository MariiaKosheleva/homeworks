package ua.kosheleva.hw26.dao;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

abstract class AbstractDao<T> {
    protected static final Gson gson = new Gson();
    protected final MongoCollection<Document> collection;

    public AbstractDao(MongoDatabase database, String collectionName) {
        this.collection = database.getCollection(collectionName);
    }

    protected static <T> Document mapFrom(T item) {
        return Document.parse(gson.toJson(item));
    }

    public void insertMany(List<T> list) {
        List<Document> documents = list.stream()
                .map(AbstractDao::mapFrom)
                .collect(Collectors.toList());
        collection.insertMany(documents);
    }

    public List<T> findAll(Class<T> tClass) {
        return collection.find()
                .map(x -> gson.fromJson(x.toJson(), tClass))
                .into(new ArrayList<>());
    }

    public List<T> findAllByFilter(Class<T> tClass, Bson filter) {
        return collection.find(filter)
                .map(x -> gson.fromJson(x.toJson(), tClass))
                .into(new ArrayList<>());
    }
}
