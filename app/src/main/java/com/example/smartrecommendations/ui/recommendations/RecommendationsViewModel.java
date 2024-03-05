package com.example.smartrecommendations.ui.recommendations;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RecommendationsViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public RecommendationsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is recommendations fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}