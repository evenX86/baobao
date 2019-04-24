package com.alexura.baobao.mapper;

import com.alexura.baobao.entity.ActivityEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * Created with baobao
 *
 * @author xuyifei
 * @date 2019-04-24 1:11 AM
 */
@Mapper
public interface ActivityMapper {
    @Insert("INSERT INTO alex_activity(`group_name`,act_addr,act_date,act_people_num,act_user_tel,act_user,`desc`,act_img1,act_img2,act_img3,act_img4,created,modified)" +
            " VALUES(#{groupName}, #{actAddr},#{actDate},#{actPeopleNum},#{actUserTel},#{actUser},#{desc},#{actImg1},#{actImg2},#{actImg3},#{actImg4}, now(),now())")
    void insert(ActivityEntity activityEntity);


    @Select("SELECT id, `group_name`,act_addr,act_date,act_people_num,act_user_tel,act_user,`desc`,act_img1,act_img2,act_img3,act_img4,created,modified  FROM alex_activity")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "groupName", column = "group_name"),
            @Result(property = "actAddr", column = "act_addr"),
            @Result(property = "actDate", column = "act_date"),
            @Result(property = "actPeopleNum", column = "act_people_num"),
            @Result(property = "actUserTel", column = "act_user_tel"),
            @Result(property = "actUser", column = "act_user"),
            @Result(property = "desc", column = "desc"),
            @Result(property = "actImg1", column = "act_img1"),
            @Result(property = "actImg2", column = "act_img2"),
            @Result(property = "actImg3", column = "act_img3"),
            @Result(property = "actImg4", column = "act_img4"),
            @Result(property = "created", column = "created"),
            @Result(property = "modified", column = "modified")
    })
    List<ActivityEntity> getAll();

    @Select("select count(*) from alex_activity")
    Long countAll();

    @Select("SELECT count(DISTINCT group_name) from alex_activity")
    Long countAllGroup();

    @Select("SELECT count(*) as cnt,group_name from alex_activity group by group_name")
    List<Map<String, Object>> queryGroupNum();

}
