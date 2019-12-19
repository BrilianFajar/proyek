package com.example.proyek.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.proyek.R;
import com.example.proyek.fragments.homeFragment;
import com.example.proyek.fragments.locFragment;
import com.example.proyek.fragments.makananFragment;
import com.example.proyek.fragments.userFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFragment(new homeFragment());
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .addToBackStack(null)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.home:
                fragment = new homeFragment();
                break;
            case R.id.pizza:
                fragment = new makananFragment();
                break;
            case R.id.minum:
                fragment = new locFragment();
                break;
            case R.id.user:
                fragment = new userFragment();
                break;
        }
        return loadFragment(fragment);
    }
}
