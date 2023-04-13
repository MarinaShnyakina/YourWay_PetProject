package com.example.yourway_petproject.Menu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.yourway_petproject.Adapters.CategoryAdapter;
import com.example.yourway_petproject.Adapters.CourseAdapter;
import com.example.yourway_petproject.Models.Category;
import com.example.yourway_petproject.Models.Course;
import com.example.yourway_petproject.R;

import java.util.ArrayList;
import java.util.List;

public class Courses extends AppCompatActivity {

    RecyclerView categoryRecycler, courseRecycler;
    CategoryAdapter categoryAdapter;
    CourseAdapter courseAdapter;



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

        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course(1, "coursegoalsetting", "Целеполагание", "24 апреля", "Онлайн", "1499 рублей", "#D7D9FD"));
        courseList.add(new Course(2, "courseacceptanceofemotions", "Принятие эмоций", "1 мая", "Нижний Новгород", "2999 рублей", "#D1F6FD"));
        courseList.add(new Course(3, "courseselflove", "Любовь к себе", "11 мая", "Онлайн", "Бесплатно", "#FADEC6"));
        courseList.add(new Course(4, "courseimpostorsyndrome", "Синдром самозванца", "1 июня", "Онлайн", "999 рублей", "#C4C7FC"));
        courseList.add(new Course(5, "coursesresourses", "Ресурсы", "13 июня", "Москва", "4999 рублей", "#FBE8D6"));

        setCourseRecycler(courseList);
    }

    private void setCourseRecycler(List<Course> courseList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        courseRecycler = findViewById(R.id.courseRecycler);
        courseRecycler.setLayoutManager(layoutManager);

        courseAdapter = new CourseAdapter(this, courseList);
        courseRecycler.setAdapter(courseAdapter);

    }

    private void setCategoryRecycler(List<Category> categoryList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);

        categoryAdapter = new CategoryAdapter(this, categoryList);
        categoryRecycler.setAdapter(categoryAdapter);

    }
    
    
}