package com.example.myfood_son.Adapters;


import android.content.Context;
import android.content.Intent;
import android.view.*;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myfood_son.FoodDetailActivity_Son;
import com.example.myfood_son.Models.Food_NTNSon;
import com.example.myfood_son.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FoodAdapter_Son extends RecyclerView.Adapter<FoodAdapter_Son.FoodViewHolder> {

    Context context;
    List<Food_NTNSon> list;

    public FoodAdapter_Son(Context context, ArrayList<Food_NTNSon> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_food_item, parent, false);
        return new FoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food_NTNSon f = list.get(position);
        holder.txtName.setText(f.name);
        holder.txtPrice.setText("Từ " + (int)f.priceSmall + "đ");
        Picasso.get().load(f.image).into(holder.img);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, FoodDetailActivity_Son.class);
            intent.putExtra("foodId", f.id);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class FoodViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtPrice;
        ImageView img;

        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtFoodName_Son);
            txtPrice = itemView.findViewById(R.id.txtFoodPrice_Son);
            img = itemView.findViewById(R.id.imgFood_Son);
        }
    }
}
