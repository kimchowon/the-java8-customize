package com.chocho.study.chapter06;

public class OnlineClass {

    private Integer id;

    private String title;

    private boolean closed;

    public OnlineClass(Integer id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }
    
    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isClosed() {
        return closed;
    }

    @Override
    public String toString() {
        return "OnlineClass{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", closed=" + closed +
                '}';
    }
}
