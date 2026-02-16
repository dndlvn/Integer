package com.example.integer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.TaskViewHolder> {

    private final List<Tasks> tasksList;
    private OnTaskClickListener listener;

    public TasksAdapter(List<Tasks> tasksList) {
        this.tasksList = tasksList;
    }

    public interface OnTaskClickListener {
        void onTaskClick(int position);
    }

    public void setOnTaskClickListener(OnTaskClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Tasks task = tasksList.get(position);

        holder.tvNumber.setText("  " + task.getNumber());
        holder.tvTitle.setText(task.getTitle());

        int color;
        switch (task.getStatus()) {
            case "В работе":
                color = holder.itemView.getContext()
                        .getColor(android.R.color.holo_green_dark);
                break;
            case "Нужно сделать":
                color = holder.itemView.getContext()
                        .getColor(android.R.color.holo_orange_dark);
                break;
            default:
                color = holder.itemView.getContext()
                        .getColor(android.R.color.holo_red_dark);
                break;
        }
        holder.triangle.setBackgroundColor(color);
    }

    @Override
    public int getItemCount() {
        return tasksList.size();
    }

    class TaskViewHolder extends RecyclerView.ViewHolder {

        TextView tvNumber, tvTitle;
        View triangle;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNumber = itemView.findViewById(R.id.tvNumber);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            triangle = itemView.findViewById(R.id.triangle);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (listener != null && pos != RecyclerView.NO_POSITION) {
                        listener.onTaskClick(pos);
                    }
                }
            });
        }
    }
}

