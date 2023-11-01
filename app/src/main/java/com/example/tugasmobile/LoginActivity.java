package com.example.tugasmobile;

import static android.text.TextUtils.isEmpty;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText username = findViewById(R.id.usernameEditText);
        EditText password = findViewById(R.id.passwordEditText);
        Button login = findViewById(R.id.loginButton);
        TextView forgotPassword = findViewById(R.id.forgotPassword);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Proses mengubah value dari EditText dan password menjadi string
                String strUsername = username.getText().toString().trim();
                String strPassword = password.getText().toString().trim();

                if (strUsername.isEmpty() || strPassword.isEmpty()){
                    // Proses cek jika username dan password kosong
                    username.setError("Username is required!!!");
                    password.setError("Password is required!!");
                } // Proses Validasi isi dari username dan password
                else if (strUsername.equals("user1") && strPassword.equals("rahasia")) {
                    // Jika username berisi "user1" dan password "rahasia", maka akan pindah ke homepage
                    Intent intent = new Intent(LoginActivity.this, HomepageActivity.class);
                    startActivity(intent);
                } else {
                    // Menampilkan pesan error jika username atau password salah
                    Toast.makeText(LoginActivity.this, "Username or password is wrong!!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });

        TextView textView = findViewById(R.id.register);

        String text = "Doesn't have an account? Sign up now!";

        SpannableString signUp = new SpannableString(text);

        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View view) {
                Intent i = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(i);
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(Color.BLUE);
                ds.setUnderlineText(false);
            }
        };

        // Membuat kata "Sign up now!" menjadi link, dimulai dari index ke-25 sampai 36
        signUp.setSpan(clickableSpan1, 25, 36, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.setText(signUp);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void forgotPassword(View view) {
    }
}