package com.alexura.baobao.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.sql.Date;

/**
 * Created with baobao
 *
 * CREATE TABLE `alex_user` (
 *   `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键, 用户id',
 *   `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户名',
 *   `tel` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机号码',
 *   `passwd` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '用户密码',
 *   `group_id` int(10) unsigned DEFAULT NULL COMMENT '所属组织',
 *   `created` datetime DEFAULT NULL COMMENT '创建日期',
 *   `modified` datetime DEFAULT NULL COMMENT '创建日期',
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='用户信息表';
 * @author xuyifei
 * @date 2019-03-17 6:11 PM
 */
public class UserEntity {
    private Integer id;
    /**
     * 账户名
     */
    @Excel(name = "账号名", orderNum = "0")
    private String account;
    /**
     *     社团名
     */
    @Excel(name = "所属组织", orderNum = "1")
    private String groupName;
    /**
     *     联系人
     */
    @Excel(name = "联系人", orderNum = "1")
    private String userName;
    /**
     联系方式
     */
    private String userTel;
    private String passwd;
    private Date created;
    private Date modified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
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
