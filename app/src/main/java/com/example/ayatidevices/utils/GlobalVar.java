package com.example.ayatidevices.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ayatidevices.R;



public class GlobalVar {

    public static String ServerAddress = "http://sadmin.whrhealth.com/api/";
    //public static String ServerAddress = "http://192.168.10.203/api/";
    public static boolean categoriesSpinnerFlage = false;

    public static double latitude;
    public static double longitude;
    public static String placesname;
    public static String MID = "LivWor74836176531967";
    public static String Website = "LivWorWAP";
    public static String Merchant_Key = "IEVtRc4_W74R_27o";
    public static String Industry_type_ID = "Retail109";
    public static String Channel_ID = "WAP";
    public static String CALLBACK_URL = "https://secure.paytm.in/oltp-web/processTransaction";

    public static String Call_number = "+918698210210";
    public static String ivr_auth_key = "vIbtD-Y3Zpr0Z1ouA-lyabJQ0X-mhvAaZIP";

    public static Dialog pDialog;
    static String TAG = "GlobalVar";
    public static int countProgress = 0;
    public static String WHR_SUPPORT_EMAIL = "support@whrhelath.com";
    public static String PAY_STATUS_DOCTOR = "1";
    public static String PAY_STATUS_PATHOLOGY = "2";
    public static String PAY_STATUS_HOSPITAL = "3";
    public static String PAY_STATUS_HOSPITAL_PACKAGES = "4";
    public static int NO_INTERNET_REQUEST_CODE = 1111;
    public static int NO_DATA_AVAILABLE = 2222;


    public static void showProgressDialog(Activity activity, String message, boolean isCancelable) {
        if (message.isEmpty()) {
            message = "Loading....";
        }
        countProgress++;
        pDialog = new Dialog(activity, R.style.full_screen_dialog);
        pDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        pDialog.setCancelable(isCancelable);
        pDialog.setCanceledOnTouchOutside(isCancelable);
        pDialog.setContentView(R.layout.dialog_loading);
        Window window = pDialog.getWindow();
        assert window != null;
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.BOTTOM;
        window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        window.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        window.setAttributes(wlp);
        ProgressBar progressBar = pDialog.findViewById(R.id.pb_loading);
        TextView txtTitle = pDialog.findViewById(R.id.txtTitle);
        txtTitle.setText(message);
        progressBar.incrementProgressBy(10);
        progressBar.setIndeterminate(true);
        if (!pDialog.isShowing()) {
            pDialog.show();
        }
    }

    public static void showProgressDialog(Context activity, String message, boolean isCancelable) {
        if (message.isEmpty()) {
            message = "Loading....";
        }
        countProgress++;
        pDialog = new Dialog(activity, R.style.full_screen_dialog);
        pDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        pDialog.setCancelable(isCancelable);
        pDialog.setCanceledOnTouchOutside(isCancelable);
        pDialog.setContentView(R.layout.dialog_loading);
        Window window = pDialog.getWindow();
        assert window != null;
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.BOTTOM;
        window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        window.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        window.setAttributes(wlp);
        ProgressBar progressBar = pDialog.findViewById(R.id.pb_loading);
        TextView txtTitle = pDialog.findViewById(R.id.txtTitle);
        txtTitle.setText(message);
        progressBar.incrementProgressBy(10);
        progressBar.setIndeterminate(true);
        if (!pDialog.isShowing()) {
            pDialog.show();
        }
    }


    public static void hideProgressDialog() {
        if (pDialog != null) {
            if (pDialog.isShowing()) {
                countProgress--;
                errorLog(TAG, "hideProgressDialog", String.valueOf(countProgress));
                pDialog.dismiss();
            }
        }
    }


    public static void errorLog(String TAG, String tag, String message) {
        Log.e("*" + TAG + "* " + tag, message);
    }


    public static void showMessage(String message, Context ctx) {
        final Dialog pDialog = new Dialog(ctx, R.style.full_screen_dialog);
        pDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        pDialog.setCancelable(true);
        pDialog.setCanceledOnTouchOutside(true);
        pDialog.setContentView(R.layout.dialog_validations);
        Window window = pDialog.getWindow();
        assert window != null;
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.BOTTOM;
        window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        window.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        window.setAttributes(wlp);
        ImageView imgClose = pDialog.findViewById(R.id.imgClose);
        TextView txtTitle = pDialog.findViewById(R.id.txtTitle);
        txtTitle.setText(message);

        if (!pDialog.isShowing()) {
            pDialog.show();
        }
        imgClose.setOnClickListener(v -> pDialog.dismiss());

    }
    public static void showSave(String message, Context ctx) {
        final Dialog pDialog = new Dialog(ctx, R.style.full_screen_dialog);
        pDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        pDialog.setCancelable(true);
        pDialog.setCanceledOnTouchOutside(true);
        pDialog.setContentView(R.layout.dialog_validations);
        Window window = pDialog.getWindow();
        assert window != null;
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.BOTTOM;
        window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        window.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        window.setAttributes(wlp);
        ImageView imgClose = pDialog.findViewById(R.id.imgClose);
        TextView txtTitle = pDialog.findViewById(R.id.txtTitle);
        txtTitle.setText(message);

        if (!pDialog.isShowing()) {
            pDialog.show();
        }
        imgClose.setOnClickListener(v ->
                pDialog.dismiss()


        );

    }

}