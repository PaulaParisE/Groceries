package com.example.paulapariselias.groceries.models;

import com.orm.SugarRecord;

/**
 * Created by paulapariselias on 19-08-17.
 */

public class Grocery extends SugarRecord {

    private String name, description;
    private int quantity;
    private boolean done;



    public Grocery() {
    }

    public Grocery(String name, String description, int quantity, boolean done) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.done = done;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
