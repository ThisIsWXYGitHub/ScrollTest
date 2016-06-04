package com.example.lenovo.scrolltest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Scroller;

/**
 * Created by lenovo on 23/5/2016.
 */
public class MyView extends View {
    Scroller scroller;
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        scroller=new Scroller(context);
    }

    public MyView(Context context) {
        super(context);
        scroller=new Scroller(context,new AccelerateDecelerateInterpolator());
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        scroller=new Scroller(context);
    }
    /*
        view在执行draw方法中调用该方法
    */

    public void startScroll(int x,int y,int dx,int dy,int time )
    {
        scroller.startScroll(x,y,-dx,-dy,time);
        invalidate();
    }
    @Override
    public void computeScroll() {
        super.computeScroll();
        /*
        computeScrollOffset方法判断动画是否执行完毕，true表示没执行完，false表示执行完毕
         */
        if (scroller.computeScrollOffset())
        {
            ((View)(this.getParent())).scrollTo(scroller.getCurrX(),scroller.getCurrY());
             invalidate();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint p=new Paint();
        p.setColor(Color.RED);
        p.setStyle(Paint.Style.FILL);
        canvas.drawRect(0,0,this.getMeasuredWidth(),this.getMeasuredHeight(),p);
        super.onDraw(canvas);
    }
}
