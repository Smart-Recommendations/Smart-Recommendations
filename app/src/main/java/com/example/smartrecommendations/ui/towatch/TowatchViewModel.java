package com.example.smartrecommendations.ui.towatch;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TowatchViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public TowatchViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is to watch fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}