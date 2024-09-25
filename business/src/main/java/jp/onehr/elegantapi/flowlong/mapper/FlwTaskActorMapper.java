/*
 * Copyright 2023-2025 Licensed under the AGPL License
 */
package jp.onehr.elegantapi.flowlong.mapper;

import com.aizuda.bpm.engine.entity.FlwTaskActor;
import jp.onehr.elegantapi.flowlong.example.FlwTaskActorExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 任务参与者 Mapper
 *
 * <p>
 * 尊重知识产权，不允许非法使用，后果自负
 * </p>
 *
 * @author hubin
 * @since 1.0
 */
public interface FlwTaskActorMapper {

    /**
     * 通过任务ID获取参与者列表
     *
     * @param taskId 任务ID
     * @return 参与者列表
     */
    default List<FlwTaskActor> selectListByTaskId(Long taskId) {
        var flwTaskActorExample = new FlwTaskActorExample();
        flwTaskActorExample.createCriteria().andTaskIdEqualTo(taskId);
        return this.selectByExample(flwTaskActorExample);
    }

    /**
     * 通过任务ID列表获取参与者列表
     *
     * @param taskIds 任务ID列表
     * @return 参与者列表
     */
    default List<FlwTaskActor> selectListByTaskIds(List<Long> taskIds) {
        var flwTaskActorExample = new FlwTaskActorExample();
        flwTaskActorExample.createCriteria().andTaskIdIn(taskIds);
        return this.selectByExample(flwTaskActorExample);
    }

    /**
     * 通过流程实例ID获取参与者列表
     *
     * @param instanceId 流程实例ID
     * @return 参与者列表
     */
    default List<FlwTaskActor> selectListByInstanceId(Long instanceId) {
        var flwTaskActorExample = new FlwTaskActorExample();
        flwTaskActorExample.createCriteria().andInstanceIdEqualTo(instanceId);
        return this.selectByExample(flwTaskActorExample);
    }

    /**
     * 通过任务ID删除参与者
     *
     * @param taskId 任务ID
     * @return true 成功 false 失败
     */
    default boolean deleteByTaskId(Long taskId) {
        var flwTaskActorExample = new FlwTaskActorExample();
        flwTaskActorExample.createCriteria().andTaskIdEqualTo(taskId);
        return this.deleteByExample(flwTaskActorExample) > 0;
    }

    /**
     * 通过任务ID删除参与者
     *
     * @param taskIds 任务ID列表
     * @return true 成功 false 失败
     */
    default boolean deleteByTaskIds(List<Long> taskIds) {
        var flwTaskActorExample = new FlwTaskActorExample();
        flwTaskActorExample.createCriteria().andTaskIdIn(taskIds);
        return this.deleteByExample(flwTaskActorExample) > 0;
    }

    long countByExample(FlwTaskActorExample example);

    int deleteByExample(FlwTaskActorExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FlwTaskActor row);

    int insertSelective(FlwTaskActor row);

    List<FlwTaskActor> selectByExample(FlwTaskActorExample example);

    FlwTaskActor selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") FlwTaskActor row, @Param("example") FlwTaskActorExample example);

    int updateByExample(@Param("row") FlwTaskActor row, @Param("example") FlwTaskActorExample example);

    int updateByPrimaryKeySelective(FlwTaskActor row);

    int updateByPrimaryKey(FlwTaskActor row);

}
