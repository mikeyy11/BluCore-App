package com.example.blucore;

import static android.content.ContentValues.TAG;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;
import java.util.List;

public class SignupActivity extends AppCompatActivity {

    EditText signupUsername, signupEmail, signupPassword, userType;
    CheckBox plumber,electrician,carpenter;
    TextView loginRedirectText;
    Button signupButton;
    FirebaseDatabase database;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Spinner userType = (Spinner) findViewById(R.id.user_type);
        signupEmail = findViewById(R.id.signup_email);
        signupUsername = findViewById(R.id.signup_username);
        signupPassword = findViewById(R.id.signup_password);
        loginRedirectText = findViewById(R.id.loginRedirectText);
        signupButton = findViewById(R.id.signup_button);
        plumber=(CheckBox)findViewById(R.id.checkBox);
        electrician=(CheckBox)findViewById(R.id.checkBox2);
        carpenter=(CheckBox)findViewById(R.id.checkBox3);

        userType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if(position == 1) {
                    plumber.setVisibility(View.VISIBLE);
                    electrician.setVisibility(View.VISIBLE);
                    carpenter.setVisibility(View.VISIBLE);
                } else {
                    plumber.setVisibility(View.GONE);
                    electrician.setVisibility(View.GONE);
                    carpenter.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                Log.d(TAG, "onNothingSelected = ");
            }

        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");

                String usertype = userType.getSelectedItem().toString();
                String email = signupEmail.getText().toString();
                String username = signupUsername.getText().toString();
                String password = signupPassword.getText().toString();

                Log.d(TAG, "Test2 = " + usertype);

                List<String> selectedOptions = new ArrayList<>();
                if(plumber.isChecked()){
                    selectedOptions.add(plumber.getText().toString());
                }
                if(electrician.isChecked()){
                    selectedOptions.add(electrician.getText().toString());
                }
                if(carpenter.isChecked()){
                    selectedOptions.add(carpenter.getText().toString());
                }

                HelperClass helperClass = new HelperClass(usertype, email, username, password, selectedOptions);
                reference.child(username).setValue(helperClass);

                Toast.makeText(SignupActivity.this, "You have signup successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        loginRedirectText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
