package com.example.ayatidevices.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ayatidevices.R;
import com.example.ayatidevices.TestReportsActivity;
import com.example.ayatidevices.pojo.HistoryPojo;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder>{
    private HistoryPojo[] listdata;

    public HistoryAdapter(HistoryPojo[] listdata) {
        this.listdata = listdata;

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.design_history, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final HistoryPojo HistoryPojo = listdata[position];
        holder.txtName.setText(listdata[position].getName());
        holder.txtDob.setText(listdata[position].getDob());
        holder.imgCertificate.setImageResource(listdata[position].getImgId());

        holder.card_view.setOnClickListener(v ->{
            v.getContext().startActivity(new Intent(v.getContext(), TestReportsActivity.class));
        });

    }


    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imgCertificate,imgShare;
        public TextView txtName,txtDob;
        public CardView card_view;

        public ViewHolder(View itemView) {
            super(itemView);
            this.imgCertificate =itemView.findViewById(R.id.imgCertificate);
            this.imgShare =itemView.findViewById(R.id.imgShare);
            this.txtName = itemView.findViewById(R.id.txtName);
            this.txtDob = itemView.findViewById(R.id.txtDob);
            card_view = itemView.findViewById(R.id.card_view);
        }
    }
}  