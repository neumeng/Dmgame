package com.neumeng.dmgame.api;

import com.neumeng.dmgame.service.GameService;

/**
 * Created by koo on 2016/11/6.
 */

public class ApiFactory {
    protected static final Object monitor = new Object();
    static GameService sGameService = null;
    public static final int size = 20;

    public static GameService getGameServiceSingleton(){
        synchronized (monitor){
            if (sGameService==null){
                sGameService = new ApiClient().getGankService();
            }
            return sGameService;
        }
    }
}
