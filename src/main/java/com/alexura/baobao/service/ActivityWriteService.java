package com.alexura.baobao.service;

import com.alexura.baobao.entity.ActivityEntity;

/**
 * Created with baobao
 *
 * 活动写入服务
 * @author xuyifei
 * @date 2019-07-21 5:35 PM
 */
public interface ActivityWriteService {
    public void addActivity(ActivityEntity activity);
    public void addActivityPre(ActivityEntity activity);
}
