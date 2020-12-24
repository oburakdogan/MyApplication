package com.example.myapplication.ui.suggestion.tabs;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.ui.settings.SettingsViewModel;

public class IngredientsFragment extends Fragment {

    private IngredientsViewModel ingredientsViewModel;

    public static IngredientsFragment newInstance() {
        return new IngredientsFragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ingredientsViewModel =
                new ViewModelProvider(this).get(IngredientsViewModel.class);
        View root = inflater.inflate(R.layout.ingredients_fragment, container, false);
        final TextView textView = root.findViewById(R.id.ingredientsText);
        ingredientsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ingredientsViewModel = new ViewModelProvider(this).get(IngredientsViewModel.class);
        // TODO: Use the ViewModel
    }

}