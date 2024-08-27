/*
 * Copyright 2023-2025 Licensed under the AGPL License
 */
package jp.onehr.elegantapi.bpm.mybatis.impl;

import jp.onehr.elegantapi.bpm.engine.dao.FlwExtInstanceDao;
import jp.onehr.elegantapi.bpm.engine.entity.FlwExtInstance;
import jp.onehr.elegantapi.bpm.mybatis.example.FlwExtInstanceExample;
import jp.onehr.elegantapi.bpm.mybatis.mapper.FlwExtInstanceMapper;

/**
 * 扩展流程实例数据访问层接口实现类
 *
 * <p>
 * 尊重知识产权，不允许非法使用，后果自负，不允许非法使用，后果自负
 * </p>
 *
 * @author hubin
 * @since 1.0
 */
public class FlwExtInstanceDaoImpl implements FlwExtInstanceDao {
    private final FlwExtInstanceMapper extInstanceMapper;

    public FlwExtInstanceDaoImpl(FlwExtInstanceMapper extInstanceMapper) {
        this.extInstanceMapper = extInstanceMapper;
    }

    @Override
    public boolean insert(FlwExtInstance extInstance) {
        return extInstanceMapper.insert(extInstance) > 0;
    }

    @Override
    public boolean deleteByProcessId(Long processId) {
        var flwExtInstanceExample = new FlwExtInstanceExample();
        flwExtInstanceExample.createCriteria().andProcessIdEqualTo(processId);
        return extInstanceMapper.deleteByExample(flwExtInstanceExample) > 0;
    }

    @Override
    public boolean updateById(FlwExtInstance extInstance) {
        return extInstanceMapper.updateByPrimaryKey(extInstance) > 0;
    }

    @Override
    public FlwExtInstance selectById(Long id) {
        return extInstanceMapper.selectByPrimaryKey(id);
    }
}
