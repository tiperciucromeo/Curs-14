package com.romeotutorial.ex1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    Button button;
    int sus,dreapta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);

        button.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                {
                    final FrameLayout.LayoutParams par = (FrameLayout.LayoutParams)view.getLayoutParams();
                    switch(motionEvent.getAction())
                    {
                        case MotionEvent.ACTION_MOVE:
                        {
                            par.topMargin += (int)motionEvent.getRawY() - dreapta;
                            dreapta = (int)motionEvent.getRawY();
                            par.leftMargin += (int)motionEvent.getRawX() - sus;
                            sus = (int)motionEvent.getRawX();
                            view.setLayoutParams(par);
                            return true;
                        }
                        case MotionEvent.ACTION_UP:
                        {
                            par.topMargin += (int)motionEvent.getRawY() - dreapta;
                            par.leftMargin += (int)motionEvent.getRawX() - sus;
                            view.setLayoutParams(par);
                            return true;
                        }
                        case MotionEvent.ACTION_DOWN:
                        {
                            sus = (int)motionEvent.getRawX();
                            dreapta = (int)motionEvent.getRawY();
                            par.bottomMargin = -2 * view.getHeight();
                            par.rightMargin = -2 * view.getWidth();
                            view.setLayoutParams(par);
                            return true;
                        }
                    }
                    return false;
                }
            }
        });
    }
}