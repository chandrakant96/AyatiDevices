package com.example.ayatidevices.ViewPackage;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

/**
 * Created by lenovo on 4/21/2017.
 */

public class OpenSans_Bold extends AppCompatTextView {

    public OpenSans_Bold(Context context) {
        super(context);
        init();
    }

    public OpenSans_Bold(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public OpenSans_Bold(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                "OpenSans-Bold.ttf");
        setTypeface(tf);
    }


}
