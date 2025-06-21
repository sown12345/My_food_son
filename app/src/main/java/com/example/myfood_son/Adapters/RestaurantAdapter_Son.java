package com.example.myfood_son.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.*;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfood_son.FoodListActivity_Son;
import com.example.myfood_son.R;
import com.example.myfood_son.Models.Restaurant_NTNSon;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RestaurantAdapter_Son extends RecyclerView.Adapter<RestaurantAdapter_Son.ViewHolder> {

    Context context;
    List<Restaurant_NTNSon> list;

    public RestaurantAdapter_Son(Context context, List<Restaurant_NTNSon> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.restaurant_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Restaurant_NTNSon r = list.get(position);
        holder.txtName.setText(r.name);
        holder.txtAddress.setText(r.address);
        Picasso.get().load(r.image).into(holder.img);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, FoodListActivity_Son.class);
            intent.putExtra("restaurantId", r.resId);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView txtName, txtAddress;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.imgRestaurant_Son);
            txtName = itemView.findViewById(R.id.txtRestaurantName_Son);
            txtAddress = itemView.findViewById(R.id.txtRestaurantAddress_Son);
        }
    }
}
