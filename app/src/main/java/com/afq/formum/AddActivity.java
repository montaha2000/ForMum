package com.afq.formum;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.afq.formum.Model.User;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

public class AddActivity extends AppCompatActivity {

    private Button btnJoin;
    private Toolbar myToolbar;
    private TextInputLayout edtRate;
    private TextInputLayout edtDesc;
    private TextInputLayout edtPhoneNumber;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("ForMum");
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        initView();


        setTitle(R.string.add_to_services);
        setSupportActionBar(myToolbar);

        myToolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white));

        btnJoin.setOnClickListener(view -> {
            AddServiceProvider();
            finish();
        });

    }

    private void initView() {
        btnJoin = findViewById(R.id.btnJoin);
        myToolbar = findViewById(R.id.my_toolbar);
        edtRate = findViewById(R.id.edtRate);
        edtDesc = findViewById(R.id.edtDesc);
        edtPhoneNumber = findViewById(R.id.edtPhoneNumber);
    }

    private void AddServiceProvider() {

        Log.e("afq", user.getEmail() + " name:" + user.getDisplayName());

        User u = new User();
        u.setName(user.getDisplayName());
        u.setEmail(user.getEmail());
        u.setPhone(edtPhoneNumber.getEditText().getText().toString().trim());
        u.setDesc(edtDesc.getEditText().getText().toString().trim());
        u.setRate(Integer.parseInt(edtRate.getEditText().getText().toString().trim()));

        myRef.child("ServiceProvider").child(user.getUid()).setValue(u).addOnSuccessListener(aVoid ->
                Log.i("AFQ", "1"));

        myRef.child("Users").child(user.getUid()).removeValue().addOnSuccessListener(aVoid ->
                Log.i("AFQ", "1"));

    }


}