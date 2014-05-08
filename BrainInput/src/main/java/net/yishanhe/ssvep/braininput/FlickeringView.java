package net.yishanhe.ssvep.braininput;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.graphics.Canvas;
import android.animation.Animator;

import java.util.Timer;

/**
 * Created by syi on 5/7/2014.
 */
public class FlickeringView extends View{

    public Rect rect;
    private int innerRectColor;

    private int outerRectColor;

    protected static final String TAG = "FlickeringView";




    public FlickeringView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas){
        Log.d(TAG, "onDraw");
        super.onDraw(canvas);
        innerRectColor = Color.RED;
        outerRectColor = Color.BLACK;

        // background set as black
        canvas.drawColor(outerRectColor);
        int canvasWidth = canvas.getWidth();
        int canvasHeight = canvas.getHeight();
        Log.d(TAG, "WidthxHeight:"+ Integer.toString(canvasWidth) + "x" + Integer.toString(canvasHeight) );
        // 720x1000 Galaxy Nexus

        int boxBoarderWidth = 0; // please change it in the xml. better.

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);

        paint.setColor(innerRectColor);
        rect = new Rect(0+boxBoarderWidth, 0+boxBoarderWidth, getWidth()-boxBoarderWidth, getHeight()-boxBoarderWidth);
        canvas.drawRect(rect,paint);


    }




    public void setRectColor(int outerRectColor) {
        this.outerRectColor = outerRectColor;
    }

    public void setInnerRectColor(int innerRectColor) {
        this.innerRectColor = innerRectColor;
    }


}
