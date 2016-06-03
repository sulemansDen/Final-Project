package com.example.suleman.finalproject;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


    public class HomeActivity extends AppCompatActivity
            implements NavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener {

        NavigationView navigationView = null;
        Toolbar toolbar = null;
        private ViewPager mPager;
        private LinearLayout mDotsLayout;
        private int mDotsCount;
        static TextView mDotsText[];
        private int mPosition = 0;
        private ImageAdapter mAdapter;
        GridView myGrid;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);

            //Set the fragment initially
//        HomeFragment fragment = new HomeFragment();
//        android.support.v4.app.FragmentTransaction fragmentTransaction =
//                getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.fragment_container, fragment);
//        fragmentTransaction.commit();
            myGrid = (GridView) findViewById(R.id.gridview);
            myGrid.setAdapter(new VivzAdapter(this));
            mPager = (ViewPager) findViewById(R.id.image_pagerview);
            mDotsLayout = (LinearLayout) findViewById(R.id.image_count);
            mPager.addOnPageChangeListener(this);
            mAdapter = new ImageAdapter(getApplicationContext());
            int[] mResources = {R.drawable.profile, R.drawable.ic_launcher,
                    R.drawable.background_material_red, R.drawable.ic_launcher};
            // here we count the number of images we have to know how many dots
            // we need
            mDotsCount = mResources.length;
            mDotsText = new TextView[mDotsCount];

            for (int i = 0; i < mDotsCount; i++) {
                mDotsText[i] = new TextView(getApplicationContext());
                mDotsText[i].setText(".");
                mDotsText[i].setTextSize(45);
                mDotsText[i].setTypeface(null, Typeface.BOLD);
                mDotsText[i].setTextColor(android.graphics.Color.GRAY);
                mDotsLayout.addView(mDotsText[i]);
            }
            mAdapter.setList(mResources);
            mPager.setAdapter(mAdapter);
            // method to set the selected dot color
            setSelectedDotColor(mPosition);
            // Setting the animation for the banner images
            Timer timer = new Timer();
            timer.schedule(new UpdateTimeTask(), 5000, 5000);
            myGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if(position == 0)
                    {
                        Intent i = new Intent(getApplicationContext(),Appliances_Services.class);
                        startActivity(i);
                    }
                    else if(position == 1)
                    {

                        Intent i = new Intent(getApplicationContext(),Carpentry_Services.class);
                        startActivity(i);
                    }
                    else if(position == 2)
                    {

                        Intent i = new Intent(getApplicationContext(),Cleaning_Services.class);
                        startActivity(i);
                    }
                    else if(position == 3)
                    {

                        Intent i = new Intent(getApplicationContext(),ComputerRepairing_Services.class);
                        startActivity(i);
                    }
                    else if(position == 4)
                    {

                        Intent i = new Intent(getApplicationContext(),Electrical_Services.class);
                        startActivity(i);
                    }
                    else if(position == 5)
                    {

                        Intent i = new Intent(getApplicationContext(),Laundry_Services.class);
                        startActivity(i);
                    }
                    else if(position == 6)
                    {

                        Intent i = new Intent(getApplicationContext(),Painting_Services.class);
                        startActivity(i);
                    }
                    else if(position == 7)
                    {

                        Intent i = new Intent(getApplicationContext(),Plumbing_Services.class);
                        startActivity(i);
                    }
                }
            });
            toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);

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

            navigationView = (NavigationView) findViewById(R.id.nav_view);

            //How to change elements in the header programatically
            View headerView = navigationView.getHeaderView(0);
            TextView emailText = (TextView) headerView.findViewById(R.id.email);
            emailText.setText("newemail@email.com");

            navigationView.setNavigationItemSelectedListener(this);
        }

        private void setSelectedDotColor(int position) {
            // setting all dot colors to default color
            for (int i = 0; i < mDotsCount; i++) {
                mDotsText[i].setTextColor(getApplicationContext().getResources().getColor(
                        R.color.dark_grey));
            }
            // setting the selected position's color
            mDotsText[position].setTextColor(getApplicationContext().getResources().getColor(
                    R.color.magenta));
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
            getMenuInflater().inflate(R.menu.home, menu);
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

        @SuppressWarnings("StatementWithEmptyBody")
        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            // Handle navigation view item clicks here.
            int id = item.getItemId();

            if (id == R.id.nav_camera) {
                //Set the fragment initially
//            HomeFragment fragment = new HomeFragment();
//            android.support.v4.app.FragmentTransaction fragmentTransaction =
//                    getSupportFragmentManager().beginTransaction();
//            fragmentTransaction.replace(R.id.fragment_container, fragment);
//            fragmentTransaction.commit();
                // Handle the camera action
            } else if (id == R.id.nav_gallery) {
                //Set the fragment initially
//            HomeFragment fragment = new HomeFragment();
//            android.support.v4.app.FragmentTransaction fragmentTransaction =
//                    getSupportFragmentManager().beginTransaction();
//            fragmentTransaction.replace(R.id.fragment_container, fragment);
//            fragmentTransaction.commit();

            } else if (id == R.id.nav_slideshow) {

            } else if (id == R.id.nav_manage) {

            } else if (id == R.id.nav_share) {

            } else if (id == R.id.nav_send) {

            }

            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            mPosition = position;

            setSelectedDotColor(position);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }

        class UpdateTimeTask extends TimerTask {
            public void run() {
                mPager.post(new Runnable() {
                    public void run() {

                        if (mPager.getCurrentItem() < mAdapter
                                .getCount() - 1) {
                            mPager.setCurrentItem(
                                    mPager.getCurrentItem() + 1, true);


                        } else {
                            mPager.setCurrentItem(0, true);

                        }
                    }
                });
            }
        }

        class Colour {
            int imageId;
            String countryName;

            Colour(int imageId, String countryName) {
                this.imageId = imageId;
                this.countryName = countryName;
            }
        }

        class VivzAdapter extends BaseAdapter {
            ArrayList<Colour> list;
            Context context;

            VivzAdapter(Context context) {
                this.context = context;
                list = new ArrayList<Colour>();
                Resources res = context.getResources();
                String[] temporaryColourNames = res.getStringArray(R.array.color_names);
                int[] colorImages = {R.drawable.appliance, R.drawable.appliance, R.drawable.appliance,
                        R.drawable.appliance, R.drawable.appliance, R.drawable.appliance,R.drawable.appliance,R.drawable.appliance};
                for (int i = 0; i < 8; i++) {
                    Colour tempColor = new Colour(colorImages[i], temporaryColourNames[i]);
                    list.add(tempColor);
                }
            }

            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public Object getItem(int i) {
                return list.get(i);
            }

            @Override
            public long getItemId(int i) {
                return i;
            }

            class ViewHolder {
                ImageView myColor;
                TextView text;

                ViewHolder(View v) {
                    myColor = (ImageView) v.findViewById(R.id.imageView);
                    text = (TextView) v.findViewById(R.id.text);
                }
            }

            @Override
            public View getView(int i, View view, ViewGroup viewGroup) {
                View row = view;
                ViewHolder holder = null;
                if (row == null) {
                    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    row = inflater.inflate(R.layout.single_item, viewGroup, false);
                    holder = new ViewHolder(row);
                    row.setTag(holder);
                } else {
                    holder = (ViewHolder) row.getTag();
                }
                Colour temp = list.get(i);
                holder.myColor.setImageResource(temp.imageId);
                holder.text.setText(temp.countryName);
                return row;


            }
        }
    }

