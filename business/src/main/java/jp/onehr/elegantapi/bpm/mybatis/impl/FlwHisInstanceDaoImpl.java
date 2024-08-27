/*
 * Copyright 2023-2025 Licensed under the AGPL License
 */
package jp.onehr.elegantapi.bpm.mybatis.impl;

import jp.onehr.elegantapi.bpm.engine.dao.FlwHisInstanceDao;
import jp.onehr.elegantapi.bpm.engine.entity.FlwHisInstance;
import jp.onehr.elegantapi.bpm.mybatis.example.FlwHisInstanceExample;
import jp.onehr.elegantapi.bpm.mybatis.mapper.FlwHisInstanceMapper;

import java.util.List;

/**
 * 历史流程实例数据访问层接口实现类
 *
 * <p>
 * 尊重知识产权，不允许非法使用，后果自负，不允许非法使用，后果自负
 * </p>
 *
 * @author hubin
 * @since 1.0
 */
public class FlwHisInstanceDaoImpl implements FlwHisInstanceDao {
    private final FlwHisInstanceMapper hisInstanceMapper;

    public FlwHisInstanceDaoImpl(FlwHisInstanceMapper hisInstanceMapper) {
        this.hisInstanceMapper = hisInstanceMapper;
    }

    @Override
    public boolean insert(FlwHisInstance hisInstance) {
        return hisInstanceMapper.insert(hisInstance) > 0;
    }

    @Override
    public boolean deleteByProcessId(Long processId) {
        var flwHisInstanceExample = new FlwHisInstanceExample();
        flwHisInstanceExample.createCriteria().andProcessIdEqualTo(processId);
        return hisInstanceMapper.deleteByExample(flwHisInstanceExample) > 0;
    }

    @Override
    public boolean updateById(FlwHisInstance hisInstance) {
        return hisInstanceMapper.updateByPrimaryKey(hisInstance) > 0;
    }

    @Override
    public FlwHisInstance selectById(Long id) {
        return hisInstanceMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<FlwHisInstance> selectListByProcessId(Long processId) {
        var flwHisInstanceExample = new FlwHisInstanceExample();
        flwHisInstanceExample.createCriteria().andProcessIdEqualTo(processId);
        return hisInstanceMapper.selectByExample(flwHisInstanceExample);
    }
}
