package com.asmanjas.quizproject.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.asmanjas.quizproject.R;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private CardView aptitudeBtn,generalEarthScienceBtn,geophysicsBtn,geologyBtn,meteorologyBtn;


    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
               // textView.setText(s);
            }
        });

        //adding reference to buttons
        aptitudeBtn = root.findViewById(R.id.btn_aptitude);
        generalEarthScienceBtn = root.findViewById(R.id.btn_general_earth_science);
        geophysicsBtn = root.findViewById(R.id.btn_geophysics );
        geologyBtn = root.findViewById(R.id.btn_geology);
        meteorologyBtn = root.findViewById(R.id.btn_meteorology);


        aptitudeBtn.setOnClickListener(this);
        generalEarthScienceBtn.setOnClickListener(this);
        geophysicsBtn.setOnClickListener(this);
        geologyBtn.setOnClickListener(this);
        meteorologyBtn.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_aptitude:
                Navigation.findNavController(view).navigate(R.id.action_nav_home_to_aptitudeFragment);
                break;

            case R.id.btn_general_earth_science:
                Navigation.findNavController(view).navigate(R.id.action_nav_home_to_generalEarthScienceFragment);
                break;

            case R.id.btn_geophysics:
                Navigation.findNavController(view).navigate(R.id.action_nav_home_to_geophysicsFragment);
                break;

            case R.id.btn_geology:
                Navigation.findNavController(view).navigate(R.id.action_nav_home_to_geologyFragment);
                break;

            case R.id.btn_meteorology:
                Navigation.findNavController(view).navigate(R.id.action_nav_home_to_meteorologyFragment);
                break;

                default:
                    break;
        }
    }
}