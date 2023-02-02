package com.qa.polymorphism;

import com.qa.polymorphism.repos.CarRepoMySQL;

public class Runner {


    public static void main(String[] args) {
//        CarRepo repo = new CarRepoMongo();
//
//        repo.create(new Car("Vauxhall", "Astra", "Black"));
//        repo.create(new Car("Vauxhall", "Corsa", "Blue"));
//        repo.create(new Car("Nissan", "Up", "White"));
//
//
//        System.out.println(repo.read());

        Garage garage = new Garage(new CarRepoMySQL());
        garage.manage();


    }
}
