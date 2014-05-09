package net.yishanhe.ssvep.braininput;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by syi on 5/7/2014.
 */
public class FlickeringViewInner extends View{

    public Rect rect;



    private int rectColor;

    protected static final String TAG = "FlickeringView";

    public FlickeringViewInner(Context context) {
        this(context, null);
    }


    public FlickeringViewInner(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlickeringViewInner(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        if (attrs != null) {
            TypedArray a=getContext()
                    .obtainStyledAttributes(attrs,
                            R.styleable.FlickeringViewInner,0,0);
            setRectColor(a.getColor(R.styleable.FlickeringViewInner_initialColor,Color.RED));
            a.recycle();

        }
    }

    @Override
    protected void onDraw(Canvas canvas){
        Log.d(TAG, "onDraw");
        super.onDraw(canvas);

        int boxBoarderWidth = 0; // please change it in the xml. better.

        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);

        paint.setColor(rectColor);
        rect = new Rect(0+boxBoarderWidth, 0+boxBoarderWidth, getWidth()-boxBoarderWidth, getHeight()-boxBoarderWidth);
        canvas.drawRect(rect,paint);


    }




    public void setRectColor(int rectColor) {
        this.rectColor = rectColor;
    }

    public int getRectColor() {
        return rectColor;
    }

}
