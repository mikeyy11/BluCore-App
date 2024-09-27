package com.example.blucore;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class BookingAdapter extends RecyclerView.Adapter<BookingViewHolder> {
    private List<Booking> bookings;
    public BookingAdapter(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public BookingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.booking_item, parent, false);
        return new BookingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookingViewHolder holder, int position) {
        Booking booking = bookings.get(position);
        // holder.tvBookingId.setText("Booking ID: " + booking.getBookingId());
        // holder.tvDate.setText("Date: " + booking.getDate());
        holder.tvStatus.setText(getStatusText(booking.getStatus()));
        holder.tvAddress.setText(booking.getAddress());
        holder.tvDescription.setText(booking.getDescription());
        //holder.tvId.setText("id: " + booking.getId());
        holder.tvMobile.setText(booking.getMobile());
        holder.tvName.setText(booking.getName());
        holder.tvServiceType.setText(booking.getServiceType());
    }

    public static String getStatusText(int statusId) {
        switch (statusId) {
            case 1:
                return "Pending";
            case 2:
                return "Accepted";
            case 3:
                return "Completed";
            default:
                return "";
        }
    }

    @Override
    public int getItemCount() {
        return bookings.size();
    }
}