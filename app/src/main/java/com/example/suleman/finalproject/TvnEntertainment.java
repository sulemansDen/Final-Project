package com.example.suleman.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class TvnEntertainment extends AppCompatActivity {
    TextView disp;
    int total = 0, countCeiling = 0, countWall=0;
    TextView ceiling,wall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tvn_entertainment);
        getSupportActionBar().setTitle("TV And Entertainment");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        disp = (TextView) findViewById(R.id.total);
        ceiling = (TextView) findViewById(R.id.ceiling);
        wall = (TextView) findViewById(R.id.wall);
    }
    public void result(View v) {
        if (v.getId() == R.id.add) {
            if (countCeiling == 0) {
                countCeiling++;
                total += 450;
                disp.setText("Total : Rs " + total);
                ceiling.setText(countCeiling + " TV Installation");
            } else if (countCeiling == 1) {
                countCeiling++;
                total += 250;
                disp.setText("Total : Rs " + total);
                ceiling.setText(countCeiling + " TV Installation");
            } else if (countCeiling == 2) {
                countCeiling++;
                total += 200;
                disp.setText("Total : Rs " + total);
                ceiling.setText(countCeiling + " TV Installation & above");
            }
        } else if (v.getId() == R.id.minus) {
            if (countCeiling == 0) {

            } else if (countCeiling == 1) {
                countCeiling--;
                total -= 450;
                disp.setText("Total : Rs " + total);
                ceiling.setText(countCeiling + " TV Installation");
            } else if (countCeiling == 2) {
                countCeiling--;
                total -= 250;
                disp.setText("Total : Rs " + total);
                ceiling.setText(countCeiling + " TV Installation");
            } else if (countCeiling == 3) {
                countCeiling--;
                total -= 200;
                disp.setText("Total : Rs " + total);
                ceiling.setText(countCeiling + " TV Installation");
            }

        } else if (v.getId() == R.id.addWall) {
            if (countWall == 0) {
                countWall++;
                total += 250;
                disp.setText("Total : Rs " + total);
                wall.setText(countWall + " TV UnInstallation");
            } else if (countWall == 1) {
                countWall++;
                total += 100;
                disp.setText("Total : Rs " + total);
                wall.setText(countWall + " TV UnInstallation");
            } else if (countWall == 2) {
                countWall++;
                total += 75;
                disp.setText("Total : Rs " + total);
                wall.setText(countWall + " TV UnInstallation & above");
            }
        } else if (v.getId() == R.id.minusWall) {
            if (countWall == 0) {

            } else if (countWall == 1) {
                countWall--;
                total -= 250;
                disp.setText("Total : Rs " + total);
                wall.setText(countWall + " TV UnInstallation");
            } else if (countWall == 2) {
                countWall--;
                total -= 100;
                disp.setText("Total : Rs " + total);
                wall.setText(countWall + " TV UnInstallation");
            } else if (countWall == 3) {
                countWall--;
                total -= 75;
                disp.setText("Total : Rs " + total);
                wall.setText(countWall + " TV UnInstallation");
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

