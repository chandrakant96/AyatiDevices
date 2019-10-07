package com.example.ayatidevices.usbconnection;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.provider.MediaStore;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.ayatidevices.BuildConfig;
import com.example.ayatidevices.HomeActivity;
import com.example.ayatidevices.R;
import com.example.ayatidevices.TestReportsActivity;
import com.example.ayatidevices.utils.GlobalVar;
import com.example.ayatidevices.utils.PreferenceUtils;
import com.hoho.android.usbserial.driver.UsbSerialDriver;
import com.hoho.android.usbserial.driver.UsbSerialPort;
import com.hoho.android.usbserial.driver.UsbSerialProber;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.view.LineChartView;

import static com.example.ayatidevices.ReportActivity.legType;
import static com.example.ayatidevices.ReportActivity.posiion;

public class TerminalFragment extends Fragment implements ServiceConnection, SerialListener {

    private enum Connected {False, Pending, True}

    public static final String INTENT_ACTION_GRANT_USB = BuildConfig.APPLICATION_ID + ".GRANT_USB";

    private int deviceId, portNum, baudRate;
    private String newline = "\r\n";

    private TextView receiveText, txtData;

    private SerialSocket socket;
    private SerialService service;
    private boolean initialStart = true;
    private Connected connected = Connected.False;
    private BroadcastReceiver broadcastReceiver;

