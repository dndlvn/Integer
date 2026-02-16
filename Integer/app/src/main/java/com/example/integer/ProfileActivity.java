package com.example.integer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfileActivity extends AppCompatActivity {

    EditText txtLastName, txtFirstName, txtMiddleName, txtBirthDate, txtPhone, txtEmail;
    Button  btnEditPassword, btnExit;
    private TextView userNameTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        txtLastName = findViewById(R.id.loginLastName);
        txtFirstName = findViewById(R.id.loginFirstName);
        txtMiddleName = findViewById(R.id.loginMiddleName);
        txtBirthDate = findViewById(R.id.loginBirthDate);
        txtPhone = findViewById(R.id.loginPhone);
        txtEmail = findViewById(R.id.loginEmail);
        userNameTextView = findViewById(R.id.userName);

        btnEditPassword = findViewById(R.id.button1);
        btnExit = findViewById(R.id.btnBack);

        txtLastName.setText(User.currentUser.getLastName());
        txtFirstName.setText(User.currentUser.getFirstName());
        txtMiddleName.setText(User.currentUser.getMiddleName());
        txtBirthDate.setText(User.currentUser.getBirthDate());
        txtPhone.setText(User.currentUser.getPhone());
        txtEmail.setText(User.currentUser.getEmail());

        userNameTextView.setText(User.currentUser.getLastName() + " "
                + User.currentUser.getFirstName().charAt(0) + ". "
                + User.currentUser.getMiddleName().charAt(0) + ".");

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, MainMenuActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnEditPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, EditPasswordActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}