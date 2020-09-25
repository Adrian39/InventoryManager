package com.example.inventorymanager;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Point;
import android.media.Image;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.os.StrictMode;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.inventorymanager.ui.main.SectionsPagerAdapter;
import com.google.android.material.textfield.TextInputEditText;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MainActivity extends AppCompatActivity  {

    private RelativeLayout mInvSelection;

    //INTERNET CONNECTION VARIABLES
    private static final String IP = "192.168.0.19";
    private static final String PORT = "1433";
    private static String mClass = "net.sourceforge.jtds.jdbc.Driver";
    private static final String DATABASE = "adCOMER2018";
    private static String mUserName = "test";
    private static String mPass = "test";
    private static String mURL = "jdbc:jtds:sqlserver://" + IP + ":" + PORT + "/" + DATABASE;
    private Connection mConnection = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);

//        ImageButton minusButton = findViewById(R.id.minusButton);


//        minusButton.setAlpha((float) 0.5);

        //Hide inventory selection screen
        mInvSelection = findViewById(R.id.rly_inventory_selection);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        mInvSelection.setX(size.x);



    }

}