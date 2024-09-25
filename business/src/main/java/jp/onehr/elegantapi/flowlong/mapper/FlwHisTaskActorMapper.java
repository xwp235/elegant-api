/*
 * Copyright 2023-2025 Licensed under the AGPL License
 */
package jp.onehr.elegantapi.flowlong.mapper;

import com.aizuda.bpm.engine.entity.FlwHisTaskActor;
import jp.onehr.elegantapi.flowlong.example.FlwHisTaskActorExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 历史任务参与者 Mapper
 *
 * <p>
 * 尊重知识产权，不允许非法使用，后果自负
 * </p>
 *
 * @author hubin
 * @since 1.0
 */
public interface FlwHisTaskActorMapper {

    /**
     * 通过任务ID获取参与者列表
     *
     * @param taskId 任务ID
     * @return 参与者列表
     */
    default List<FlwHisTaskActor> selectListByTaskId(Long taskId) {
        var flwHisTaskActorExample = new FlwHisTaskActorExample();
        flwHisTaskActorExample.createCriteria().andTaskIdEqualTo(taskId);
        return this.selectByExample(flwHisTaskActorExample);
    }

    /**
     * 通过任务ID获取参与者列表
     *
     * @param taskIds 任务ID列表
     * @return 历史任务参与者列表
     */
    default List<FlwHisTaskActor> selectListByTaskIds(List<Long> taskIds) {
        var flwHisTaskActorExample = new FlwHisTaskActorExample();
        flwHisTaskActorExample.createCriteria().andTaskIdIn(taskIds);
        return this.selectByExample(flwHisTaskActorExample);
    }

    long countByExample(FlwHisTaskActorExample example);

    int deleteByExample(FlwHisTaskActorExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FlwHisTaskActor row);

    int insertSelective(FlwHisTaskActor row);

    List<FlwHisTaskActor> selectByExample(FlwHisTaskActorExample example);

    FlwHisTaskActor selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") FlwHisTaskActor row, @Param("example") FlwHisTaskActorExample example);

    int updateByExample(@Param("row") FlwHisTaskActor row, @Param("example") FlwHisTaskActorExample example);

    int updateByPrimaryKeySelective(FlwHisTaskActor row);

    int updateByPrimaryKey(FlwHisTaskActor row);

}
