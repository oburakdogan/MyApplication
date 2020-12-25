package com.example.myapplication.ui.fridge;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Ingredient;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.ui.suggestion.tabs.IngredientsViewModel;

import java.util.List;

public class FridgeFragment extends Fragment implements View.OnClickListener {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    RecyclerAdapter recyclerAdapter;
    Button btAddData;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fridge, container, false);

        recyclerView = view.findViewById(R.id.fridgeRecyclerView);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        List<Ingredient> ingredientList = MainActivity.roomDatabaseClass.ingredientDao().getIngredient();
        recyclerAdapter = new RecyclerAdapter(ingredientList);
        recyclerView.setAdapter(recyclerAdapter);

        btAddData = view.findViewById(R.id.addToFridgeButton);
        btAddData.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case (R.id.addToFridgeButton):
                MainActivity.fragmentManager.beginTransaction().replace(R.id.Container, new AddDataFragment()
                        , null).addToBackStack(null).commit();
                break;
        }
    }
}