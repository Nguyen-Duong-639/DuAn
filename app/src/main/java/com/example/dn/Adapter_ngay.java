package com.example.dn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter_ngay extends RecyclerView.Adapter<Adapter_ngay.ViewHolder>{
    ArrayList<Custom_ngay> custom_ngays;
    Context context;

    public Adapter_ngay(ArrayList<Custom_ngay> custom_ngays,Context context) {
        this.custom_ngays = custom_ngays;
        this.context = context;
    }

    public Adapter_ngay() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //tạo 1 layout cho nó
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        //tạo 1 view
        View itemView=layoutInflater.inflate(R.layout.item_ngay,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //gán dữ liệu vào textview
        Custom_ngay customNgay= custom_ngays.get(position);

        holder.thu.setText(customNgay.getThu());
        holder.mua.setText(customNgay.getMua());
        holder.ndmax.setText(customNgay.getNdmax());
        holder.ndmin.setText(customNgay.getNdmin());
//        Picasso.with(context).load("http://openweathermap.org/img/wn/"+customNgay.getImage()+".png").into(holder.image);
    }

    @Override
    public int getItemCount() {
        return custom_ngays.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView thu,mua,ndmax,ndmin;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            thu=itemView.findViewById(R.id.thu);
            mua=itemView.findViewById(R.id.statusitem);
            ndmax=itemView.findViewById(R.id.ndmax);
            ndmin=itemView.findViewById(R.id.ndmin);
        }
    }
}
