package com.example.smartrecommendations.ui.watched;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WatchedViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public WatchedViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is watched fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}