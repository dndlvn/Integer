package com.example.integer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TasksActivity extends AppCompatActivity {

    private static final int REQUEST_TASK_DETAILS = 100;

    private Button btnBack;
    private TextView userNameTextView;
    private RecyclerView recyclerView;

    private TasksAdapter adapter;
    private static List<Tasks> tasksList;

    private int selectedPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        btnBack = findViewById(R.id.btnBack);
        userNameTextView = findViewById(R.id.userName);
        recyclerView = findViewById(R.id.tasksRecycler);

        // Имя пользователя
        userNameTextView.setText(
                User.currentUser.getLastName() + " " +
                        User.currentUser.getFirstName().charAt(0) + ". " +
                        User.currentUser.getMiddleName().charAt(0) + "."
        );


        tasksList = new ArrayList<>();

        String developer = User.currentUser.getLastName() + " "
                + User.currentUser.getFirstName().charAt(0) + ". "
                + User.currentUser.getMiddleName().charAt(0) + ".";

        tasksList.add(new Tasks("1057", developer, "Антонов В.А.", "2ч",
                "Коммерческие услуги", "Нужно сделать"));
        tasksList.add(new Tasks("987", developer, "Антонов В.А.", "3ч",
                "GFK_Hierarhy", "Нужно сделать"));
        tasksList.add(new Tasks("11576", developer, "Антонов В.А.", "1ч",
                "Контрагенты", "Нужно сделать"));
        tasksList.add(new Tasks("302", developer, "Антонов В.А.", "4ч",
                "Сервисы ввода данных", "В работе"));
        tasksList.add(new Tasks("476", developer, "Антонов В.А.", "2ч",
                "Корректировка сервиса вывода", "Нужно сделать"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new TasksAdapter(tasksList);
        recyclerView.setAdapter(adapter);

        adapter.setOnTaskClickListener(new TasksAdapter.OnTaskClickListener() {
            @Override
            public void onTaskClick(int position) {
                selectedPosition = position;
                Tasks task = tasksList.get(position);

                Intent intent = new Intent(TasksActivity.this, TaskDetailsActivity.class);
                intent.putExtra(TaskDetailsActivity.EXTRA_NUMBER, task.getNumber());
                intent.putExtra(TaskDetailsActivity.EXTRA_TITLE, task.getTitle());
                intent.putExtra(TaskDetailsActivity.EXTRA_STATUS, task.getStatus());
                intent.putExtra(TaskDetailsActivity.EXTRA_DEVELOPER, task.getDeveloper());
                intent.putExtra(TaskDetailsActivity.EXTRA_TESTER, task.getTester());
                intent.putExtra(TaskDetailsActivity.EXTRA_HOUR, task.getHour());

                startActivityForResult(intent, REQUEST_TASK_DETAILS);
            }
        });

        // Назад
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TasksActivity.this, MainMenuActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_TASK_DETAILS
                && resultCode == RESULT_OK
                && data != null
                && selectedPosition != -1) {

            if (data.getBooleanExtra(TaskDetailsActivity.RESULT_REMOVE_TASK, false)) {
                tasksList.remove(selectedPosition);
                adapter.notifyItemRemoved(selectedPosition);
                selectedPosition = -1;
                return;
            }

            String newStatus = data.getStringExtra(TaskDetailsActivity.RESULT_STATUS);
            if (newStatus != null) {
                tasksList.get(selectedPosition).setStatus(newStatus);
                adapter.notifyItemChanged(selectedPosition);
            }
        }
    }

}
