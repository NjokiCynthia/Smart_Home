package com.example.smart_home.ui.BLUETOOTH;

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
import com.example.smart_home.databinding.FragmentSlideshowBinding;

public class BLUETOOTHFragment extends Fragment {

    private BluetoothViewModel bluetoothViewModel;
    private FragmentSlideshowBinding binding;
    Button bluetooth;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        bluetoothViewModel =
                new ViewModelProvider(this).get(BluetoothViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        bluetooth = root.findViewById(R.id.bluetooth);

        bluetooth.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), LedActivity.class);
            intent.putExtra("key_word", "bletooth");
            startActivity(intent);
        });
//        final TextView textView = binding.textSlideshow;
//        bluetoothViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}