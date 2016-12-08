package com.example.kushal.listviewwithpicasseandglide;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class DummyRecyclerAda extends RecyclerView.Adapter<DummyRecyclerAda.MyViewHolder> {

    ArrayList<Notes> notesArrayList ;
    Context mContext;


    /*constructor*/
    public DummyRecyclerAda(Context mContext, ArrayList<Notes> notesArrayList) {
        this.notesArrayList=notesArrayList;
        this.mContext=mContext;
    }


    @Override
    public DummyRecyclerAda.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {


        Log.i("TAG", "onCreateViewHolder: ");

        View itemView = LayoutInflater.from(mContext).inflate(R.layout.notes_item, parent, false);
        return new MyViewHolder(itemView);


    }

    @Override
    public void onBindViewHolder(DummyRecyclerAda.MyViewHolder holder, int position) {


        holder.tvNotesDescription.setText(notesArrayList.get(position).notesDescription);
        holder.tvNOtesTitle.setText(notesArrayList.get(position).notesTitle);


        Log.i("TAG", "onBindViewHolder: ");

    }

    @Override
    public int getItemCount() {
        return notesArrayList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvNOtesTitle;
        TextView tvNotesDescription;

        public MyViewHolder(View view) {
            super(view);

            tvNOtesTitle = (TextView) view.findViewById(R.id.tvNotesTitle);
            tvNotesDescription = (TextView) view.findViewById(R.id.tvNotesDescription);
        }
    }


}
