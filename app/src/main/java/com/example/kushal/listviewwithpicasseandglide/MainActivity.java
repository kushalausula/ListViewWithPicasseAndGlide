package com.example.kushal.listviewwithpicasseandglide;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ImageView imgView;

    Context mContext;
    private ImageView imgView1,imgView2,imgView3;
    private ListView lvNotes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        lvNotes=(ListView)findViewById(R.id.lvNotes);
        mContext=this;
        prepareNotesInfo();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        imgView=(ImageView)findViewById(R.id.imgView);
        imgView1=(ImageView)findViewById(R.id.imgView1);
        imgView2=(ImageView)findViewById(R.id.imgView2);
        imgView3=(ImageView)findViewById(R.id.imgView3);
    }

    private void prepareNotesInfo() {

        /*prepare basic notes information here*/

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
         NotesAdapter notesAdapter=new NotesAdapter(mContext,notesArrayList);

         DummyNotesAdapter dummyNotesAdapter=new DummyNotesAdapter(mContext,notesArrayList);

         lvNotes.setAdapter(dummyNotesAdapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    void loadImagesWithPicasso(Context context,ImageView imgView,String url){
//        Picasso.with(context)
//                .load(url)
//                .placeholder(R.drawable.ic_android)
//                .error(R.drawable.ic_error_black_24dp)
//                .into(imgView);

        Glide.with(this).load(url).into(imgView);

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
            loadImagesWithPicasso(mContext,imgView,"http://i.imgur.com/DvpvklR.png");
        } else if (id == R.id.nav_gallery) {
            loadImagesWithPicasso(mContext,imgView1,"http://cdn2.softwaretestinghelp.com/wp-content/qa/uploads/2014/07/Top-Android-Testing-Tools.jpg");
        } else if (id == R.id.nav_slideshow) {
            loadImagesWithPicasso(mContext,imgView2,"https://i.ytimg.com/vi/Q1Od7_6FDY0/maxresdefault.jpg");
        } else if (id == R.id.nav_manage) {
            loadImagesWithPicasso(mContext,imgView3,"http://i.imgur.com/DvpvklR.png");
        } else if (id == R.id.nav_share) {
            loadImagesWithPicasso(mContext,imgView,"http://i.imgur.com/DvpvklR.png");
        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }






}
