package com.example.myapplication;

import android.os.Bundle;

import com.example.myapplication.ui.fridge.FridgeFragment;
import com.example.myapplication.ui.home.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.room.Room;

public class MainActivity extends AppCompatActivity {

    public static FragmentManager fragmentManager;
    public static RoomDatabaseClass roomDatabaseClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        roomDatabaseClass = Room.databaseBuilder(getApplicationContext(), RoomDatabaseClass.class
                , "mydb").allowMainThreadQueries().build();

        if (findViewById(R.id.Container) != null)
        {
            if(savedInstanceState != null)
            {
                return;
            }
            fragmentManager.beginTransaction().add(R.id.Container, new HomeFragment(), null).commit();
        }
    }

//    @Override
//    public void onBackPressed(){
//        Fragment fragment = fragmentManager.findFragmentById(R.id.Container);
//        FragmentTransaction fragmentTransaction;
//        if(fragment != null)
//        {
//            fragmentTransaction = fragmentManager.beginTransaction();
//            fragmentTransaction.remove(fragment);
//            fragmentTransaction.commit();
//        } else {
//            super.onBackPressed();
//        }
//    }

}