package com.example.integer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TaskDetailsActivity extends AppCompatActivity {

    private TextView userNameTextView;
    EditText dev, tester, hour, title, status;
    TextView number;
    Button btnBack, btnTake, btnToTest;

    public static final String EXTRA_TITLE = "extra_title";
    public static final String EXTRA_NUMBER = "extra_number";
    public static final String EXTRA_STATUS = "extra_status";
    public static final String EXTRA_DEVELOPER = "extra_developer";
    public static final String EXTRA_TESTER = "extra_tester";
    public static final String EXTRA_HOUR = "extra_hour";
    public static final String RESULT_STATUS = "result_status";
    public static final String RESULT_REMOVE_TASK = "result_remove_task";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);

        userNameTextView = findViewById(R.id.userName);

        userNameTextView.setText(User.currentUser.getLastName() + " "
                + User.currentUser.getFirstName().charAt(0) + ". "
                + User.currentUser.getMiddleName().charAt(0) + ".");

        btnBack = findViewById(R.id.btnBack);
        btnTake = findViewById(R.id.btnTake);
        btnToTest = findViewById(R.id.btnToTest);

        number = findViewById(R.id.mainTxtView);
        dev = findViewById(R.id.devTxt);
        tester = findViewById(R.id.testerTxt);
        hour = findViewById(R.id.hourTxt);
        title = findViewById(R.id.titleTxt);
        status = findViewById(R.id.statusTxt);

        String numberStr = getIntent().getStringExtra(EXTRA_NUMBER);
        String titleStr = getIntent().getStringExtra(EXTRA_TITLE);
        String statusStr = getIntent().getStringExtra(EXTRA_STATUS);
        String devStr = getIntent().getStringExtra(EXTRA_DEVELOPER);
        String testerStr = getIntent().getStringExtra(EXTRA_TESTER);
        String hourStr = getIntent().getStringExtra(EXTRA_HOUR);

        number.setText("Задача № " + numberStr);
        dev.setText(devStr);
        tester.setText(testerStr);
        hour.setText(hourStr);
        title.setText(titleStr);
        status.setText(statusStr);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        if ("Нужно сделать".equals(statusStr)) {
            btnTake.setVisibility(View.VISIBLE);
            btnToTest.setVisibility(View.GONE);
        } else if ("В работе".equals(statusStr)) {
            btnTake.setVisibility(View.GONE);
            btnToTest.setVisibility(View.VISIBLE);
        } else {
            btnTake.setVisibility(View.GONE);
            btnToTest.setVisibility(View.GONE);
        }

        btnTake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newStatus = "В работе";
                status.setText(newStatus);

                Intent resultIntent = new Intent();
                resultIntent.putExtra(RESULT_STATUS, newStatus);
                setResult(RESULT_OK, resultIntent);

                btnTake.setVisibility(View.GONE);
                btnToTest.setVisibility(View.VISIBLE);
            }
        });


        btnToTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent resultIntent = new Intent();
                resultIntent.putExtra(RESULT_REMOVE_TASK, true);
                setResult(RESULT_OK, resultIntent);

                finish();
            }
        });




    }

}
