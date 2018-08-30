package com.dhc.android.testdemoforwzw;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;
import android.widget.Toast;

import com.dhc.android.base.base.BaseActivity;
import com.dhc.android.base.base.BasePresenter;

import butterknife.BindView;
import butterknife.OnClick;

public class PermissinsDispatchederActivity extends BaseActivity {

    @BindView(R.id.tv_permission_status)
    TextView mTvPermissionStatus;

    private final int CAMERA_REQUEST_CODE = 1;
    private final int EXTERNAL_STORAGE_REQUEST_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public int getLayoutId() {
        return R.layout.aty_permissins_dispatcheder;
    }

    @OnClick(R.id.btn_request_permission)
    public void onViewClicked() {
                                                                requestPermission();
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void requestPermission() {
        //申请权限
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            //第一次请求权限时，用户如果拒绝，下一次请求shouldShowRequestPermissionRationale()返回true
            //向用户解释为什么需要这个权限
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                new AlertDialog.Builder(this).setMessage("申请读写权限").setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ActivityCompat.requestPermissions(PermissinsDispatchederActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.CAMERA}, EXTERNAL_STORAGE_REQUEST_CODE);
                    }
                }).show();
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.CAMERA}, EXTERNAL_STORAGE_REQUEST_CODE);
            }
        } else {
            mTvPermissionStatus.setTextColor(Color.GREEN);
            mTvPermissionStatus.setText("读写权限已申请");
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == EXTERNAL_STORAGE_REQUEST_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                mTvPermissionStatus.setTextColor(Color.GREEN);
                mTvPermissionStatus.setText("读写权限已申请");
            }else {
                //用户勾选了不再询问
                //提示用户手动打开权限
                if (!ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    Toast.makeText(this, "读写权限已被禁止", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
