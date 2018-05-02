package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStoryLine;
    Button mTopButton;
    Button mBottomButton;
    int mStoryIndex = 1;
    int ButtonClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:

        mStoryLine = findViewById(R.id.storyTextView);
        mTopButton = findViewById(R.id.buttonTop);
        mBottomButton = findViewById(R.id.buttonBottom);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ButtonClicked = 1;
                checkRoute();
                Log.d("Top", "Top Button Pressed");
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:

        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ButtonClicked = 2;
                checkRoute();
                Log.d("Bottom", "Bottom Button Pressed");
            }
        });

    }

    private void checkRoute() {

        if ((mStoryIndex == 1 && ButtonClicked == 1) || (mStoryIndex == 2 && ButtonClicked == 1)) {

            mStoryLine.setText(R.string.T3_Story);
            mTopButton.setText(R.string.T3_Ans1);
            mBottomButton.setText(R.string.T3_Ans2);
            mStoryIndex = 3;

        } else if (mStoryIndex == 1 && ButtonClicked == 2) {

            mStoryLine.setText(R.string.T2_Story);
            mTopButton.setText(R.string.T2_Ans1);
            mBottomButton.setText(R.string.T2_Ans2);
            mStoryIndex = 2;

        } else if (mStoryIndex == 3 && ButtonClicked == 1) {

            mStoryLine.setText(R.string.T6_End);
            mTopButton.setVisibility(View.GONE);
            mBottomButton.setVisibility(View.GONE);
            mStoryIndex = 6;

        } else if (mStoryIndex == 3 && ButtonClicked == 2) {

            mStoryLine.setText(R.string.T5_End);
            mTopButton.setVisibility(View.GONE);
            mBottomButton.setVisibility(View.GONE);
            mStoryIndex = 5;

        } else if (mStoryIndex == 2 && ButtonClicked == 2) {

            mStoryLine.setText(R.string.T4_End);
            mTopButton.setVisibility(View.GONE);
            mBottomButton.setVisibility(View.GONE);
            mStoryIndex = 4;

        }
    }
}
