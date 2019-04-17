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
public interface UserMapper {


    @Select("SELECT * FROM alex_user")
    List<UserEntity> getAll();

    @Insert("INSERT INTO alex_user(`name`,tel,created,modified) VALUES(#{name}, #{tel}, now(),now())")
    void insert(UserEntity user);
}
