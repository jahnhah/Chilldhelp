package com.jahnhahcraven.childhelp.model.generic;

import java.util.List;

public class ReponseAPI {
    private List<Object> data;
    private String message;
    private Integer status;

    public ReponseAPI() {
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
