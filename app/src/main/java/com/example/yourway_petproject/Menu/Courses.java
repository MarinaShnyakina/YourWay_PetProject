package com.example.yourway_petproject.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.yourway_petproject.Adapters.CategoryAdapter;
import com.example.yourway_petproject.Models.Category;
import com.example.yourway_petproject.R;

import java.util.ArrayList;
import java.util.List;

public class Courses extends AppCompatActivity {

    RecyclerView categoryRecycler;
    CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);

        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1, "Онлайн"));
        categoryList.add(new Category(2, "Офлайн"));
        categoryList.add(new Category(3, "Коучинг"));
        categoryList.add(new Category(4, "Психология"));
        categoryList.add(new Category(5, "Прочее"));

        setCategoryRecycler(categoryList);
    }

    private void setCategoryRecycler(List<Category> categoryList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);

    }
}