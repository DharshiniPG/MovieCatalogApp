package com.example.moviecatalogapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.moviecatalogapp.R;
import com.example.moviecatalogapp.databinding.FragmentOneBinding;
import com.example.moviecatalogapp.viewmodal.FragmentOneViewModal;

import org.jetbrains.annotations.NotNull;

public class FragmentOne extends Fragment{

    FragmentOneViewModal fragmentOneViewModal;
    FragmentOneBinding fragmentOneBinding;
    //SharedPreferences sharedPreferences;
    //SharedPreferences.Editor editor;

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /*sharedPreferences = getContext().getSharedPreferences("MOVIES_LIST", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();*/
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