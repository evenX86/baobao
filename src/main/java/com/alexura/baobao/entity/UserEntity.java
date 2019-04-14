package com.alexura.baobao.entity;

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
    private Long id;
    private String name;
    private String tel;
    private String passwd;
    private Long groupId;
    private Date created;
    private Date modified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
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
