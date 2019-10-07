package com.example.ayatidevices;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.balysv.materialripple.MaterialRippleLayout;

public class TestReportsActivity extends AppCompatActivity {
    private TextView txtAll, txtLeft, txtRight, txtShare,txtNEw,txtNoData;
    Context context;
    ImageView imgback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_reports);

        context = this;

        imgback = findViewById(R.id.imgback);
        txtNEw = findViewById(R.id.txtNEw);
        txtAll = findViewById(R.id.txtAll);
        txtShare = findViewById(R.id.txtShare);
        txtLeft = findViewById(R.id.txtLeft);
        txtRight = findViewById(R.id.txtRight);
        txtNoData = findViewById(R.id.txtNoData);


        LinearLayout layoutName=findViewById(R.id.layoutName);
        MaterialRippleLayout materialLayout=findViewById(R.id.materialLayout);
        CardView card_view_position=findViewById(R.id.card_view_position);
        CardView card_view_graph=findViewById(R.id.card_view_graph);
        CardView card_view_position1=findViewById(R.id.card_view_position1);
        CardView card_view_graph1=findViewById(R.id.card_view_graph1);

        imgback.setOnClickListener(v -> {
            onBackPressed();
        });
        txtNEw.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });

        txtAll.setOnClickListener(v -> {
            txtAll.setText(R.string.all);
            txtLeft.setText("Left");
            txtRight.setText("Right");

            txtAll.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));
            txtLeft.setTextColor(ContextCompat.getColor(context, R.color.black));
            txtRight.setTextColor(ContextCompat.getColor(context, R.color.black));

            layoutName.setVisibility(View.VISIBLE);
            card_view_position.setVisibility(View.VISIBLE);
            card_view_graph.setVisibility(View.VISIBLE);
            card_view_position1.setVisibility(View.VISIBLE);
            card_view_graph1.setVisibility(View.VISIBLE);
            materialLayout.setVisibility(View.VISIBLE);
            txtNoData.setVisibility(View.GONE);

        });

        txtLeft.setOnClickListener(v -> {
            txtLeft.setText(R.string.left);
            txtRight.setText("Right");
            txtAll.setText("All");

            txtAll.setTextColor(ContextCompat.getColor(context, R.color.black));
            txtLeft.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));
            txtRight.setTextColor(ContextCompat.getColor(context, R.color.black));

            layoutName.setVisibility(View.VISIBLE);
            card_view_position.setVisibility(View.VISIBLE);
            card_view_graph.setVisibility(View.VISIBLE);
            card_view_position1.setVisibility(View.VISIBLE);
            card_view_graph1.setVisibility(View.VISIBLE);
            materialLayout.setVisibility(View.VISIBLE);
            txtNoData.setVisibility(View.GONE);
        });

        txtRight.setOnClickListener(v -> {
            txtRight.setText(R.string.right);
            txtLeft.setText("Left");
            txtAll.setText("All");

            txtAll.setTextColor(ContextCompat.getColor(context, R.color.black));
            txtLeft.setTextColor(ContextCompat.getColor(context, R.color.black));
            txtRight.setTextColor(ContextCompat.getColor(context, R.color.colorAccent));

            layoutName.setVisibility(View.GONE);
            card_view_position.setVisibility(View.GONE);
            card_view_graph.setVisibility(View.GONE);
            card_view_position1.setVisibility(View.GONE);
            card_view_graph1.setVisibility(View.GONE);
            materialLayout.setVisibility(View.GONE);

            txtNoData.setVisibility(View.VISIBLE);
        });
    }
}
