package com.example.lg.ch;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    static final int PICK_CONTACT_REQUEST = 1;
    TextView t_cnt;
    LinearLayout body;
    Button but;
    int score=0;
    int sum=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        body=(LinearLayout) findViewById(R.id.body);
        t_cnt=(TextView)findViewById(R.id.t_cnt);
        but=(Button)findViewById(R.id.but);
        body.setOnClickListener(this);
        but.setOnClickListener(butMainHandler);
        body.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.body :
                score+=sum;
                t_cnt.setText(score+"");
                if(score>=15000)body.setBackgroundResource(R.drawable.and_end);
                else if(score>=10000)body.setBackgroundResource(R.drawable.and_night2);
                else if(score>=7000)body.setBackgroundResource(R.drawable.and_night);
                else if(score>=3000)body.setBackgroundResource(R.drawable.and_pink);
                else if(score>=1000)body.setBackgroundResource(R.drawable.and_3);
                else if(score>=200)body.setBackgroundResource(R.drawable.and_2);
                break;
        }


    }
    View.OnClickListener butMainHandler=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,SecondActivity.class); //그냥 this를 하면 익명 클래스의 this가 된다
            intent.putExtra("sum",sum);
            intent.putExtra("cnt",score);
            startActivityForResult(intent, PICK_CONTACT_REQUEST);
        }
    }; //익명 클래스 객체는 ; 가 있어야 함
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != RESULT_OK) {
            return;
        }
        if (requestCode ==PICK_CONTACT_REQUEST) {
            sum = data.getIntExtra("sum", 1);
            Toast.makeText(MainActivity.this, "결제 되었습니다",Toast.LENGTH_SHORT).show();
            score =score-(10+(sum-1)*2);
            t_cnt.setText(score+"");
        }
    }
  }
