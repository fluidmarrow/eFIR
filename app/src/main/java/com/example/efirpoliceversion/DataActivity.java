package com.example.efirpoliceversion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Objects;

public class DataActivity extends AppCompatActivity {

    ArrayList<ComplainModel> solvedComplains = new ArrayList<ComplainModel>();
    ArrayList<ComplainModel> pendingComplains = new ArrayList<ComplainModel>();
    RadioButton rbFinished, rbPending;
    RecyclerView rvTasks;
    RecyclerView.Adapter solvedAdapter, pendingAdapter;
    private long pressedTime = 0;
    private Toast showToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        rbFinished = findViewById(R.id.rbFinished);
        rbPending = findViewById(R.id.rbPending);

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

        rvTasks = (RecyclerView) findViewById(R.id.rvTasks);
        rvTasks.setHasFixedSize(true);

        rvTasks.setLayoutManager(new LinearLayoutManager(this));
        solvedComplains.add(new ComplainModel("A","B","C","D","E",true));
        pendingComplains.add(new ComplainModel("A","B","C","D","E",false));
        solvedAdapter = new DataActivityAdapter(solvedComplains);
        pendingAdapter = new DataActivityAdapter(pendingComplains);

        setRecyclerView(pendingAdapter);

        rbFinished.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRecyclerView(solvedAdapter);
            }
        });

        rbPending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRecyclerView(pendingAdapter);
            }
        });

    }

    public void setRecyclerView(RecyclerView.Adapter adapter)
    {
        rvTasks.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_design, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.log_out)
        {
            LogOutDialog timeUpDialog = new LogOutDialog();
            timeUpDialog.show(getSupportFragmentManager(), "Log Out?");
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed() {
        if(pressedTime + 2000 > System.currentTimeMillis())
        {
            showToast.cancel();
            finishAffinity();
            finish();
        }
        else
        {
            pressedTime = System.currentTimeMillis();
            showToast = Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT);
            showToast.show();
        }
    }
}