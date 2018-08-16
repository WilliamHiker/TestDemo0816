package com.toocms.www.testdemoforwzw.btn2;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.toocms.www.testdemoforwzw.R;

public class Btn2Aty extends AppCompatActivity implements View.OnClickListener {

    private Btn2Fragment1 mBtn2Fragment1;
    private Btn2Fragment2 mBtn2Fragment2;
    private Btn2Fragment3 mBtn2Fragment3;

    private Button foot1;
    private Button foot2;
    private Button foot3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aty_btn2);

        foot1 = (Button) findViewById(R.id.btn1);
        foot2 = (Button) findViewById(R.id.btn2);
        foot3 = (Button) findViewById(R.id.btn3);
        foot1.setOnClickListener(this);
        foot2.setOnClickListener(this);
        foot3.setOnClickListener(this);
        initFgt1();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                initFgt1();
                break;
            case R.id.btn2:
                initFgt2();
                break;
            case R.id.btn3:
                initFgt3();
                break;
        }
    }

    private void initFgt1() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        hideFragment(fragmentTransaction);
        if (mBtn2Fragment1 == null) {
            mBtn2Fragment1 = new Btn2Fragment1();
            fragmentTransaction.add(R.id.main_frame_layout, mBtn2Fragment1);
        }
        fragmentTransaction.show(mBtn2Fragment1);
        fragmentTransaction.commit();
    }

    private void initFgt2() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        hideFragment(fragmentTransaction);
        if (mBtn2Fragment2 == null) {
            mBtn2Fragment2 = new Btn2Fragment2();
            fragmentTransaction.add(R.id.main_frame_layout, mBtn2Fragment2);
        }
        fragmentTransaction.show(mBtn2Fragment2);
        fragmentTransaction.commit();
    }

    private void initFgt3() {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        hideFragment(fragmentTransaction);
        if (mBtn2Fragment3 == null) {
            mBtn2Fragment3 = new Btn2Fragment3();
            fragmentTransaction.add(R.id.main_frame_layout, mBtn2Fragment3);
        }
        fragmentTransaction.show(mBtn2Fragment3);
        fragmentTransaction.commit();
    }

    private void hideFragment(FragmentTransaction fragmentTransaction) {
        if (mBtn2Fragment1 != null) {
            fragmentTransaction.hide(mBtn2Fragment1);
        }
        if (mBtn2Fragment2 != null) {
            fragmentTransaction.hide(mBtn2Fragment2);
        }
        if (mBtn2Fragment3 != null) {
            fragmentTransaction.hide(mBtn2Fragment3);
        }
    }
}
