package com.example.suleman.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class ExpressCleaning extends AppCompatActivity {
    TextView disp;
    int total = 0, countBhk = 0, countWater = 0;
    TextView bhk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_express_cleaning);
        getSupportActionBar().setTitle("Express Cleaning");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        disp = (TextView) findViewById(R.id.total);
        bhk = (TextView) findViewById(R.id.bhk);
    }

    public void result(View v) {
        if (v.getId() == R.id.add) {
            if (countBhk == 0) {
                countBhk++;
                total += 1900;
                disp.setText("Total : Rs " + total);
                bhk.setText(countBhk + " BHK");
            } else if (countBhk == 1) {
                countBhk++;
                total += 500;
                disp.setText("Total : Rs " + total);
                bhk.setText(countBhk + " BHK");
            } else if (countBhk == 2) {
                countBhk++;
                total += 500;
                disp.setText("Total : Rs " + total);
                bhk.setText(countBhk + " BHK & above");

            }
        }
            else if (v.getId() == R.id.minus) {
                {
                    if (countBhk == 0) {

                    } else if (countBhk == 1) {
                        countBhk--;
                        total -= 1900;
                        disp.setText("Total : Rs " + total);
                        bhk.setText(countBhk + " BHK");

                    } else if (countBhk == 2) {
                        countBhk--;
                        total -= 500;
                        disp.setText("Total : Rs " + total);
                        bhk.setText(countBhk + " BHK");
                    } else if (countBhk == 3) {
                        countBhk--;
                        total -= 500;
                        disp.setText("Total : Rs " + total);
                        bhk.setText(countBhk + " BHK");
                    }
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


