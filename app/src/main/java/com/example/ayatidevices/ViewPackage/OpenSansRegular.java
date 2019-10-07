package com.example.ayatidevices.ViewPackage;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

/**
 * Created by Etech001 on 19/11/2016.
 */

public class OpenSansRegular extends AppCompatTextView {
    public OpenSansRegular(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public OpenSansRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public OpenSansRegular(Context context) {
        super(context);
        init();
    }


    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                "OpenSans-Regular.ttf");
        setTypeface(tf);
    }


}
