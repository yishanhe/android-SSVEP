package net.yishanhe.ssvep.braininput;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.animation.AnimatorSet;


public class BrainInputMainActivity extends ActionBarActivity {


//    private FlickeringView flickerViewTest;

    private AlphaAnimation aATopRight;
    private FlickeringView flickerViewTopRight;

    private AlphaAnimation aATopLeft;
    private FlickeringView flickerViewTopLeft;

    private AlphaAnimation aAButtomLeft;
    private FlickeringView flickerViewButtomLeft;

    private AlphaAnimation aAButtomRight;
    private FlickeringView flickerViewButtomRight;

    private Button controlBTN;
    private boolean controlFlag = true;
    private Activity activity = this;
//    private ObjectAnimator oa;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brain_input_main);

        flickerViewTopLeft = (FlickeringView) findViewById(R.id.topLeftView);
        flickerViewTopRight = (FlickeringView) findViewById(R.id.topRightView);
        flickerViewButtomLeft = (FlickeringView) findViewById(R.id.bottomLeftView);
        flickerViewButtomRight = (FlickeringView) findViewById(R.id.bottomRightView);

        aATopLeft = new AlphaAnimation(0.0f,1.0f);
        aATopLeft.setDuration(5000/60); //6hz
        aATopLeft.setRepeatCount(Animation.INFINITE);
        aATopLeft.setRepeatMode(Animation.REVERSE);
//        flickerViewTopLeft.setAnimation(aATopLeft);
//        aATopLeft.start();

        // 5000/10 = 1hz

        aATopRight = new AlphaAnimation(0.0f,1.0f);
        aATopRight.setDuration(5000/70);  // duration is half period
        aATopRight.setRepeatCount(Animation.INFINITE);
        aATopRight.setRepeatMode(Animation.REVERSE);
//        flickerViewTopRight.setAnimation(aATopRight);
//        aATopRight.start();

        aAButtomLeft = new AlphaAnimation(0.0f,1.0f);
        aAButtomLeft.setDuration(5000/80);
        aAButtomLeft.setRepeatCount(Animation.INFINITE);
        aAButtomLeft.setRepeatMode(Animation.REVERSE);
//        flickerViewButtomLeft.setAnimation(aAButtomLeft);
//        aAButtomLeft.start();

        aAButtomRight = new AlphaAnimation(0.0f,1.0f);
        aAButtomRight.setDuration(5000/90);
        aAButtomRight.setRepeatCount(Animation.INFINITE);
        aAButtomRight.setRepeatMode(Animation.REVERSE);
//        flickerViewButtomRight.setAnimation(aAButtomRight);
//        aAButtomLeft.start();



        // TEST
//        flickerView.ofInt(target, propertyName, 0, 10).setDuration(500).start().
//        oa = new ObjectAnimator();
//        oa.ofInt(flickerView, "InnerRectColor", Color.RED, Color.BLACK).setDuration(3000).start();
//        oa.ofInt(flickerView, "OuterRectColor", Color.BLACK, Color.RED).setDuration(3000).start();


//        flickerViewTest = (FlickeringView) findViewById(R.id.topLeftView);
//        ObjectAnimator animX = ObjectAnimator.ofInt(flickerViewTest, "InnerRectColor", Color.RED, Color.BLACK).setDuration(3000);
//        ObjectAnimator animY = ObjectAnimator.ofInt(flickerViewTest, "OuterRectColor", Color.BLACK, Color.RED).setDuration(3000);
//        AnimatorSet animSetXY = new AnimatorSet();
//        animSetXY.playTogether(animX, animY);
//        animSetXY.start();



        controlBTN = (Button) findViewById(R.id.control);
        controlBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (controlFlag == true){
                    Toast.makeText(activity, "Start flickering.", Toast.LENGTH_SHORT).show();
                    controlFlag = false;
                    controlBTN.setText("Stop");
                    // Start action here
                    flickerViewTopLeft.startAnimation(aATopLeft);
                    flickerViewTopRight.startAnimation(aATopRight);
                    flickerViewButtomLeft.startAnimation(aAButtomLeft);
                    flickerViewButtomRight.startAnimation(aAButtomRight);



                }else{
                    Toast.makeText(activity, "Stop flickering,", Toast.LENGTH_SHORT).show();
                    controlFlag = true;
                    controlBTN.setText("Start");
                    // Stop action here
                    flickerViewTopLeft.clearAnimation();
                    flickerViewTopRight.clearAnimation();
                    flickerViewButtomRight.clearAnimation();
                    flickerViewButtomLeft.clearAnimation();
                }
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.brain_input_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
