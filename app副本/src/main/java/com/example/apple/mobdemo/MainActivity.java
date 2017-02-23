package com.example.apple.mobdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv_sms)
    TextView tvSms;
    @BindView(R.id.tv_share)
    TextView tvShare;
    @BindView(R.id.tv_rec)
    TextView tvRec;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;

    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_sms, R.id.tv_share, R.id.tv_rec})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_sms:
                JumpActivity(SMSActivity.class);
                break;
            case R.id.tv_share:
                JumpActivity(ShareActivity.class);
                break;
            case R.id.tv_rec:
                JumpActivity(RECActivity.class);
                break;
        }
    }

    public void JumpActivity(Class o) {
        Intent intent = new Intent();
        intent.setClass(context, o);
        startActivity(intent);
    }
}
