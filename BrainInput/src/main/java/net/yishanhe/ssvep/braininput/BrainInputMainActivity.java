package net.yishanhe.ssvep.braininput;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class BrainInputMainActivity extends ActionBarActivity {

    private AnimatorSet animatorSet;
    private Button controlBTN;
    private boolean controlFlag = true;
    private Activity activity = this;

    // first
    private ValueAnimator colorAnimationOuter1;
    private ValueAnimator colorAnimationInner1;
    private View view1,view2,view3,view4,view5;
    final int freq1 = 5000/60;

    // second
    private ValueAnimator colorAnimationOuter2;
    private ValueAnimator colorAnimationInner2;
    private View view21,view22,view23,view24,view25;
    final int freq2 = 5000/70;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brain_input_main);


        // 5000/10 = 1hz
        view1 = (View) findViewById(R.id.view1);
        view2 = (View) findViewById(R.id.view2);
        view3 = (View) findViewById(R.id.view3);
        view4 = (View) findViewById(R.id.view4);
        view5 = (View) findViewById(R.id.view5);

        view21 = (View) findViewById(R.id.view21);
        view22 = (View) findViewById(R.id.view22);
        view23 = (View) findViewById(R.id.view23);
        view24 = (View) findViewById(R.id.view24);
        view25 = (View) findViewById(R.id.view25);




        Integer colorFrom = Color.RED;
        Integer colorTo = Color.WHITE;

        colorAnimationOuter1 = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
        colorAnimationOuter1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                view5.setBackgroundColor((Integer) animator.getAnimatedValue());
                view4.setBackgroundColor((Integer) animator.getAnimatedValue());
                view3.setBackgroundColor((Integer) animator.getAnimatedValue());
                view2.setBackgroundColor((Integer) animator.getAnimatedValue());

            }

        });
        colorAnimationInner1 = ValueAnimator.ofObject(new ArgbEvaluator(), colorTo, colorFrom);
        colorAnimationInner1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                view1.setBackgroundColor((Integer) animator.getAnimatedValue());

            }

        });
        colorAnimationOuter1.setRepeatCount(ValueAnimator.INFINITE);
        colorAnimationOuter1.setRepeatMode(ValueAnimator.REVERSE);
        colorAnimationOuter1.setDuration(freq1);
        colorAnimationInner1.setRepeatCount(ValueAnimator.INFINITE);
        colorAnimationInner1.setRepeatMode(ValueAnimator.REVERSE);
        colorAnimationInner1.setDuration(freq1);


        colorAnimationOuter2 = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
        colorAnimationOuter2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                view25.setBackgroundColor((Integer) animator.getAnimatedValue());
                view24.setBackgroundColor((Integer) animator.getAnimatedValue());
                view23.setBackgroundColor((Integer) animator.getAnimatedValue());
                view22.setBackgroundColor((Integer) animator.getAnimatedValue());

            }

        });
        colorAnimationOuter2.setRepeatCount(ValueAnimator.INFINITE);
        colorAnimationOuter2.setRepeatMode(ValueAnimator.REVERSE);
        colorAnimationOuter2.setDuration(freq2);


        colorAnimationInner2 = ValueAnimator.ofObject(new ArgbEvaluator(), colorTo, colorFrom);
        colorAnimationInner2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                view21.setBackgroundColor((Integer) animator.getAnimatedValue());

            }

        });
        colorAnimationInner2.setRepeatCount(ValueAnimator.INFINITE);
        colorAnimationInner2.setRepeatMode(ValueAnimator.REVERSE);
        colorAnimationInner2.setDuration(freq2);

        // @TODO animation set
        animatorSet = new AnimatorSet();
        animatorSet.playTogether(colorAnimationOuter1, colorAnimationInner1,
                colorAnimationOuter2, colorAnimationInner2);


        controlBTN = (Button) findViewById(R.id.control);
        controlBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (controlFlag == true){
//                    Toast.makeText(activity, "Start flickering.", Toast.LENGTH_SHORT).show();
                    controlFlag = false;
                    controlBTN.setText("Stop");
                    // Start action here
                    animatorSet.start();



                }else{
//                    Toast.makeText(activity, "Stop flickering,", Toast.LENGTH_SHORT).show();
                    controlFlag = true;
                    controlBTN.setText("Start");
                    // Stop action here
                    animatorSet.cancel();

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
