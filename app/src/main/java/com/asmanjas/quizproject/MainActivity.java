package com.asmanjas.quizproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView tv1,tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        tv1 = findViewById(R.id.textView1);
        tv2 = findViewById(R.id.textView2);

        TestViewModel viewModel = new ViewModelProvider(this).get(TestViewModel.class);

        LiveData<HotStockEntity> liveData = viewModel.getHotStockEntityMediatorLiveData();

        liveData.observe(this, new Observer<HotStockEntity>() {
            @Override
            public void onChanged(HotStockEntity hotStockEntity) {
                if(hotStockEntity!=null){
                    tv1.setText(hotStockEntity.getTicker());
                    tv2.setText(String.format(Locale.getDefault(),"%.2f",hotStockEntity.getPrice()));
                }
            }
        });
    }
}
