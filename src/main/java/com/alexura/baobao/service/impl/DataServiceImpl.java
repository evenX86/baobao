package com.alexura.baobao.service.impl;

import com.alexura.baobao.entity.ActivityEntity;
import com.alexura.baobao.mapper.ActivityMapper;
import com.alexura.baobao.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with baobao
 *
 * @author xuyifei
 * @date 2019-04-17 9:56 PM
 */
@Service
public class DataServiceImpl implements DataService {
    @Autowired
    private ActivityMapper activityMapper;
    @Override
    public void addActivity(ActivityEntity activity) {
        activityMapper.insert(activity);
    }

    @Override
    public List<ActivityEntity> listActivity() {
        return  activityMapper.getAll();
    }
}
