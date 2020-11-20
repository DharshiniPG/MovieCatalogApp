package com.example.moviecatalogapp.viewmodal;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.example.moviecatalogapp.adapter.MoviesListAdapter;
import com.example.moviecatalogapp.modal.Movies;
import com.example.moviecatalogapp.services.ApiClient;
import com.example.moviecatalogapp.services.ApiService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class FragmentOneViewModal {
    Context context;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    MoviesListAdapter moviesListAdapter;

    public FragmentOneViewModal(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("MOVIES", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public MoviesListAdapter setAdapter(){
        String prefs = sharedPreferences.getString("MOVIES_LIST", null);
        if (prefs != null){
            ApiService apiService = ApiClient.getApiService();
            Observable<List<Movies>> call = apiService.getMoviesList().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());

            call.subscribe(new Observer<List<Movies>>() {
                @Override
                public void onSubscribe(Disposable d) {}

                @Override
                public void onNext(List<Movies> movies) {
                    moviesListAdapter = new MoviesListAdapter(context, movies);
                    storeSharedPrefs(movies);
                }

                @Override
                public void onError(Throwable e) { Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show(); }

                @Override
                public void onComplete() {}
            });
        } else {
            moviesListAdapter = new MoviesListAdapter(context, getSharedPrefs(prefs));
        }

        return moviesListAdapter;
    }

    private void storeSharedPrefs(List<Movies> moviesList){
        Gson gson = new Gson();
        String json = gson.toJson(moviesList);
        editor.putString("MOVIES_LIST", json);
        editor.commit();
    }

    private List<Movies> getSharedPrefs(String prefs){
        List<Movies> moviesList;

        Gson gson = new Gson();
        Type type = new TypeToken<List<Movies>>(){}.getType();

        moviesList = gson.fromJson(prefs, type);

        return moviesList;
    }


}
