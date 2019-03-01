package com.example.week3day4homework;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnStaticUserFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link UserInput#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UserInput extends Fragment implements View.OnClickListener {
    EditText etName;
    EditText etEmail;
    EditText etPassword;
    Button btnSendToMain;
    private OnStaticUserFragmentInteractionListener mListener;

    public UserInput() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static UserInput newInstance() {
        UserInput fragment = new UserInput();
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        etName = view.findViewById(R.id.etName);
        etEmail = view.findViewById(R.id.etEmail);
        etPassword = view.findViewById(R.id.etPassword);
        btnSendToMain = view.findViewById(R.id.btnSendToActivity);
        btnSendToMain.setOnClickListener(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnStaticUserFragmentInteractionListener) {
            mListener = (OnStaticUserFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnStaticUserFragmentInteractionListener");
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
            String name = etName.getText()!=null?etName.getText().toString():"";
            String email = etEmail.getText()!=null?etEmail.getText().toString():"";
            String password = etPassword.getText()!=null?etPassword.getText().toString():"";
            mListener.onSendActivity(new User(name,email,password));
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnStaticUserFragmentInteractionListener {
        // TODO: Update argument type and name
        void onSendActivity(User passeduser);
    }
}
