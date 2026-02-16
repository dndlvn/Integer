package com.example.integer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainMenuActivity extends AppCompatActivity {

    private TextView userNameTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        userNameTextView = findViewById(R.id.userName);

        userNameTextView.setText(User.currentUser.getLastName() + " "
                + User.currentUser.getFirstName().charAt(0) + ". "
                + User.currentUser.getMiddleName().charAt(0) + ".");

        Button btnTasks = findViewById(R.id.button2);
        Button btnProfile = findViewById(R.id.button3);
        Button btnExit = findViewById(R.id.button4);
        Button btnNotification = findViewById(R.id.button1);
        //Выход
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //ЛК
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, ProfileActivity.class);
                startActivity(intent);

            }
        });
        //Задачи
        btnTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, TasksActivity.class);
                startActivity(intent);

            }
        });
        //Уведомления
        btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenuActivity.this, NotificationActivity.class);
                startActivity(intent);

            }
        });

    }

}