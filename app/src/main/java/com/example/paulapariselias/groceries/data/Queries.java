package com.example.paulapariselias.groceries.data;

import com.example.paulapariselias.groceries.models.Grocery;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulapariselias on 19-08-17.
 */

public class Queries {

    public List <Grocery> groceries () {

        List <Grocery> groceries = new ArrayList<>();
        List<Grocery> groceryList = Grocery.find(Grocery.class, "done = 0");
        if (groceryList != null && groceryList.size() > 0){
            groceries.addAll(groceryList);
        }
        return groceries;
    }
}
