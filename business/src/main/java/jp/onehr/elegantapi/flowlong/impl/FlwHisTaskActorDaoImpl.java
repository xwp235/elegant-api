/*
 * Copyright 2023-2025 Licensed under the AGPL License
 */
package jp.onehr.elegantapi.flowlong.impl;

import com.aizuda.bpm.engine.dao.FlwHisTaskActorDao;
import com.aizuda.bpm.engine.entity.FlwHisTaskActor;
import jp.onehr.elegantapi.flowlong.example.FlwHisTaskActorExample;
import jp.onehr.elegantapi.flowlong.mapper.FlwHisTaskActorMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 历史任务参与者数据访问层接口实现类
 *
 * <p>
 * 尊重知识产权，不允许非法使用，后果自负，不允许非法使用，后果自负
 * </p>
 *
 * @author hubin
 * @since 1.0
 */
@Repository("hisTaskActorDao")
public class FlwHisTaskActorDaoImpl implements FlwHisTaskActorDao {
    private final FlwHisTaskActorMapper hisTaskActorMapper;

    public FlwHisTaskActorDaoImpl(FlwHisTaskActorMapper hisTaskActorMapper) {
        this.hisTaskActorMapper = hisTaskActorMapper;
    }

    @Override
    public boolean insert(FlwHisTaskActor hisTaskActor) {
        return hisTaskActorMapper.insert(hisTaskActor) > 0;
    }

    @Override
    public boolean deleteByInstanceIds(List<Long> instanceIds) {
        var flwHisTaskActorExample = new FlwHisTaskActorExample();
        flwHisTaskActorExample.createCriteria().andInstanceIdIn(instanceIds);
        return hisTaskActorMapper.deleteByExample(flwHisTaskActorExample) > 0;
    }

    @Override
    public boolean deleteByTaskId(Long taskId) {
        var flwHisTaskActorExample = new FlwHisTaskActorExample();
        flwHisTaskActorExample.createCriteria().andTaskIdEqualTo(taskId);
        return hisTaskActorMapper.deleteByExample(flwHisTaskActorExample) > 0;
    }

    @Override
    public List<FlwHisTaskActor> selectListByTaskId(Long taskId) {
        var flwHisTaskActorExample = new FlwHisTaskActorExample();
        flwHisTaskActorExample.createCriteria().andTaskIdEqualTo(taskId);
        return hisTaskActorMapper.selectByExample(flwHisTaskActorExample);
    }

    @Override
    public List<FlwHisTaskActor> selectListByTaskIds(List<Long> taskIds) {
        var flwHisTaskActorExample = new FlwHisTaskActorExample();
        flwHisTaskActorExample.createCriteria().andTaskIdIn(taskIds);
        return hisTaskActorMapper.selectByExample(flwHisTaskActorExample);
    }

    @Override
    public List<FlwHisTaskActor> selectListByTaskIdAndActorId(Long taskId, String actorId) {
        var flwHisTaskActorExample = new FlwHisTaskActorExample();
        flwHisTaskActorExample.createCriteria().andTaskIdEqualTo(taskId)
                .andActorIdEqualTo(actorId);
        return hisTaskActorMapper.selectByExample(flwHisTaskActorExample);
    }
}
