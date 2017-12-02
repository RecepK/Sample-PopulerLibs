package com.rkurban.myapplication.part.rx;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by user on 2.12.2017.
 */

public class Rxx {

    public String Test() {
        return "test";
    }

    public Observable<List<String>> getObservableList() {
        return Observable.just(getList())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private List<String> getList() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        return list;
    }

}