    public TerminalFragment() {
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals(INTENT_ACTION_GRANT_USB)) {
                    Boolean granted = intent.getBooleanExtra(UsbManager.EXTRA_PERMISSION_GRANTED, false);
                    connect(granted);
                }
            }
        };

    }

    int[] h = new int[500];
    int receivecount = 0;

    List<String> data_d_list, data_f_list;
    LineChartView lineChartView;

    ImageView imgback, imgposition;
    CardView card_view, graphCard;
    LinearLayout layoutbottom;
    TextView txtRecheck, txtSave, txtPostion,txtName,txtLeg;
    String legType1;
    File imageFile;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        setRetainInstance(true);
        deviceId = getArguments().getInt("device");
        portNum = getArguments().getInt("port");
        baudRate = getArguments().getInt("baud");

    }

    @Override
    public void onDestroy() {
        if (connected != Connected.False)
            disconnect();
        getActivity().stopService(new Intent(getActivity(), SerialService.class));
        super.onDestroy();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (service != null)
            service.attach(this);
        else
            getActivity().startService(new Intent(getActivity(), SerialService.class)); // prevents service destroy on unbind from recreated activity caused by orientation change
    }

    @Override
    public void onStop() {
        if (service != null && !getActivity().isChangingConfigurations())
            service.detach();
        super.onStop();
    }

    @SuppressWarnings("deprecation")
    // onAttach(context) was added with API 23. onAttach(activity) works for all API versions
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        getActivity().bindService(new Intent(getActivity(), SerialService.class), this, Context.BIND_AUTO_CREATE);
    }

    @Override
    public void onDetach() {
        try {
            getActivity().unbindService(this);
        } catch (Exception ignored) {
        }
        super.onDetach();
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity().registerReceiver(broadcastReceiver, new IntentFilter(INTENT_ACTION_GRANT_USB));
        if (initialStart && service != null) {
            initialStart = false;
            getActivity().runOnUiThread(this::connect);
        }
    }

    @Override
    public void onPause() {
        getActivity().unregisterReceiver(broadcastReceiver);
        super.onPause();
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder binder) {
        service = ((SerialService.SerialBinder) binder).getService();
        if (initialStart && isResumed()) {
            initialStart = false;
            getActivity().runOnUiThread(this::connect);

            send();
        }
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        service = null;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_terminal, container, false);
        receiveText = view.findViewById(R.id.receive_text);                          // TextView performance decreases with number of spans
        txtData = view.findViewById(R.id.txtData);                          // TextView performance decreases with number of spans
        receiveText.setTextColor(getResources().getColor(R.color.colorRecieveText)); // set as default color to reduce number of spans
        receiveText.setMovementMethod(ScrollingMovementMethod.getInstance());

        imgback = view.findViewById(R.id.imgback);
        lineChartView = view.findViewById(R.id.lineChart);
        card_view = view.findViewById(R.id.card_view);
        graphCard = view.findViewById(R.id.graphCard);
        layoutbottom = view.findViewById(R.id.layoutbottom);
        txtRecheck = view.findViewById(R.id.txtRecheck);
        txtSave = view.findViewById(R.id.txtSave);
        txtPostion = view.findViewById(R.id.txtPostion);
        imgposition = view.findViewById(R.id.imgposition);
        txtLeg = view.findViewById(R.id.txtLeg);
        txtName = view.findViewById(R.id.txtName);

        PreferenceUtils preferenceUtils=new PreferenceUtils(getActivity());
        txtPostion.setText(posiion);
        legType1 = legType;
        txtName.setText(preferenceUtils.getUserName());
        txtLeg.setText(legType1);

        imgback.setOnClickListener(v ->{
            getActivity().onBackPressed();
        });
        txtSave.setOnClickListener(v -> {
            dialogTest();
        });

        txtRecheck.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), HomeActivity.class);
            intent.putExtra("activity", "fromlogin");
            startActivity(intent);
        });

        if (posiion.equals("Position 1") && legType1.equals("Left")) {
            imgposition.setImageResource(R.drawable.left_position_1_small);
        } else if (posiion.equals("Position 2") && legType1.equals("Left")) {
            imgposition.setImageResource(R.drawable.left_position_3_small);
        } else if (posiion.equals("Position 3") && legType1.equals("Left")) {
            imgposition.setImageResource(R.drawable.left_position_4_small);
        } else if (posiion.equals("Position 4") && legType1.equals("Left")) {
            imgposition.setImageResource(R.drawable.left_position_5_small);
        } else if (posiion.equals("Position 5") && legType1.equals("Left")) {
            imgposition.setImageResource(R.drawable.left_position_6_small);
        } else if (posiion.equals("Position 1") && legType1.equals("Right")) {
            imgposition.setImageResource(R.drawable.right_position_1_small);
        } else if (posiion.equals("Position 2") && legType1.equals("Right")) {
            imgposition.setImageResource(R.drawable.right_position_3_small);
        } else if (posiion.equals("Position 3") && legType1.equals("Right")) {
            imgposition.setImageResource(R.drawable.right_position_4_small);
        } else if (posiion.equals("Position 4") && legType1.equals("Right")) {
            imgposition.setImageResource(R.drawable.right_position_5_small);
        } else if (posiion.equals("Position 5") && legType1.equals("Right")) {
            imgposition.setImageResource(R.drawable.right_position_6_small);
        }


        return view;
    }

    private void connect() {
        connect(null);
    }

    private void connect(Boolean permissionGranted) {
        UsbDevice device = null;
        UsbManager usbManager = (UsbManager) getActivity().getSystemService(Context.USB_SERVICE);
        for (UsbDevice v : usbManager.getDeviceList().values())
            if (v.getDeviceId() == deviceId)
                device = v;
        if (device == null) {
            status("connection failed: device not found");
            return;
        }
        UsbSerialDriver driver = UsbSerialProber.getDefaultProber().probeDevice(device);
        if (driver == null) {
            driver = CustomProber.getCustomProber().probeDevice(device);
        }
        if (driver == null) {
            status("connection failed: no driver for device");
            return;
        }
        if (driver.getPorts().size() < portNum) {
            status("connection failed: not enough ports at device");
            return;
        }
        UsbSerialPort usbSerialPort = driver.getPorts().get(portNum);
        UsbDeviceConnection usbConnection = usbManager.openDevice(driver.getDevice());
        if (usbConnection == null && permissionGranted == null && !usbManager.hasPermission(driver.getDevice())) {
            PendingIntent usbPermissionIntent = PendingIntent.getBroadcast(getActivity(), 0, new Intent(INTENT_ACTION_GRANT_USB), 0);
            usbManager.requestPermission(driver.getDevice(), usbPermissionIntent);
            return;
        }
        if (usbConnection == null) {
            if (!usbManager.hasPermission(driver.getDevice()))
                status("connection failed: permission denied");
            else
                status("connection failed: open failed");
            return;
        }

        connected = Connected.Pending;
        try {
            socket = new SerialSocket();
            service.connect(this, "Connected");
            socket.connect(getContext(), service, usbConnection, usbSerialPort, baudRate);
            onSerialConnect();
        } catch (Exception e) {
            onSerialConnectError(e);
        }
    }

    private void disconnect() {
        connected = Connected.False;
        service.disconnect();
        socket.disconnect();
        socket = null;
    }

    private void send() {
        GlobalVar.showProgressDialog(getActivity(), "Please Wait,.....", false);
        if (connected != Connected.True) {
            Toast.makeText(getActivity(), "not connected", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            SpannableStringBuilder spn = new SpannableStringBuilder("T" + '\n');
            spn.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorSendText)), 0, spn.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            receiveText.append(spn);
            byte[] data = ("T" + newline).getBytes();
            socket.write(data);

        } catch (Exception e) {
            onSerialIoError(e);
        }
    }

    private void receive(byte[] data) {
        receiveText.append(new String(data));

        for (int j = 0; j < data.length; j++) {
            h[receivecount] = data[j];
            receivecount++;
        }


        char[] decimalArray = "0123456789".toCharArray();
        char[] decimalChars = new char[h.length * 4];
        for (int j = 0; j < h.length; j++) {
            int v = h[j] & 0xFF;
            decimalChars[j * 4] = decimalArray[v / 100];
            decimalChars[j * 4 + 1] = decimalArray[(v / 10) % 10];
            decimalChars[j * 4 + 2] = decimalArray[v % 10];
            decimalChars[j * 4 + 3] = ' ';

        }
        String[] separated = String.valueOf(decimalChars).split("\\s+" + "102" + "\\s+" + "010");
        String a = separated[0];
        String b = separated[1];
        //receivecount = 0;

        String force = (String) a.subSequence(0, a.length() / 2);
        String discforce = (String) a.subSequence((a.length() / 2) + 1, a.length());
        txtData.setText(a + "\n\n" + force + "\n\n" + discforce);
        //txtData.setText(String.valueOf(decimalChars));

        String replace = discforce.replace("[", "");
        String replace1 = replace.replace("]", "");
        data_d_list = new ArrayList<>(Arrays.asList(replace1.split("\\s")));


        String replace2 = force.replace("[", "");
        String replace3 = replace2.replace("]", "");
        data_f_list = new ArrayList<>(Arrays.asList(replace3.split("\\s")));

        GlobalVar.hideProgressDialog();
        graphCard.setVisibility(View.VISIBLE);
        setupGraph();
    }

    private void status(String str) {
        SpannableStringBuilder spn = new SpannableStringBuilder(str + '\n');
        spn.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.colorStatusText)), 0, spn.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        receiveText.append(spn);
    }

    @Override
    public void onSerialConnect() {
        status("connected");
        connected = Connected.True;
    }

    @Override
    public void onSerialConnectError(Exception e) {
        status("connection failed: " + e.getMessage());
        disconnect();
    }

    @Override
    public void onSerialRead(byte[] data) {
        receive(data);


    }

    @Override
    public void onSerialIoError(Exception e) {
        status("connection lost: " + e.getMessage());
        disconnect();
    }

    private void setupGraph() {

        try {

            PointValue pointValue_temp;

            ArrayList<PointValue> values = new ArrayList<PointValue>();

            for (int i = 0; i < data_d_list.size(); i++) {
                pointValue_temp = new PointValue(Float.parseFloat(data_d_list.get(i)), Float.parseFloat(data_f_list.get(i)));
                values.add(pointValue_temp);
            }


            Line line = new Line(values).setColor(ContextCompat.getColor(getActivity(), R.color.colorPrimaryDark));
            ArrayList<Line> lines = new ArrayList<Line>();
            lines.add(line);
            line.setPointRadius(0);
            line.setStrokeWidth(2);


            LineChartData data = new LineChartData();
            data.setLines(lines);

            Axis x = new Axis();
            x.setName("D val");
            x.setHasLines(true);
            x.setLineColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));
            x.setTextColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));
            data.setAxisXBottom(x);


            Axis y = new Axis();
            y.setName("F val");
            y.setHasLines(true);
            y.setLineColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));
            y.setTextColor(ContextCompat.getColor(getActivity(), R.color.colorPrimary));
            data.setAxisYLeft(y);

            lineChartView.setLineChartData(data);
            layoutbottom.setVisibility(View.VISIBLE);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void dialogTest() {
        final Dialog dialog = new Dialog(getActivity(), R.style.full_screen_dialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setContentView(R.layout.dialog_save);
        Window window = dialog.getWindow();
        assert window != null;
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.gravity = Gravity.BOTTOM;
        window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        window.setLayout(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        window.setAttributes(wlp);

        ImageView close = dialog.findViewById(R.id.imgClose);
        close.setOnClickListener(v -> {
            dialog.dismiss();
        });

        TextView txtTitle = dialog.findViewById(R.id.txtTitle);

        txtTitle.setText("Sucessfully Saved");

        dialog.show();
    }

    private void takeScreenshot() {
        Date now = new Date();
        android.text.format.DateFormat.format("yyyy-MM-dd_hh:mm:ss", now);

        try {
            String mPath = Environment.getExternalStorageDirectory().toString() + "/" + now + ".jpg";

            //LinearLayout layoytmain=view.findViewById(R.id.layoytmain);

            View v1 = getActivity().getWindow().getDecorView().getRootView();
            v1.setDrawingCacheEnabled(true);
            Bitmap bitmap = Bitmap.createBitmap(v1.getDrawingCache());
            v1.setDrawingCacheEnabled(false);

            imageFile = new File(mPath);

            FileOutputStream outputStream = new FileOutputStream(imageFile);
            int quality = 100;
            bitmap.compress(Bitmap.CompressFormat.JPEG, quality, outputStream);
            outputStream.flush();
            outputStream.close();

            File imgFile = new  File(mPath);
            if(imgFile.exists()){

                Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

                Intent share1 = new Intent(Intent.ACTION_SEND);
                share1.setType("image/jpeg");
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                myBitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                String path = MediaStore.Images.Media.insertImage(getActivity().getContentResolver(), myBitmap, "Title", null);
                Uri imageUri1 = Uri.parse(path);
                share1.putExtra(Intent.EXTRA_STREAM, imageUri1);
                startActivity(Intent.createChooser(share1, "Share Image using"));
            };
        } catch (Throwable e) {
            // Several error may come out with file handling or DOM
            e.printStackTrace();
        }
    }


}
