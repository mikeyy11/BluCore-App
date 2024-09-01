package com.example.blucore;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;


public class UserHomeActivity extends AppCompatActivity {

    EditText name, mobile, address, description;
    TextView loginRedirectText;
    Button submitButton;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    //Date date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        name = findViewById(R.id.name);
        mobile = findViewById(R.id.mobile_no);
        address = findViewById(R.id.address);
        description = findViewById(R.id.description);
        //date = findViewById(R.id.date);
        submitButton = findViewById(R.id.submit_button);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitBooking();
            }
        });
    }

    private void submitBooking() {
        Spinner serviceType = (Spinner) findViewById(R.id.service_type);
        databaseReference = FirebaseDatabase.getInstance().getReference("Bookings");

        String ServiceType = serviceType.getSelectedItem().toString();
        String Name = name.getText().toString().trim();
        String Mobile = mobile.getText().toString().trim();
        String Address = address.getText().toString().trim();
        String Description = description.getText().toString().trim();

        /*if (name.isEmpty() || date.isEmpty() || time.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }*/

        String bookingId = databaseReference.push().getKey();
        BookingHelperClass bookingHelperClass = new BookingHelperClass(bookingId, ServiceType, Name, Mobile, Address, Description);

        if (bookingId != null) {
            databaseReference.child(bookingId).setValue(bookingHelperClass).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(UserHomeActivity.this, "Booking submitted", Toast.LENGTH_SHORT).show();
                    //serviceType.setText("");
                    name.setText("");
                    mobile.setText("");
                    address.setText("");
                    description.setText("");
                } else {
                    Toast.makeText(UserHomeActivity.this, "Failed to submit booking", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
