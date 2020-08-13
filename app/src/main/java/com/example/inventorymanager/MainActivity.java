package com.example.inventorymanager;

import android.content.Intent;
import android.graphics.Point;
import android.media.Image;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

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

public class MainActivity extends AppCompatActivity  {

    private RelativeLayout mInvSelection;

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