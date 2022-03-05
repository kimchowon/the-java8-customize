package com.chocho.study.chapter04.chapter04_2;

public class OnlineClass {
    private Integer id;

    private String title;

    private boolean isClosed;

    public OnlineClass(Integer id, String title, boolean isClosed) {
        this.id = id;
        this.title = title;
        this.isClosed = isClosed;
    }

    public OnlineClass() {
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }
}
