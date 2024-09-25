/*
 * Copyright 2023-2025 Licensed under the AGPL License
 */
package jp.onehr.elegantapi.flowlong.mapper;

import com.aizuda.bpm.engine.entity.FlwTask;
import jp.onehr.elegantapi.flowlong.example.FlwTaskExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 任务 Mapper
 *
 * <p>
 * 尊重知识产权，不允许非法使用，后果自负
 * </p>
 *
 * @author hubin
 * @since 1.0
 */
public interface FlwTaskMapper {

    /**
     * 根据流程实例ID获取任务列表
     *
     * @param instanceId 流程实例ID
     * @return 任务列表
     */
    default List<FlwTask> selectListByInstanceId(Long instanceId) {
        var flwTaskExample = new FlwTaskExample();
        flwTaskExample.createCriteria().andInstanceIdEqualTo(instanceId);
        return this.selectByExample(flwTaskExample);
    }

    /**
     * 根据父任务ID获取任务列表
     *
     * @param parentTaskId 父任务ID
     * @return 任务列表
     */
    default List<FlwTask> selectListByParentTaskId(Long parentTaskId) {
        var flwTaskExample = new FlwTaskExample();
        flwTaskExample.createCriteria().andParentTaskIdEqualTo(parentTaskId);
        return this.selectByExample(flwTaskExample);
    }

    /**
     * 根据父任务ID获取任务数量
     *
     * @param parentTaskId 父任务ID
     * @return 任务数量
     */
    default Long selectCountByParentTaskId(Long parentTaskId) {
        var flwTaskExample = new FlwTaskExample();
        flwTaskExample.createCriteria().andParentTaskIdEqualTo(parentTaskId);
        return this.countByExample(flwTaskExample);
    }

    long countByExample(FlwTaskExample example);

    int deleteByExample(FlwTaskExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FlwTask row);

    int insertSelective(FlwTask row);

    List<FlwTask> selectByExample(FlwTaskExample example);

    FlwTask selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") FlwTask row, @Param("example") FlwTaskExample example);

    int updateByExample(@Param("row")FlwTask row, @Param("example") FlwTaskExample example);

    int updateByPrimaryKeySelective(FlwTask row);

    int updateByPrimaryKey(FlwTask row);

}
