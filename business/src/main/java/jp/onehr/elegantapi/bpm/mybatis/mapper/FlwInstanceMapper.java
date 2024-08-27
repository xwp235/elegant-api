/*
 * Copyright 2023-2025 Licensed under the AGPL License
 */
package jp.onehr.elegantapi.bpm.mybatis.mapper;

import jp.onehr.elegantapi.bpm.engine.entity.FlwInstance;
import jp.onehr.elegantapi.bpm.mybatis.example.FlwInstanceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

/**
 * 流程实例 Mapper
 *
 * <p>
 * 尊重知识产权，不允许非法使用，后果自负
 * </p>
 *
 * @author hubin
 * @since 1.0
 */
public interface FlwInstanceMapper {

    default Optional<List<FlwInstance>> listByParentInstanceId(Long parentInstanceId) {
        var flwInstanceExample = new FlwInstanceExample();
        flwInstanceExample.createCriteria().andParentInstanceIdEqualTo(parentInstanceId);
        return Optional.ofNullable(selectByExample(flwInstanceExample));
    }

    long countByExample(FlwInstanceExample example);

    int deleteByExample(FlwInstanceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FlwInstance row);

    int insertSelective(FlwInstance row);

    List<FlwInstance> selectByExample(FlwInstanceExample example);

    FlwInstance selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") FlwInstance row, @Param("example") FlwInstanceExample example);

    int updateByExample(@Param("row") FlwInstance row, @Param("example") FlwInstanceExample example);

    int updateByPrimaryKeySelective(FlwInstance row);

    int updateByPrimaryKey(FlwInstance row);

}
