package com.toocms.www.testframeforwzw.base;

import android.os.Bundle;

public interface UICallback {
    void initData(Bundle savedInstanceState);

    void setListener();

    int getLayoutId();
}
