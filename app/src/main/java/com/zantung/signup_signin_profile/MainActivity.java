package com.zantung.signup_signin_profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn_Signin;
    TextView txtCreateAcc;
    EditText edtEmail, edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        txtCreateAcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, signUp.class);
                startActivity(intent);
            }
        });
        btn_Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtEmail.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();

                if (checkEmail(email) & checkPasswword(password)){
                    Intent intent = new Intent(MainActivity.this, profile.class);
                    startActivity(intent);
                }
//                if(email.isEmpty() || password.isEmpty()){
//                    Toast.makeText(MainActivity.this, "Bạn chưa nhập Email hoặc Password !", Toast.LENGTH_SHORT).show();
//                    edtEmail.setError("error");
//                    edtEmail.setBackgroundResource(R.drawable.errorbg);
//                } else if (email.equals("vantung.260902@gmail.com") && !password.equals("123")){
//                    Toast.makeText(MainActivity.this, "Đăng nhập không thành công!", Toast.LENGTH_SHORT).show();
//                } else {
//                    Intent intent = new Intent(MainActivity.this, profile.class);
//                    startActivity(intent);
//                }
            }
        });
    }
    private boolean checkEmail(String email){
        if (!email.isEmpty() && email.equals("vantung.260902@gmail.com")){
            edtEmail.setBackgroundResource(R.drawable.round_border);
            edtEmail.setError(null);
            return true;
        }else {
            edtEmail.setError("error");
            edtEmail.setBackgroundResource(R.drawable.errorbg);
        }
        return false;
    }
    private boolean checkPasswword(String pass){
        if (!pass.isEmpty() && pass.equals("123")){
            edtPassword.setBackgroundResource(R.drawable.round_border);
            edtPassword.setError(null);
            return true;
        }else {
            edtPassword.setError("error");
            edtPassword.setBackgroundResource(R.drawable.errorbg);
        }
        return false;
    }

    private void anhXa() {
        btn_Signin = findViewById(R.id.btn_login);
        txtCreateAcc = findViewById(R.id.tvCreateAccount);
        edtEmail = findViewById(R.id.inputEmail);
        edtPassword = findViewById(R.id.inputPassword);
    }
}