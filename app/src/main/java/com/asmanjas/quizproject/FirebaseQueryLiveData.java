package com.asmanjas.quizproject;

import android.os.Handler;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class FirebaseQueryLiveData extends LiveData<DataSnapshot> {

    private static final String LOG_TAG = "FirebaseQueryLiveData";
    private boolean listenerRemovePending = false;
    private final Handler handler = new Handler();


    private final Runnable removeListener = new Runnable() {
        @Override
        public void run() {
            query.removeEventListener(listener);
            listenerRemovePending = false;
        }
    };

    private final Query query;
    private final MyValueEventListener listener = new MyValueEventListener();

    public FirebaseQueryLiveData(Query query){
        this.query = query;
    }

    public FirebaseQueryLiveData(DatabaseReference databaseReference){
        this.query = databaseReference;
    }

    @Override
    protected void onActive() {
        super.onActive();
        Log.d(LOG_TAG, "onActive: ");
        if(listenerRemovePending){
            handler.removeCallbacks(removeListener);
        }
        else {
            query.addValueEventListener(listener);
        }
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        Log.d(LOG_TAG, "onInactive: ");
       // query.removeEventListener(listener);
        handler.postDelayed(removeListener,2000);
        listenerRemovePending = true;
    }


    private class MyValueEventListener implements ValueEventListener{

        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            setValue(dataSnapshot);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
            Log.e(LOG_TAG, "can't listen to query " + query , databaseError.toException()) ;
        }
    }
}
