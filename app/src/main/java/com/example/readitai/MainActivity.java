package com.example.readitai;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment = new MainFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment) // Replace with your container ID
                .commit();
    }
}