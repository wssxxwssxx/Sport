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

public class FootbolActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private TextView textView;
    private RecyclerView recyclerView, recyclerViewGallery;

    private String[] names = {"Лионель Месси", "Килиан Мбаппе", "Джейдон Санчо", "Роналду", "Вирджил ван Дейк", "Роберт Левандовски",
            "Кевин Де Брюйне", "Садио Мане", "Салах", "Неймар "};
    private String nameSports = "Футбол";
    private int[] images = {R.drawable.messi, R.drawable.mbappe, R.drawable.sancj, R.drawable.ronaldo, R.drawable.van, R.drawable.levandowski,
            R.drawable.bruyne, R.drawable.mane, R.drawable.salah, R.drawable.neymar};
    private List<Person> personList = new ArrayList<>();
    private List<Gallery> imagetLsit = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_footbol);

        bottomNavigationView = findViewById(R.id.bottomNavigator);
        textView = findViewById(R.id.textViewFootbol);
        recyclerView = findViewById(R.id.recyclerViewFootbol);
        recyclerViewGallery = findViewById(R.id.recyclerViewFootbolGallery);

        vis();

        recyclerView();
        recyclerViewGallery();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.firstFragment:
                        textView.setText(R.string.document);
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