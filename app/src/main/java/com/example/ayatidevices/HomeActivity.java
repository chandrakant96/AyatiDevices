package com.example.ayatidevices;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ayatidevices.adapter.MyAdapter;
import com.example.ayatidevices.utils.GlobalVar;
import com.example.ayatidevices.utils.PreferenceUtils;
import com.felhr.usbserial.UsbSerialDevice;
import com.felhr.usbserial.UsbSerialInterface;
import com.ftdi.j2xx.D2xxManager;
import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class HomeActivity extends AppCompatActivity {

    private Context context;
    private TextView txtName, txtLeftLeg, txtRightLeg, txtHistory;
    private ImageView imgNotification;
    PreferenceUtils preferenceUtils;
    String activityType;
    String legType;
    String posiion = "Position 1";

    private static ViewPager mPager;
    private static final Integer[] XMEN = {R.drawable.left_position_1, R.drawable.left_position_3, R.drawable.left_position_4, R.drawable.left_position_5, R.drawable.left_position_6};
    private static final Integer[] XMENone = {R.drawable.right_position_1, R.drawable.right_position_3, R.drawable.right_position_4, R.drawable.right_position_5, R.drawable.right_position_6};
    private ArrayList<Integer> XMENArray = new ArrayList<>();
    private ArrayList<Integer> XMENArrayone = new ArrayList<>();

    File imageFile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        PermissionListener permissionlistener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
            }

            @Override
            public void onPermissionDenied(ArrayList<String> deniedPermissions) {
                Toast.makeText(context, "Permission Denied\n" + deniedPermissions.toString(), Toast.LENGTH_SHORT).show();
            }
        };

        new TedPermission(HomeActivity.this)
                .setPermissionListener(permissionlistener)
                .setDeniedMessage("If you reject permission,you can not use this service\n\nPlease turn on permissions at [Setting] > [Permission]")
                .setPermissions(Manifest.permission.READ_PHONE_STATE)
                .setPermissions(Manifest.permission.READ_EXTERNAL_STORAGE)
                .setPermissions(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                .check();
        context = HomeActivity.this;
        preferenceUtils = new PreferenceUtils(context);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            activityType = bundle.getString("activity");
        }

        txtHistory = findViewById(R.id.txtHistory);
        txtLeftLeg = findViewById(R.id.txtLeftLeg);
        txtRightLeg = findViewById(R.id.txtRightLeg);
        txtName = findViewById(R.id.txtName);
        RelativeLayout vie = findViewById(R.id.layoutmain);


        if (activityType.equals("fromlogin")) {
            txtName.setText("Hi" + "\t" + preferenceUtils.getUserName() + "," + "\n" + "Welcome back");
            txtHistory.setText("VIEW HISTORY");

            txtHistory.setOnClickListener(v -> {

                startActivity(new Intent(context, HistoryActivity.class));


            });

        } else {
            txtName.setText("Hi" + "\t" + preferenceUtils.getUserName() + "," + "\n" + "Welcome");
            txtHistory.setText("NOT HISTORY YET");
        }


        txtLeftLeg.setOnClickListener(v -> {
            legType = "Left";
            dialogLeftLeg();
        });

        txtRightLeg.setOnClickListener(v -> {
            legType = "Right";
            dialogRightLeg();
        });


    }

    private void dialogLeftLeg() {
        final Dialog dialog = new Dialog(context, R.style.full_screen_dialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(R.layout.dialog_left_leg);
        Window window = dialog.getWindow();
        assert window != null;
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.BOTTOM;
        window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        window.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        window.setAttributes(wlp);

        ImageView close = dialog.findViewById(R.id.close);
        TextView txtName1 = dialog.findViewById(R.id.txtName);
        TextView txtPostion = dialog.findViewById(R.id.txtPostion);
        TextView txtStart = dialog.findViewById(R.id.txtStart);
        TextView txtViewHistory = dialog.findViewById(R.id.txtViewHistory);
        TextView txtPotionString = dialog.findViewById(R.id.txtPotionString);

        txtName1.setText(preferenceUtils.getUserName());
        txtPostion.setText("Left");


        close.setOnClickListener(v -> {
            dialog.dismiss();
            XMENArray.clear();
        });


        txtStart.setOnClickListener(v -> {
            dialog.dismiss();
            Intent intent = new Intent(context, ReportActivity.class);
            intent.putExtra("legType", legType);
            intent.putExtra("legposition", posiion);
            startActivity(intent);

        });


        txtViewHistory.setOnClickListener(v -> {
            startActivity(new Intent(context, HistoryActivity.class));

        });


        for (int i = 0; i < XMEN.length; i++) {
            XMENArray.add(XMEN[i]);
        }

        mPager = dialog.findViewById(R.id.pager);
        mPager.setAdapter(new MyAdapter(context, XMENArray));
        CircleIndicator indicator = dialog.findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {

                if (position == 0) {
                    posiion = "Position 1";
                    txtPotionString.setText(posiion);
                } else if (position == 1) {
                    posiion = "Position 2";
                    txtPotionString.setText(posiion);
                } else if (position == 2) {
                    posiion = "Position 3";
                    txtPotionString.setText(posiion);
                } else if (position == 3) {
                    posiion = "Position 4";
                    txtPotionString.setText(posiion);
                } else {
                    posiion = "Position 5";
                    txtPotionString.setText(posiion);
                }
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        dialog.show();
    }

    private void dialogRightLeg() {
        final Dialog dialog = new Dialog(context, R.style.full_screen_dialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(R.layout.dialog_right_leg);
        Window window = dialog.getWindow();
        assert window != null;
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.BOTTOM;
        window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        window.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        window.setAttributes(wlp);

        ImageView close = dialog.findViewById(R.id.close);
        TextView txtName1 = dialog.findViewById(R.id.txtName);
        TextView txtPostion = dialog.findViewById(R.id.txtPostion);
        TextView txtStart = dialog.findViewById(R.id.txtStart);
        TextView txtViewHistory = dialog.findViewById(R.id.txtViewHistory);
        TextView txtPotionString = dialog.findViewById(R.id.txtPotionString);

        txtName1.setText(preferenceUtils.getUserName());
        txtPostion.setText("Right");


        close.setOnClickListener(v -> {
            dialog.dismiss();
            XMENArray.clear();
        });


        txtStart.setOnClickListener(v -> {
            dialog.dismiss();
            Intent intent = new Intent(context, ReportActivity.class);
            intent.putExtra("legType", legType);
            intent.putExtra("legposition", posiion);
            startActivity(intent);

        });


        txtViewHistory.setOnClickListener(v -> {
            startActivity(new Intent(context, HistoryActivity.class));

        });


        for (int i = 0; i < XMENone.length; i++) {
            XMENArrayone.add(XMENone[i]);
        }

        mPager = dialog.findViewById(R.id.pager);
        mPager.setAdapter(new MyAdapter(context, XMENArrayone));
        CircleIndicator indicator = dialog.findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {

                if (position == 0) {
                    posiion = "Position 1";
                    txtPotionString.setText(posiion);
                } else if (position == 1) {
                    posiion = "Position 2";
                    txtPotionString.setText(posiion);
                } else if (position == 2) {
                    posiion = "Position 3";
                    txtPotionString.setText(posiion);
                } else if (position == 3) {
                    posiion = "Position 4";
                    txtPotionString.setText(posiion);
                } else {
                    posiion = "Position 5";
                    txtPotionString.setText(posiion);
                }
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        dialog.show();
    }

//    private void takeScreenshot() {
//        Date now = new Date();
//        android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", now);
//
//        try {
//            String mPath = Environment.getExternalStorageDirectory().toString() + "/" + now + ".jpg";
//
//            //LinearLayout layoytmain=findViewById(R.id.layoytmain);
//
//            View v1 = getWindow().getDecorView().getRootView();
//            v1.setDrawingCacheEnabled(true);
//            Bitmap bitmap = Bitmap.createBitmap(v1.getDrawingCache());
//            v1.setDrawingCacheEnabled(false);
//
//            imageFile = new File(mPath);
//
//            FileOutputStream outputStream = new FileOutputStream(imageFile);
//            int quality = 100;
//            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);
//            outputStream.flush();
//            outputStream.close();
//
//            File imgFile = new  File(mPath);
//            if(imgFile.exists()){
//
//                Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
//
//                Intent share1 = new Intent(Intent.ACTION_SEND);
//                share1.setType("image/jpeg");
//                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
//                myBitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
//                String path = MediaStore.Images.Media.insertImage(getContentResolver(),
//                        myBitmap, "Title", null);
//                Uri imageUri1 = Uri.parse(path);
//                share1.putExtra(Intent.EXTRA_STREAM, imageUri1);
//                startActivity(Intent.createChooser(share1, "Share Image using"));
//            };
//        } catch (Throwable e) {
//            // Several error may come out with file handling or DOM
//            e.printStackTrace();
//        }
//    }

}