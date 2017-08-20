package com.example.paulapariselias.groceries.adapters;

import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.paulapariselias.groceries.R;
import com.example.paulapariselias.groceries.data.Queries;
import com.example.paulapariselias.groceries.models.Grocery;

import java.util.List;

/**
 * Created by paulapariselias on 19-08-17.
 */

public class GroceriesAdapter extends RecyclerView.Adapter<GroceriesAdapter.ViewHolder> {

    private List<Grocery> groceries = new Queries().groceries();

    private GroceryClickListener listener;


    public GroceriesAdapter(GroceryClickListener listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_grocery, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        final Grocery grocery = groceries.get(position);
        holder.name.setText(grocery.getName());
        holder.done.setChecked(grocery.isDone());


        holder.done.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isCheked) {

                if (isCheked){

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                        int auxPosition = holder.getAdapterPosition();
                            Grocery auxGrocery = groceries.get(auxPosition);
                            auxGrocery.setDone(true);
                            auxGrocery.save();
                            groceries.remove(auxPosition);
                            notifyItemRemoved(auxPosition);
                        }
                    },500);
                }

            }
        });

        holder.name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Grocery auxGrocery = groceries.get(holder.getAdapterPosition());
                listener.clickedId(auxGrocery.getId());

            }
        });



    }

    @Override
    public int getItemCount() {

        return  groceries.size();
    }


    public void update(Grocery grocery){

        groceries.add(grocery);
        notifyDataSetChanged();
    }



    static class ViewHolder extends RecyclerView.ViewHolder {

        private CheckBox done;
        private TextView name;


        public ViewHolder(View itemView) {
            super(itemView);

            done = itemView.findViewById(R.id.groceryCb);
            name =itemView.findViewById(R.id.groceryTv);

        }
    }
}
