/*
 * Copyright 2023-2025 Licensed under the AGPL License
 */
package jp.onehr.elegantapi.flowlong.mapper;

import com.aizuda.bpm.engine.entity.FlwHisInstance;
import jp.onehr.elegantapi.flowlong.example.FlwHisInstanceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 历史流程实例 Mapper
 *
 * <p>
 * 尊重知识产权，不允许非法使用，后果自负
 * </p>
 *
 * @author hubin
 * @since 1.0
 */
public interface FlwHisInstanceMapper {

    long countByExample(FlwHisInstanceExample example);

    int deleteByExample(FlwHisInstanceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FlwHisInstance row);

    int insertSelective(FlwHisInstance row);

    List<FlwHisInstance> selectByExample(FlwHisInstanceExample example);

    FlwHisInstance selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row")FlwHisInstance row, @Param("example") FlwHisInstanceExample example);

    int updateByExample(@Param("row") FlwHisInstance row, @Param("example") FlwHisInstanceExample example);

    int updateByPrimaryKeySelective(FlwHisInstance row);

    int updateByPrimaryKey(FlwHisInstance row);

}
