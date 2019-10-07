package com.example.ayatidevices;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.ayatidevices.adapter.HistoryAdapter;
import com.example.ayatidevices.pojo.HistoryPojo;

import java.util.ArrayList;
import java.util.Date;

public class HistoryActivity extends AppCompatActivity {
    Context context;
    private CardView card_view;
    TextView txtBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        context=HistoryActivity.this;
        card_view=findViewById(R.id.card_view);
        txtBack=findViewById(R.id.txtBack);

        HistoryPojo[] HistoryPojo = new HistoryPojo[] {
                new HistoryPojo("Chandu walke", "Date - 12/10/1990" ,R.drawable.certificate_icon),
                new HistoryPojo("Raj Walke", "Date - 08/01/1999" ,R.drawable.certificate_icon),
                new HistoryPojo("Arjun Patil","Date - 05/11/1992" , R.drawable.certificate_icon),
        };

        RecyclerView recyclerView = findViewById(R.id.listHistory);
        HistoryAdapter adapter = new HistoryAdapter(HistoryPojo);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        txtBack.setOnClickListener(v ->{
            onBackPressed();
        });

        card_view.setOnClickListener(v ->{
            dialogFilter();
        });

    }

    private void dialogFilter() {
        final Dialog dialog = new Dialog(context, R.style.full_screen_dialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(R.layout.dialog_history_filter);
        Window window = dialog.getWindow();
        assert window != null;
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.BOTTOM;
        window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        window.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        window.setAttributes(wlp);

        ImageView close=dialog.findViewById(R.id.close);
        close.setOnClickListener(v ->{
            dialog.dismiss();
        });


        dialog.show();
    }
}
