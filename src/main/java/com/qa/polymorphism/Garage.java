package com.qa.polymorphism;

import com.qa.polymorphism.entities.Car;
import com.qa.polymorphism.repos.CarRepo;

import java.util.Scanner;

public class Garage {

    private final Scanner scan = new Scanner(System.in);

    private final CarRepo repo;

    public Garage(CarRepo repo) {
        this.repo = repo;
    }

    public void manage() {
        String input = "";
        do {
            System.out.println("Enter 1 to add a new Car, 2 to view current cars or q to quit");
            input = this.scan.nextLine().toLowerCase().strip();
            switch (input) {
                case "1":
                    System.out.println("Enter a make:");
                    String make = this.scan.nextLine().strip();
                    System.out.println("Enter a model:");
                    String model = this.scan.nextLine().strip();
                    System.out.println("Enter a colour:");
                    String colour = this.scan.nextLine().strip();
                    
                    this.repo.create(new Car(make, model, colour));

                    System.out.println("Car created successfully (probably)");
                    break;
                case "2":
                    System.out.println(this.repo.read());
                    break;
                case "q":
                    break;
                default:
            }
        } while (!input.equals("q"));
        System.out.println("BYE!");
    }
}
