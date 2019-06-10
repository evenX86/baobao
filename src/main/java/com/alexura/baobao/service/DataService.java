package com.alexura.baobao.service;

import com.alexura.baobao.entity.ActivityEntity;
import com.alexura.baobao.entity.UserEntity;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created with baobao
 *
 * @author xuyifei
 * @date 2019-04-17 9:56 PM
 */
public interface DataService {
    public void addActivity(ActivityEntity activity);
    public List<ActivityEntity> listActivity();
    public List<ActivityEntity> listActivity(String groupName);
    public Long countAll();
    public Long countAllGroup();
    public List<Map<String, Object>> queryGroupNum();

    ActivityEntity getActById(Integer actIdVal);

    void delActById(Integer actIdVal);

    void updateActivity(ActivityEntity activityEntity);

    List<ActivityEntity> queryActByOpt(Date d1, Date d2, String groupOpt,String communityOpt, UserEntity userEntity);

    List<String> getCommunityList();
}
