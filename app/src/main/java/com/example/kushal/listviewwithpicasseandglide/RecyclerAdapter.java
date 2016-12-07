package com.example.kushal.listviewwithpicasseandglide;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Pupa on 12/7/2016.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    ArrayList<Notes> notesArrayList ;
    Context mContext;


    /*constructor*/
    public RecyclerAdapter(Context mContext, ArrayList<Notes> notesArrayList) {
        this.notesArrayList=notesArrayList;
        this.mContext=mContext;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /*creating view object goes here*/
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.notes_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
            /*set texts and onclicks goes here*/
        holder.tvNotesDescription.setText(notesArrayList.get(position).notesDescription);
        holder.tvNOtesTitle.setText(notesArrayList.get(position).notesTitle);
    }

    @Override
    public int getItemCount()
    {
        return notesArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvNOtesTitle;
        TextView tvNotesDescription;

        public MyViewHolder(View view) {
            super(view);

            tvNOtesTitle = (TextView) view.findViewById(R.id.tvNotesTitle);
            tvNotesDescription = (TextView) view.findViewById(R.id.tvNotesDescription);
        }

    }
}

