package com.example.ayatidevices.ViewPackage;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

/**
 * Created by lenovo on 5/13/2017.
 */

public class OpenSansSemiBold extends AppCompatTextView {

    public OpenSansSemiBold(Context context) {
        super(context);
        init();
    }

    public OpenSansSemiBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public OpenSansSemiBold(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                "OpenSans-Semibold.ttf");
        setTypeface(tf);
    }


}
