package com.example.efirpoliceversion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Objects;

public class DataActivity extends AppCompatActivity {

    ArrayList<ComplainModel> complains;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        Toolbar actionBar = (Toolbar) findViewById(R.id.toolbar_data_activity);
        setSupportActionBar(actionBar);
        if(actionBar!=null){
            Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("DataBase") ;
        }
        assert actionBar != null;
        actionBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        RecyclerView rvTasks = (RecyclerView) findViewById(R.id.rvTasks);

        DataActivityAdapter adapter = new DataActivityAdapter(complains);

        rvTasks.setAdapter(adapter);

        rvTasks.setLayoutManager(new LinearLayoutManager(this));

    }
}