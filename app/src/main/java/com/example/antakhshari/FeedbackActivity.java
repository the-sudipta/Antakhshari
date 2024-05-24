package com.example.antakhshari;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class FeedbackActivity extends AppCompatActivity {

    // ******************************************************** My Phone Properties ************************************************************************
    double MY_PHONE_HEIGHT = 640;
    double MY_PHONE_WIDTH = 360;
    double MY_PHONE_DP = 2.625;
    String message;
    public String UniqueID = getMacAddress();

    // *********************************************************** Object Declaration **********************************************************************
    Utility util = new Utility();

    // *********************************************************** App Component Declaration ***************************************************************
    TextView feedback_below_textView;
    EditText feedback_editTextTextMultiLine;
    Button send_button;
    Firebase firebase;
    TelephonyManager telephonyManager;

    // *****************************************************************************************************************************************************


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true); // This Will enable the Back Button
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO); // This Will Turn off the Night/Dark Mode

        // region USER DISPLAY DIMENSIONS
        // Get the display size of the device in which the app is running on
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getRealMetrics(metrics);

        double USER_height = metrics.heightPixels ; // Getting the Height of the screen
        double USER_width = metrics.widthPixels; // Getting the Width of the screen
        double USER_dp = metrics.scaledDensity; // Getting the Density of the screen
        // endregion USER DISPLAY DIMENSIONS





        // region TextView

        /**
         *  TextView
         **/
        // feedback_below_textView
        feedback_below_textView = findViewById(R.id.feedback_below_textView);
        feedback_below_textView.getLayoutParams().height = (int) util.calculateDimension(40,MY_PHONE_HEIGHT,(int) USER_height);
        feedback_below_textView.getLayoutParams().width = (int) util.calculateDimension(144,MY_PHONE_WIDTH,(int) USER_width);
        feedback_below_textView.setTextSize((int) util.calculateTextSize(USER_height,25,MY_PHONE_HEIGHT,USER_dp));

        // endregion TextView

        // region EditText

        /**
         *  EditText
         **/
        // feedback_editTextTextMultiLine
        feedback_editTextTextMultiLine = findViewById(R.id.feedback_editTextTextMultiLine);
        feedback_editTextTextMultiLine.getLayoutParams().height = (int) util.calculateDimension(298,MY_PHONE_HEIGHT,(int) USER_height);
        feedback_editTextTextMultiLine.getLayoutParams().width = (int) util.calculateDimension(338,MY_PHONE_WIDTH,(int) USER_width);
        feedback_editTextTextMultiLine.setTextSize((int) util.calculateTextSize(USER_height,22,MY_PHONE_HEIGHT,USER_dp));

        // endregion EditText

        // region Firebase

        /**
         *  Firebase
         */


        Firebase.setAndroidContext(this);
        firebase = new Firebase("https://antakhshari-default-rtdb.asia-southeast1.firebasedatabase.app/User_ID = "+UniqueID);

        // endregion Firebase




        // region Button

        /**
         *  Button
         **/
        // send_button
        send_button = findViewById(R.id.send_button);
        send_button.getLayoutParams().height = (int) util.calculateDimension(73,MY_PHONE_HEIGHT,(int) USER_height);
        send_button.getLayoutParams().width = (int) util.calculateDimension(216,MY_PHONE_WIDTH,(int) USER_width);
        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final String feedback_message = feedback_editTextTextMultiLine.getText().toString();

                Firebase child_name = firebase.child("Message");
                child_name.setValue(feedback_message);
                if(feedback_message.isEmpty()){
                    feedback_editTextTextMultiLine.setError("This field is required!");
                    send_button.setEnabled(false);
                }else{
                    feedback_editTextTextMultiLine.setError(null);
                    send_button.setEnabled(true);
                }
                feedback_editTextTextMultiLine.setText("");
                Toast.makeText(getBaseContext(), "Feedback has been sent", Toast.LENGTH_SHORT).show();

            }
        });

        // endregion Button





    }

    //region Mac Address

    /**
     *  MAC ADDRESS
     * @return Mac Address
     */
    public String getMacAddress(){
        try {
            List<NetworkInterface> networkInterfaceList = Collections.list(NetworkInterface.getNetworkInterfaces());
            String stringMac = "";
            for (NetworkInterface networkInterface : networkInterfaceList){
                if(networkInterface.getName().equalsIgnoreCase("wlon0"));{
                    for (int i = 0;i<networkInterface.getHardwareAddress().length;i++){
                        String stringMacByte = Integer.toHexString(networkInterface.getHardwareAddress()[i& 0xFF]);

                        if(stringMacByte.length() == 1){
                            stringMacByte = "0"+stringMacByte;
                        }
                        stringMac = stringMac+stringMacByte.toUpperCase()+":";
                    }
                    break;
                }
            }
            return stringMac;
        }catch (SocketException e){
            e.printStackTrace();
        }
        return "0";
    }

    //endregion Mac Address




}