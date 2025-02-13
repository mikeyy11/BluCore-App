package com.example.blucore;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class WorkerHomeActivity extends AppCompatActivity implements BottomNavigationView
        .OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_home);
        session = new SessionManager(getApplicationContext());

        bottomNavigationView
                = findViewById(R.id.bottomNavigationView);

        bottomNavigationView
                .setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);

        /////
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        Menu menu = bottomNavigationView.getMenu();

        MenuItem transactionItem = menu.findItem(R.id.transaction);
        if (Objects.equals(session.getUserType(), "User")) {
            transactionItem.setVisible(true);
        } else {
            transactionItem.setVisible(false);
        }
        MenuItem bookingItem = menu.findItem(R.id.person);
        if (!Objects.equals(session.getUserType(), "User")) {
            bookingItem.setVisible(true);
        } else {
            bookingItem.setVisible(false);
        }

        ////
    }
    PersonFragment personFragment = new PersonFragment();
    UserHomeFragment homeFragment = new UserHomeFragment();     // HomeFragment
    EditProfileFragment editProfileFragment = new EditProfileFragment();
    SkillsFragment skillsFragment = new SkillsFragment();
    TransactionFragment transactionFragment = new TransactionFragment();

    @Override
    public boolean
    onNavigationItemSelected(@NonNull MenuItem item)
    {

        if (Objects.equals(session.getUserType(), "User")) {
            //Toast.makeText(WorkerHomeActivity.this, "submit booking 1 " + session.getUserType(), Toast.LENGTH_SHORT).show();
        } else {
            //Toast.makeText(WorkerHomeActivity.this, "submit booking 2 " + session.getUserType(), Toast.LENGTH_SHORT).show();
        }

        int itemId = item.getItemId();

        if (itemId == R.id.person) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, personFragment)
                    .commit();
            return true;
        } else if (itemId == R.id.home) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, Objects.equals(session.getUserType(), "User") ? homeFragment : skillsFragment)
                    .commit();
            return true;
        } else if (itemId == R.id.transaction) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, transactionFragment)
                    .commit();
            return true;
        } else if (itemId == R.id.settings) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flFragment, editProfileFragment)
                    .commit();
            return true;
        }

        return false;
    }
}