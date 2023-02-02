package com.qa.polymorphism.repos;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.qa.polymorphism.entities.Car;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class CarRepoMongo implements CarRepo {

    private final MongoClient mongoClient;

    private final MongoDatabase db;

    private final MongoCollection collection;

    public CarRepoMongo() {
        this("localhost", 27017, "sky", "garage");

    }


    public CarRepoMongo(String host, int port, String db, String collection) {
        super();
        this.mongoClient = new MongoClient(host, port);
        this.db = mongoClient.getDatabase(db);
        this.collection = this.db.getCollection(collection);
    }

    private Car convertDocument(Document doc) {
        Car c = new Car();
//        c.setId(doc.getInteger("_id"));
        c.setMake(doc.getString("make"));
        c.setModel(doc.getString("model"));
        c.setColour(doc.getString("colour"));
        return c;
    }

    @Override
    public void create(Car c) {

    }

    @Override
    public List<Car> read() {
        List<Car> cars = new ArrayList<>();
        db.getCollection("car").find().map(this::convertDocument).forEach(new Consumer<Car>() {
            @Override
            public void accept(Car car) {
                cars.add(car);
            }
        });
        return cars;
    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }
}
