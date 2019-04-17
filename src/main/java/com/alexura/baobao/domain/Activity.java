package com.alexura.baobao.domain;

import java.util.Date;

/**
 * Created with baobao
 *
 * @author xuyifei
 * @date 2019-04-17 9:57 PM
 */
public class Activity {
    private Integer id;
    private String name;
    private String addr;
    private String num;
    private String contacts;
    private String tel;
    private String desc;
    private String img;
    private String date;

    public Activity(String name, String addr, String num, String contacts, String tel, String desc, String img, String date) {
        this.name = name;
        this.addr = addr;
        this.num = num;
        this.contacts = contacts;
        this.tel = tel;
        this.desc = desc;
        this.img = img;
        this.date = date;
    }

    public Activity() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
