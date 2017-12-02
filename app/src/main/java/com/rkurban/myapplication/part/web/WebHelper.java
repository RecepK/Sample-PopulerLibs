package com.rkurban.myapplication.part.web;

import com.rkurban.myapplication.part.web.rss.Js;
import com.rkurban.myapplication.part.web.rss.Rss;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rkurban on 08/11/2017.
 */

public class WebHelper {

    //private static String API_BASE_URL = "http://us2.campaign-archive1.com/feed?u=887caf4f48db76fd91e20a06d&id=4eb677ad19";
    //private static String API_BASE_URL = "https://www.w3schools.com";
    //private static String API_BASE_URL = "http://www.json-generator.com/api/json/get/";

    private static String API_BASE_URL = "http://ip.jsontest.com/";

    private static WebHelper helperClient;
    private WebService client;

    public WebService getClient() {
        if (client == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    //.addConverterFactory(SimpleXmlConverterFactory.create())
                    //.client(new OkHttpClient.Builder().build())
                    .build();
            client = retrofit.create(WebService.class);
        }
        return client;
    }

    /*private static OkHttpClient getOkHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        // add your other interceptors
        // add logging as last interceptor
        httpClient.addInterceptor(logging);
        return httpClient.build();
    }*/

    /*
    public Observable<List<>> getObservableList() {
        return getClient().observableItemList()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<BreakFastMenu> getObservableXmlList0() {
        return getClient().observableXmlItemList()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }*/

    public Observable<Rss> getObservableXmlList() {
        return getClient().observableXmlItemList()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Js> getObservableJs() {
        return getClient().observableJs()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }



    /*
    xml:
    https://codebeautify.org/xmlviewer
    link:
    http://us2.campaign-archive1.com/feed?u=887caf4f48db76fd91e20a06d&id=4eb677ad19


    http://gradleplease.appspot.com/#com.android.support%3Aappcompat-v7%3A


    //retrofit
    http://square.github.io/retrofit/
    https://futurestud.io/tutorials/retrofit-getting-started-and-android-client


    //RxAndroid
    https://github.com/ReactiveX/RxAndroid
    */
}
