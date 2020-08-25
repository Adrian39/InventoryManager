package com.example.inventorymanager.ui.main;

import android.os.Bundle;
import android.os.StrictMode;
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

import java.security.PrivilegedAction;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private PageViewModel pageViewModel;
    int amount = 0;
    //GUI VARIABLES
    private ImageButton minusButton;
    private ImageButton plusButton;
    private EditText amountEditText;
    private EditText codeEditText;
    private TextView productName;

    //INTERNET CONNECTION VARIABLES
    private static final String IP = "192.168.0.12";
    private static final String PORT = "1433";
    private static String mClass = "net.sourceforge.jtds.jdbc.Driver";
    private static final String DATABASE = "adCOMER2018";
    private static String mUserName = "test";
    private static String mPass = "test";
    private static String mURL = "jdbc:jtds:sqlserver://" + IP + ":" + PORT + "/" + DATABASE;
    private Connection mConnection = null;

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

        //DATABASE CONNECTION
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try {
            Class.forName(mClass);
            mConnection = DriverManager.getConnection(mURL, mUserName, mPass);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

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

    private void searchItemByCode(View view){
        
    }

}