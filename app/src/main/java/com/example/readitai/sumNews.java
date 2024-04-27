package com.example.readitai;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;

public class sumNews extends AppCompatActivity {

    DbHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summarization);

        dbHandler = new DbHandler(sumNews.this);

        TextView title = findViewById(R.id.headline);
        ImageView image = findViewById(R.id.imagesum);
        TextView text = findViewById(R.id.summary);
        TextView link = findViewById(R.id.link);

        Button fav = (Button) findViewById(R.id.fav);
        fav.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                if(fav.getText().equals("Tap to Fav")) {
                    fav.setTextColor(ContextCompat.getColor(sumNews.this, R.color.blue));
                    fav.setText("Tap to UnFav");

                    String linkText = link.getText().toString();
                    dbHandler.addNews(linkText);
                } else {
                    fav.setTextColor(ContextCompat.getColor(sumNews.this, R.color.lightBlue));
                    fav.setText("Tap to Fav");
                }
            }
        });

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
