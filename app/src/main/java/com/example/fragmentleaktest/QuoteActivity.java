package com.example.fragmentleaktest;

import android.app.Activity;
import android.os.Bundle;

import com.example.fragmentleaktest.ui.main.QuoteFragment;


public class QuoteActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            // During initial setup, plug in the details fragment.
            QuoteFragment details = new QuoteFragment();
            details.setArguments(getIntent().getExtras());
            getFragmentManager().beginTransaction().add(android.R.id.content, details).commit();
        }
    }
}