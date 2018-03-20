package com.example.timeless.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.timeless.timelesstest.R;
import android.view.View.OnClickListener;

public class ResultFragment extends Fragment{
    private TextView textView;
    private EditText editText;
    private Button button;
    private MyListener listener;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //listener实例化
        listener = (MyListener) getActivity();
    }

    @Override
    public void setRetainInstance(boolean retain) {
        super.setRetainInstance(retain);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result,null);

        textView = (TextView) view.findViewById(R.id.tx_title_fg);
        editText = (EditText) view.findViewById(R.id.ed_fragment);
        button = (Button) view.findViewById(R.id.btn_to_activity);

        //接收activity传过来的值
        final Bundle bundle = getArguments();
        if (bundle != null){
            String info = bundle.getString("activityInfo");
            textView.setText(info);
        }

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //点击按钮时editText的值传给activity
                String info = editText.getText().toString().trim();
                listener.sendMessage(info);
            }
        });
        return view;
    }

    //接口
    public interface  MyListener{
        public abstract void sendMessage(String str);
    }
}
