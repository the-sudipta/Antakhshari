package com.example.antakhshari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // ******************************************************** My Phone Properties ************************************************************************
    double MY_PHONE_HEIGHT = 640;
    double MY_PHONE_WIDTH = 360;
    double MY_PHONE_DP = 2.625;
    String[] team = new String[2];

    // *********************************************************** Object Declaration **********************************************************************
    Utility util = new Utility();

    // *********************************************************** App Component Declaration ***************************************************************
    TextView team_A_name_textView, team_B_name_textView,feedback_textView;
    EditText teamName_A_editTextTextPersonName, teamName_B_editTextTextPersonName;
    ImageView feedback_imageButton,next_imageButton;

    // *****************************************************************************************************************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // region USER DISPLAY DIMENSIONS
        // Get the display size of the device in which the app is running on
        Display display = getWindowManager().getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getRealMetrics(metrics);

        double USER_height = metrics.heightPixels ; // Getting the Height of the screen
        double USER_width = metrics.widthPixels; // Getting the Width of the screen
        double USER_dp = metrics.scaledDensity; // Getting the Density of the screen
        // endregion USER DISPLAY DIMENSIONS

        // region  TextView

        /**
         *  TextView
         **/
        // team_A_name_textView
        team_A_name_textView = findViewById(R.id.team_A_name_textView);
        team_A_name_textView.getLayoutParams().height = (int) util.calculateDimension(27,MY_PHONE_HEIGHT,(int) USER_height);
        team_A_name_textView.getLayoutParams().width = (int) util.calculateDimension(126,MY_PHONE_WIDTH,(int) USER_width);
        team_A_name_textView.setTextSize((int) util.calculateTextSize(USER_height,16,MY_PHONE_HEIGHT,USER_dp));

        // team_B_name_textView
        team_B_name_textView = findViewById(R.id.team_B_name_textView);
        team_B_name_textView.getLayoutParams().height = (int) util.calculateDimension(27,MY_PHONE_HEIGHT,(int) USER_height);
        team_B_name_textView.getLayoutParams().width = (int) util.calculateDimension(126,MY_PHONE_WIDTH,(int) USER_width);
        team_B_name_textView.setTextSize((int) util.calculateTextSize(USER_height,16,MY_PHONE_HEIGHT,USER_dp));

        // feedback_textView
        feedback_textView =findViewById(R.id.feedback_textView);
        feedback_textView.getLayoutParams().height = (int) util.calculateDimension(18,MY_PHONE_HEIGHT,(int) USER_height);
        feedback_textView.getLayoutParams().width = (int) util.calculateDimension(75,MY_PHONE_WIDTH,(int) USER_width);
        feedback_textView.setTextSize((int) util.calculateTextSize(USER_height,14,MY_PHONE_HEIGHT,USER_dp));

        // endregion  TextView

        // region  EditText

        /**
         *  EditText
         **/
        //teamName_A_editTextTextPersonName
        teamName_A_editTextTextPersonName = findViewById(R.id.teamName_A_editTextTextPersonName);
        teamName_A_editTextTextPersonName.getLayoutParams().height = (int) util.calculateDimension(45,MY_PHONE_HEIGHT,(int) USER_height);
        teamName_A_editTextTextPersonName.getLayoutParams().width = (int) util.calculateDimension(158,MY_PHONE_WIDTH,(int) USER_width);
        teamName_A_editTextTextPersonName.setTextSize((int) util.calculateTextSize(USER_height,18,MY_PHONE_HEIGHT,USER_dp));

        //teamName_B_editTextTextPersonName
        teamName_B_editTextTextPersonName = findViewById(R.id.teamName_B_editTextTextPersonName);
        teamName_B_editTextTextPersonName.getLayoutParams().height = (int) util.calculateDimension(45,MY_PHONE_HEIGHT,(int) USER_height);
        teamName_B_editTextTextPersonName.getLayoutParams().width = (int) util.calculateDimension(158,MY_PHONE_WIDTH,(int) USER_width);
        teamName_B_editTextTextPersonName.setTextSize((int) util.calculateTextSize(USER_height,18,MY_PHONE_HEIGHT,USER_dp));

        // endregion  EditText


        // region ImageButton

        /**
         *  ImageButton
         **/
        //feedback_imageButton
        feedback_imageButton = findViewById(R.id.feedback_imageButton);
        feedback_imageButton.getLayoutParams().height = (int) util.calculateDimension(50,MY_PHONE_HEIGHT,(int) USER_height);
        feedback_imageButton.getLayoutParams().width = (int) util.calculateDimension(50,MY_PHONE_WIDTH,(int) USER_width);
        feedback_imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,FeedbackActivity.class));
                //Toast.makeText(getBaseContext(), "Clicked", Toast.LENGTH_SHORT).show();
            }
        });


        //next_imageButton
        next_imageButton = findViewById(R.id.next_imageButton);
        next_imageButton.getLayoutParams().height = (int) util.calculateDimension(76,MY_PHONE_HEIGHT,(int) USER_height);
        next_imageButton.getLayoutParams().width = (int) util.calculateDimension(76,MY_PHONE_WIDTH,(int) USER_width);
        next_imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                team[0] = teamName_A_editTextTextPersonName.getText().toString();
                team[1] = teamName_B_editTextTextPersonName.getText().toString();
                // region Send Data to PlayBoardActivity
                Intent intent  = (new Intent(MainActivity.this,PlayBoardActivity.class));
                intent.putExtra("team_A_name",team[0]);
                intent.putExtra("team_B_name",team[1]);
                startActivity(intent);
                // endregion Send Data to PlayBoardActivity
                //Toast.makeText(getBaseContext(), "Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // endregion ImageButton



    }









}