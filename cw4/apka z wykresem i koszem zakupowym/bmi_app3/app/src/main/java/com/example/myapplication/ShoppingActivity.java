package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ShoppingActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ShoppingListAdapter adapter;
    private List<ShoppingItem> shoppingItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping);

        recyclerView = findViewById(R.id.recyclerViewShopping);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Lista przykładowych zakupów
        shoppingItems = new ArrayList<>();
        shoppingItems.add(new ShoppingItem("2 jajka"));
        shoppingItems.add(new ShoppingItem("200 ml mleka"));
        shoppingItems.add(new ShoppingItem("1 łyżka oliwy"));
        shoppingItems.add(new ShoppingItem("Sól"));
        shoppingItems.add(new ShoppingItem("Pieprz"));

        adapter = new ShoppingListAdapter(shoppingItems);
        recyclerView.setAdapter(adapter);
    }
}
