package com.example.raghul.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Thread.*;

/**
 * Created by Raghul on 7/18/2017.
 */

public class Second extends Activity implements Animation.AnimationListener{
    TextView tm;
    Animation in, out;
    Button bm;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        tm = (TextView)findViewById(R.id.textView);
        bm = (Button) findViewById(R.id.button);

        in = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadein);
        out = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fadeout);

        in.setAnimationListener(this);
        out.setAnimationListener(this);
        bm.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                tm.setVisibility(View.VISIBLE);
                tm.startAnimation(in);
            }
        });

    }

    @Override
    public void onAnimationStart(Animation animation) {
        Toast.makeText(this, "Animation Started", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if(animation==in){
            Toast.makeText(this, "Animation Stopped", Toast.LENGTH_SHORT).show();
            tm.startAnimation(out);
            out.start();

            tm.setVisibility(View.GONE);

        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
