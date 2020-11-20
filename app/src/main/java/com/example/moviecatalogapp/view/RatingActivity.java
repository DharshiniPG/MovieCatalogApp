package com.example.moviecatalogapp.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.moviecatalogapp.R;
import com.example.moviecatalogapp.databinding.ActivityRatingBinding;
import com.example.moviecatalogapp.fragments.FragmentOne;

public class RatingActivity extends AppCompatActivity {
    ActivityRatingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_rating);
        binding.textQn.setText(getQn());
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        float ratingCount = binding.activityRatingBar.getRating();
        storeRatingInPrefs(ratingCount);

        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, new FragmentOne()).commit();
    }

    private void storeRatingInPrefs(float ratingCount){

        SharedPreferences sharedPreferences = getSharedPreferences("RATING_POS", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String position = getPosition();
        Log.d("TAG CHECK", "rating"+position);
        editor.putFloat("rating"+position, ratingCount);

        editor.apply();
    }

    private String getPosition(){
        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        return bundle.getString("POSITION", "");
    }

    private String getQn(){
        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        return bundle.getString("TEXT_EPI", "");
    }


}