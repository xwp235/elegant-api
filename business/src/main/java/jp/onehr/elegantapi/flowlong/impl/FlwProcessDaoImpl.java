/*
 * Copyright 2023-2025 Licensed under the AGPL License
 */
package jp.onehr.elegantapi.flowlong.impl;

import com.aizuda.bpm.engine.dao.FlwProcessDao;
import com.aizuda.bpm.engine.entity.FlwProcess;
import jp.onehr.elegantapi.flowlong.example.FlwProcessExample;
import jp.onehr.elegantapi.flowlong.mapper.FlwProcessMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 流程定义数据访问层接口实现类
 *
 * <p>
 * 尊重知识产权，不允许非法使用，后果自负，不允许非法使用，后果自负
 * </p>
 *
 * @author hubin
 * @since 1.0
 */
@Repository("processDao")
public class FlwProcessDaoImpl implements FlwProcessDao {
    private final FlwProcessMapper processMapper;

    public FlwProcessDaoImpl(FlwProcessMapper processMapper) {
        this.processMapper = processMapper;
    }

    @Override
    public boolean insert(FlwProcess process) {
        return processMapper.insert(process) > 0;
    }

    @Override
    public boolean deleteById(Long id) {
        return processMapper.deleteByPrimaryKey(id) > 0;
    }

    @Override
    public boolean updateById(FlwProcess process) {
        return processMapper.updateByPrimaryKey(process) > 0;
    }

    @Override
    public boolean updateByProcessKey(FlwProcess process, String tenantId, String processKey) {
        var flwProcessExample = new FlwProcessExample();
        flwProcessExample.createCriteria().andProcessKeyEqualTo(processKey);
        if (null!=tenantId){
            flwProcessExample.createCriteria().andTenantIdEqualTo(tenantId);
        }
        return processMapper.updateByExampleSelective(process, flwProcessExample) > 0;
    }

    @Override
    public FlwProcess selectById(Long id) {
        return processMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<FlwProcess> selectListByProcessKeyAndVersion(String tenantId, String processKey, Integer version) {

        var flwProcessExample = new FlwProcessExample();
        var criteria = flwProcessExample.createCriteria().andProcessKeyEqualTo(processKey);
        if (null != tenantId) {
            criteria.andTenantIdEqualTo(tenantId);
        }
        if (null != version) {
            criteria.andProcessVersionEqualTo(version);
        } else {
            flwProcessExample.setOrderByClause("process_version desc");
        }
        return processMapper.selectByExample(flwProcessExample);
    }
}
