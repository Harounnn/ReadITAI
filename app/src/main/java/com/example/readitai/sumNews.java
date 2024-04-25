package com.example.readitai;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class sumNews extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summarization);

        TextView title = findViewById(R.id.headline);

        Intent i = getIntent();
        Bundle b = i.getExtras();

        title.setText((String) b.get("title"));
    }
}
