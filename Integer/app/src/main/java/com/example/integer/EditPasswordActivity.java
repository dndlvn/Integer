package com.example.integer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EditPasswordActivity extends AppCompatActivity {

    private TextView userNameTextView;
    EditText oldPassword, newPassword, newPassword2;
    Button btnEdit, btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_password);

        oldPassword = findViewById(R.id.oldPassword);
        newPassword = findViewById(R.id.newPassword);
        newPassword2 = findViewById(R.id.newPasswordTryTwo);

        btnBack = findViewById(R.id.btnBack);
        btnEdit = findViewById(R.id.button1);

        userNameTextView = findViewById(R.id.userName);

        userNameTextView.setText(User.currentUser.getLastName() + " "
                + User.currentUser.getFirstName().charAt(0) + ". "
                + User.currentUser.getMiddleName().charAt(0) + ".");

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditPasswordActivity.this, ProfileActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(oldPassword.getText().toString().equals(User.currentUser.getPassword())) {
                    if(newPassword.getText().toString().equals(newPassword2.getText().toString())) {
                        User.currentUser.setPassword(newPassword.getText().toString());
                        Intent intent = new Intent(EditPasswordActivity.this, ProfileActivity.class);
                        startActivity(intent);
                        Toast.makeText(EditPasswordActivity.this,
                                "Пароль успешно изменен!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                    else {
                        Toast.makeText(EditPasswordActivity.this,
                                "Пароли не совпадают", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(EditPasswordActivity.this,
                            "Старый пароль введен неверно", Toast.LENGTH_SHORT).show();
                }
            }



        });
    }
}