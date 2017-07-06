package com.vis.poc_eppo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClickNewEPPO(View v) {

        if (v.getId() == R.id.CNewEPPO) {
            Intent i = new Intent(MainActivity.this, eppo_request.class);
            startActivity(i);
        }

    }
}
