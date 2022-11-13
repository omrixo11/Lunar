package com.esprit.lunar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList brand,year,name,serialNumber,quantity;
    Activity activity;

    CustomAdapter(Activity activity, Context context,ArrayList brand,ArrayList year,ArrayList name, ArrayList serialNumber, ArrayList quantity){

        this.activity = activity;
        this.context = context;
        this.brand = brand;
        this.year = year;
        this.name = name;
        this.serialNumber = serialNumber;
        this.quantity = quantity;
    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.singledata,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {

        holder.Brand.setText(String.valueOf(brand.get(position)));
        holder.Year.setText(String.valueOf(year.get(position)));
        holder.Name.setText(String.valueOf(name.get(position)));
        holder.SerialNumber.setText(String.valueOf(serialNumber.get(position)));
        holder.Quantity.setText(String.valueOf(quantity.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (context, UpdateActivity.class);
                intent.putExtra("brand",String.valueOf(brand.get(position)));
                intent.putExtra("year",String.valueOf(year.get(position)));
                intent.putExtra("name",String.valueOf(name.get(position)));
                intent.putExtra("serialNumber",String.valueOf(serialNumber.get(position)));
                intent.putExtra("quantity",String.valueOf(quantity.get(position)));
                activity.startActivityForResult(intent,1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return brand.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView Brand,Year,Name,SerialNumber,Quantity;
        LinearLayout mainLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Brand = itemView.findViewById(R.id.Brand);
            Year = itemView.findViewById(R.id.Year);
            Name = itemView.findViewById(R.id.Name);
            SerialNumber = itemView.findViewById(R.id.SerialNumber);
            Quantity = itemView.findViewById(R.id.Quantity);
            mainLayout = itemView.findViewById(R.id.mainLayout);

        }
    }
}
