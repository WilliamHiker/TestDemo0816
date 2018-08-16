package com.toocms.www.testdemoforwzw;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.toocms.www.testframeforwzw.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class ColorMatrixAty2 extends BaseActivity {

    @BindView(R.id.imageview)
    ImageView mImageview;
    @BindView(R.id.group)
    GridLayout mGroup;
    @BindView(R.id.btnChange)
    Button mBtnChange;
    @BindView(R.id.btnReset)
    Button mBtnReset;

    private Bitmap mBitmap;
    private int mEtWidth;
    private int mEtHeight;
    private EditText mEts[] = new EditText[20];
    private float mColorMatrix[] = new float[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher_round);
        //我们无法再onCreate()方法中获得视图的宽高值
        //所以通过View的post方法，在视图创建完毕后获得其宽高值
        mGroup.post(new Runnable() {
            @Override
            public void run() {
                mEtWidth = mGroup.getWidth() / 5;
                mEtHeight = mGroup.getHeight() / 4;
                addEts();
                initMatrix();
            }
        });
    }

    private void getMatrix() {
        for (int i = 0; i < 20; i++) {
            mColorMatrix[i] = Float.valueOf(mEts[i].getText().toString());
        }
    }

    private void setImageMatrix() {
        Bitmap bmp = Bitmap.createBitmap(mBitmap.getWidth(), mBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        android.graphics.ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.set(mColorMatrix);
        Canvas canvas = new Canvas(bmp);
        Paint paint = new Paint();
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(mBitmap, 0, 0, paint);
        mImageview.setImageBitmap(bmp);
    }

    private void initMatrix() {
        for (int i = 0; i < 20; i++) {
            if (i % 6 == 0) {
                mEts[i].setText(String.valueOf(1));
            } else {
                mEts[i].setText(String.valueOf(0));
            }
        }
    }

    private void addEts() {
        for (int i = 0; i < 20; i++) {
            EditText editText = new EditText(ColorMatrixAty2.this);
            mEts[i] = editText;
            mGroup.addView(editText, mEtWidth, mEtHeight);
        }
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.aty2_color_matrix;
    }

    @OnClick({R.id.btnChange, R.id.btnReset})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnChange:
                getMatrix();
                setImageMatrix();
                break;
            case R.id.btnReset:
                initMatrix();
                getMatrix();
                setImageMatrix();
                break;
        }
    }
}
