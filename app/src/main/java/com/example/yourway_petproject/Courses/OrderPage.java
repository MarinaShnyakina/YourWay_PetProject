package com.example.yourway_petproject.Courses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.yourway_petproject.Models.Order;
import com.example.yourway_petproject.R;

public class OrderPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_page);

        ListView ordersList = findViewById(R.id.ordersList);

        ordersList.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, Order.itemsId.toArray()));
    }
}