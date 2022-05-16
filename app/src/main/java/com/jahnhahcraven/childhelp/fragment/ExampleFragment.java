package com.jahnhahcraven.childhelp.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.jahnhahcraven.childhelp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExampleFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExampleFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

//    properties initialization
    private Button button;
    private EditText numberPicker;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    OnFragmentInteractionListener mListener;

    private void init(View view){
        button=view.findViewById(R.id.fragment_example_btnFind);
        numberPicker=(EditText) view.findViewById(R.id.txtId);
        button.setOnClickListener(onButtonPressed);
    }


    public ExampleFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExampleFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExampleFragment newInstance(String param1, String param2) {
        ExampleFragment fragment = new ExampleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof OnFragmentInteractionListener){
            mListener=(OnFragmentInteractionListener) context;
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewGroup=inflater.inflate(R.layout.fragment_example, container, false);
        init(viewGroup);
        return viewGroup;
    }

    public View.OnClickListener onButtonPressed=
            new Button.OnClickListener(){
                public void onClick(View view){
                    if(mListener!=null) {

                        mListener.onFragmentInteraction(Integer.parseInt(numberPicker.getText().toString()));
                    }
                }
            };

    public interface OnFragmentInteractionListener{
        public void onFragmentInteraction(int id);
    }
}