package com.example.smart_home.ui.LoRaWAN;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoRaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LoRaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}