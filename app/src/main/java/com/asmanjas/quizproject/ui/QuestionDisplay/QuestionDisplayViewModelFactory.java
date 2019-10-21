package com.asmanjas.quizproject.ui.QuestionDisplay;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class QuestionDisplayViewModelFactory implements ViewModelProvider.Factory {

    private String mParam;


    public QuestionDisplayViewModelFactory(String mParam) {

        this.mParam = mParam;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new QuestionDisplayViewModel(mParam);
    }
}
