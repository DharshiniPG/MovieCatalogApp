package com.example.moviecatalogapp.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.moviecatalogapp.R;
import com.example.moviecatalogapp.databinding.FragmentTwoBinding;
import com.example.moviecatalogapp.modal.Movies;

public class FragmentTwo extends Fragment {

    Movies movieCardViewViewModal;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            movieCardViewViewModal = bundle.getParcelable("MovieDetails");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentTwoBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_two, container, false);
        binding.setItems(movieCardViewViewModal);

        View view = binding.getRoot();

        return view;
    }


}