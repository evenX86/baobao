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


    @Select("SELECT * FROM alex_user")
    List<UserEntity> getAll();

    @Insert("INSERT INTO alex_user(`account`,user_name,user_tel,passwd,group_name,created,modified) VALUES(#{account}, #{userName},#{userTel},#{passwd},#{groupName}, now(),now())")
    void insert(UserEntity user);
}
