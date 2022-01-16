package com.example.td4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText userEmail,userPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle(getLocalClassName());
        initView();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkCredintials(userEmail.getText().toString(),userPassword.getText().toString())){
                    Intent intent = new Intent(LoginActivity.this,DetailsActivity.class);
                    intent.putExtra("login",userEmail.getText().toString());
                    NewsListApplication app = (NewsListApplication) getApplicationContext();
                    app.setLogin(userEmail.getText().toString());
                    startActivity(intent);
                }
                else {
                    Toast.makeText(LoginActivity.this,"Invalid credintials",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initView() {
        userEmail = findViewById(R.id.user_email);
        userPassword = findViewById(R.id.user_password);
        btnLogin = findViewById(R.id.btnLogin);
    }

    private boolean checkCredintials(String email,String password){
        return email.equals("ifatssane@mail.com") && password.equals("jaouad") ? true : false;
    }
}