package com.example.suleman.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Oven_Repair extends AppCompatActivity {
    TextView disp;
    int total = 0,countOven=0;
    TextView ov;
    TextView split;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oven__repair);
        getSupportActionBar().setTitle("Oven Repair");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        disp = (TextView)findViewById(R.id.total);
        ov = (TextView)findViewById(R.id.oven);
    }
    public void result(View v)
    {
        if(v.getId() == R.id.add) {
            total += 450;
            countOven++;
            disp.setText("Total : Rs " + total);
            ov.setText(countOven + " Convection/Grill");
        }
        else  if(v.getId() == R.id.minus) {
            if(countOven==0)
            {
                //    countWindow=0;
            }
            else
            {
                total -= 450;
                countOven--;
                disp.setText("Total : Rs " + total);
                ov.setText(countOven + " Convection/Grill");
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
