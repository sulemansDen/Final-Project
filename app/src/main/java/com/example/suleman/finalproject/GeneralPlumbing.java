package com.example.suleman.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class GeneralPlumbing extends AppCompatActivity {
    TextView disp;
    int total = 0;
    float countCeiling = 0;
    TextView ceiling;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_plumbing);
        getSupportActionBar().setTitle("General Plumbing Service");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        disp = (TextView) findViewById(R.id.total);
        ceiling = (TextView) findViewById(R.id.ceiling);
    }
    public void result(View v) {
        if (v.getId() == R.id.add) {
            if (countCeiling == 0) {
                countCeiling+=2;
                total += 350;
                disp.setText("Total : Rs " + total);
                ceiling.setText(countCeiling + " Hour(s)");
            }

            else if(countCeiling<8)
            {
                countCeiling+=0.5;
                total += 50;
                disp.setText("Total : Rs " + total);
                ceiling.setText(countCeiling + " Hour(s)");
            }
            else if(countCeiling == 8)
            {
                countCeiling+=0.5;
                total += 50;
                disp.setText("Total : Rs " + total);
                ceiling.setText(countCeiling + " Hour(s) & above");
            }
        }
        else if (v.getId() == R.id.minus) {
            if (countCeiling == 0) {

            }
            else if(countCeiling ==2)
            {
                countCeiling-=2;
                total -= 350;
                disp.setText("Total : Rs " + total);
                ceiling.setText(countCeiling + " Hour(s)");
            }
            else if (countCeiling <= 8.5 ) {
                countCeiling-=0.5;
                total -= 50;
                disp.setText("Total : Rs " + total);
                ceiling.setText(countCeiling + " Hour(s)");
            }
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(android.R.id.home == item.getItemId())
        {
            this.finish();

        }
        return super.onOptionsItemSelected(item);
    }
}



