package com.example.suleman.finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class AC_Installation extends AppCompatActivity {
TextView disp;
    int total = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ac__installation);
        getSupportActionBar().setTitle("AC Installation");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        disp = (TextView)findViewById(R.id.total);
    }
public void result(View v)
{
        total+=500;
        disp.setText("Total : Rs "+total);

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
