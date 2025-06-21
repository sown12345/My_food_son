package com.example.myfood_son;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myfood_son.database.UserDAO_Son;

public class LoginActivity_Son extends AppCompatActivity {

    EditText edtUsername_Son, edtPassword_Son;
    Button btnLogin_Son;
    TextView txtRegister_Son;

    UserDAO_Son userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsername_Son = findViewById(R.id.edtUsername_Son);
        edtPassword_Son = findViewById(R.id.edtPassword_Son);
        btnLogin_Son = findViewById(R.id.btnLogin_Son);
        txtRegister_Son = findViewById(R.id.txtRegister_Son);

        userDAO = new UserDAO_Son(this);

        btnLogin_Son.setOnClickListener(v -> {
            String username = edtUsername_Son.getText().toString().trim();
            String password = edtPassword_Son.getText().toString().trim();

            if (userDAO.checkLogin(username, password)) {
                Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, HomeActivity_Son.class)); // sẽ làm sau
            } else {
                Toast.makeText(this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
            }
        });

        txtRegister_Son.setOnClickListener(v -> {
            startActivity(new Intent(this, RegisterActivity_Son.class));
        });
    }
}
