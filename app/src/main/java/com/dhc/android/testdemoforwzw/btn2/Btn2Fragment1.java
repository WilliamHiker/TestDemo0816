package com.dhc.android.testdemoforwzw.btn2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dhc.android.testdemoforwzw.R;

public class Btn2Fragment1 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fgt_btn2, container,false);
        TextView tv = (TextView) view.findViewById(R.id.tv);
        tv.setText("测试碎片1");
        return view;
    }
}
