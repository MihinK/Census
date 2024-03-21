package com.example.census;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.census.databinding.HomePageBinding;



public class HomePage extends AppCompatActivity {
    HomePageBinding binding;

    ConstraintLayout myLayout;

    int myDefaultColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = HomePageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        myLayout = (ConstraintLayout) findViewById(R.id.layoutColor);
        SharedPreferences sp = getSharedPreferences("MyUserPreferences",MODE_PRIVATE);
        myDefaultColor = sp.getInt("color",0);
        if (myDefaultColor==0)
            myDefaultColor = ContextCompat.getColor(HomePage.this ,R.color.white);

        myLayout.setBackgroundColor(myDefaultColor);

        repalceFragment(new HomeFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home) {
                repalceFragment(new HomeFragment());
            } else if (item.getItemId() == R.id.addData) {
                repalceFragment(new AddDataFragment());
            } else if (item.getItemId() == R.id.preferences) {
//                    openColorPicker();
                repalceFragment(new PreferencesFragment());
            } else if (item.getItemId() == R.id.listData) {
                repalceFragment(new ListDataFragment());
            }
                return true;
        });
    }
    private void repalceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
}
