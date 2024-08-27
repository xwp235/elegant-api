/*
 * Copyright 2023-2025 Licensed under the AGPL License
 */
package jp.onehr.elegantapi.bpm.engine.impl;


import jp.onehr.elegantapi.bpm.engine.TaskActorProvider;
import jp.onehr.elegantapi.bpm.engine.assist.ObjectUtils;
import jp.onehr.elegantapi.bpm.engine.core.Execution;
import jp.onehr.elegantapi.bpm.engine.core.enums.NodeSetType;
import jp.onehr.elegantapi.bpm.engine.entity.FlwTaskActor;
import jp.onehr.elegantapi.bpm.engine.model.NodeAssignee;
import jp.onehr.elegantapi.bpm.engine.model.NodeModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 普遍的任务参与者提供处理类
 *
 * <p>
 * 尊重知识产权，不允许非法使用，后果自负
 * </p>
 *
 * @author hubin
 * @since 1.0
 */
public class GeneralTaskActorProvider implements TaskActorProvider {

    public List<FlwTaskActor> getTaskActors(NodeModel nodeModel, Execution execution) {
        List<FlwTaskActor> flwTaskActors = new ArrayList<>();
        if (ObjectUtils.isNotEmpty(nodeModel.getNodeAssigneeList())) {
            final Integer actorType = getActorType(nodeModel);
            if (null != actorType) {
                for (NodeAssignee nodeAssignee : nodeModel.getNodeAssigneeList()) {
                    flwTaskActors.add(FlwTaskActor.of(nodeAssignee, actorType));
                }
            }
        }
        return ObjectUtils.isEmpty(flwTaskActors) ? null : flwTaskActors;
    }

    private static Integer getActorType(NodeModel nodeModel) {
        // 0，用户
        if (NodeSetType.specifyMembers.eq(nodeModel.getSetType())
                || NodeSetType.initiatorThemselves.eq(nodeModel.getSetType())
                || NodeSetType.initiatorSelected.eq(nodeModel.getSetType())) {
            return 0;
        }

        // 1，角色
        if (NodeSetType.role.eq(nodeModel.getSetType())) {
            return 1;
        }

        // 2，部门
        if (NodeSetType.department.eq(nodeModel.getSetType())) {
            return 2;
        }
        return null;
    }
}
