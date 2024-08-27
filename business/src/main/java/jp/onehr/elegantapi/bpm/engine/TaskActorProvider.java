/*
 * Copyright 2023-2025 Licensed under the AGPL License
 */
package jp.onehr.elegantapi.bpm.engine;


import jp.onehr.elegantapi.bpm.engine.assist.Assert;
import jp.onehr.elegantapi.bpm.engine.assist.ObjectUtils;
import jp.onehr.elegantapi.bpm.engine.core.Execution;
import jp.onehr.elegantapi.bpm.engine.core.FlowCreator;
import jp.onehr.elegantapi.bpm.engine.core.enums.NodeSetType;
import jp.onehr.elegantapi.bpm.engine.core.enums.TaskType;
import jp.onehr.elegantapi.bpm.engine.entity.FlwTaskActor;
import jp.onehr.elegantapi.bpm.engine.model.NodeAssignee;
import jp.onehr.elegantapi.bpm.engine.model.NodeModel;

import java.util.List;
import java.util.Objects;

/**
 * 任务参与者提供处理接口
 *
 * <p>
 * 尊重知识产权，不允许非法使用，后果自负
 * </p>
 *
 * @author hubin
 * @since 1.0
 */
public interface TaskActorProvider {

    /**
     * 流程创建者是否允许操作执行当前节点
     *
     * @param nodeModel   当前执行节点
     * @param flowCreator 流程创建者
     * @return true 允许 false 不被允许
     */
    default boolean isAllowed(NodeModel nodeModel, FlowCreator flowCreator) {
        List<NodeAssignee> nodeAssigneeList = nodeModel.getNodeAssigneeList();
        if (NodeSetType.specifyMembers.eq(nodeModel.getSetType()) && ObjectUtils.isNotEmpty(nodeAssigneeList)) {
            return nodeAssigneeList.stream().anyMatch(t -> Objects.equals(t.getId(), flowCreator.getCreateId()));
        }

        if (TaskType.major.eq(nodeModel.getType()) && !NodeSetType.initiatorSelected.eq(nodeModel.getSetType())) {
            // 发起人且非自选情况
            return true;
        }

        // 角色判断必须要求子类实现
        Assert.isEmpty(nodeAssigneeList, "Please implement the interface TaskActorProvider method isAllow");
        return true;
    }

    /**
     * 根据Task模型的assignee、assignmentHandler属性以及运行时数据，确定参与者
     *
     * @param nodeModel 节点模型
     * @param execution 执行对象
     * @return 参与者数组
     */
    List<FlwTaskActor> getTaskActors(NodeModel nodeModel, Execution execution);
}
