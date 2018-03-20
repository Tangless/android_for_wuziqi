package com.example.timeless.timelesstest;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import com.example.timeless.fragment.ResultFragment;

/**
 * Created by timeless on 2018/3/15.
 */
public class SecondActivity extends Activity {
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editText =(EditText) findViewById(R.id.ed_input);

        manager = getFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.layout_content,new ResultFragment());
        transaction.commit();
    }

    /*传值*/
    public void send(View view){
        String info = editText.getText().toString().trim();
        ResultFragment resultFragment = new ResultFragment();
        Bundle bundle =new Bundle();
        bundle.putString("info",info);
        resultFragment.setArguments(bundle);

        manager = getFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.layout_content,resultFragment);
        transaction.commit();
    }
}
