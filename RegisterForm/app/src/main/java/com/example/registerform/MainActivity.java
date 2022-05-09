package com.example.registerform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText MSSV;
    EditText HoTen;
    EditText CCCD;
    EditText SDT;
    EditText Email;
    CalendarView NgaySinh;
    EditText QueQuan;
    EditText NoiO;
    Button register;
    CheckBox confirm;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MSSV = (EditText) findViewById(R.id.mssv);
        HoTen = (EditText)findViewById(R.id.ten);
        CCCD = (EditText) findViewById(R.id.cccd);
        SDT = (EditText) findViewById(R.id.sdt);
        Email = (EditText) findViewById(R.id.email);
        NgaySinh = (CalendarView) findViewById(R.id.ngaysinh);
        QueQuan = (EditText) findViewById(R.id.quequan);
        NoiO = (EditText) findViewById(R.id.noio);
        register = (Button) findViewById(R.id.register);
        confirm = (CheckBox) findViewById(R.id.check_cf);
        confirm.setChecked(false);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkDataEntered();
            }
        });
    }

    boolean isEmpty(EditText text){
        String data = text.getText().toString();
        if (data.length() == 0) return true;
        else
            return false;
    }

    boolean isEmail(EditText text){
        String email = text.getText().toString().trim();
        return email.matches(emailPattern);
    }

    void checkDataEntered(){
        int c = 0;
        if (!confirm.isChecked()){
            Toast t = Toast.makeText(this, "Cần phải đồng ý với điều khoản sử dụng!", Toast.LENGTH_SHORT);
            t.show();
            return;
        }
        if (isEmpty(MSSV)) {
            MSSV.setError("Cần nhập MSSV");
            c++;
        }
        if (isEmpty(HoTen)) {
            HoTen.setError("Cần nhập họ tên");
            c++;
        }
        if (isEmpty(CCCD)) {
            CCCD.setError("Cần nhập CCCD");
            c++;
        }
        if (isEmpty(SDT)) {
            SDT.setError("Cần nhập SDT");
            c++;
        }
        if (!isEmail(Email)) {
            Email.setError("Cần nhập Email hoặc Email chưa hợp lệ");
            c++;
        }

        if (c == 0){
            Toast t = Toast.makeText(this, "Nhập dữ liệu thành công!", Toast.LENGTH_SHORT);
            t.show();
            return;
        }
    }

}