package com.example.moviecatalogapp.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.moviecatalogapp.R;
import com.example.moviecatalogapp.adapter.MoviesListAdapter;
import com.example.moviecatalogapp.databinding.FragmentOneBinding;
import com.example.moviecatalogapp.modal.Movies;
import com.example.moviecatalogapp.services.ApiClient;
import com.example.moviecatalogapp.services.ApiService;
import com.example.moviecatalogapp.viewmodal.FragmentOneViewModal;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class FragmentOne extends Fragment{

    FragmentOneViewModal fragmentOneViewModal;
    FragmentOneBinding fragmentOneBinding;
    //SharedPreferences sharedPreferences;
    //SharedPreferences.Editor editor;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //sharedPreferences = getContext().getSharedPreferences("MOVIES_LIST", Context.MODE_PRIVATE);
        //editor = sharedPreferences.edit();
        fragmentOneViewModal = new FragmentOneViewModal(getContext());

        fragmentOneBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_one, null, false);


        fragmentOneBinding.recyclerView.setLayoutManager(new LinearLayoutManager(container.getContext()));
        fragmentOneBinding.recyclerView.setAdapter(fragmentOneViewModal.setAdapter());

        View view = fragmentOneBinding.getRoot();

        /*
            ApiService apiService = ApiClient.getApiService();
            Observable<List<Movies>> call = apiService.getMoviesList().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());

            call.subscribe(new Observer<List<Movies>>() {
                @Override
                public void onSubscribe(Disposable d) {}

                @Override
                public void onNext(List<Movies> movies) {
                    MoviesListAdapter moviesListAdapter = new MoviesListAdapter(getContext(), movies);
                    fragmentOneBinding.recyclerView.setAdapter(moviesListAdapter);
                }

                @Override
                public void onError(Throwable e) {
                    Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                }

                @Override
                public void onComplete() {
                }
            });*/


        return view;
    }
}