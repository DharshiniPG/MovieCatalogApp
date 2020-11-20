package com.example.moviecatalogapp.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.moviecatalogapp.R;
import com.example.moviecatalogapp.fragments.FragmentOne;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, new FragmentOne()).commit();
    }
}