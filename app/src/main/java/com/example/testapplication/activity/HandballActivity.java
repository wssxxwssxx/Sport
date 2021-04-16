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

public class HandballActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private TextView textView;
    private RecyclerView recyclerView, recyclerViewGallery;

    private String[] names = {"Евгений Трефилов", "Анна Вяхирева", "Константин Игропуло", "Полина Кузнецова", "Екатерина Ильина", "Тимур Дибиров",
            "Дарья Дмитриева", "Эмилия Турей", "Мария Рачителева", "Владлена Бобровникова"};
    private String nameSports = "Теннис";
    private int[] images = {R.drawable.evgeniy, R.drawable.anna, R.drawable.igropulo, R.drawable.user, R.drawable.ilina, R.drawable.timur,
            R.drawable.user, R.drawable.turey, R.drawable.maria, R.drawable.user};
    private List<Person> personList = new ArrayList<>();
    private List<Gallery> imagetLsit = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handball);

        bottomNavigationView = findViewById(R.id.bottomNavigator);
        textView = findViewById(R.id.textViewHandall);
        recyclerView = findViewById(R.id.recyclerViewHandall);
        recyclerViewGallery = findViewById(R.id.recyclerViewHandallGallery);

        vis();

        recyclerView();
        recyclerViewGallery();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.firstFragment:
                        textView.setText(R.string.documentHandball);
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