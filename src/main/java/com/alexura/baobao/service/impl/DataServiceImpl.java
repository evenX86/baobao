package com.alexura.baobao.service.impl;

import com.alexura.baobao.entity.ActivityEntity;
import com.alexura.baobao.entity.UserEntity;
import com.alexura.baobao.mapper.ActivityMapper;
import com.alexura.baobao.service.DataService;
import com.alexura.baobao.utils.JsonUtil;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with baobao
 *
 * @author xuyifei
 * @date 2019-04-17 9:56 PM
 */
@Service
public class DataServiceImpl implements DataService {
    private static final Logger log = LoggerFactory.getLogger(DataServiceImpl.class);
    @Autowired
    private ActivityMapper activityMapper;
    @Override
    public void addActivity(ActivityEntity activity) {
        activityMapper.insert(activity);
    }

    @Override
    public List<ActivityEntity> listActivity() {
        return activityMapper.getAll();
    }

    @Override
    public List<ActivityEntity> listActivity(String groupName) {
        return activityMapper.getAllByGroup(groupName);
    }

    @Override
    public Long countAll() {
        return  activityMapper.countAll();

    }

    @Override
    public Long countAllGroup() {
        return activityMapper.countAllGroup();
    }

    @Override
    public List<Map<String,Object>> queryGroupNum() {
        return activityMapper.queryGroupNum();
    }

    @Override
    public ActivityEntity getActById(Integer actIdVal) {
        ActivityEntity activityEntity = activityMapper.getActById(actIdVal);
       return activityEntity;
    }

    @Override
    public void delActById(Integer actIdVal) {
        activityMapper.delActById(actIdVal);

    }

    @Override
    public void updateActivity(ActivityEntity activityEntity) {
        activityMapper.update(activityEntity);
    }

    @Override
    public List<ActivityEntity> queryActByOpt(Date d1, Date d2, String groupOpt, String communityOpt, UserEntity userEntity) {
        if ("全部".equals(groupOpt)) {
            groupOpt = null;
        }
        if ("全部".equals(communityOpt)) {
            communityOpt = null;
        }
        if (!"admin".equals(userEntity.getAccount())) {
            groupOpt = userEntity.getGroupName();
        }
        return activityMapper.queryActList(d1,d2,groupOpt,communityOpt);
    }

    @Override
    public List<String> getCommunityList() {
        return activityMapper.getCommunityList();
    }

    @Override
    public List<ActivityEntity> listPreActivity() {
        return activityMapper.listPreActivity();
    }
}
