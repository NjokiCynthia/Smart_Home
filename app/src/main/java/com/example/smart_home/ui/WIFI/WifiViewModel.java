package com.example.smart_home.ui.WIFI;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WifiViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public WifiViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is WIFI fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}