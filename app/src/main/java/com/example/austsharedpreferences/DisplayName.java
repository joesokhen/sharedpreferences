package com.example.austsharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DisplayName extends AppCompatActivity {

    SharedPreferences sp;
    TextView Name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_display_name);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        Name = findViewById(R.id.tvName);
        String name = sp.getString("NAME", "");
        String age = sp.getString("AGE", "");
        String major = sp.getString("MAJOR","");

        Name.setText("Hello " + name + "\nAge: "+ age + "\nMajor: " + major);
    }
}