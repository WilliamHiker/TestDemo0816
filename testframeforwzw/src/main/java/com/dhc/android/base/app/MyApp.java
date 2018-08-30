package com.dhc.android.base.app;

import android.content.Context;

import java.util.WeakHashMap;

public final class MyApp {
    public static Configurator init(Context context) {
        getConfigurations().put(ConfigType.APPLICATION_CONTENT.name(), context.getApplicationContext());
        return Configurator.getInstance();
    }

    private static WeakHashMap<String, Object> getConfigurations() {
        return Configurator.getInstance().getMyConfigs();
    }
}
