/*
 * Copyright 2023-2025 Licensed under the AGPL License
 */
package jp.onehr.elegantapi.bpm.mybatis.mapper;

import jp.onehr.elegantapi.bpm.engine.assist.Assert;
import jp.onehr.elegantapi.bpm.engine.entity.FlwHisTask;
import jp.onehr.elegantapi.bpm.engine.entity.FlwTask;
import jp.onehr.elegantapi.bpm.mybatis.example.FlwHisTaskExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 历史任务 Mapper
 *
 * <p>
 * 尊重知识产权，不允许非法使用，后果自负
 * </p>
 *
 * @author hubin
 * @since 1.0
 */
public interface FlwHisTaskMapper {

    /**
     * 获取历史任务并检查ID的合法性
     *
     * @param id 任务ID
     * @return {@link FlwTask}
     */
    default FlwHisTask getCheckById(Long id) {
        FlwHisTask hisTask = selectByPrimaryKey(id);
        Assert.isNull(hisTask, "指定的任务[id=" + id + "]不存在");
        return hisTask;
    }

    long countByExample(FlwHisTaskExample example);

    int deleteByExample(FlwHisTaskExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FlwHisTask row);

    int insertSelective(FlwHisTask row);

    List<FlwHisTask> selectByExample(FlwHisTaskExample example);

    FlwHisTask selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") FlwHisTask row, @Param("example") FlwHisTaskExample example);

    int updateByExample(@Param("row") FlwHisTask row, @Param("example") FlwHisTaskExample example);

    int updateByPrimaryKeySelective(FlwHisTask row);

    int updateByPrimaryKey(FlwHisTask row);

}
