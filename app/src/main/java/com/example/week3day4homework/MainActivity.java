package com.example.week3day4homework;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements UserInputFragment.OnFragmentInteractionListener, RecyclerViewFragment.OnFragmentInteractionListener{
    private static ArrayList<User> userArrayList;

    UserInputFragment userInputFragment;
    public static final String USER_INPUT_TAG = "user_input";
    public static final String RECYCLER_VIEW_TAG = "recycler_view";
    User newUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().replace(R.id.frmInput, UserInputFragment.newInstance()).addToBackStack(USER_INPUT_TAG).commit();

        fragmentManager.beginTransaction().replace(R.id.frmRecylerView, RecyclerViewFragment.newInstance()).addToBackStack(RECYCLER_VIEW_TAG).commit();
    }


    @Override
    public void onFragmentInteraction(User user) {

       newUser = userInputFragment.setDynamicOutput(user);
       userArrayList.add(newUser);

    }

    @Override
    public void onRecyclerViewImplementation(ArrayList<User> user) {
user = this.userArrayList;
    }

    public ArrayList<User> sendToFragment () {

        return userArrayList;
    }
}
