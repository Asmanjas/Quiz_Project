package com.asmanjas.quizproject.ui.aptitude;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.asmanjas.quizproject.R;
import com.asmanjas.quizproject.ui.RecyclerSetsAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AptitudeFragment extends Fragment {

    private AptitudeViewModel mViewModel;
    private RecyclerView recyclerView;
    private RecyclerSetsAdapter adapter;

    public static AptitudeFragment newInstance() {
        return new AptitudeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root =  inflater.inflate(R.layout.aptitude_fragment, container, false);
        recyclerView = root.findViewById(R.id.recycler_view_aptitude_fragment);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AptitudeViewModel.class);
        LiveData<Long> mData = mViewModel.getNumberOfSets();
        mData.observe(this, new Observer<Long>() {
            @Override
            public void onChanged(Long s) {
                if(s!=null){
                    int numberOfSets = s.intValue();
                    adapter = new RecyclerSetsAdapter(getContext(),numberOfSets);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                }
            }
        });


    }

}
