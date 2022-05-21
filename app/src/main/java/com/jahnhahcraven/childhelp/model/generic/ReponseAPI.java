package com.jahnhahcraven.childhelp.model.generic;

import android.util.Log;

import com.google.gson.Gson;
import com.jahnhahcraven.childhelp.model.User;

import java.util.ArrayList;
import java.util.List;

public class ReponseAPI {
    private Object data;
    private String message;
    private Integer status;

    public ReponseAPI() {
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
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

    public ArrayList fomraterArrayJSONObject(ArrayList<Object> jsonType, Class classes){
        Gson gson = new Gson();
        for (int counter = 0; counter < jsonType.size(); counter++) {
            Object obj = gson.fromJson(gson.toJson(jsonType.get(counter)),classes);
            jsonType.set(counter,obj);
        }
        return jsonType;
    }
}
