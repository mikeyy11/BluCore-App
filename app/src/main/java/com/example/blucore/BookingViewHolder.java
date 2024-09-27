package com.example.blucore;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class BookingViewHolder extends RecyclerView.ViewHolder {
    TextView tvAddress, tvDescription, tvId, tvMobile, tvName, tvServiceType, tvStatus;  //, tvBookingId, tvDate;

    public BookingViewHolder(View itemView) {
        super(itemView);
        // tvBookingId = itemView.findViewById(R.id.tvBookingId);
        // tvDate = itemView.findViewById(R.id.tvDate);
        tvStatus = itemView.findViewById(R.id.tvStatus);
        tvAddress = itemView.findViewById(R.id.tvAddress);
        tvDescription = itemView.findViewById(R.id.tvDescription);
        //tvId = itemView.findViewById(R.id.tvId);
        tvMobile = itemView.findViewById(R.id.tvMobile);
        tvName = itemView.findViewById(R.id.tvName);
        tvServiceType = itemView.findViewById(R.id.tvServiceType);
    }
}
