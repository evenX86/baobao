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

    List<UserEntity> getAll();

    /**
     * 插入新用户
     * @param user
     */
    void insert(UserEntity user);

    /**
     * 统计用户数
     * @return
     */
    Long countAll();

    /**
     * 通过用户id查找用户
     * @param id
     * @return
     */
    UserEntity getUserByAccount(@Param("id") Integer id);


    UserEntity getUserByAccountAndPasswd(@Param("account") String account, @Param("passwd") String passwd);

    void updateUser(UserEntity userEntity);

    UserEntity getUser(@Param("account") String account);

    void deleteUser(UserEntity entity);
}
