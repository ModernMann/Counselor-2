package com.example.counselor;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.counselor.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
private ListView list;
private String[] array;
private ArrayAdapter<String> adapter;
    private ActivityMainBinding binding;

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        list = findViewById(R.id.listView);
        array = getResources().getStringArray(R.array.menu_array);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                new ArrayList<String>(Arrays.asList(array)) );
        list.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Связываем наш список с ListView на экране с помощью адаптера.
        list = findViewById(R.id.listView);
        array = getResources().getStringArray(R.array.menu_array);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                new ArrayList<String>(Arrays.asList(array)) );
        list.setAdapter(adapter);



        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, TextContentActivity.class);
                startActivity(intent);
            }
        });

                BottomNavigationView navView = findViewById(R.id.nav_view);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_guide, R.id.navigation_profile, R.id.navigation_about)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

}
