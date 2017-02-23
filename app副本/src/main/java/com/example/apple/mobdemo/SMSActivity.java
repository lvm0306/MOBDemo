package com.example.apple.mobdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.ContactsPage;
import cn.smssdk.gui.RegisterPage;

public class SMSActivity extends AppCompatActivity {
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        ButterKnife.bind(this);
    }

    private void SendSMS() {
        //打开注册页面
        RegisterPage registerPage = new RegisterPage();
        registerPage.setRegisterCallback(new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                // 解析注册结果
                if (result == SMSSDK.RESULT_COMPLETE) {
                    @SuppressWarnings("unchecked")
                    HashMap<String, Object> phoneMap = (HashMap<String, Object>) data;
                    String country = (String) phoneMap.get("country");
                    String phone = (String) phoneMap.get("phone");
                    // 提交用户信息（此方法可以不调用）
                    // registerUser(country, phone);
                    Toast.makeText(context, country + phone, Toast.LENGTH_SHORT);
                }
            }
        });
        registerPage.show(context);
    }

    @OnClick({R.id.tv_sendsms, R.id.activity_sms})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_sendsms:
                SendSMS();

                break;
            case R.id.activity_sms:
                Toast.makeText(context, "恭喜你触发，隐藏代码，好友搜索", Toast.LENGTH_SHORT);
                ContactsPage contactsPage = new ContactsPage();
                contactsPage.show(context);
                break;
        }
    }
}
