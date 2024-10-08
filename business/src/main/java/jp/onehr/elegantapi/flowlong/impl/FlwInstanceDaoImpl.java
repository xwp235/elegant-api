/*
 * Copyright 2023-2025 Licensed under the AGPL License
 */
package jp.onehr.elegantapi.flowlong.impl;

import com.aizuda.bpm.engine.dao.FlwInstanceDao;
import com.aizuda.bpm.engine.entity.FlwInstance;
import jp.onehr.elegantapi.flowlong.example.FlwInstanceExample;
import jp.onehr.elegantapi.flowlong.mapper.FlwInstanceMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * 流程实例数据访问层接口实现类
 *
 * <p>
 * 尊重知识产权，不允许非法使用，后果自负，不允许非法使用，后果自负
 * </p>
 *
 * @author hubin
 * @since 1.0
 */
@Repository("instanceDao")
public class FlwInstanceDaoImpl implements FlwInstanceDao {
    private final FlwInstanceMapper instanceMapper;

    public FlwInstanceDaoImpl(FlwInstanceMapper instanceMapper) {
        this.instanceMapper = instanceMapper;
    }

    @Override
    public boolean insert(FlwInstance instance) {
        return instanceMapper.insert(instance) > 0;
    }

    @Override
    public boolean deleteById(Long id) {
        return instanceMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public boolean deleteByProcessId(Long processId) {
        var flwInstanceExample = new FlwInstanceExample();
        flwInstanceExample.createCriteria().andProcessIdEqualTo(processId);
        return instanceMapper.deleteByExample(flwInstanceExample) > 0;
    }

    @Override
    public boolean updateById(FlwInstance instance) {
        return instanceMapper.updateByPrimaryKey(instance) > 0;
    }

    @Override
    public Long selectCountByParentInstanceId(Long parentInstanceId) {
        var flwInstanceExample = new FlwInstanceExample();
        flwInstanceExample.createCriteria().andParentInstanceIdEqualTo(parentInstanceId);
        return instanceMapper.countByExample(flwInstanceExample);
    }

    @Override
    public FlwInstance selectById(Long id) {
        return instanceMapper.selectByPrimaryKey(id);
    }

    @Override
    public Optional<List<FlwInstance>> selectListByParentInstanceId(Long parentInstanceId) {
        var flwInstanceExample = new FlwInstanceExample();
        flwInstanceExample.createCriteria().andParentInstanceIdEqualTo(parentInstanceId);
        return Optional.ofNullable(instanceMapper.selectByExample(flwInstanceExample));
    }
}
