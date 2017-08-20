package com.example.paulapariselias.groceries.views.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.paulapariselias.groceries.R;
import com.example.paulapariselias.groceries.adapters.GroceriesAdapter;
import com.example.paulapariselias.groceries.adapters.GroceryClickListener;
import com.example.paulapariselias.groceries.models.Grocery;
import com.example.paulapariselias.groceries.views.details.DetailsGroceriesActivity;

/**
 * A placeholder fragment containing a simple view.
 */
public class GroceriesFragment extends Fragment implements GroceryClickListener {

    public static String GROCERIES_ID = "com.example.paulapariselias.groceries.views.KEY.GROCERIES_ID";

    private GroceriesAdapter adapter;



    public GroceriesFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.groceriesRv);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);



        adapter = new GroceriesAdapter(this);
        recyclerView.setAdapter(adapter);



        }




  public void updateList(Grocery grocery){
      adapter.update(grocery);

      Log.d("E2", grocery.getName());
  }

    @Override
    public void clickedId(long id) {

        Intent intent = new Intent(getContext(), DetailsGroceriesActivity.class);
        intent.putExtra(GROCERIES_ID,id);
        startActivity(intent);
    }


    }

