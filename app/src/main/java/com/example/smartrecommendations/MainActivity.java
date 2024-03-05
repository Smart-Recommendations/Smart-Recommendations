package com.example.smartrecommendations;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.smartrecommendations.ui.home.HomeFragment;
import com.example.smartrecommendations.ui.recommendations.RecommendationsFragment;
import com.example.smartrecommendations.ui.settings.SettingsFragment;
import com.example.smartrecommendations.ui.towatch.ToWatchFragment;
import com.example.smartrecommendations.ui.user.UserFragment;
import com.example.smartrecommendations.ui.watched.WatchedFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements
    NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;
    FragmentManager fragmentManager;
    Toolbar toolbar;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //fab = findViewById(R.id.fab);
        toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setBackground(null);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.recommendations) {
                    openFragment(new RecommendationsFragment());
                    return true;
                }
                else if (itemId == R.id.towatch) {
                    openFragment(new ToWatchFragment());
                    return true;
                }
                else if (itemId == R.id.watched) {
                    openFragment(new WatchedFragment());
                    return true;
                }
                return true;
            }
        });

        fragmentManager = getSupportFragmentManager();
        openFragment(new HomeFragment());

        /*
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Add your own action here", Toast.LENGTH_SHORT).show();
            }
        });
         */
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.nav_home) {
            openFragment(new HomeFragment());
        }
        else if (itemId == R.id.nav_settings) {
            openFragment(new SettingsFragment());
        }
        else if (itemId == R.id.nav_user) {
            openFragment(new UserFragment());
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }
}