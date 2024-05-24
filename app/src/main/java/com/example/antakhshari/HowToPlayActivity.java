package com.example.antakhshari;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.widget.ScrollView;
import android.widget.TextView;

public class HowToPlayActivity extends AppCompatActivity {

    // ******************************************************** My Phone Properties ************************************************************************
    double MY_PHONE_HEIGHT = 640;
    double MY_PHONE_WIDTH = 360;
    double MY_PHONE_DP = 2.625;

    // *********************************************************** Object Declaration **********************************************************************
    Utility util = new Utility();

    // *********************************************************** App Component Declaration ***************************************************************
    ScrollView game_instructions_scrollview;
    TextView game_instructions_textView;
    // *****************************************************************************************************************************************************

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_play);
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


        // region ScrollView

        /**
         *  ScrollView
         */
        // game_instructions_scrollview
        game_instructions_scrollview = findViewById(R.id.game_instructions_scrollview);
        game_instructions_scrollview.getLayoutParams().height = (int) util.calculateDimension(515,MY_PHONE_HEIGHT,(int) USER_height);
        game_instructions_scrollview.getLayoutParams().width = (int) util.calculateDimension(351,MY_PHONE_WIDTH,(int) USER_width);

        // endregion ScrollView

        // region  TextView

        /**
         *  TextView
         **/
        // game_instructions_textView
        game_instructions_textView = findViewById(R.id.game_instructions_textView);
        game_instructions_textView.setTextSize((int) util.calculateTextSize(USER_height,18,MY_PHONE_HEIGHT,USER_dp));

        // endregion  TextView


    }
}