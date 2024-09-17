package com.example.blucore;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

/*public class PersonFragment extends Fragment {

    public PersonFragment(){
        // require a empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String[] items = {"Apple", "Banana", "Cherry", "Date", "Grapes", "Mango", "Orange", "Pineapple"};

        ListView listView = findViewById(R.id.listView);

        // Create an ArrayAdapter to bind the array data to the ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, items);

        // Set the adapter on the ListView
        listView.setAdapter(adapter);

        return inflater.inflate(R.layout.fragment_person, container, false);
    }
}*/


public class PersonFragment extends Fragment
{
    private TextView mTextViewEmpty;
    private ProgressBar mProgressBarLoading;
    private ImageView mImageViewEmpty;
    private RecyclerView mRecyclerView;
    //private ListAdapter mListadapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_person, container, false);

        LinearLayout cardView = view.findViewById(R.id.list);
        cardView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                // Toast.makeText(getApplicationContext(), "CardView clicked!", Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(PersonFragment.this, ViewServiceFragment.class);
                //startActivity(intent);

//                Fragment viewServiceFragment = new ViewServiceFragment();
//                FragmentTransaction transaction = getFragmentManager().beginTransaction();
//                transaction.replace(R.layout.fragment_person, viewServiceFragment);
//                transaction.addToBackStack(null);
//                transaction.commit();

                Fragment fragmentB = new ViewServiceFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                // Replace the current fragment with FragmentB
                transaction.replace(R.layout.fragment_person, fragmentB);
                transaction.addToBackStack(null);  // Optional: adds the transaction to the back stack
                transaction.commit();
            }
        });

        /*mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        mTextViewEmpty = (TextView)view.findViewById(R.id.textViewEmpty);
        mImageViewEmpty = (ImageView)view.findViewById(R.id.imageViewEmpty);
        mProgressBarLoading = (ProgressBar)view.findViewById(R.id.progressBarLoading);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        ArrayList data = new ArrayList<DataNote>();
        for (int i = 0; i < DataNoteImformation.id.length; i++)
        {
            data.add(
                    new DataNote
                            (
                                    DataNoteImformation.id[i],
                                    DataNoteImformation.textArray[i],
                                    DataNoteImformation.dateArray[i]
                            ));
        }

        mListadapter = new ListAdapter(data);
        mRecyclerView.setAdapter(mListadapter);*/

        return view;
    }

    /*public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>
    {
        private ArrayList<DataNote> dataList;

        public ListAdapter(ArrayList<DataNote> data)
        {
            this.dataList = data;
        }

        public class ViewHolder extends RecyclerView.ViewHolder
        {
            TextView textViewText;
            TextView textViewComment;
            TextView textViewDate;

            public ViewHolder(View itemView)
            {
                super(itemView);
                this.textViewText = (TextView) itemView.findViewById(R.id.text);
                this.textViewComment = (TextView) itemView.findViewById(R.id.comment);
                this.textViewDate = (TextView) itemView.findViewById(R.id.date);
            }
        }

        @Override
        public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item, parent, false);

            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ListAdapter.ViewHolder holder, final int position)
        {
            holder.textViewText.setText(dataList.get(position).getText());
            holder.textViewComment.setText(dataList.get(position).getComment());
            holder.textViewDate.setText(dataList.get(position).getDate());

            holder.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    Toast.makeText(getActivity(), "Item " + position + " is clicked.", Toast.LENGTH_SHORT).show();
                }
            });
        }*/

        /*@Override
        public int getItemCount()
        {
            return dataList.size();
        }
    }*/
}