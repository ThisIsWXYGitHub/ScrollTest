package com.example.lenovo.scrolltest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    MyView view;
    RelativeLayout parent;
    int x;
    int y;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        view=(MyView) findViewById(R.id.myview);
        view.setOnTouchListener(this);

        parent=(RelativeLayout)view.getParent();

    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Toast.makeText(MainActivity.this, "触摸成功", Toast.LENGTH_SHORT).show();
        switch (event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                 x= (int) event.getX();
                 y= (int) event.getY();
                 break;
            case MotionEvent.ACTION_MOVE:
                int dx=(int)(event.getX()-x);
                int dy=(int)(event.getY()-y);
                view.startScroll(parent.getScrollX(),parent.getScrollY(),dx,dy,1);
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }
}
