package com.asmanjas.quizproject.ui.aptitude;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.asmanjas.quizproject.FirebaseQueryLiveData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AptitudeViewModel extends ViewModel {
    private static final DatabaseReference APTITUDE_META_REF = FirebaseDatabase.getInstance().getReference("Questions-meta").child("Aptitude");
    private final FirebaseQueryLiveData liveData = new FirebaseQueryLiveData(APTITUDE_META_REF);
    private final MediatorLiveData<Long> mData = new MediatorLiveData<>();


    public AptitudeViewModel(){
        mData.addSource(liveData, new Observer<DataSnapshot>() {
            @Override
            public void onChanged(final DataSnapshot dataSnapshot) {
                if(dataSnapshot!=null){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            mData.postValue(dataSnapshot.getValue(Long.class));
                        }
                    }).start();
                }
                else {
                    mData.setValue(null);
                }
            }
        });
    }


    public MediatorLiveData<Long> getNumberOfSets() {
        return mData;
    }
}
