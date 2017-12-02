package com.rkurban.myapplication.part.web.rss;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by rkurban on 08/11/2017.
 */

@Root(name = "task")
public class Task {
    @Element(name = "id")
    private long id;

    @Element(name = "title")
    private String title;

    @Element(name = "description")
    private String description;

    @Element(name = "languagede")
    private String languagede;

    @Attribute(required = false)
    private String link;

    public Task() {
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLanguagede() {
        return languagede;
    }

    public String getLink() {
        return link;
    }
}