package com.qa.polymorphism.repos;

import com.qa.polymorphism.entities.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarRepoMySQL implements CarRepo {


    private final String user;
    private final String pass;

    private final String url;

    public CarRepoMySQL() {
        this("root", "pass", "jdbc:mysql://localhost:3306/garage");
    }

    public CarRepoMySQL(String user, String pass, String url) {
        this.user = user;
        this.pass = pass;
        this.url = url;
    }


    private Car convertResultSet(ResultSet rs) throws SQLException {
        Car c = new Car();
        c.setId(rs.getInt("id"));
        c.setMake(rs.getString("make"));
        c.setModel(rs.getString("model"));
        c.setColour(rs.getString("colour"));
        return c;
    }

    @Override
    public void create(Car c) {
        try (Connection con = DriverManager.getConnection(url, user, pass);
             PreparedStatement stmnt = con.prepareStatement("INSERT INTO Car(make, model, colour) VALUES (?, ? , ?)")
        ) {
            stmnt.setString(1, c.getMake());
            stmnt.setString(2, c.getModel());
            stmnt.setString(3, c.getColour());
            stmnt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Car> read() {
        List<Car> cars = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(url, user, pass);
             Statement stmnt = con.createStatement()
        ) {
            ResultSet rs = stmnt.executeQuery("SELECT * FROM Car");
            while (rs.next()) cars.add(this.convertResultSet(rs));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cars;
    }

    @Override
    public void update() {
        // code
    }

    @Override
    public void delete() {
        // code
    }
}
