package com.example.inventorymanager.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.inventorymanager.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;





    int amount = 0;
    private ImageButton minusButton;
    private ImageButton plusButton;
    private EditText amountEditText;


    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;



        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        minusButton = root.findViewById(R.id.minusButton);
        plusButton = root.findViewById(R.id.plusButton);
        amountEditText = root.findViewById(R.id.amountTextEdit);



        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subtractAmount();

            }
        });

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addAmount();

            }
        });



        return root;
    }


    private void addAmount (){
        if (amount != 0) {
            amount = Integer.valueOf(String.valueOf(amountEditText.getText()));

        }
        amount++;
        amountEditText.setText(String.valueOf(amount));
    }
    private void subtractAmount (){
        if (amount != 0) {
            amount = Integer.valueOf(String.valueOf(amountEditText.getText()));

        }
        amount--;
        amountEditText.setText(String.valueOf(amount));
    }

}