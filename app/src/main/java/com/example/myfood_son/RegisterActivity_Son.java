package com.example.myfood_son;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myfood_son.database.UserDAO_Son;

public class RegisterActivity_Son extends AppCompatActivity {

    EditText edtUsernameReg_Son, edtPasswordReg_Son, edtRePassword_Son;
    Button btnRegister_Son;
    TextView txtBackToLogin_Son;

    UserDAO_Son userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtUsernameReg_Son = findViewById(R.id.edtUsernameReg_Son);
        edtPasswordReg_Son = findViewById(R.id.edtPasswordReg_Son);
        edtRePassword_Son = findViewById(R.id.edtRePassword_Son);
        btnRegister_Son = findViewById(R.id.btnRegister_Son);
        txtBackToLogin_Son = findViewById(R.id.txtBackToLogin_Son);

        userDAO = new UserDAO_Son(this);

        btnRegister_Son.setOnClickListener(v -> {
            String username = edtUsernameReg_Son.getText().toString().trim();
            String password = edtPasswordReg_Son.getText().toString().trim();
            String rePassword = edtRePassword_Son.getText().toString().trim();

            if (username.isEmpty() || password.isEmpty() || rePassword.isEmpty()) {
                Toast.makeText(this, "Không được để trống!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!password.equals(rePassword)) {
                Toast.makeText(this, "Mật khẩu không trùng khớp!", Toast.LENGTH_SHORT).show();
                return;
            }

            boolean ok = userDAO.insertUser("Tên Mặc định", "Nam", "2000-01-01", "0900000000", "TP.HCM", username, password);
            if (ok) {
                Toast.makeText(this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, LoginActivity_Son.class));
            } else {
                Toast.makeText(this, "Tài khoản đã tồn tại!", Toast.LENGTH_SHORT).show();
            }
        });

        txtBackToLogin_Son.setOnClickListener(v -> {
            startActivity(new Intent(this, LoginActivity_Son.class));
        });
    }
}
