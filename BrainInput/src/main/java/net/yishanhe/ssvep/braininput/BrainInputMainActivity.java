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


    private AlphaAnimation a1,a2,a3,a4,a5;
    private FlickeringView view2,view3,view4,view5;
    private FlickeringViewInner view1;


    private Button controlBTN;
    private boolean controlFlag = true;
    private Activity activity = this;

    final int boxColor = Color.BLACK;
    final int freq1= 5000/60;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brain_input_main);

        // turn off title to provide more visible area
//        requestWindowFeature(Window.FEATURE_NO_TITLE);



        view1 = (FlickeringViewInner) findViewById(R.id.view);
        view2 = (FlickeringView) findViewById(R.id.view2);
        view3 = (FlickeringView) findViewById(R.id.view3);
        view4 = (FlickeringView) findViewById(R.id.view4);
        view5 = (FlickeringView) findViewById(R.id.view5);



        a1 = new AlphaAnimation(0.0f,1.0f);
        a1.setDuration(freq1); //6hz
        a1.setRepeatCount(Animation.INFINITE);
        a1.setRepeatMode(Animation.REVERSE);
        // 5000/10 = 1hz



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
                    view1.startAnimation(a1);
                    view2.startAnimation(a1);
                    view3.startAnimation(a1);
                    view4.startAnimation(a1);
                    view5.startAnimation(a1);


                }else{
//                    Toast.makeText(activity, "Stop flickering,", Toast.LENGTH_SHORT).show();
                    controlFlag = true;
                    controlBTN.setText("Start");
                    // Stop action here
                    view1.clearAnimation();
                    view2.clearAnimation();
                    view3.clearAnimation();
                    view4.clearAnimation();
                    view5.clearAnimation();

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
