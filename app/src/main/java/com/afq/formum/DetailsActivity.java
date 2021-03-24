package com.afq.formum;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

public class DetailsActivity extends AppCompatActivity {

    private Button button;
    private TextView txtDesc;
    private TextView txtRate;
    private TextView txtPhone;
    private TextView txtEmail;
    private TextView txtName;
    private Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        initView();

        setTitle(getString(R.string.details));
        setSupportActionBar(myToolbar);

        myToolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white));

        Intent i = getIntent();
        String name = i.getStringExtra("Name");
        String desc = i.getStringExtra("Desc");
        int rate = i.getIntExtra("Rate",0);
        String phone = i.getStringExtra("Phone");
        String email= i.getStringExtra("Email");

        txtName.setText("Name : "+name);
        txtDesc.setText("Description : "+desc);
        txtEmail.setText("Email : "+email);
        txtPhone.setText("Phone # : "+ phone);
        txtRate.setText("Rate : "+rate);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://api.whatsapp.com/send?phone="+phone;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

    }

    private void initView() {
        button = findViewById(R.id.button);
        txtDesc = findViewById(R.id.txtDesc);
        txtRate = findViewById(R.id.txtRate);
        txtPhone = findViewById(R.id.txtPhone);
        txtEmail = findViewById(R.id.txtEmail);
        txtName = findViewById(R.id.txtName);
        myToolbar = findViewById(R.id.my_toolbar);
    }
}