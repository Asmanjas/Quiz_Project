package com.asmanjas.quizproject.ui.QuestionDisplay;

import android.app.Application;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.asmanjas.quizproject.FirebaseQueryLiveData;
import com.asmanjas.quizproject.QuestionEntity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class QuestionDisplayViewModel extends ViewModel {

    private final MediatorLiveData<List<QuestionEntity>> mData = new MediatorLiveData<>();
    private ArrayList<QuestionEntity> mList = new ArrayList<>();


    public QuestionDisplayViewModel(String pathParameter){
        DatabaseReference DATABASE_REFERENCE = FirebaseDatabase.getInstance().getReference(pathParameter);
        FirebaseQueryLiveData liveData = new FirebaseQueryLiveData(DATABASE_REFERENCE);

        mData.addSource(liveData, new Observer<DataSnapshot>() {
            @Override
            public void onChanged(final DataSnapshot dataSnapshot) {
                if(dataSnapshot!=null){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            for (DataSnapshot snapshot:dataSnapshot.getChildren()){
                                QuestionEntity questionEntity = snapshot.getValue(QuestionEntity.class);
                                mList.add(questionEntity);
                            }
                            mData.postValue(mList);
                        }
                    }).start();
                }
                else {
                    mData.setValue(null);
                }
            }
        });
    }


    public MediatorLiveData<List<QuestionEntity>> getQuestionList() {
        return mData;
    }


}
