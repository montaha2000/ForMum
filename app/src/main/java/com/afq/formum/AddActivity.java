package com.afq.formum;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

public class AddActivity extends AppCompatActivity {

    private Button btnRegister;
    private Toolbar myToolbar;
    private TextInputLayout edtRate;
    private TextInputLayout edtDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        initView();

        setTitle(R.string.add_to_services);
        setSupportActionBar(myToolbar);

        myToolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white));



    }

    private void initView() {
        btnRegister = findViewById(R.id.btnRegister);
        myToolbar = findViewById(R.id.my_toolbar);
        edtRate = findViewById(R.id.edtRate);
        edtDesc = findViewById(R.id.edtDesc);
    }
}