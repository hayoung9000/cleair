package com.example.lg.ch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView t_cnt;
    LinearLayout body;
    int score=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        body=(LinearLayout) findViewById(R.id.body);
        t_cnt=(TextView)findViewById(R.id.t_cnt);
        body.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.body :
                score++;
                t_cnt.setText(score+"");
                if(score>=17)body.setBackgroundResource(R.drawable.and_end);
                else if(score>=15)body.setBackgroundResource(R.drawable.and_3);
                else if(score>=10)body.setBackgroundResource(R.drawable.and_2);
                break;
        }
    }
}
