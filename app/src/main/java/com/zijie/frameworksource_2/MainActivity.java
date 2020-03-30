package com.zijie.frameworksource_2;



import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    ViewStub viewStub;
    boolean isCollapes = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tvTxt = findViewById(R.id.tv_text);
        tvTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isCollapes){
                    tvTxt.setSingleLine(false);
                    isCollapes = false;
                }else {
                    tvTxt.setSingleLine(true);
                    isCollapes = true;
                }
            }
        });
    }

    public void visibleClick(View view) {
        if (null == viewStub){
            viewStub.inflate();
        }
    }
}
