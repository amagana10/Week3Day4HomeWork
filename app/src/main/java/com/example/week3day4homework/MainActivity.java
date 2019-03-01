package com.example.week3day4homework;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements
        UserInput.OnStaticUserFragmentInteractionListener {
    Display display;
    FragmentManager fragmentManager;
    ArrayList<User> users;

    public static final String DISPLAY_FRAG_ONE_TAG = "display_frag_one";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        users = new ArrayList<User>();

        display = Display.newInstance();

        fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(R.id.frmDisplay, display)
                .addToBackStack(DISPLAY_FRAG_ONE_TAG)
                .commit();
    }

    @Override
    public void onSendActivity(User passeduser) {
        users.add(passeduser);
        //updateRecycler viewer

        Log.d("TAG", "onSendActivity: "+passeduser.toString());

        display.addUser(passeduser);

        fragmentManager = getSupportFragmentManager();
        fragmentManager
                .beginTransaction()
                .replace(R.id.frmDisplay, display)
                .addToBackStack(DISPLAY_FRAG_ONE_TAG)
                .commit();
    }
}
