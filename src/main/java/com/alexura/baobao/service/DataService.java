package com.alexura.baobao.service;

import com.alexura.baobao.entity.ActivityEntity;

import java.util.List;

/**
 * Created with baobao
 *
 * @author xuyifei
 * @date 2019-04-17 9:56 PM
 */
public interface DataService {
    public void addActivity(ActivityEntity activity);
    public List<ActivityEntity> listActivity();
    public Long countAll();
    public Long countAllGroup();
}
