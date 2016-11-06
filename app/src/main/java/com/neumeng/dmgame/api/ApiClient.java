package com.neumeng.dmgame.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.neumeng.dmgame.service.GameService;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by koo on 2016/11/6.
 */

public class ApiClient {
    final GameService gameService;
    ApiClient(){
        OkHttpClient client = new OkHttpClient();
        Gson gson = new GsonBuilder().serializeNulls().create();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl("http://www.3dmgame.com/sitemap/")
                .addConverterFactory(ScalarsConverterFactory.create())//读取string 类型的结果 而不是json格式
//                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        gameService = retrofit.create(GameService.class);
    }
    public GameService getGankService(){
        return gameService;
    }
}
