package com.example.ayatidevices;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.example.ayatidevices.utils.CustomJSONObjectRequest;
import com.example.ayatidevices.utils.CustomVolleyRequestQueue;
import com.example.ayatidevices.utils.GlobalVar;
import com.example.ayatidevices.utils.PreferenceUtils;
import com.example.ayatidevices.utils.VolleyErrorHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.Calendar;

public class RegistrationAcivity extends AppCompatActivity {

    Calendar today = Calendar.getInstance();
    Context context;
    private RequestQueue mQueue;
    PreferenceUtils preferenceUtils;
    String status = "Yes";
    String name,dob,number;

    private TextView txtRegister, txtYes, txtNo;
    private EditText edName, edNumber, edDob, edCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_acivity);

        context = RegistrationAcivity.this;
        preferenceUtils = new PreferenceUtils(context);
        mQueue = CustomVolleyRequestQueue.getInstance(getApplicationContext()).getRequestQueue();

        Intent intentExtra = getIntent();
        Bundle bundle = intentExtra.getExtras();
        name = bundle.getString("name");
        number = bundle.getString("number");
        dob = bundle.getString("dob");

        txtRegister = findViewById(R.id.txtRegister);
        txtNo = findViewById(R.id.txtNo);
        txtYes = findViewById(R.id.txtYes);
        edName = findViewById(R.id.edName);
        edNumber = findViewById(R.id.edNumber);
        edDob = findViewById(R.id.edDob);
        edCity = findViewById(R.id.edCity);

        txtYes.setOnClickListener(v -> {
            status = "Yes";
            txtYes.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.background_left) );
            txtNo.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.background_card) );
            txtYes.setTextColor(ContextCompat.getColor(context, R.color.white));
            txtNo.setTextColor(ContextCompat.getColor(context, R.color.colorPrimary));

        });

        txtNo.setOnClickListener(v -> {
            status = "No";
            txtNo.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.background_left) );
            txtYes.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.background_card) );
            txtNo.setTextColor(ContextCompat.getColor(context, R.color.white));
            txtYes.setTextColor(ContextCompat.getColor(context, R.color.colorPrimary));
        });

        edName.setText(name);
        edNumber.setText(number);
        edDob.setText(dob);

        txtRegister.setOnClickListener(v -> {
            if (edName.getText().toString().isEmpty()) {
                GlobalVar.showMessage("Enter your Name", context);
            } else if (edNumber.getText().toString().isEmpty()) {
                GlobalVar.showMessage("Enter mobile number", context);

            } else if (edNumber.getText().toString().length() <= 9) {
                GlobalVar.showMessage("Enter Correct mobile number", context);
            } else if (edDob.getText().toString().isEmpty()) {
                GlobalVar.showMessage("Select Date Of Birth", context);
            } else if (edCity.getText().toString().isEmpty()) {
                GlobalVar.showMessage("Enter City", context);
            } else if (status.isEmpty()) {
                GlobalVar.showMessage("Select Your Previous Hisory", context);
            } else {
                registerUser();
            }
        });


        edDob.setOnClickListener(view -> {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            assert imm != null;
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

            final DatePickerDialog dp = new DatePickerDialog(context, android.R.style.Theme_Holo_Light_Dialog, (view1, year, monthOfYear, dayOfMonth) -> {
                DecimalFormat formatter = new DecimalFormat("00");
                today.set(year, monthOfYear, dayOfMonth);
                long selectedTimeInMillis = today.getTimeInMillis();
                long systemTimeInMillis = Calendar.getInstance().getTimeInMillis();

                if (selectedTimeInMillis <= systemTimeInMillis) {
                    edDob.setText(year + "-" + formatter.format(monthOfYear + 1) + "-" + formatter.format(dayOfMonth));

                } else {
                    GlobalVar.showMessage("Cannot select future date", context);
                }

            }, today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH));
            dp.getDatePicker().setMaxDate(today.getTimeInMillis());
            dp.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));


            dp.show();

        });

    }

    private void registerUser() {
        GlobalVar.showProgressDialog(context, "Please Wait.....", false);
        JSONObject obj = new JSONObject();
        try {
            obj.put("FullName", edName.getText().toString().trim());
            obj.put("MobileNumber", edNumber.getText().toString().trim());
            obj.put("DateOfBirth", edDob.getText().toString().trim());
            obj.put("City", edCity.getText().toString().trim());
            obj.put("HistoryStatus", status);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        String url = GlobalVar.ServerAddress + "AyatiUsers";
        Log.e("url", url);
        Log.e("obj", obj.toString());

        final CustomJSONObjectRequest jsonRequest = new CustomJSONObjectRequest(Request.Method.POST, url, obj,
                response -> {
                    GlobalVar.hideProgressDialog();
                    Log.e("responce:", response.toString());
                    try {
                        String id = response.getString("Id");
                        if (id.equals("0")) {
                          GlobalVar.showMessage("Register not successfully",context);
                        } else {
                            preferenceUtils.setId(response.getString("Id"));
                            preferenceUtils.setUserName(response.getString("FullName"));
                            preferenceUtils.setCno(response.getString("MobileNumber"));
                            preferenceUtils.setDob(response.getString("DateOfBirth"));
                            preferenceUtils.setCity(response.getString("City"));
                            preferenceUtils.setStatus(response.getString("HistoryStatus"));


                            Intent intent = new Intent(context, HomeActivity.class);
                            intent.putExtra("activity", "fromreg");
                            startActivity(intent);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }, error -> {
            GlobalVar.hideProgressDialog();
            GlobalVar.showMessage(VolleyErrorHelper.getMessage(error, context), context);
        });
        jsonRequest.setTag("get");
        mQueue.add(jsonRequest);
    }


}
