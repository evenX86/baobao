package com.alexura.baobao.mapper;

import com.alexura.baobao.entity.ActivityEntity;
import org.apache.ibatis.annotations.*;

import java.util.Date;
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
    void insert(ActivityEntity activityEntity);

    List<ActivityEntity> getAll();

    Long countAll();

    Long countAllGroup();

    List<Map<String, Object>> queryGroupNum();

    ActivityEntity getActById(@Param("actId") Integer actId);

    void delActById(@Param("actId") Integer actIdVal);

    void update(ActivityEntity activityEntity);

    List<ActivityEntity> getAllByGroup(@Param("groupName") String groupName);

    List<ActivityEntity> queryActList(@Param("st") Date d1, @Param("et") Date d2, @Param("search") String groupOpt);
}
