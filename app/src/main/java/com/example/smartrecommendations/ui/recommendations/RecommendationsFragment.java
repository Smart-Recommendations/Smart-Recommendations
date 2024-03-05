package com.example.smartrecommendations.ui.recommendations;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.smartrecommendations.databinding.FragmentRecommendationsBinding;

public class RecommendationsFragment extends Fragment {

    private FragmentRecommendationsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RecommendationsViewModel recommendationsViewModel =
                new ViewModelProvider(this).get(RecommendationsViewModel.class);

        binding = FragmentRecommendationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textRecommendations;
        recommendationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}