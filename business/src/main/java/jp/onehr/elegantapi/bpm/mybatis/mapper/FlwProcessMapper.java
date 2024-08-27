/*
 * Copyright 2023-2025 Licensed under the AGPL License
 */
package jp.onehr.elegantapi.bpm.mybatis.mapper;

import cn.hutool.core.util.StrUtil;
import jp.onehr.elegantapi.bpm.engine.entity.FlwProcess;
import jp.onehr.elegantapi.bpm.mybatis.example.FlwProcessExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 流程定义 Mapper
 *
 * <p>
 * 尊重知识产权，不允许非法使用，后果自负
 * </p>
 *
 * @author hubin
 * @since 1.0
 */
public interface FlwProcessMapper {

    default List<FlwProcess> selectListByProcessKey(String tenantId, String processKey) {
        var flwProcessExample = new FlwProcessExample();
        var criteria = flwProcessExample.createCriteria().andProcessKeyEqualTo(processKey);
        if (StrUtil.isNotBlank(tenantId)) {
            criteria.andTenantIdEqualTo(tenantId);
        }
        flwProcessExample.setOrderByClause("process_version desc");
        return this.selectByExample(flwProcessExample);
    }

    long countByExample(FlwProcessExample example);

    int deleteByExample(FlwProcessExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FlwProcess row);

    int insertSelective(FlwProcess row);

    List<FlwProcess> selectByExample(FlwProcessExample example);

    FlwProcess selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") FlwProcess row, @Param("example") FlwProcessExample example);

    int updateByExample(@Param("row") FlwProcess row, @Param("example") FlwProcessExample example);

    int updateByPrimaryKeySelective(FlwProcess row);

    int updateByPrimaryKey(FlwProcess row);

}
