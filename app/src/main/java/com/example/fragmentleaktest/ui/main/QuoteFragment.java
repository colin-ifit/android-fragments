package com.example.fragmentleaktest.ui.main;

import android.app.Fragment;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;


import com.example.fragmentleaktest.Quotes;
import com.example.fragmentleaktest.R;


public class QuoteFragment extends Fragment {

    private static TextView quoteText;

    /**
     * Create a new instance of QuoteFragment, initialized to
     * show the text at 'index'.
     */
    public static QuoteFragment newInstance(int index) {
        QuoteFragment f = new QuoteFragment();

        // Supply index input as an argument.
        Bundle args = new Bundle();
        args.putInt("index", index);
        f.setArguments(args);

        return f;
    }

    public int getShownIndex() {
        return getArguments().getInt("index", 0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (container == null) {
            // We have different layouts, and in one of them this
            // fragment's containing frame doesn't exist. The fragment
            // may still be created from its saved state, but there is
            // no reason to try to create its view hierarchy because it
            // isn't displayed. Note this isn't needed -- we could just
            // run the code below, where we would create and return the
            // view hierarchy; it would just never be used.
            return null;
        }

        View rootView = inflater.inflate(R.layout.quote_layout, container, false);
        quoteText = (TextView) rootView.findViewById(R.id.quoteTextView);

        int padding = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                4, getActivity().getResources().getDisplayMetrics());
        quoteText.setPadding(padding, padding, padding, padding);
        quoteText.setText(Quotes.DIALOGUE[getShownIndex()]);
        return rootView;
    }


}