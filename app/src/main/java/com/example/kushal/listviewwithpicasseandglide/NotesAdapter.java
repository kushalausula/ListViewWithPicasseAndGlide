package com.example.kushal.listviewwithpicasseandglide;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.util.ArrayList;

public class NotesAdapter extends BaseAdapter {
    ArrayList<Notes> notesArrayList ;
    Context mContext;
    LayoutInflater inflater;

    public NotesAdapter(Context mContext, ArrayList<Notes> notesArrayList) {
        this.notesArrayList=notesArrayList;
        this.mContext=mContext;

        inflater= (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);



    }

    @Override
    public int getCount() {
        return notesArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return notesArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
/*init part*/
        view=inflater.inflate(R.layout.notes_item,null);
/**********/


       /***** declare views*/
        TextView tvNOtesTitle;
        TextView tvNotesDescription;


        tvNOtesTitle = (TextView) view.findViewById(R.id.tvNotesTitle);
        tvNotesDescription = (TextView) view.findViewById(R.id.tvNotesDescription);

        /*************/

        /*assigning values and onlicks*****/

        tvNotesDescription.setText(notesArrayList.get(i).notesDescription);
        tvNOtesTitle.setText(notesArrayList.get(i).notesTitle);


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.startActivity(new Intent(mContext,RecyclerViewActivity.class));
            }
        });

        /********************/

        return view;
    }
}
