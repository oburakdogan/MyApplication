package com.example.myapplication.ui.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.ui.fridge.AddDataFragment;
import com.example.myapplication.ui.fridge.FridgeFragment;


public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button btFridge, btShoppingList, btSuggestion, btRecipes;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        btFridge = view.findViewById(R.id.fridgeButton);
        btShoppingList = view.findViewById(R.id.shoppingListButton);
        btSuggestion = view.findViewById(R.id.suggestionButton);
        btRecipes = view.findViewById(R.id.recipesButton);

        btFridge.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case (R.id.fridgeButton):
                MainActivity.fragmentManager.beginTransaction().replace(R.id.Container,
                        new FridgeFragment(), null).addToBackStack(null).commit();
                break;

        }

    }
}