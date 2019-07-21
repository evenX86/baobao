package com.alexura.baobao.service.impl;

import com.alexura.baobao.entity.ActivityEntity;
import com.alexura.baobao.mapper.ActivityMapper;
import com.alexura.baobao.service.ActivityWriteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created with baobao
 *
 * @author xuyifei
 * @date 2019-07-21 5:35 PM
 */
@Service
public class ActivityWriteServiceImpl implements ActivityWriteService {
    private static final Logger log = LoggerFactory.getLogger(ActivityWriteServiceImpl.class);
    private ActivityMapper activityMapper;


    @Override
    public void addActivity(ActivityEntity activity) {

    }

    @Override
    public void addActivityPre(ActivityEntity activity) {
        activityMapper.insertPreActInfo(activity);

    }
}
