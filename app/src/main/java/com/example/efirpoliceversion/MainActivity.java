package com.example.efirpoliceversion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = findViewById(R.id.btn_LogIn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText username = (EditText) findViewById(R.id.name);
                String user = username.getText().toString().trim();
                EditText password = (EditText) findViewById(R.id.password);
                String pass = password.getText().toString().trim();

                if(user.equals("username@ifir") && pass.equals("password")){
                    Intent intent = new Intent(MainActivity.this, DataActivity.class);
                    startActivity(intent);
                } else {
                    Toast toast = Toast.makeText(MainActivity.this,"Invalid Username or Password",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}