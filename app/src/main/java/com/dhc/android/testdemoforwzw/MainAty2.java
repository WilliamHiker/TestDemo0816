package com.dhc.android.testdemoforwzw;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainAty2 extends AppCompatActivity {

    CalenderTestView ctv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_aty2);
        ctv = (CalenderTestView) findViewById(R.id.ctv);
    }
}
