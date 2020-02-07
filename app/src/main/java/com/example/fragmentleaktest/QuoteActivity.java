package com.example.fragmentleaktest;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;


import com.example.fragmentleaktest.ui.main.QuoteFragment;


public class QuoteActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            // During initial setup, plug in the details fragment.
            QuoteFragment details = new QuoteFragment();
            details.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(android.R.id.content, details).commit();
        }
    }
}