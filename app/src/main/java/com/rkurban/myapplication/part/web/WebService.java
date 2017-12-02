package com.rkurban.myapplication.part.web;


import com.rkurban.myapplication.part.web.rss.Js;
import com.rkurban.myapplication.part.web.rss.Rss;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by rkurban on 08/11/2017.
 */

public interface WebService {

    //@GET("bMHBicTEya?indent=2")
    //Call<List<Modal>> itemList();

    //@GET("bMHBicTEya?indent=2")
    //Observable<List<Modal>> observableItemList();

    //@GET("/xml/simple.xml")

    //@GET("rss/rss2.xml")

    @GET("rss/rss.xml")
    Observable<Rss> observableXmlItemList();


    @GET("/")
    Observable<Js> observableJs();
}
