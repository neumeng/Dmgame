package com.neumeng.dmgame.service;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by koo on 2016/11/6.
 */

public interface GameService {
    //http://www.3dmgame.com/sitemap/api.php?row=10&typeid=1&paging=1&page=%s
    @GET("api.php")
    Observable<String> getArticle(
            @Query("row") int row,
            @Query("typeid") int typeid,
            @Query("paging") int paging,
            @Query("page") int page);

}
