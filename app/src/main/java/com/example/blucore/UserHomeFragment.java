package com.example.blucore;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class UserHomeFragment extends Fragment {

    EditText name, mobile, address, description;
    Spinner serviceType;
    TextView loginRedirectText;
    Button submitButton;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    SessionManager session;
    private Context context = getContext();;
    //Date date;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.activity_user_home, container, false);
        name = view.findViewById(R.id.name);
        mobile = view.findViewById(R.id.mobile_no);
        address = view.findViewById(R.id.address);
        description = view.findViewById(R.id.description);
        serviceType = view.findViewById(R.id.service_type);
        //date = findViewById(R.id.date);
        submitButton = view.findViewById(R.id.submit_button);
        session = new SessionManager(requireContext());

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submitBooking();
            }
        });
        return view;
    }

    private void submitBooking() {
        //Spinner serviceType = (Spinner) view.findViewById(R.id.service_type);
        databaseReference = FirebaseDatabase.getInstance().getReference("Bookings");

        String ServiceType = serviceType.getSelectedItem().toString();
        String Name = name.getText().toString().trim();
        String Mobile = mobile.getText().toString().trim();
        String Address = address.getText().toString().trim();
        String Description = description.getText().toString().trim();
        int Status = 1;

        /*if (name.isEmpty() || date.isEmpty() || time.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
            return;
        }*/

        String bookingId = databaseReference.push().getKey();
        BookingHelperClass bookingHelperClass = new BookingHelperClass(bookingId, ServiceType, Mobile, Name, Address, Description, Status);

        if (bookingId != null) {
            databaseReference.child(bookingId).setValue(bookingHelperClass).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    Toast.makeText(getContext(), "Booking submitted", Toast.LENGTH_SHORT).show();
                    //serviceType.setText("");
                    name.setText("");
                    mobile.setText("");
                    address.setText("");
                    description.setText("");
                } else {
                    Toast.makeText(getContext(), "Failed to submit booking", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
