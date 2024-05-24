package com.example.antakhshari;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class PlayBoardActivity extends AppCompatActivity {

    // ******************************************************** My Phone Properties ************************************************************************
    double MY_PHONE_HEIGHT = 640;
    double MY_PHONE_WIDTH = 360;
    double MY_PHONE_DP = 2.625;
    String[] team = new String[2];

    // *********************************************************** Object Declaration **********************************************************************
    Utility util = new Utility();

    // *********************************************************** App Component Declaration ***************************************************************
    TextView how_to_play_textView,starting_toss_textView,starting_toss_result_textView,challenge_result_textView,scoreBoard_textView,team_A_Name_textView,
            team_B_Name_textView,team_A_points_textView,team_B_points_textView,divider_textView;
    ImageButton how_to_play_imageButton,team_A_add_imageButton,team_B_add_imageButton;
    Button challenge_button;

    // *****************************************************************************************************************************************************

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_board);
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

        // region Get Data From MainActivity

        Bundle bn = getIntent().getExtras();
        team[0] = bn.getString("team_A_name");
        team[1] = bn.getString("team_B_name");

        // endregion Get Data From MainActivity





        // region  TextView

        /**
         *  TextView
         **/
        // how_to_play_textView
        how_to_play_textView = findViewById(R.id.how_to_play_textView);
        how_to_play_textView.getLayoutParams().height = (int) util.calculateDimension(20,MY_PHONE_HEIGHT,(int) USER_height);
        how_to_play_textView.getLayoutParams().width = (int) util.calculateDimension(90,MY_PHONE_WIDTH,(int) USER_width);
        how_to_play_textView.setTextSize((int) util.calculateTextSize(USER_height,14,MY_PHONE_HEIGHT,USER_dp));

        // starting_toss_textView
        starting_toss_textView = findViewById(R.id.starting_toss_textView);
        starting_toss_textView.getLayoutParams().height = (int) util.calculateDimension(30,MY_PHONE_HEIGHT,(int) USER_height);
        starting_toss_textView.getLayoutParams().width = (int) util.calculateDimension(128,MY_PHONE_WIDTH,(int) USER_width);
        starting_toss_textView.setTextSize((int) util.calculateTextSize(USER_height,18,MY_PHONE_HEIGHT,USER_dp));

        // starting_toss_result_textView
        starting_toss_result_textView = findViewById(R.id.starting_toss_result_textView);
        starting_toss_result_textView.getLayoutParams().height = (int) util.calculateDimension(30,MY_PHONE_HEIGHT,(int) USER_height);
        starting_toss_result_textView.getLayoutParams().width = (int) util.calculateDimension(180,MY_PHONE_WIDTH,(int) USER_width);
        starting_toss_result_textView.setTextSize((int) util.calculateTextSize(USER_height,18,MY_PHONE_HEIGHT,USER_dp));
        starting_toss_result_textView.setText(team[util.getTeamName()]);
        //Toast.makeText(getBaseContext(), "Starting Team = "+team[util.getTeamName()], Toast.LENGTH_SHORT).show();

        // challenge_result_textView
        challenge_result_textView = findViewById(R.id.challenge_result_textView);
        challenge_result_textView.getLayoutParams().height = (int) util.calculateDimension(51,MY_PHONE_HEIGHT,(int) USER_height);
        challenge_result_textView.getLayoutParams().width = (int) util.calculateDimension(67,MY_PHONE_WIDTH,(int) USER_width);
        challenge_result_textView.setTextSize((int) util.calculateTextSize(USER_height,20,MY_PHONE_HEIGHT,USER_dp));
        challenge_result_textView.setText(Character.toString(util.getRandomAlphabet()));

        // scoreBoard_textView
        scoreBoard_textView = findViewById(R.id.scoreBoard_textView);
        scoreBoard_textView.getLayoutParams().height = (int) util.calculateDimension(30,MY_PHONE_HEIGHT,(int) USER_height);
        scoreBoard_textView.getLayoutParams().width = (int) util.calculateDimension(360,MY_PHONE_WIDTH,(int) USER_width);
        scoreBoard_textView.setTextSize((int) util.calculateTextSize(USER_height,20,MY_PHONE_HEIGHT,USER_dp));

        // team_A_Name_textView
        team_A_Name_textView = findViewById(R.id.team_A_Name_textView);
        team_A_Name_textView.getLayoutParams().height = (int) util.calculateDimension(29,MY_PHONE_HEIGHT,(int) USER_height);
        team_A_Name_textView.getLayoutParams().width = (int) util.calculateDimension(149,MY_PHONE_WIDTH,(int) USER_width);
        team_A_Name_textView.setTextSize((int) util.calculateTextSize(USER_height,18,MY_PHONE_HEIGHT,USER_dp));
        team_A_Name_textView.setText(team[0]);

        // team_B_Name_textView
        team_B_Name_textView = findViewById(R.id.team_B_Name_textView);
        team_B_Name_textView.getLayoutParams().height = (int) util.calculateDimension(29,MY_PHONE_HEIGHT,(int) USER_height);
        team_B_Name_textView.getLayoutParams().width = (int) util.calculateDimension(149,MY_PHONE_WIDTH,(int) USER_width);
        team_B_Name_textView.setTextSize((int) util.calculateTextSize(USER_height,18,MY_PHONE_HEIGHT,USER_dp));
        team_B_Name_textView.setText(team[1]);

        // team_A_points_textView
        team_A_points_textView = findViewById(R.id.team_A_points_textView);
        team_A_points_textView.getLayoutParams().height = (int) util.calculateDimension(64,MY_PHONE_HEIGHT,(int) USER_height);
        team_A_points_textView.getLayoutParams().width = (int) util.calculateDimension(64,MY_PHONE_WIDTH,(int) USER_width);
        team_A_points_textView.setTextSize((int) util.calculateTextSize(USER_height,20,MY_PHONE_HEIGHT,USER_dp));

        // team_B_points_textView
        team_B_points_textView = findViewById(R.id.team_B_points_textView);
        team_B_points_textView.getLayoutParams().height = (int) util.calculateDimension(64,MY_PHONE_HEIGHT,(int) USER_height);
        team_B_points_textView.getLayoutParams().width = (int) util.calculateDimension(64,MY_PHONE_WIDTH,(int) USER_width);
        team_B_points_textView.setTextSize((int) util.calculateTextSize(USER_height,20,MY_PHONE_HEIGHT,USER_dp));

        // divider_textView
        divider_textView = findViewById(R.id.divider_textView);
        divider_textView.getLayoutParams().height = (int) util.calculateDimension(200,MY_PHONE_HEIGHT,(int) USER_height);
        divider_textView.getLayoutParams().width = (int) util.calculateDimension(6,MY_PHONE_WIDTH,(int) USER_width);

        // endregion  TextView

        // region ImageButton

        /**
         *  ImageButton
         **/
        // how_to_play_imageButton
        how_to_play_imageButton = findViewById(R.id.how_to_play_imageButton);
        how_to_play_imageButton.getLayoutParams().height = (int) util.calculateDimension(50,MY_PHONE_HEIGHT,(int) USER_height);
        how_to_play_imageButton.getLayoutParams().width = (int) util.calculateDimension(50,MY_PHONE_WIDTH,(int) USER_width);
        how_to_play_imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PlayBoardActivity.this,HowToPlayActivity.class));
            }
        });

        // team_A_add_imageButton
        team_A_add_imageButton = findViewById(R.id.team_A_add_imageButton);
        team_A_add_imageButton.getLayoutParams().height = (int) util.calculateDimension(60,MY_PHONE_HEIGHT,(int) USER_height);
        team_A_add_imageButton.getLayoutParams().width = (int) util.calculateDimension(60,MY_PHONE_WIDTH,(int) USER_width);
        team_A_add_imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String A_Point = Integer.toString((util.points('A')));
                team_A_points_textView.setText(A_Point);
            }
        });

        // team_B_add_imageButton
        team_B_add_imageButton = findViewById(R.id.team_B_add_imageButton);
        team_B_add_imageButton.getLayoutParams().height = (int) util.calculateDimension(60,MY_PHONE_HEIGHT,(int) USER_height);
        team_B_add_imageButton.getLayoutParams().width = (int) util.calculateDimension(60,MY_PHONE_WIDTH,(int) USER_width);
        team_B_add_imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String B_Point = Integer.toString((util.points('B')));
                team_B_points_textView.setText(B_Point);
            }
        });

        // endregion ImageButton

        // region Button

        /**
         *  Button
         **/
        // challenge_button
        challenge_button = findViewById(R.id.challenge_button);
        challenge_button.getLayoutParams().height = (int) util.calculateDimension(67,MY_PHONE_HEIGHT,(int) USER_height);
        challenge_button.getLayoutParams().width = (int) util.calculateDimension(132,MY_PHONE_WIDTH,(int) USER_width);
        challenge_button.setTextSize((int) util.calculateTextSize(USER_height,20,MY_PHONE_HEIGHT,USER_dp));
        challenge_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                char alphabet = util.getRandomAlphabet();
                //Toast.makeText(getBaseContext(), "Alphabet = "+alphabet, Toast.LENGTH_SHORT).show();
                starting_toss_result_textView.setText(team[util.getTeamName()]);
                challenge_result_textView.setText(Character.toString(alphabet));

            }
        });

        // endregion Button



    }
}