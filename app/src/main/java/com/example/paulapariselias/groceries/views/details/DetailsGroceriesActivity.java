package com.example.paulapariselias.groceries.views.details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.widget.EditText;
import android.widget.TextView;

import com.example.paulapariselias.groceries.R;
import com.example.paulapariselias.groceries.models.Grocery;
import com.example.paulapariselias.groceries.views.main.GroceriesFragment;

public class DetailsGroceriesActivity extends AppCompatActivity {

    private Grocery grocery;

    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_groceries);

        editText= (EditText) findViewById(R.id.inputEt);
        TextView textView= (TextView) findViewById(R.id.descriptionTv);


        long idGrocery = getIntent().getLongExtra(GroceriesFragment.GROCERIES_ID,0);

        grocery = Grocery.findById(Grocery.class, idGrocery);

        grocery.getName();



        getSupportActionBar().setTitle(grocery.getName());
        editText.setText(grocery.getName());

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (grocery.getDescription() != null){
            editText.setText(grocery.getDescription());
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        Editable editable = editText.getText();
        grocery.setDescription(String.valueOf(editable));
        grocery.save();




    }
}

