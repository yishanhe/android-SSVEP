package net.yishanhe.ssvep.braininput;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;



public class BrainInputMainActivity extends ActionBarActivity {


    private AlphaAnimation aATop;
    private FlickeringView flickerViewTop;

    private AlphaAnimation aAMiddle;
    private FlickeringView flickerViewMiddle;

    private AlphaAnimation aAButtom;
    private FlickeringView flickerViewButtom;



    private Button controlBTN;
    private boolean controlFlag = true;
    private Activity activity = this;

    final int boxColor = Color.BLACK;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brain_input_main);

        // turn off title to provide more visible area
//        requestWindowFeature(Window.FEATURE_NO_TITLE);



        flickerViewTop = (FlickeringView) findViewById(R.id.topBoxView);

        flickerViewMiddle = (FlickeringView) findViewById(R.id.midBoxView);
        flickerViewButtom = (FlickeringView) findViewById(R.id.botBoxView);


        aATop = new AlphaAnimation(0.0f,1.0f);
        aATop.setDuration(5000/60); //6hz
        aATop.setRepeatCount(Animation.INFINITE);
        aATop.setRepeatMode(Animation.REVERSE);
        // 5000/10 = 1hz

        aAMiddle = new AlphaAnimation(0.0f,1.0f);
        aAMiddle.setDuration(5000/80);
        aAMiddle.setRepeatCount(Animation.INFINITE);
        aAMiddle.setRepeatMode(Animation.REVERSE);

        aAButtom = new AlphaAnimation(0.0f,1.0f);
        aAButtom.setDuration(5000/100);
        aAButtom.setRepeatCount(Animation.INFINITE);
        aAButtom.setRepeatMode(Animation.REVERSE);


        // @TODO using OPENGL ES


        controlBTN = (Button) findViewById(R.id.control);
        controlBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (controlFlag == true){
//                    Toast.makeText(activity, "Start flickering.", Toast.LENGTH_SHORT).show();
                    controlFlag = false;
                    controlBTN.setText("Stop");
                    // Start action here
                    flickerViewTop.startAnimation(aATop);
                    flickerViewMiddle.startAnimation(aAMiddle);
                    flickerViewButtom.startAnimation(aAButtom);

                }else{
//                    Toast.makeText(activity, "Stop flickering,", Toast.LENGTH_SHORT).show();
                    controlFlag = true;
                    controlBTN.setText("Start");
                    // Stop action here
                    flickerViewTop.clearAnimation();
                    flickerViewMiddle.clearAnimation();
                    flickerViewButtom.clearAnimation();

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
