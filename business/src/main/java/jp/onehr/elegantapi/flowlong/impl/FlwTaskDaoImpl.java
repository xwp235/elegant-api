/*
 * Copyright 2023-2025 Licensed under the AGPL License
 */
package jp.onehr.elegantapi.flowlong.impl;

import com.aizuda.bpm.engine.dao.FlwTaskDao;
import com.aizuda.bpm.engine.entity.FlwTask;
import jp.onehr.elegantapi.flowlong.example.FlwTaskExample;
import jp.onehr.elegantapi.flowlong.mapper.FlwTaskMapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 任务数据访问层接口实现类
 *
 * <p>
 * 尊重知识产权，不允许非法使用，后果自负，不允许非法使用，后果自负
 * </p>
 *
 * @author hubin
 * @since 1.0
 */
@Repository("taskDao")
public class FlwTaskDaoImpl implements FlwTaskDao {
    private final FlwTaskMapper taskMapper;

    public FlwTaskDaoImpl(FlwTaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    @Override
    public boolean insert(FlwTask flwTask) {
        return taskMapper.insert(flwTask) > 0;
    }

    @Override
    public boolean deleteById(Long id) {
        return taskMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public boolean deleteByInstanceIds(List<Long> instanceIds) {
        var flwTaskExample = new FlwTaskExample();
        flwTaskExample.createCriteria().andInstanceIdIn(instanceIds);
        return taskMapper.deleteByExample(flwTaskExample) > 0;
    }

    @Override
    public boolean deleteByIds(List<Long> ids) {
        var flwTaskExample = new FlwTaskExample();
        flwTaskExample.createCriteria().andIdIn(ids);
        return taskMapper.deleteByExample(flwTaskExample) > 0;
    }

    @Override
    public boolean updateById(FlwTask flwTask) {
        return taskMapper.updateByPrimaryKey(flwTask) > 0;
    }

    @Override
    public FlwTask selectById(Long id) {
        return taskMapper.selectByPrimaryKey(id);
    }

    @Override
    public Long selectCountByParentTaskId(Long parentTaskId) {
        return taskMapper.selectCountByParentTaskId(parentTaskId);
    }

    @Override
    public List<FlwTask> selectListByInstanceId(Long instanceId) {
        var flwTaskExample = new FlwTaskExample();
        flwTaskExample.createCriteria().andInstanceIdEqualTo(instanceId);
        return taskMapper.selectByExample(flwTaskExample);
    }

    @Override
    public List<FlwTask> selectListByInstanceIdAndTaskName(Long instanceId, String taskName) {
        var flwTaskExample = new FlwTaskExample();
        flwTaskExample.createCriteria().andInstanceIdEqualTo(instanceId).andTaskNameEqualTo(taskName);
        return taskMapper.selectByExample(flwTaskExample);
    }

    @Override
    public List<FlwTask> selectListByInstanceIdAndTaskKey(Long instanceId, String taskKey) {
        var flwTaskExample = new FlwTaskExample();
        flwTaskExample.createCriteria().andInstanceIdEqualTo(instanceId).andTaskKeyEqualTo(taskKey);
        return taskMapper.selectByExample(flwTaskExample);
    }

    @Override
    public List<FlwTask> selectListByInstanceIdAndTaskNames(Long instanceId, List<String> taskNames) {
        var flwTaskExample = new FlwTaskExample();
        flwTaskExample.createCriteria().andInstanceIdEqualTo(instanceId)
                .andTaskNameIn(taskNames);
        return taskMapper.selectByExample(flwTaskExample);
    }

    @Override
    public List<FlwTask> selectListTimeoutOrRemindTasks(Date currentDate) {
        var flwTaskExample = new FlwTaskExample();
        flwTaskExample.createCriteria().andExpireTimeLessThanOrEqualTo(currentDate);
        flwTaskExample.or().andRemindTimeLessThanOrEqualTo(currentDate);
        return taskMapper.selectByExample(flwTaskExample);
    }

    @Override
    public List<FlwTask> selectListByParentTaskId(Long parentTaskId) {
        var flwTaskExample = new FlwTaskExample();
        flwTaskExample.createCriteria().andParentTaskIdEqualTo(parentTaskId);
        return taskMapper.selectByExample(flwTaskExample);
    }

    @Override
    public List<FlwTask> selectListByParentTaskIds(List<Long> parentTaskIds) {
        var flwTaskExample = new FlwTaskExample();
        flwTaskExample.createCriteria().andParentTaskIdIn(parentTaskIds);
        return taskMapper.selectByExample(flwTaskExample );
    }
}
