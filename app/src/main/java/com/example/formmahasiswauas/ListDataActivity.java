package com.example.formmahasiswauas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;

public class ListDataActivity extends AppCompatActivity {

    RecyclerView rvData;
    ArrayList<ModelMahasiswa> mhs;
    ListDataAdapter adapter;
    DBHelper dbHelper;

    public static Activity fa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);

        fa = this;
        rvData = findViewById(R.id.rv_list_data);

        dbHelper = new DBHelper(getApplicationContext());
        mhs = dbHelper.getAllRecord();

        adapter = new ListDataAdapter(mhs, getApplicationContext());
        rvData.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvData.setAdapter(adapter);
    }
}
