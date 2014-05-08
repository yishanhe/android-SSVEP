package net.yishanhe.ssvep.braininput;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class BrainInputMainActivity extends ActionBarActivity {


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
        // 5000/10 = 1hz

        aATopRight = new AlphaAnimation(0.0f,1.0f);
        aATopRight.setDuration(5000/70);  // duration is half period
        aATopRight.setRepeatCount(Animation.INFINITE);
        aATopRight.setRepeatMode(Animation.REVERSE);

        aAButtomLeft = new AlphaAnimation(0.0f,1.0f);
        aAButtomLeft.setDuration(5000/80);
        aAButtomLeft.setRepeatCount(Animation.INFINITE);
        aAButtomLeft.setRepeatMode(Animation.REVERSE);

        aAButtomRight = new AlphaAnimation(0.0f,1.0f);
        aAButtomRight.setDuration(5000/90);
        aAButtomRight.setRepeatCount(Animation.INFINITE);
        aAButtomRight.setRepeatMode(Animation.REVERSE);


        // @TODO using OPENGL ES


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
