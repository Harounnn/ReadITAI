package com.example.readitai;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class sumNews extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summarization);



        TextView title = findViewById(R.id.headline);
        ImageView image = findViewById(R.id.imagesum);
        TextView text = findViewById(R.id.summary);
        TextView link = findViewById(R.id.link);

        Intent i = getIntent();
        Bundle b = i.getExtras();

        title.setText((String) b.get("title"));
        Glide.with(this).load(b.get("image")).into(image);
        link.setText((String) b.get("link"));

        Summarizer summarizer = new Summarizer((String) b.get("content"));

        String summary = summarizer.summarize();

        text.setText(summary);

    }


}
