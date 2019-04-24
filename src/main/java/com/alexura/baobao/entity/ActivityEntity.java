package com.alexura.baobao.entity;

import java.util.Date;

/**
 * Created with baobao
 *
 * @author xuyifei
 * @date 2019-04-17 9:57 PM
 */
public class ActivityEntity {
    private Integer id;
    private String groupName;
    private String actAddr;
    private String actDate;
    private String actPeopleNum;
    private String actUserTel;
    private String actUser;
    private String desc;
    private String actImg1;
    private String actImg2;
    private String actImg3;
    private String actImg4;
    private Date created;
    private Date modified;


    public ActivityEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getActAddr() {
        return actAddr;
    }

    public void setActAddr(String actAddr) {
        this.actAddr = actAddr;
    }

    public String getActDate() {
        return actDate;
    }

    public void setActDate(String actDate) {
        this.actDate = actDate;
    }

    public String getActPeopleNum() {
        return actPeopleNum;
    }

    public void setActPeopleNum(String actPeopleNum) {
        this.actPeopleNum = actPeopleNum;
    }

    public String getActUserTel() {
        return actUserTel;
    }

    public void setActUserTel(String actUserTel) {
        this.actUserTel = actUserTel;
    }

    public String getActUser() {
        return actUser;
    }

    public void setActUser(String actUser) {
        this.actUser = actUser;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getActImg1() {
        return actImg1;
    }

    public void setActImg1(String actImg1) {
        this.actImg1 = actImg1;
    }

    public String getActImg2() {
        return actImg2;
    }

    public void setActImg2(String actImg2) {
        this.actImg2 = actImg2;
    }

    public String getActImg3() {
        return actImg3;
    }

    public void setActImg3(String actImg3) {
        this.actImg3 = actImg3;
    }

    public String getActImg4() {
        return actImg4;
    }

    public void setActImg4(String actImg4) {
        this.actImg4 = actImg4;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}
