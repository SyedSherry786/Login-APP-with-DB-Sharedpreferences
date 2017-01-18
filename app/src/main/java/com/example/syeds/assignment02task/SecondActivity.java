package com.example.syeds.assignment02task;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //String username=getIntent().getStringExtra("Uname");

        SharedPreferences settings = getSharedPreferences("MYPREFS", Context.MODE_PRIVATE);
        username = settings.getString("username", "");
        TextView tv=(TextView)findViewById(R.id.textView4);
        tv.setText(username);

    }
}
