/*
 * Copyright 2023-2025 Licensed under the AGPL License
 */
package jp.onehr.elegantapi.flowlong.impl;

import com.aizuda.bpm.engine.dao.FlwTaskActorDao;
import com.aizuda.bpm.engine.entity.FlwTaskActor;
import jp.onehr.elegantapi.flowlong.example.FlwTaskActorExample;
import jp.onehr.elegantapi.flowlong.mapper.FlwTaskActorMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 任务参与者数据访问层接口实现类
 *
 * <p>
 * 尊重知识产权，不允许非法使用，后果自负，不允许非法使用，后果自负
 * </p>
 *
 * @author hubin
 * @since 1.0
 */
@Repository("taskActorDao")
public class FlwTaskActorDaoImpl implements FlwTaskActorDao {
    private final FlwTaskActorMapper taskActorMapper;

    public FlwTaskActorDaoImpl(FlwTaskActorMapper taskActorMapper) {
        this.taskActorMapper = taskActorMapper;
    }

    @Override
    public boolean insert(FlwTaskActor taskActor) {
        return taskActorMapper.insert(taskActor) > 0;
    }

    @Override
    public boolean deleteById(Long id) {
        return taskActorMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public boolean deleteByIds(List<Long> ids) {
        var flwTaskActorExample = new FlwTaskActorExample();
        flwTaskActorExample.createCriteria().andIdIn(ids);
        return taskActorMapper.deleteByExample(flwTaskActorExample) > 0;
    }

    @Override
    public boolean deleteByTaskId(Long taskId) {
        var flwTaskActorExample = new FlwTaskActorExample();
        flwTaskActorExample.createCriteria().andTaskIdEqualTo(taskId);
        return taskActorMapper.deleteByExample(flwTaskActorExample) > 0;
    }

    @Override
    public boolean deleteByInstanceIds(List<Long> instanceIds) {
        var flwTaskActorExample = new FlwTaskActorExample();
        flwTaskActorExample.createCriteria().andInstanceIdIn(instanceIds);
        return taskActorMapper.deleteByExample(flwTaskActorExample) > 0;
    }

    @Override
    public boolean deleteByTaskIdAndAgentType(Long taskId, int agentType) {
        var flwTaskActorExample = new FlwTaskActorExample();
        flwTaskActorExample.createCriteria().andTaskIdEqualTo(taskId).andAgentTypeEqualTo(agentType);
        return taskActorMapper.deleteByExample(flwTaskActorExample) > 0;
    }

    @Override
    public boolean deleteByTaskIdAndActorIds(Long taskId, List<String> actorIds) {
        var flwTaskActorExample = new FlwTaskActorExample();
        flwTaskActorExample.createCriteria().andTaskIdEqualTo(taskId).andActorIdIn(actorIds);
        return taskActorMapper.deleteByExample(flwTaskActorExample) > 0;
    }

    @Override
    public boolean updateById(FlwTaskActor taskActor) {
        return taskActorMapper.updateByPrimaryKey(taskActor) > 0;
    }

    @Override
    public List<FlwTaskActor> selectListByInstanceId(Long instanceId) {
        var flwTaskActorExample = new FlwTaskActorExample();
        flwTaskActorExample.createCriteria().andInstanceIdEqualTo(instanceId);
        return taskActorMapper.selectByExample(flwTaskActorExample);
    }

    @Override
    public List<FlwTaskActor> selectListByTaskId(Long taskId) {
        var flwTaskActorExample = new FlwTaskActorExample();
        flwTaskActorExample.createCriteria().andTaskIdEqualTo(taskId);
        return taskActorMapper.selectByExample(flwTaskActorExample);
    }

    @Override
    public List<FlwTaskActor> selectListByTaskIds(List<Long> taskIds) {
        var flwTaskActorExample = new FlwTaskActorExample();
        flwTaskActorExample.createCriteria().andTaskIdIn(taskIds);
        return taskActorMapper.selectByExample(flwTaskActorExample);
    }

    @Override
    public List<FlwTaskActor> selectListByTaskIdAndActorId(Long taskId, String actorId) {
        var flwTaskActorExample = new FlwTaskActorExample();
        flwTaskActorExample.createCriteria().andTaskIdEqualTo(taskId).andActorIdEqualTo(actorId);
        return taskActorMapper.selectByExample(flwTaskActorExample);
    }

    @Override
    public Long selectCountByTaskIdAndActorId(Long taskId, String actorId) {
        var flwTaskActorExample = new FlwTaskActorExample();
        flwTaskActorExample.createCriteria().andTaskIdEqualTo(taskId).andActorIdEqualTo(actorId);
        return taskActorMapper.countByExample(flwTaskActorExample);
    }
}
