package com.infisionid.basic_android;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /**
     * Create Adapter for handle recyclerview data
     */
    private TodoAdapter adapter;

    /**
     * Create the list
     */
    private List<String> todoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etInput = findViewById(R.id.et_input);
        Button btnChangeText = findViewById(R.id.btn_change_text);
        RecyclerView rvTodo = findViewById(R.id.rv_todo);

        /**
         * Don't forget to assign a value for list
         * The app will crash if we assign null to the adapter
         */
        todoList = new ArrayList<>();

        adapter = new TodoAdapter(todoList);

        /**
         * Init RecyclerView
         */
        rvTodo.setLayoutManager(new LinearLayoutManager(this));
        rvTodo.setAdapter(adapter);

        btnChangeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etInput.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Input cannot empty!", Toast.LENGTH_SHORT).show();
                    return;
                }

                /**
                 * Insert data to list, and clear the input text
                 */
                todoList.add(etInput.getText().toString());
                adapter.notifyItemInserted(todoList.size());

                hideKeyboard(etInput);

                etInput.setText("");
                etInput.clearFocus();
            }
        });
    }

    private void hideKeyboard(View v) {
//        View view = this.getCurrentFocus();
//        if (view != null) {
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
//        }
    }
}