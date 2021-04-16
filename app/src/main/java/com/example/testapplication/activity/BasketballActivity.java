package com.example.testapplication.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.testapplication.R;
import com.example.testapplication.adapters.Gallery;
import com.example.testapplication.adapters.Person;
import com.example.testapplication.adapters.RecyclerAdapter;
import com.example.testapplication.adapters.RecyclerAdapterGallery;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class BasketballActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private TextView textView;
    private RecyclerView recyclerView, recyclerViewGallery;

    private String[] names = {"Оскар Шмидт", "Сергей Белов", "Джерри Уэст", "Коби Брайант", "Оскар", "Джон Стоктон",
            "Билл Расселл", "Чемберлен", "Майкл Джордан", "Карим Абдул"};
    private String nameSports = "Батскетбол";
    private int[] images = {R.drawable.smid, R.drawable.belov, R.drawable.djery, R.drawable.bruyne, R.drawable.robertson, R.drawable.stokon,
            R.drawable.ressel, R.drawable.chemberlen, R.drawable.djordan, R.drawable.abdul};
    private List<Person> personList = new ArrayList<>();
    private List<Gallery> imagetLsit = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basketball);

        bottomNavigationView = findViewById(R.id.bottomNavigator);
        textView = findViewById(R.id.textViewBasketball);
        recyclerView = findViewById(R.id.recyclerViewBasketball);
        recyclerViewGallery = findViewById(R.id.recyclerViewBasketballGallery);

        vis();

        recyclerView();
        recyclerViewGallery();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.firstFragment:
                        textView.setText(R.string.documentBat);
                        textView.setVisibility(View.VISIBLE);
                        recyclerView.setVisibility(View.GONE);
                        recyclerViewGallery.setVisibility(View.GONE);
                        break;
                    case R.id.secondFragment:
                        textView.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.VISIBLE);
                        recyclerViewGallery.setVisibility(View.GONE);
                        break;
                    case R.id.thirdFragment:
                        textView.setVisibility(View.GONE);
                        recyclerView.setVisibility(View.GONE);
                        recyclerViewGallery.setVisibility(View.VISIBLE);
                        break;

                }
                return false;
            }
        });
    }


    private void vis() {
        textView.setText(R.string.documentBat);
        textView.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
        recyclerViewGallery.setVisibility(View.GONE);
    }

    private void recyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        prepareTheList();
        RecyclerAdapter adapter = new RecyclerAdapter(personList);
        recyclerView.setAdapter(adapter);
    }

    private void prepareTheList() {
        int count = 0;
        for (String name : names) {
            Person person = new Person(name, images[count], nameSports);
            personList.add(person);
            count++;
        }
    }

    private void recyclerViewGallery() {
        recyclerViewGallery.setLayoutManager(new LinearLayoutManager(this));
        prepareTheListGallery();
        RecyclerAdapterGallery adapter = new RecyclerAdapterGallery(imagetLsit);
        recyclerViewGallery.setAdapter(adapter);
    }

    private void prepareTheListGallery() {
        int count = 0;
        for (String name : names) {
            Gallery person = new Gallery(images[count]);
            imagetLsit.add(person);
            count++;
        }
    }
}