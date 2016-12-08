package com.example.kushal.listviewwithpicasseandglide;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class DummyNotesAdapter extends  BaseAdapter{

    private final LayoutInflater inflater;

    ArrayList<Notes> notesArrayList;
    Context mContext;



    public DummyNotesAdapter(Context mContext, ArrayList<Notes> notesArrayList) {
        this.notesArrayList=notesArrayList;

        this.mContext=mContext;
        inflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {

        Log.i("TAG", "getItem Count: "+notesArrayList.size());
        return notesArrayList.size();
    }


    @Override
    public Object getItem(int i) {
        Log.i("TAG", "getItem: "+i);
        return notesArrayList.get(i);

    }

    @Override
    public long getItemId(int i) {
        Log.i("TAG", "getItemId: "+i);
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Log.i("TAG", "getItemView: "+i);

        view=inflater.inflate(R.layout.notes_item,null);

        TextView tvNOtesTitle= (TextView) view.findViewById(R.id.tvNotesTitle);
        TextView tvNotesDescription= (TextView) view.findViewById(R.id.tvNotesDescription);

        tvNotesDescription.setText(notesArrayList.get(i).notesDescription);
        tvNOtesTitle.setText(notesArrayList.get(i).notesTitle);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.startActivity(new Intent(mContext,RecyclerViewActivity.class));
            }
        });



        return view;
    }
}
