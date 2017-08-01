package com.vis.poc_eppo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

/**
 * Created by XPS13 on 7/31/2017.
 */

public class github_entry extends AppCompatActivity

{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.github_entry);
        final EditText mEdit = (EditText) findViewById(R.id.GitUser);

    }

    public void onClickGitUser(View v) {

        if (v.getId() == R.id.Fetch_Repos) {

            EditText a = (EditText)findViewById(R.id.GitUser);
            String str = a.getText().toString();
            Intent i = new Intent(github_entry.this, gitHub_request.class);

            i.putExtra("GitUser", str);
            startActivity(i);

        }
    }
}
