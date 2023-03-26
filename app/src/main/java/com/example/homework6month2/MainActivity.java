package com.example.homework6month2;

import static android.opengl.ETC1.isValid;
import static android.view.View.VISIBLE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myBtn = findViewById(R.id.to_come_in);
        EditText editMail = findViewById(R.id.email_et);
        EditText editPassword = findViewById(R.id.password_et);
        LinearLayout container = findViewById(R.id.linear1);
        LinearLayout container2 = findViewById(R.id.linear2);
        TextView textView1 = findViewById(R.id.next1_tv);
        TextView textView2 = findViewById(R.id.password_tv);
        TextView textView3 = findViewById(R.id.next_tv);
        TextView textView4 = findViewById(R.id.welcome_tv1);


        myBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editMail.getText().toString().equals("admin") &&
                        editPassword.getText().toString().equals("admin")) {
                    Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались!", Toast.LENGTH_SHORT).show();
                    container.setVisibility(View.GONE);

                } else {
                    Toast.makeText(MainActivity.this, "Неверный пароль или логин ", Toast.LENGTH_SHORT).show();
                    container.setVisibility(VISIBLE);
                }
            }
        });

        editMail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().isEmpty()) {
                    myBtn.setBackgroundResource(R.drawable.gray_bg);
                } else {
                    myBtn.setBackgroundResource(R.drawable.yellow_bg);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        editPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                switch (s.length()) {
                    case 0:
                        myBtn.setBackgroundResource(R.drawable.gray_bg);
                        break;
                    case 1:
                        myBtn.setBackgroundResource(R.drawable.yellow_bg);
                        break;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}

