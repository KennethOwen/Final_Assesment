package com.example.myprofile_05ddt21f2070;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText user_name, user_ic;
    Button btnLogin;
    SharedPreferences Shared_pref;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user_name = findViewById(R.id.name);
        user_ic = findViewById(R.id.nric);
        btnLogin = findViewById(R.id.btnLogin);
        Shared_pref = getSharedPreferences("details", MODE_PRIVATE);
        intent = new Intent(LoginActivity.this, ProfileActivity.class);
        if (Shared_pref.contains("username") && Shared_pref.contains("password")) {
            startActivity(intent);
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = user_name.getText().toString();
                String ic = user_ic.getText().toString();

                if (name.equals("kenneth") && ic.equals("010225120185")) {
                    SharedPreferences.Editor editor = Shared_pref.edit();
                    editor.putString("name", name);
                    editor.putString("ic", ic);
                    editor.commit();
                    Toast.makeText(getApplicationContext(), "Logged in", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Enter Right Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}