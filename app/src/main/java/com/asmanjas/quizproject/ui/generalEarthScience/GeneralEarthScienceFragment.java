package com.asmanjas.quizproject.ui.generalEarthScience;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asmanjas.quizproject.R;

public class GeneralEarthScienceFragment extends Fragment {

    private GeneralEarthScienceViewModel mViewModel;

    public static GeneralEarthScienceFragment newInstance() {
        return new GeneralEarthScienceFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.general_earth_science_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(GeneralEarthScienceViewModel.class);
        // TODO: Use the ViewModel
    }

}
