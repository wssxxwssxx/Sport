package com.example.testapplication.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
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

public class TenisActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private TextView textView;
    private RecyclerView recyclerView, recyclerViewGallery;

    private String[] names = {"Андре Агасси", "Джон Макинрой", "Джимми Коннорс", "Рафаэль Надаль", "Иван Лендл", "Бьорн Борг",
            "Род Лейвер", "Пит Сампрас", "Новак Джокович", "Роджер Федерер"};
    private String nameSports = "Теннис";
    private int[] images = {R.drawable.aggasy, R.drawable.makinroy, R.drawable.connorc, R.drawable.nadal, R.drawable.ivan, R.drawable.borg,
            R.drawable.rod, R.drawable.pit, R.drawable.novak, R.drawable.federer};
    private List<Person> personList = new ArrayList<>();
    private List<Gallery> imagetLsit = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenis);

        bottomNavigationView = findViewById(R.id.bottomNavigator);
        textView = findViewById(R.id.textViewTenis);
        recyclerView = findViewById(R.id.recyclerViewTenis);
        recyclerViewGallery = findViewById(R.id.recyclerViewTenisGallery);

        vis();

        recyclerView();
        recyclerViewGallery();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.firstFragment:
                        textView.setText(R.string.documentTenis);
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