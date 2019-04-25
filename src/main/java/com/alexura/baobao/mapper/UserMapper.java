package com.alexura.baobao.mapper;

import com.alexura.baobao.entity.UserEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created with baobao
 *
 * @author xuyifei
 * @date 2019-03-17 6:10 PM
 */
@Mapper
public interface UserMapper {


    @Select("SELECT id,account,user_name,user_tel,group_name,created,modified FROM alex_user")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "account", column = "account"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userTel", column = "user_tel"),
            @Result(property = "groupName", column = "group_name"),
            @Result(property = "created", column = "created"),
            @Result(property = "modified", column = "modified")
    })
    List<UserEntity> getAll();

    @Insert("INSERT INTO alex_user(`account`,user_name,user_tel,passwd,group_name,created,modified) VALUES(#{account}, #{userName},#{userTel},#{passwd},#{groupName}, now(),now())")
    @SelectKey(statement="select LAST_INSERT_ID()", keyProperty="id", before=false, resultType=int.class)
    void insert(UserEntity user);

    @Select("select count(*) from alex_user")
    Long countAll();

    @Select("SELECT id,account,user_name,user_tel,group_name,created,modified FROM alex_user where id =#{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "account", column = "account"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userTel", column = "user_tel"),
            @Result(property = "groupName", column = "group_name"),
            @Result(property = "created", column = "created"),
            @Result(property = "modified", column = "modified")
    })
    UserEntity getUserByAccount(Integer id);

    @Select("SELECT id,account,user_name,user_tel,group_name,created,modified FROM alex_user where account =#{account} and passwd=#{passwd}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "account", column = "account"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userTel", column = "user_tel"),
            @Result(property = "groupName", column = "group_name"),
            @Result(property = "created", column = "created"),
            @Result(property = "modified", column = "modified")
    })
    UserEntity getUserByAccountAndPasswd(String account, String passwd);
}
