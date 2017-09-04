package com.example.lg.ch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by LG on 2017-09-04.
 */

public class SecondActivity extends AppCompatActivity {
    int sum;
    int cnt;
    int pay;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        Intent intent =getIntent();
        Button butBack=(Button)findViewById(R.id.back);
        Button buy=(Button)findViewById(R.id.buy);
        text=(TextView)findViewById(R.id.text);
        sum=intent.getIntExtra("sum",1);
        cnt=intent.getIntExtra("cnt",1);
        pay=10+sum*2;
        text.setText("비용:"+pay+"  +"+(sum*2)+"/클릭");
        butBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cnt>pay){
                    sum=sum*2;
                    Intent i= new Intent();
                    i.putExtra("sum",sum);
                    setResult(RESULT_OK, i);
                    finish();
                }
                else{
                    setResult(RESULT_CANCELED);
                    finish();
                }
            }
        });
    }

}
