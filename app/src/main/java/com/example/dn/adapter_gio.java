package com.example.dn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter_gio extends RecyclerView.Adapter<adapter_gio.ViewHolder>{
    ArrayList<custom_gio> custom_gios;
    Context context;

    public adapter_gio(ArrayList<custom_gio> custom_gios, Context context) {
        this.custom_gios = custom_gios;
        this.context = context;
    }

    public adapter_gio() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View itemView= layoutInflater.inflate(R.layout.item_gio,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.gio.setText(custom_gios.get(position).getGio());
        holder.nhietdo.setText(custom_gios.get(position).getTemp());
        holder.mua.setText(custom_gios.get(position).getMua());


    }

    @Override
    public int getItemCount() {
        return custom_gios.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView mua;
        TextView gio;
        TextView nhietdo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mua=itemView.findViewById(R.id.mua);
            gio=itemView.findViewById(R.id.gio);
            nhietdo=itemView.findViewById(R.id.nhietdo);
        }
    }
}
