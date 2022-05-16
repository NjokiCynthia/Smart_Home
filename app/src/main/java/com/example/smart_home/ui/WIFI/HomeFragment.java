package com.example.smart_home.ui.WIFI;

import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.smart_home.LedActivity;
import com.example.smart_home.R;
import com.example.smart_home.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private WifiViewModel wifiViewModel;
    private FragmentHomeBinding binding;
    Button wifi_on, wifi_off;
    private WifiManager wifiManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        wifiViewModel =
                new ViewModelProvider(this).get(WifiViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        wifi_on = root.findViewById(R.id.wifi_on);
        wifi_off = root.findViewById(R.id.wifi_off);

        wifi_on.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), LedActivity.class);
            intent.putExtra("key_word", "WIFI");
            startActivity(intent);
        });

        return root;
         }
    }
