package com.example.week3day4homework;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;



public class UserInputFragment extends Fragment implements View.OnClickListener {

TextView tvUserName;
TextView tvUserEmail;
TextView tvUserPass;
private User newUserInfo;
Button btnSubmitInfo;



    private OnFragmentInteractionListener mListener;

    public UserInputFragment() {
        // Required empty public constructor
    }


    public static UserInputFragment newInstance() {
        UserInputFragment fragment = new UserInputFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_input, container, false);

    }


    public void onButtonPressed(Uri uri) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        if (mListener != null) {


            String username = tvUserName.getText().toString();
            String email = tvUserEmail.getText().toString();
            String pass = tvUserPass.getText().toString();

            User newUser = new User(username, email, pass);
            newUserInfo = newUser;

            mListener.onFragmentInteraction(newUser);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvUserName = view.findViewById(R.id.etFrgUserName);
        tvUserEmail = view.findViewById(R.id.etFrgUserEmail);
        tvUserPass = view.findViewById(R.id.etFrgUserPass);
        btnSubmitInfo = view.findViewById(R.id.btnSubmitInfo);
        btnSubmitInfo.setOnClickListener(this);
    }

    public interface OnFragmentInteractionListener {


        void onFragmentInteraction(User user);
    }

    public User setDynamicOutput(User user) {

return newUserInfo;
    }
}


