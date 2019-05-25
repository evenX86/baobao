package com.alexura.baobao.service.impl;

import com.alexura.baobao.entity.ActivityEntity;
import com.alexura.baobao.mapper.ActivityMapper;
import com.alexura.baobao.service.DataService;
import com.alexura.baobao.utils.JsonUtil;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        List<ActivityEntity> result = activityMapper.getAll();
        for (ActivityEntity activityEntity : result) {
            if (activityEntity.getActImg1() != null && !activityEntity.getActImg1().contains("static")) {
                activityEntity.setActImg1("static/img/"+activityEntity.getActImg1());
            }
            if (activityEntity.getActImg2() != null && !activityEntity.getActImg2().contains("static")) {
                activityEntity.setActImg2("static/img/"+activityEntity.getActImg2());
            }
            if (activityEntity.getActImg3() != null && !activityEntity.getActImg3().contains("static")) {
                activityEntity.setActImg3("static/img/"+activityEntity.getActImg3());
            }
            if (activityEntity.getActImg4() != null && !activityEntity.getActImg4().contains("static")) {
                activityEntity.setActImg4("static/img/"+activityEntity.getActImg4());
            }
        }
        return  result;
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
}
