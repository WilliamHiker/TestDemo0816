package com.toocms.www.testframeforwzw.base;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.lzy.okgo.OkGo;
import com.toocms.www.testframeforwzw.kit.KnifeKit;
import com.toocms.www.testframeforwzw.manager.AppManager;

import java.util.ArrayList;
import java.util.List;

import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity implements UICallback {

    private Unbinder unbinder;
    protected UiDelegate mUiDelegate;

    private static final int PERMISSION_ERQUESTCODE = 100;
    private PermissionListener mPermissionListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppManager.instance = this;
        AppManager.getInstance().addActivity(this);

        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
            unbinder = KnifeKit.bind(this);
        }
        setListener();
        initData(savedInstanceState);
    }

    protected UiDelegate getUiDelegate() {
        if (mUiDelegate == null) {
            mUiDelegate = UiDelegateBase.create(this);
        }
        return mUiDelegate;
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        AppManager.instance = this;
        getUiDelegate().resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        getUiDelegate().pause();
    }

    @Override
    protected void onDestroy() {
        getUiDelegate().destory();
        AppManager.getInstance().killActivity(this);
        OkGo.getInstance().cancelTag(this);
        super.onDestroy();
    }

    @Override
    public void setListener() {

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        AppManager.instance = this;
    }

    /**
     * 授权
     *
     * @param permissions
     * @param listener
     */
    public void requestRunPermission(String[] permissions, PermissionListener listener) {
        mPermissionListener = listener;
        List<String> permissionLists = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                permissionLists.add(permission);
            }
        }
        if (!permissionLists.isEmpty()) {
            ActivityCompat.requestPermissions(this, permissionLists.toArray(new String[permissionLists.size()]), PERMISSION_ERQUESTCODE);
        } else {
            mPermissionListener.onGranted();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_ERQUESTCODE:
                if (grantResults.length > 0) {
                    //存放没有授权的权限
                    List<String> deniedPermissions = new ArrayList<>();
                    for (int i = 0; i < grantResults.length; i++) {
                        int grantResult = grantResults[i];
                        String permission = permissions[i];
                        if (grantResult != PackageManager.PERMISSION_GRANTED) {
                            deniedPermissions.add(permission);
                        }
                    }
                    if (deniedPermissions.isEmpty()) {
                        //都授权了
                        mPermissionListener.onGranted();
                    } else {
                        mPermissionListener.onDenied(deniedPermissions);
                    }
                }
                break;
            default:
                break;
        }
    }

    /**
     * 已授权、未授权接口回掉
     */
    public interface PermissionListener {
        void onGranted();       //已授权

        void onDenied(List<String> deniedPermissions);      //未授权
    }
}
