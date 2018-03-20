package com.example.timeless.timelesstest;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.example.timeless.fragment.ResultFragment;

/**
 * Created by timeless on 2018/3/15.
 */
public class SecondActivity extends Activity implements ResultFragment.MyListener{
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private EditText editText;
    private TextView tv_show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editText = (EditText) findViewById(R.id.ed_activity_to_fragment);
        tv_show = (TextView) findViewById(R.id.tx_from_fragment);

        manager = getFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.layout_fragment_data,new ResultFragment());
        transaction.commit();
    }

    /*传值*/
    public void send(View view){
        String info = editText.getText().toString().trim();
        ResultFragment resultFragment = new ResultFragment();
        Bundle bundle =new Bundle();
        bundle.putString("activityInfo",info);
        resultFragment.setArguments(bundle);

        manager = getFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.layout_fragment_data,resultFragment);
        transaction.commit();
    }

    @Override
    public void sendMessage(String str) {
        if (str != null && !"".equals(str)){
            tv_show.setText(str);
        }
    }
}
