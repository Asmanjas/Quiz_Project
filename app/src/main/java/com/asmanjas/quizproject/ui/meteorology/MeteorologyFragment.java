package com.asmanjas.quizproject.ui.meteorology;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asmanjas.quizproject.R;

public class MeteorologyFragment extends Fragment {

    private MeteorologyViewModel mViewModel;

    public static MeteorologyFragment newInstance() {
        return new MeteorologyFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.meteorology_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MeteorologyViewModel.class);
        // TODO: Use the ViewModel
    }

}
