package com.example.myapplication.ui.suggestion;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.ui.adapter.SectionPagerAdapter;
import com.example.myapplication.ui.suggestion.tabs.IngredientsFragment;
import com.example.myapplication.ui.suggestion.tabs.RecipeFragment;
import com.google.android.material.tabs.TabLayout;

public class SuggestionFragment extends Fragment {

    private SuggestionViewModel suggestionViewModel;
    View myFragment;

    ViewPager viewPager;
    TabLayout tabLayout;

    public SuggestionFragment(){
        //empty constructor
    }

    public static SuggestionFragment getInstance()    {
        return new SuggestionFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View myFragment = inflater.inflate(R.layout.fragment_suggestion, container, false);

        viewPager = myFragment.findViewById(R.id.viewPager);
        tabLayout = myFragment.findViewById(R.id.tabLayout);

        suggestionViewModel = new ViewModelProvider(this).get(SuggestionViewModel.class);
        final TextView textView = myFragment.findViewById(R.id.text_suggestion);
        suggestionViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });
        return myFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setUpViewPager(ViewPager viewPager) {
        SectionPagerAdapter adapter = new SectionPagerAdapter(getChildFragmentManager());

        adapter.addFragment(new IngredientsFragment(), "Ingredients");
        adapter.addFragment(new RecipeFragment(), "Recipe");

        viewPager.setAdapter(adapter);
    }

}