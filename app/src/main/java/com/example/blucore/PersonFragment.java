package com.example.blucore;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class PersonFragment extends Fragment
{
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Bookings");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_person, container, false);
        /*LinearLayout cardView = view.findViewById(R.id.list);
        cardView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ViewServiceActivity.class);
                startActivity(intent);
            }
        });*/

        List<Booking> bookingList = new ArrayList<>();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                bookingList.clear();
                for (DataSnapshot bookingSnapshot : snapshot.getChildren()) {
                    Booking booking = bookingSnapshot.getValue(Booking.class);
                    String bookingId = bookingSnapshot.getKey();
                    Log.d("Booking....1", "Booking ID: " + bookingId);
                    if (booking != null) {
                        bookingList.add(booking);
                        //bookingDetails.append("Name: ").append(booking.getName()).append("\n");
                        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
                        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

                        BookingAdapter adapter = new BookingAdapter(bookingList);
                        recyclerView.setAdapter(adapter);
                    }
                }

                for (Booking booking : bookingList) {
                    Log.d("Booking....0", "ID: " + booking.getId() + ", User: " + booking.getDescription() +
                            ", Date: " + booking.getName() + ", Time: " + booking.getAddress());
                }
                // retrieveTV.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.d("Fail to get data.", "value" + " => ");
                // Toast.makeText(MainActivity.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}