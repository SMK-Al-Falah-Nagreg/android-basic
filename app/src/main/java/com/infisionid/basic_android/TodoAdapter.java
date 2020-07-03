package com.infisionid.basic_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import java.util.List;

/**
 * TODO: Creating Adapter for RecyclerView
 */
public class TodoAdapter extends Adapter<TodoAdapter.TodoViewHolder> {

    private List<String> todoList;

    public TodoAdapter(List<String> todoList) {
        this.todoList = todoList;
    }

    @NonNull
    @Override
    public TodoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_todo, parent, false);

        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoViewHolder holder, int position) {
        holder.bind(todoList.get(position));
    }

    @Override
    public int getItemCount() {
        return todoList.size();
    }

    class TodoViewHolder extends ViewHolder {

        private TextView tvItem;

        public TodoViewHolder(@NonNull View itemView) {
            super(itemView);

            tvItem = itemView.findViewById(R.id.tv_text);
        }

        public void bind(String text) {
            tvItem.setText(text);
        }
    }
}
