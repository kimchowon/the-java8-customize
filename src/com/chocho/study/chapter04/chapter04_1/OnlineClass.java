package com.chocho.study.chapter04.chapter04_1;

import java.util.Optional;

public class OnlineClass {

    private Integer id;

    private String title;

    private boolean isClosed;

    private Progress progress;

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

    public Progress getProgress() {
        return progress;
    }

    public void setProgress(Optional<Progress> progress) {
        if (progress != null) {
            progress.ifPresent(p -> this.progress = p);
        }
    }
}
