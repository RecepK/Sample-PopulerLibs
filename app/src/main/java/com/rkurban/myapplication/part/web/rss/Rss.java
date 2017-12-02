package com.rkurban.myapplication.part.web.rss;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by rkurban on 08/11/2017.
 */

@Root(name = "rss")
public class Rss {

    public Rss() {
    }

    @Element(name = "task")
    private Task task;

    public Task getTask() {
        return task;
    }
}
