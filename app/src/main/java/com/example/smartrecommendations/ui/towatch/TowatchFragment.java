package com.example.smartrecommendations.ui.towatch;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.smartrecommendations.databinding.FragmentTowatchBinding;

public class TowatchFragment extends Fragment {

    private FragmentTowatchBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TowatchViewModel TowatchViewModel =
                new ViewModelProvider(this).get(TowatchViewModel.class);

        binding = FragmentTowatchBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textTowatch;
        TowatchViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}