package com.alexura.baobao.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

/**
 * Created with baobao
 *
 * @author xuyifei
 * @date 2019-04-17 9:57 PM
 */
public class ActivityEntity {
    @Excel(name = "活动ID", orderNum = "0")
    private Integer id;
    @Excel(name = "组织名", orderNum = "1")
    private String groupName;
    @Excel(name = "活动地址", orderNum = "2")
    private String actAddr;
    @Excel(name = "活动日期", exportFormat = "yyyy-MM-dd", orderNum = "3")
    private String actDate;
    @Excel(name = "活动人数", orderNum = "4")
    private String actPeopleNum;
    @Excel(name = "结对社区", orderNum = "5")
    private String community;
    @Excel(name = "结对项目", orderNum = "6")
    private String project;
    @Excel(name = "活动简介", orderNum = "7")
    private String introduce;
    @Excel(name = "联系方式", orderNum = "8")
    private String actUserTel;
    @Excel(name = "联系人", orderNum = "9")
    private String actUser;
    @Excel(name = "活动备注", orderNum = "10")
    private String desc;
    private String actImg1;
    private String actImg2;
    private String actImg3;
    private String actImg4;
    @Excel(name = "记录创建时间",exportFormat = "yyyy-MM-dd hh:mm:ss", orderNum = "12")
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

    public String getCommunity() {
        return community;
    }

    public void setCommunity(String community) {
        this.community = community;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}
