package com.example.moviecatalogapp.clickHandler;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.moviecatalogapp.R;
import com.example.moviecatalogapp.fragments.FragmentTwo;
import com.example.moviecatalogapp.modal.Movies;
import com.example.moviecatalogapp.view.RatingActivity;

public class ClickHandler {
    private SharedPreferences.Editor editor;
    private SharedPreferences sharedPreferences;
    private Context context;

    public ClickHandler(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("CLICK_COUNT", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public int getClickCount(int position){
        String TAG = ""+position;
        int count = sharedPreferences.getInt(TAG, 0);
        editor.putInt(TAG, count+1);
        editor.commit();
        return sharedPreferences.getInt(TAG, 0);
    }

    public void giveDescription(View view, Movies movie){
        Bundle bundle = new Bundle();
        bundle.putParcelable("MovieDetails",movie);

        FragmentTwo fragment = new FragmentTwo();
        fragment.setArguments(bundle);

        AppCompatActivity activity = (AppCompatActivity) view.getContext();
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).addToBackStack(null).commit();
    }

    public void ratingActivity(View view, int position, int number){
        Intent intent = new Intent(view.getContext(), RatingActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString("POSITION", ""+position);
        bundle.putString("TEXT_EPI", "Did you enjoy watching Episode" + number + "Rate the episode here: ");
        intent.putExtras(bundle);

        view.getContext().startActivity(intent);
    }
}
