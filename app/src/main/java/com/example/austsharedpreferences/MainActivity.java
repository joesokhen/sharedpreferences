package com.example.austsharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sp;
    EditText contactName, major;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        contactName = findViewById(R.id.etName);
        major = findViewById(R.id.etMajor);
        sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
    }

    public void saveName(View view) {
        String name = contactName.getText().toString().trim();
        String s_major = major.getText().toString().trim();
        int age = 45;
        sp.edit().putString("NAME", name).apply();
        sp.edit().putString("MAJOR", s_major).apply();
        sp.edit().putString("AGE", Integer.toString(age)).apply();
    }

    public void goToDisplayActivity(View view) {
        Intent i = new Intent(this, DisplayName.class);
        startActivity(i);
    }
}