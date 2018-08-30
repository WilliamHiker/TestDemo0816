package com.dhc.android.base.app;

import java.util.WeakHashMap;

public class Configurator {
    private static final WeakHashMap<String,Object> MY_CONFIGS = new WeakHashMap<>();

    private Configurator(){
        MY_CONFIGS.put(ConfigType.CONFIG_READY.name(),false);
    }

    public static Configurator getInstance(){
        return Holder.INSTANCE;
    }

    final WeakHashMap<String,Object> getMyConfigs(){
        return MY_CONFIGS;
    }

    private static class Holder{
        private static final Configurator INSTANCE = new Configurator();
    }

    public final void configure(){
        MY_CONFIGS.put(ConfigType.CONFIG_READY.name(),true);
    }

    public final Configurator withApiHost(String host){
        MY_CONFIGS.put(ConfigType.API_HOST.name(),host);
        return this;
    }

    private void checkConfiguration(){
        final boolean isReady = (boolean) MY_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady){
            throw new RuntimeException("Configuration is not Ready,call configure");
        }
    }

    public final <T> T getCnfiguration(Enum<ConfigType> key){
        checkConfiguration();
        return (T)MY_CONFIGS.get(key.name());
    }
}
