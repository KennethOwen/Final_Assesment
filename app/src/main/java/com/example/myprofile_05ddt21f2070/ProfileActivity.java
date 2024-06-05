package com.example.myprofile_05ddt21f2070;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    SharedPreferences newPreference;
    Intent newIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView result = findViewById(R.id.resultText);
        Button update = findViewById(R.id.update);
        Button logout = findViewById(R.id.logout);
        newPreference = getSharedPreferences("details", MODE_PRIVATE);
        newIntent = new Intent(ProfileActivity.this, LoginActivity.class);
        result.setText("Welcome, " + newPreference.getString("name", null));


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Your profile has successfully updated", Toast.LENGTH_SHORT).show();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor edit = newPreference.edit();
                edit.clear();
                edit.commit();
                startActivity(newIntent);
            }
        });
    }
}