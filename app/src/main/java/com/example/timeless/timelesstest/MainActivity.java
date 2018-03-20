package com.example.timeless.timelesstest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    public static final String TAG = "nate";

    private Button btn;
    private WuziqiPanel wuziqiPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_wuziqi);

        Log.i(TAG,"MainActivity onCreate");

        //activity传值给fragment
//        btn = (Button) findViewById(R.id.button);

        //五子棋
        wuziqiPanel = (WuziqiPanel) findViewById(R.id.id_wuziqi);
        btn = (Button) findViewById(R.id.re_start);

        btn.setOnClickListener(this);
        if(savedInstanceState != null){
            Log.i(TAG,savedInstanceState.getString("name"));
        }
    }

    @Override
    public void onClick(View v) {
        //五子棋
        wuziqiPanel.onceAgain();

        //activity向fragment传值demo（打开SecondActivity.class）
        //显示启动activity--1
//        Intent intent = new Intent(MainActivity.this,SecondActivity.class);
//        startActivity(intent);
//        //显示启动activity--2
//        Intent intent1 = new Intent();
//        ComponentName component = new ComponentName(MainActivity.this,SecondActivity.class);
//        intent1.setComponent(component);
////        startActivity(intent);
//        //匿名启动activity--1
//        Intent intent2 = new Intent();
//        intent2.setAction("www.mooc.com");
////        startActivity(intent);
//        //启动浏览器
//        Intent intent3 = new Intent();
//        intent3.setAction(Intent.ACTION_VIEW);
//        startActivity(intent3);
//        //启动相册
//        Intent intent4 = new Intent();
//        intent4.setAction(Intent.ACTION_GET_CONTENT);
//        intent4.setType("image/*");
////        startActivity(intent4);
//        //发送短信
//        Intent intent5 = new Intent();
//        intent5.setAction(Intent.ACTION_SEND);
//        intent5.setType("text/plain");
//        intent5.putExtra(Intent.EXTRA_TEXT,"内容");
//
//
//        startActivity(intent);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("name","横屏了");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"MainActivity onStart");
    }
    @Override
    protected void onRestart() {
        super.onStart();
        Log.i(TAG,"MainActivity onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"MainActivity onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"MainActivity onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"MainActivity onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"MainActivity onDestroy");
    }



}
