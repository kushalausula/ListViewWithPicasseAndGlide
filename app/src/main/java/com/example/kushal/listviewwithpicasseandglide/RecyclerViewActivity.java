package com.example.kushal.listviewwithpicasseandglide;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView rvData;
    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);


        rvData=(RecyclerView)findViewById(R.id.rvData);
        mContext=this;
        ArrayList<Notes> notesArrayList=new ArrayList<>();


        for(int i=0;i<10;i++){
            Notes notes=new Notes();
            notes.notesTitle="notestitle   pavan"+i+1;
            notes.notesDescription="notesDescription  sudheer"+i+1;
            notesArrayList.add(notes);
        }

        loadAdapter(notesArrayList);
    }

    void loadAdapter(ArrayList<Notes> notesArrayList) {
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(mContext);
        rvData.setLayoutManager(layoutManager);



        RecyclerAdapter recyclerAdapter=new RecyclerAdapter(mContext,notesArrayList);
        rvData.setAdapter(recyclerAdapter);
    }
}
