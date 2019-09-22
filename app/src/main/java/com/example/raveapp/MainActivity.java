package com.example.raveapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.flutterwave.raveandroid.RaveConstants;
import com.flutterwave.raveandroid.RavePayActivity;
import com.flutterwave.raveandroid.RavePayManager;

import java.net.InterfaceAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity implements RecyclerAdapter.onRecyclerClick {
    RecyclerView recyclerView;
    RecyclerAdapter adapter;



    List<items> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        products = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        products.add(new items(1, "Book1", "500$", R.drawable.downloadbook));
        products.add(new items(1, "Book2", "500$", R.drawable.downloadbook));
        products.add(new items(1, "Book3", "500$", R.drawable.downloadbook));
        products.add(new items(1, "Book4", "500$", R.drawable.downloadbook));


        adapter = new RecyclerAdapter(this, products, this);
        recyclerView.setAdapter(adapter);




    }

    @Override
    public void onItemClick(int position) {



    }

}
