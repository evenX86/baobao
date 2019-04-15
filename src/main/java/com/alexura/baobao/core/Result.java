package com.alexura.baobao.core;

import java.util.Map;

/**
 * Created with baobao
 *
 * @author xuyifei
 * @date 2019-04-14 7:16 PM
 */
public class Result {
    private Integer code;
    private String message;
    private Map<String, Object> data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
