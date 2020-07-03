package com.infisionid.basic_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText etInput = findViewById(R.id.et_input);
        Button btnChangeText = findViewById(R.id.btn_change_text);
        final TextView tvChangedText = findViewById(R.id.tv_changed_text);

        btnChangeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etInput.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Input cannot empty!", Toast.LENGTH_SHORT).show();
                    return;
                }
                tvChangedText.setText(etInput.getText().toString());
            }
        });
    }
}