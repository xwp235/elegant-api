/*
 * Copyright 2023-2025 Licensed under the AGPL License
 */
package jp.onehr.elegantapi.bpm.mybatis.impl;


import jp.onehr.elegantapi.bpm.engine.dao.FlwHisTaskDao;
import jp.onehr.elegantapi.bpm.engine.entity.FlwHisTask;
import jp.onehr.elegantapi.bpm.mybatis.example.FlwHisTaskExample;
import jp.onehr.elegantapi.bpm.mybatis.mapper.FlwHisTaskMapper;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * 历史任务数据访问层接口实现类
 *
 * <p>
 * 尊重知识产权，不允许非法使用，后果自负，不允许非法使用，后果自负
 * </p>
 *
 * @author hubin
 * @since 1.0
 */
public class FlwHisTaskDaoImpl implements FlwHisTaskDao {
    private final FlwHisTaskMapper hisTaskMapper;

    public FlwHisTaskDaoImpl(FlwHisTaskMapper hisTaskMapper) {
        this.hisTaskMapper = hisTaskMapper;
    }

    @Override
    public boolean insert(FlwHisTask hisTask) {
        return hisTaskMapper.insert(hisTask) > 0;
    }

    @Override
    public boolean deleteById(Long id) {
        return hisTaskMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public boolean deleteByInstanceIds(List<Long> instanceIds) {
        var flwHisTaskExample = new FlwHisTaskExample();
        flwHisTaskExample.createCriteria().andInstanceIdIn(instanceIds);
        return hisTaskMapper.deleteByExample(flwHisTaskExample) > 0;
    }

    @Override
    public boolean updateById(FlwHisTask hisTask) {
        return hisTaskMapper.updateByPrimaryKey(hisTask) > 0;
    }

    @Override
    public FlwHisTask selectById(Long id) {
        return hisTaskMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<FlwHisTask> selectListByInstanceIdAndTaskName(Long instanceId, String taskName) {
        var flwHisTaskExample = new FlwHisTaskExample();
        flwHisTaskExample.createCriteria().andInstanceIdEqualTo(instanceId).andTaskNameEqualTo(taskName);
        return hisTaskMapper.selectByExample(flwHisTaskExample);
    }

    @Override
    public Optional<List<FlwHisTask>> selectListByInstanceId(Long instanceId) {
        var flwHisTaskExample = new FlwHisTaskExample();
        flwHisTaskExample.createCriteria().andInstanceIdEqualTo(instanceId);
        return Optional.ofNullable(hisTaskMapper.selectByExample(flwHisTaskExample));
    }

    @Override
    public List<FlwHisTask> selectListByCallProcessIdAndCallInstanceId(Long callProcessId, Long callInstanceId) {
        var flwHisTaskExample = new FlwHisTaskExample();
        flwHisTaskExample.createCriteria().andCallProcessIdEqualTo(callProcessId)
                .andCallInstanceIdEqualTo(callInstanceId);
        return hisTaskMapper.selectByExample(flwHisTaskExample);
    }

    @Override
    public List<FlwHisTask> selectListByParentTaskId(Long parentTaskId) {
        var flwHisTaskExample = new FlwHisTaskExample();
        flwHisTaskExample.createCriteria().andParentTaskIdEqualTo(parentTaskId);
        return hisTaskMapper.selectByExample(flwHisTaskExample);
    }

    @Override
    public Collection<FlwHisTask> selectListByInstanceIdAndTaskNameAndParentTaskId(Long instanceId, String taskName, Long parentTaskId) {
        var flwHisTaskExample = new FlwHisTaskExample();
        flwHisTaskExample.createCriteria().andInstanceIdEqualTo(instanceId)
                .andTaskNameEqualTo(taskName)
                .andParentTaskIdEqualTo(parentTaskId);
        return hisTaskMapper.selectByExample(flwHisTaskExample);
    }
}
