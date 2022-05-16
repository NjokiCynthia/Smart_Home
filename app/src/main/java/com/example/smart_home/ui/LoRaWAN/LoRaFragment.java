package com.example.smart_home.ui.LoRaWAN;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.smart_home.LedActivity;
import com.example.smart_home.R;
import com.example.smart_home.databinding.FragmentGalleryBinding;

public class LoRaFragment extends Fragment {

    private LoRaViewModel loRaViewModel;
    private FragmentGalleryBinding binding;
    Button lora;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        loRaViewModel =
                new ViewModelProvider(this).get(LoRaViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        lora = root.findViewById(R.id.lora);

        lora.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), LedActivity.class);
            intent.putExtra("key_word", "LoRaWAN");
            startActivity(intent);
        });

//        final TextView textView = binding.textGallery;
//        loRaViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
        public void onDestroyView () {
            super.onDestroyView();
            binding = null;
        }
  }