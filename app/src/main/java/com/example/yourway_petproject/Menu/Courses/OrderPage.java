package com.example.yourway_petproject.Menu.Courses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.yourway_petproject.Models.Course;
import com.example.yourway_petproject.Models.Order;
import com.example.yourway_petproject.R;

import java.util.ArrayList;
import java.util.List;

public class OrderPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_page);

        ListView ordersList = findViewById(R.id.ordersList);

        List<String> coursesTitle = new ArrayList<>();
        for(Course c : Courses.fullCoursesList) {
            if(Order.itemsId.contains(c.getId()))
                coursesTitle.add(c.getTitle());
        }

        ordersList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, coursesTitle));

    }
}