package com.example.timeless.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.timeless.timelesstest.R;

public class ResultFragment extends Fragment{
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result,null);

        textView = (TextView) view.findViewById(R.id.tx_title_fg);

        Bundle bundle = getArguments();
        if (bundle != null){
            String info = bundle.getString("info");
            textView.setText(info);
        }
        return view;
    }
}
