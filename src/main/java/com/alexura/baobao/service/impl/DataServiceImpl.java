package com.alexura.baobao.service.impl;

import com.alexura.baobao.domain.Activity;
import com.alexura.baobao.service.DataService;
import javafx.scene.chart.PieChart;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

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

    private List<Activity> activityList = new ArrayList<>();

    @Override
    public void addActivity(Activity activity) {
        if (activityList == null) {
            activityList = new ArrayList<>();
        }
        int size = activityList.size();
        activity.setId(size+1);
        activityList.add(activity);
    }

    @Override
    public List<Activity> listActivity() {
        return activityList;
    }
}
