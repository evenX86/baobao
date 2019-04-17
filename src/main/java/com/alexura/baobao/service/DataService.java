package com.alexura.baobao.service;

import com.alexura.baobao.domain.Activity;

import java.util.List;

/**
 * Created with baobao
 *
 * @author xuyifei
 * @date 2019-04-17 9:56 PM
 */
public interface DataService {
    public void addActivity(Activity activity);
    public List<Activity> listActivity();
}
