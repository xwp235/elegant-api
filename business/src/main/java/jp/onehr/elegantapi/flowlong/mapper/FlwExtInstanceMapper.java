/*
 * Copyright 2023-2025 Licensed under the AGPL License
 */
package jp.onehr.elegantapi.flowlong.mapper;

import com.aizuda.bpm.engine.entity.FlwExtInstance;
import jp.onehr.elegantapi.flowlong.example.FlwExtInstanceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 扩展流程实例 Mapper
 *
 * <p>
 * 尊重知识产权，不允许非法使用，后果自负
 * </p>
 *
 * @author hubin
 * @since 1.0
 */
public interface FlwExtInstanceMapper {

    long countByExample(FlwExtInstanceExample example);

    int deleteByExample(FlwExtInstanceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FlwExtInstance row);

    int insertSelective(FlwExtInstance row);

    List<FlwExtInstance> selectByExample(FlwExtInstanceExample example);

    FlwExtInstance selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") FlwExtInstance row, @Param("example") FlwExtInstanceExample example);

    int updateByExample(@Param("row") FlwExtInstance row, @Param("example") FlwExtInstanceExample example);

    int updateByPrimaryKeySelective(FlwExtInstance row);

    int updateByPrimaryKey(FlwExtInstance row);

}
