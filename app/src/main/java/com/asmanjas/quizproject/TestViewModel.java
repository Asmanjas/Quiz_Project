package com.asmanjas.quizproject;

import android.provider.ContactsContract;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TestViewModel extends ViewModel {

    private static final DatabaseReference HOT_STOCK_REF = FirebaseDatabase.getInstance().getReference("/hotstock");


    private final FirebaseQueryLiveData liveData = new FirebaseQueryLiveData(HOT_STOCK_REF);





    private final MediatorLiveData<HotStockEntity> hotStockEntityMediatorLiveData = new MediatorLiveData<>();


    public TestViewModel(){
        hotStockEntityMediatorLiveData.addSource(liveData, new Observer<DataSnapshot>() {
            @Override
            public void onChanged(final DataSnapshot dataSnapshot) {
                if(dataSnapshot!=null){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            hotStockEntityMediatorLiveData.postValue(dataSnapshot.getValue(HotStockEntity.class));
                        }
                    }).start();
                }
                else {
                    hotStockEntityMediatorLiveData.setValue(null);
                }
            }
        });
    }


    public MediatorLiveData<HotStockEntity> getHotStockEntityMediatorLiveData() {
        return hotStockEntityMediatorLiveData;
    }
}
